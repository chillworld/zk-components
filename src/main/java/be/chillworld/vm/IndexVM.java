package be.chillworld.vm;

import be.chillworld.model.Continent;
import be.chillworld.model.Country;
import be.chillworld.model.User;
import be.chillworld.model.enums.Color;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

/**
 *
 * @author chillworld
 */
public class IndexVM {

   private Color selectedColor;
   private Country country = new Country(true, "BE","Belgie");
   private Continent continent = new Continent(true, "EU","Europe");
   private User user = new User("John","Doe");
   
   @Init
   public void init() {
       country.setContinent(continent);
   }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Command
    @NotifyChange({"continent","country","user"})
    public void switchActive() {
        country.setInUse(!country.isInUse());
        continent.setInUse(!continent.isInUse());
        user.setActive(!user.isActive());
    }
}
