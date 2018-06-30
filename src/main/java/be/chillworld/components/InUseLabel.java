package be.chillworld.components;

import be.chillworld.model.AbstractCatalog;
import org.zkoss.zul.Label;

/**
 *
 * @author filip.cossaer
 */
public class InUseLabel extends Label {

    private static final String INACTIVE_STYLE = "color:red;text-decoration:line-through;";
    private AbstractCatalog catalog;
    private String style;

    public AbstractCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(AbstractCatalog catalog) {
        this.catalog = catalog;
        if (catalog != null) {
            super.setValue(catalog.getCode() + " - " + catalog.getDescription());
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
        boolean extraStyle = catalog == null || !catalog.isInUse();
        super.setStyle((style==null?"":style) +(extraStyle ? INACTIVE_STYLE : "")) ;
    }

    @Override
    public void setValue(String value) {
        throw new UnsupportedOperationException("inuselabel can't set value, please set label through the catalog attribute.");
    }
}
