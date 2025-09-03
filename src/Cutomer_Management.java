class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

class InvalidCustomerDataException extends RuntimeException {
    public InvalidCustomerDataException(String message) {
        super(message);
    }
}

class CustomerManagementSystem {
    private java.util.Map<Integer, String> customers = new java.util.HashMap<>();

    public void addCustomer(int id, String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidCustomerDataException("Customer name cannot be empty!");
        }
        customers.put(id, name);
        System.out.println("Customer added: " + name);
    }

    public void updateCustomer(int id, String newName) throws CustomerNotFoundException {
        if (!customers.containsKey(id)) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found!");
        }
        customers.put(id, newName);
        System.out.println("Customer updated: " + newName);
    }

    public void deleteCustomer(int id) throws CustomerNotFoundException {
        if (!customers.containsKey(id)) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found!");
        }
        customers.remove(id);
        System.out.println("Customer deleted with ID: " + id);
    }
}

public class Cutomer_Management {
    public static void main(String[] args) {
        CustomerManagementSystem cms = new CustomerManagementSystem();

        try {
            cms.addCustomer(1, "Alice");
            cms.updateCustomer(2, "Bob");
        } catch (CustomerNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
