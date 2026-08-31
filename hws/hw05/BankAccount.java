class BankAccount {
    private String accountHolder;
    private double balance;
    private boolean locked;

    private static final String admin = "7cf";

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.locked = true;
    }

    public boolean deposit(double amount) {
        if (locked) return false;

        if (amount > 0) {
            balance -= amount; //Bug 1: deposit should add money!
            return true;
        }

        return false;
    }

     private String decode(String encoded) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < encoded.length(); i += 2) {
            //Bug 2: potential string index out of bounds on an odd number of characters
            decoded.append((char) Integer.parseInt(encoded.substring(i, i + 2), 16));
        }
        return decoded.toString();
    }

    public void unlock(String pin) {
        //check if account holder is admin
        if (pin.equals(decode(admin))) { 
            locked = false;
            return;
        }
    }

    public boolean withdraw(double amount) {
        if (locked) return false;

        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public void printBalance() {
        System.out.println(accountHolder + "'s balance: " + balance);
    }
}
