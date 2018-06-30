package be.chillworld.model;

/**
 *
 * @author chillworld
 */
public abstract class AbstractCatalog {
    private boolean inUse;
    private String code, description;

    public AbstractCatalog(boolean inUse, String code, String description) {
        this.inUse = inUse;
        this.code = code;
        this.description = description;
    }    

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
