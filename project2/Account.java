/**
 * @author Jack Roach
 * Date: Mar 4, 2022
 * Class: CSE 271 - E
 * File: Account.java
 */
public class Account {

    protected static int staticID = 990;
    private int id;
    private Customer customer;
    private double balance;

    /**
     * The default constructor.
     *
     * @param customer is a Customer
     */
    public Account(Customer customer) {
        this(customer, 0.0);
        staticID += 10;
        id = staticID;
    }

    /**
     * The workhorse constructor.
     *
     * @param customer is a Customer
     * @param balance is a double
     */
    public Account(Customer customer, double balance) {
        this.customer = customer;
        this.balance = balance;
        staticID += 10;
        id = staticID;
    }

    /**
     * The copy constructor
     *
     * @param account is an Account
     */
    public Account(Account account) {
        this(account.customer, account.balance);
    }

    /**
     * Add a deposit to the account balance.
     *
     * @param amount is a double
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract a deposit from the account balance.
     *
     * @param amount is a double
     * @return true if subtracted, false otherwise
     */
    public boolean withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        } else if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Account)) {
            return false;
        }

        Account a = (Account) o;
        return a.id == id && a.customer.equals(customer)
            && a.balance == balance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%d, %s, %.2f", id, customer, balance);
    }

    /**
     * Gets the Account id.
     *
     * @return the Account id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the Account Customer.
     *
     * @return the Account Customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the Account Customer
     *
     * @param customer is a Customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the Account balance.
     *
     * @return the Account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the Account balance.
     *
     * @param balance is a double
     */
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException();
        } else {
            this.balance = balance;
        }
    }

}