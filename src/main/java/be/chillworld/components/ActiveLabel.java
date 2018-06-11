package be.chillworld.components;

import be.chillworld.model.IActive;
import org.zkoss.zul.Label;

/**
 *
 * @author filip.cossaer
 */
public class ActiveLabel extends Label {

    private static final String INACTIVE_STYLE = "color:red;text-decoration:line-through;";
    private IActive object;
    private String style;

    public IActive getObject() {
        return object;
    }

    public void setObject(IActive iActive) {
        this.object = iActive;
        if (iActive != null) {
            super.setValue(iActive.getLabel());
        } else {
            super.setValue(null);
        }
        setStyle(style);
    }

    @Override
    public String getStyle() {
        return style;
    }

    @Override
    public void setStyle(String style) {
        this.style = style;
        boolean extraStyle = object == null || !object.isActive();
        super.setStyle((style==null?"":style) +(extraStyle ? INACTIVE_STYLE : "")) ;
    }

    @Override
    public void setValue(String value) {
        throw new UnsupportedOperationException("activelabel can't set value, please set label through the object attribute.");
    }
}
