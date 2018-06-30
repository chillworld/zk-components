package be.chillworld.model;

/**
 *
 * @author chillworld
 */
public class Country extends AbstractCatalog {
    
   private Continent continent;

    public Country(boolean inUse, String code, String description) {
        super(inUse, code, description);
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
    
}
