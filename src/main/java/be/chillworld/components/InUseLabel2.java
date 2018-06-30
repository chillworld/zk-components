package be.chillworld.components;

import org.zkoss.zul.Label;

/**
 *
 * @author filip.cossaer
 */
public class InUseLabel2 extends Label {

    private static final String INACTIVE_STYLE = "color:red;text-decoration:line-through;";
    private boolean inUse;
    private String style;
    
    public void setInUse(boolean inUse) {
        this.inUse = inUse;
        setStyle(style);
    }

    @Override
    public String getStyle() {
        return style;
    }

    @Override
    public void setStyle(String style) {
        this.style = style;
        super.setStyle((style==null?"":style) + (inUse ? "" : INACTIVE_STYLE)) ;
    }
}
