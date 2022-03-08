/**
 * @author Jack Roach
 * Date: Mar 4, 2022
 * Class: CSE 271 - E
 * File: Address.java
 */
public class Address {

    private int streetNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;

    /**
     * The default constructor.
     */
    public Address() {
        this(0, "", "", "OH", "00000");
    }

    /**
     * The workhorse constructor.
     *
     * @param streetNumber is an int
     * @param streetName is a String
     * @param city is a String
     * @param state is a String
     * @param zipCode is a String
     */
    public Address(int streetNumber, String streetName, String city,
        String state, String zipCode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * The copy constructor
     *
     * @param address is an Address
     */
    public Address(Address address) {
        this(address.streetNumber, address.streetName, address.city,
            address.state, address.zipCode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address)) {
            return false;
        }

        Address a = (Address) o;
        return a.streetNumber == streetNumber && a.streetName.equals(streetName)
            && a.city.equals(city) && a.state.equals(state)
            && a.zipCode.equals(zipCode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%d %s, %s, %s, %s", streetNumber, streetName,
            city, state, zipCode);
    }

    /**
     * Gets the Address streetNumber.
     *
     * @return the Address streetNumber
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the Address streetNumber
     *
     * @param streetNumber is an int
     */
    public void setStreetNumber(int streetNumber) {
        if (streetNumber < 0) {
            throw new IllegalArgumentException();
        } else {
            this.streetNumber = streetNumber;
        }
    }

    /**
     * Gets the Address streetName.
     *
     * @return the Address streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the Address streetName.
     *
     * @param streetName is a String
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets the Address city.
     *
     * @return the Address city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the Address city
     *
     * @param city is a String
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the Address state.
     *
     * @return the Address state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the Address state.
     *
     * @param state is a String
     */
    public void setState(String state) {
        if (state.length() == 2 && Character.isLetter(state.charAt(0))
            && Character.isLetter(state.charAt(1))) {
            this.state = state;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Gets the Address zipCode.
     *
     * @return the Address zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the Address zipCode.
     *
     * @param zipCode the Address zipCode.
     */
    public void setZipCode(String zipCode) {
        if (zipCode.length() == 5 && Character.isDigit(zipCode.charAt(0))
            && Character.isDigit(zipCode.charAt(1))
            && Character.isDigit(zipCode.charAt(2))
            && Character.isDigit(zipCode.charAt(3))
            && Character.isDigit(zipCode.charAt(4))) {
            this.zipCode = zipCode;
        } else {
            throw new IllegalArgumentException();
        }
    }

}