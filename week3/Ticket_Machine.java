/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified cia the constructor.
 * 
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket 
 * if enough money has been input.
 */

public class Ticket_Machine {
    private int price;      // the price of the ticket.
    private int balance;    // the amount money entered by a customer so far.
    private int total;      // total amount of money collected by this machine.

    // Create a machine that issue tickets of the given price.
    public Ticket_Machine(int ticketPrice) {
        price = ticketPrice;
        balance = 0;
        total = 0;
    }

    // Return the price of a ticket.
    public int getPrice() {
        return price;
    }

    // Return the amount of money already inserted for the next ticket.
    public int getBalance() {
        return balance;
    }

    // Receive an amount of money in cents from a customer.
    // Check that the amount is sensible
    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Use a positive amount rather than: " + amount);
        }
    } 

    // Print a ticket if enough money has been inserted, and reduce the current balance by the ticket price.
    // Print an error message if more money required.
    public void printTicket() {
        if (balance >= price) {
            System.out.println("##################");
            System.out.println("# The BlueJ Line #");
            System.out.println("# Ticket         #");
            System.out.println("# " + price + " cents.     #");
            System.out.println("##################");
            System.out.println();

            total += price;
            balance -= price;
        }

        else {
            System.out.println("You must insert at least: " + (price - balance) + " cents.\n");
        }
    }

    // Return the money in the balance.
    // The balance is cleared.
    public int refundBalance() {
        int amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    public static void main(String[] args) {
        // line 75 - 84, it will clear the screen in the terminal.
        // so the terminal looks clean.
        // ignore it.
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Ticket_Machine machine = new Ticket_Machine(500);

        machine.insertMoney(200);
        machine.printTicket();
        machine.insertMoney(500);
        machine.printTicket();

        int refund = machine.refundBalance();
        System.out.println("Refunded:" + refund + " cents");
    }
}
