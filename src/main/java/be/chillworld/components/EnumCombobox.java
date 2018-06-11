package be.chillworld.components;

import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModelList;

/**
 *
 * @author chillworld
 */
public class EnumCombobox extends Combobox implements AfterCompose {

    private Class<Enum> enumClass;
    private boolean emptyValue = false;

    @Override
    public void afterCompose() {
        ListModelList model = new ListModelList(enumClass.getEnumConstants());
        if (emptyValue) {
            model.add(0, null);
        }
        setModel(model);
        setItemRenderer(new ComboitemRenderer<Enum>() {

            @Override
            public void render(Comboitem item, Enum data, int index) throws Exception {
                if (data == null) {
                    item.setLabel("Empty selection");
                    item.setStyle("color:grey");
                } else {
                    item.setLabel(data.toString());
                }
                item.setValue(data);
            }

        });
    }

    public void setEnumClass(String enumClass) throws ClassNotFoundException {
        this.enumClass = (Class<Enum>) Class.forName(enumClass);
    }

    public void setEmptyValue(boolean emptyValue) {
        this.emptyValue = emptyValue;
    }
}
