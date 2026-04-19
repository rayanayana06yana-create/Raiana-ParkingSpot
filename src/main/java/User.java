public class User {
    // Encapsulated fields
    private String name;
    private String email;

    // Constructor to initialize user object
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters for name and email
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Method to display user information (used for polymorphism)
    public void displayInfo() {
        System.out.println("User: " + name + " | " + email);
    }
}
