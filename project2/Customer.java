/**
 * @author Jack Roach
 * Date: Mar 4, 2022
 * Class: CSE 271 - E
 * File: Customer.java
 */
public class Customer {

    protected static int staticID = 999;
    private int id;
    private String name;
    private Address address;
    private String ssn;

    /**
     * The default constructor.
     */
    public Customer() {
        this("", new Address(), "");
        staticID += 1;
        id = staticID;
    }

    /**
     * The workhorse constructor.
     *
     * @param name is a String
     * @param address is a String
     * @param ssn is a String
     */
    public Customer(String name, Address address, String ssn) {
        this.name = name;
        this.address = address;
        this.ssn = ssn;
        staticID += 1;
        id = staticID;
    }

    /**
     * The copy constructor.
     *
     * @param customer is a Customer
     */
    public Customer(Customer customer) {
        this(customer.name, customer.address, customer.ssn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Customer)) {
            return false;
        }

        Customer c = (Customer) object;
        return c.id == id && c.name.equals(name)
            && c.address.equals(address) && c.ssn.equals(ssn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s", id, name, address, ssn);
    }

    /**
     * Gets the Customer id.
     *
     * @return the Customer id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the Customer name.
     *
     * @return the Customer name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the Customer name.
     *
     * @param name is a String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Customer address.
     *
     * @return the Customer address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the Customer address.
     *
     * @param address is an Address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Sets the Customer ssn.
     *
     * @return the Customer ssn.
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * Gets the Customer ssn.
     *
     * @param ssn is a String
     */
    public void setSsn(String ssn) {
        if (ssn.length() == 11
            && Character.isDigit(ssn.charAt(0))
            && Character.isDigit(ssn.charAt(1))
            && Character.isDigit(ssn.charAt(2))
            && ssn.charAt(3) == '-'
            && Character.isDigit(ssn.charAt(4))
            && Character.isDigit(ssn.charAt(5))
            && ssn.charAt(6) == '-'
            && Character.isDigit(ssn.charAt(7))
            && Character.isDigit(ssn.charAt(8))
            && Character.isDigit(ssn.charAt(9))
            && Character.isDigit(ssn.charAt(10))) {
                this.ssn = ssn;
        } else {
            throw new IllegalArgumentException();
        }
    }

}