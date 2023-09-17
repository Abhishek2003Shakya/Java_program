import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Create a class to represent the user's bank account, which stores the account balance
class BankAccount {
    private double balance;

    public BankAccount(double TotalBalance) {
        balance = TotalBalance;
    }

    // Implement methods for each option, such as withdraw(amount), deposit(amount), and checkBalance().
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

// Design the user interface for the ATM, including options such as withdrawing, depositing, and checking the balance.
public class ATM extends JFrame {
    private BankAccount userAccount;
    private JTextField amountField;
    private JTextArea outputArea;

    // Connect the ATM class with the user's bank account class to access and modify the account balance.
    public ATM(BankAccount account) {
        userAccount = account;
        // Unicode code point for the Indian Rupee symbol is "U+20B9"
        char rupeeSymbol = '\u20B9';

        // Create frame
        setTitle("ATM Machine");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
        // Add welcome heading 
        JLabel Heading = new JLabel("WELCOME");
        Heading.setBounds(250, 20, 200, 50);
        Font HeadingFont = new Font("Arial", Font.PLAIN,24);
        Heading.setFont(HeadingFont);
        // Add amount label 
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(150, 50, 80, 100);
        // Add text field 
        amountField = new JTextField(10);
        amountField.setBounds(260, 90, 200, 20);
        // Add withadraw button 
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(100, 140, 90, 30);
        // Add deposit button 
        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(255, 140, 90, 30);
        // Add balance button 
        JButton balanceButton = new JButton("Balance");
        balanceButton.setBounds(410, 140, 90, 30);

        // Adding the components
        add(Heading);
        add(amountLabel);
        add(amountField);
        add(withdrawButton);
        add(depositButton);
        add(balanceButton);

        // Display ouput area 
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(100, 200, 400, 140);
        add(scrollPane);

        // Handling all action when click on buttons 
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                if (userAccount.withdraw(amount)) {
                    showMessage("\n     SUCCESS: Withdrew " + rupeeSymbol + amount);
                } else {
                    showError("\n   Withdrawal failed!");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                if (userAccount.deposit(amount)) {
                    showMessage("\n     SUCCESS: Deposited " + rupeeSymbol + amount);
                } else {
                    showError("\n   Deposit failed!");
                }
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = userAccount.checkBalance();
                showMessage("\n     Your current Balance is: " + rupeeSymbol + balance);
            }
        });
    }

    // Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
    // Handling errors 
    private void showMessage(String message) {
        outputArea.append(message + "\n");
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        double TotalBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter your total account balance:"));
        BankAccount userAccount = new BankAccount(TotalBalance);
        new ATM(userAccount);
    }
}
