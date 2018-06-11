package com.deslin.ui.components;

import com.deslin.GenericNameValuePair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.zkoss.zk.ui.annotation.ComponentAnnotation;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Div;
import org.zkoss.zul.SimpleListModel;

/**
 *
 * @author chillworld
 * @param <T>
 */
@ComponentAnnotation({"selectedItem: @ZKBIND(ACCESS=both,SAVE_EVENT=onSelect)",
    "selectedItemLabel: @ZKBIND(ACCESS=both,SAVE_EVENT=onSelect)"})
public class FilterDropDown extends Div implements AfterCompose {

    private static final long serialVersionUID = 5183321186606483398L;
    private static final ComboitemRenderer COMBO_RENDERER = new ComboitemRenderer<String>() {

        @Override
        public void render(Comboitem cmbtm, String label, int i) throws Exception {
            cmbtm.setLabel(label);
        }
    };

    private final Combobox combobox = new Combobox();
    private final HashMap<String, GenericNameValuePair> base = new HashMap<>();
    private SimpleListModel<String> model;
    private GenericNameValuePair selectedItem;
    private String tempSelection;

    public FilterDropDown() {
    }

    @Override
    public void afterCompose() {
        this.appendChild(combobox);
        combobox.setHflex("1");
        combobox.setMultiline(false);
        combobox.setAutodrop(true);
        combobox.setItemRenderer(COMBO_RENDERER);
        combobox.addEventListener("onSelect", new EventListener<SelectEvent>() {

            @Override
            public void onEvent(SelectEvent t) throws Exception {
                if (model.getSelection().isEmpty()) {
                    setSelectedItem(null);
                } else {
                    String gnvpLabel = model.getSelection().iterator().next();
                    setSelectedItemLabel(gnvpLabel);
                }
                Events.postEvent("onSelect", FilterDropDown.this, getSelectedItem());
            }
        });
    }

    public void setSelectedItem(GenericNameValuePair selectedItem) {
        setSelectedItemLabel(selectedItem == null ? null : selectedItem.getLabel());
    }

    public GenericNameValuePair getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItemLabel(String gnvpLabel) {
        if (model != null) {
            model.clearSelection();
            if (base.containsKey(gnvpLabel)) {
                selectedItem = base.get(gnvpLabel);
                model.addToSelection(gnvpLabel);
            } else {
                selectedItem = null;
            }
        } else {
            tempSelection = gnvpLabel; // could be that model isn't set before the selection.
        }
    }

    public String getSelectedItemLabel() {
        return selectedItem == null ? null : selectedItem.getLabel();
    }

    public void setModel(List<GenericNameValuePair> model) {
        boolean setTempSelection = this.model==null; // not the nicest code, but good enough to know what the selection was before any lmodel was set.
        base.clear();
        if (model == null) {
            this.model = new SimpleListModel(new ArrayList<>());
        } else {
            for (GenericNameValuePair gnvp : model) {
                base.put(gnvp.getLabel(), gnvp);
            }
            this.model = new SimpleListModel<>(new ArrayList(base.keySet()));
        }
        combobox.setModel(this.model);
        if (setTempSelection) {
            setSelectedItemLabel(tempSelection);
        } else {
            selectedItem = null;
        }   
        Events.postEvent("onSelect", FilterDropDown.this, getSelectedItem());
    }

    public void setModel(GenericNameValuePair[] model) {
        setModel(Arrays.asList(model));
    }
}
