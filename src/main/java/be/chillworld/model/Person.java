package be.chillworld.model;

/**
 *
 * @author chillworld
 */
public class Person implements IActive {
    private String firstName, lastName;
    private boolean active = true;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Override
    public String getLabel() {
        return lastName + " " + firstName;
    }
    
    
}
