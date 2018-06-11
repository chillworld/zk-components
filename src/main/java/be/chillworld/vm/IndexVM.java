package be.chillworld.vm;

import be.chillworld.model.Person;
import be.chillworld.model.enums.Color;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

/**
 *
 * @author chillworld
 */
public class IndexVM {

   private Color selectedColor;
   private Person person = new Person("John","Doe");

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

    public Person getPerson() {
        return person;
    }
    
    @Command
    @NotifyChange("person")
    public void switchActive() {
        person.setActive(!person.isActive());
    }
   
   

}
