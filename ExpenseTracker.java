import java.util.ArrayList;
import java.util.Scanner;

/*
 * Personal Expense Tracker
 * Author: Sumedha Chowdhury
 * Description: A menu-driven Java console application to track daily expenses
 */
class Expense 
{
    private int expenseId;
    private String date;
    private String category;
    private double amount;
    private String description;
    public Expense(int expenseId, String date, String category, double amount, String description) 
    {
        this.expenseId = expenseId;
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }
    public int getExpenseId() 
    {
        return expenseId;
    }
    public String getCategory() 
    {
        return category;
    }
    public double getAmount() 
    {
        return amount;
    }
    public void displayExpense() 
    {
        System.out.println("------------------------------------");
        System.out.println("Expense ID   : " + expenseId);
        System.out.println("Date         : " + date);
        System.out.println("Category     : " + category);
        System.out.println("Amount (₹)   : " + amount);
        System.out.println("Description  : " + description);
        System.out.println("------------------------------------");
    }
}
public class PersonalExpenseTracker 
{
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int expenseCounter = 1001;
    public static void main(String[] args) 
    {
        int choice;
        do 
        {
            System.out.println("\n====== PERSONAL EXPENSE TRACKER ======");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Search Expense by Category");
            System.out.println("4. View Total Spending");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) 
            {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    searchByCategory();
                    break;
                case 4:
                    calculateTotal();
                    break;
                case 5:
                    deleteExpense();
                    break;
                case 6:
                    System.out.println("Exiting Expense Tracker... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
    }
    private static void addExpense() 
    {
        System.out.print("Enter Date (DD-MM-YYYY): ");
        String date = sc.nextLine();
        System.out.print("Enter Category (Food/Travel/Shopping/etc): ");
        String category = sc.nextLine();
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Description: ");
        String description = sc.nextLine();
        Expense expense = new Expense(expenseCounter++, date, category, amount, description);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }
    private static void viewExpenses() 
    {
        if (expenses.isEmpty()) 
        {
            System.out.println("No expenses recorded yet.");
            return;
        }
        for (Expense expense : expenses) 
        {
            expense.displayExpense();
        }
    }
    private static void searchByCategory() 
    {
        System.out.print("Enter category to search: ");
        String searchCategory = sc.nextLine();
        boolean found = false;
        for (Expense expense : expenses) 
        {
            if (expense.getCategory().equalsIgnoreCase(searchCategory)) 
            {
                expense.displayExpense();
                found = true;
            }
        }
        if (!found) 
        {
            System.out.println("No expenses found in this category.");
        }
    }
    private static void calculateTotal() 
    {
        double total = 0;
        for (Expense expense : expenses) 
        {
            total += expense.getAmount();
        }
        System.out.println("Total Spending: ₹" + total);
    }
    private static void deleteExpense() 
    {
        System.out.print("Enter Expense ID to delete: ");
        int id = sc.nextInt();
        boolean removed = expenses.removeIf(e -> e.getExpenseId() == id);
        if (removed) 
        {
            System.out.println("Expense deleted successfully.");
        } 
        else 
        {
            System.out.println("Expense ID not found.");
        }
    }
}
