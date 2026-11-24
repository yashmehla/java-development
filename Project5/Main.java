public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00);
        System.out.println("Initial Balance: $" + account.getBalance());

        account.deposit(250.00);
        System.out.println("After depositing $250: $" + account.getBalance());

        account.withdraw(100.00);
        System.out.println("After withdrawing $100: $" + account.getBalance());

        System.out.println("Attempting to withdraw $1000...");
        try {
            account.withdraw(1000.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught as expected: " + e.getMessage());
        }

        System.out.println("Final Balance: $" + account.getBalance());
    }
}
