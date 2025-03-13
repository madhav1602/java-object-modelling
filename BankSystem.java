import java.util.ArrayList;

// Bank class
class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public void openAccount(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer.getName() + " in " + name);
    }

    public String getName() {
        return name;
    }
}

// Customer class
class Customer {
    private String name;
    private Bank bank;

    public Customer(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    public void viewBalance() {
        System.out.println(name + " has an account in " + bank.getName()); // Now this works
    }

    public String getName() {
        return name;
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {
        Bank hdfc = new Bank("HDFC Bank");
        Customer c1 = new Customer("Madhav Aggarwal", hdfc);
        Customer c2 = new Customer("Rahul Sharma", hdfc);

        hdfc.openAccount(c1);
        hdfc.openAccount(c2);

        c1.viewBalance();
        c2.viewBalance();
    }
}
