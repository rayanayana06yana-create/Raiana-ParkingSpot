// Inheritance: Customer is a type of User
public class Customer extends User {

    // Constructor calls parent constructor
    public Customer(String name, String email) {
        super(name, email);
    }

    // Polymorphism: overriding parent method
    @Override
    public void displayInfo() {
        System.out.println("Customer: " + getName() + " | " + getEmail());
    }
}