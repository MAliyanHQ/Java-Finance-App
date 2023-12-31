
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sufiy
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    private StackLinkedList userTransaction = new StackLinkedList();
    private User loggedUser;
    String date;

    public Dashboard(String x) {
        try {
            objectCreation(x);
            salarydate();
            setIconImage();
            initComponents();
            linkedListCreation();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    public Dashboard(User user) {
        try {
            loggedUser = user;
            salarydate();
            setIconImage();
            initComponents();
            linkedListCreation();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/favicon.png")));
    }

    public final void salarydate() throws IOException {
        LocalDate ldate = LocalDate.now();
        String date = ldate.toString();
        String month = date.substring(5, 7);
        String purpose = month + " Monthly Income/Monthly Allowance";
        File transData = new File(loggedUser.getUid() + "_transactions.txt");
        if (transData.exists()) {
            Scanner reader = new Scanner(transData);
            int index = 0;
            while (reader.hasNextLine()) {
                index = reader.nextLine().indexOf(purpose);
                if (index > 0) {
                    break;
                }
            }
            if (index == -1) {
                loggedUser.deposit(loggedUser.getIncome() + 1, purpose);
            }
        } else {
            loggedUser.deposit(loggedUser.getIncome() + 1, purpose);
        }

    }

    public final void objectCreation(String uid) throws FileNotFoundException, IOException {
        File object = new File(uid + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(object));
        String ouid = br.readLine();
        String opin = br.readLine();
        String oname = br.readLine();
        char ogender = br.readLine().charAt(0);
        String orole = br.readLine();
        double obalance = Double.parseDouble(br.readLine());
        switch (orole) {
            case "Employee":
                String ocompanyname = br.readLine();
                String ojobtitle = br.readLine();
                double osalary = Double.parseDouble(br.readLine());
                loggedUser = new Employee(ocompanyname, ojobtitle, obalance, oname, orole, ouid, opin, ogender, osalary);
                break;
            case "Businessman":
                String obusinessname = br.readLine();
                double oincome = Double.parseDouble(br.readLine());
                loggedUser = new Businessman(obusinessname, obalance, oname, orole, ouid, opin, ogender, oincome);
                break;
            case "Student":
                String oeducationlvl = br.readLine();
                double opocketmoney = Double.parseDouble(br.readLine());
                loggedUser = new Student(oeducationlvl, obalance, oname, orole, ouid, opin, ogender, opocketmoney);
                break;
            case "Dependent on spouse":
                double omonthlyallowance = Double.parseDouble(br.readLine());
                loggedUser = new Dependantonspouse(obalance, oname, orole, ouid, opin, ogender, omonthlyallowance);
                break;
            default:
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        depositIcon = new javax.swing.JLabel();
        deposit = new javax.swing.JLabel();
        withdrawIcon = new javax.swing.JLabel();
        withdraws = new javax.swing.JLabel();
        transactionIcon = new javax.swing.JLabel();
        transactions = new javax.swing.JLabel();
        investmentIcon = new javax.swing.JLabel();
        investment = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        exitIcon = new javax.swing.JLabel();
        accountIcon = new javax.swing.JLabel();
        account = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard - Sukoon Finance App");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(219, 228, 238));

        depositIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deposit.png"))); // NOI18N
        depositIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depositclicked(evt);
            }
        });

        deposit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deposit.setForeground(new java.awt.Color(45, 49, 66));
        deposit.setLabelFor(depositIcon);
        deposit.setText("Deposit");
        deposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depositclicked(evt);
            }
        });

        withdrawIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/withdraw.png"))); // NOI18N
        withdrawIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                withdrawClicked(evt);
            }
        });

        withdraws.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        withdraws.setForeground(new java.awt.Color(45, 49, 66));
        withdraws.setText("Withdraw");
        withdraws.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                withdrawClicked(evt);
            }
        });

        transactionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Transactions.png"))); // NOI18N
        transactionIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionClicked(evt);
            }
        });

        transactions.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        transactions.setForeground(new java.awt.Color(45, 49, 66));
        transactions.setText("Transactions");
        transactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionClicked(evt);
            }
        });

        investmentIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deposit.png"))); // NOI18N
        investmentIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                investmentClicked(evt);
            }
        });

        investment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        investment.setForeground(new java.awt.Color(45, 49, 66));
        investment.setText("Investment");
        investment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                investmentClicked(evt);
            }
        });

        exit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(45, 49, 66));
        exit.setText("Exit");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitClicked(evt);
            }
        });

        exitIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exit.png"))); // NOI18N
        exitIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitClicked(evt);
            }
        });

        accountIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/account.png"))); // NOI18N
        accountIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accClicked(evt);
            }
        });

        account.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        account.setForeground(new java.awt.Color(45, 49, 66));
        account.setText("Account");

        jPanel2.setBackground(new java.awt.Color(219, 228, 238));

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(180, 34, 242));
        username.setText("User");
        username.setText(loggedUser.getName());

        jLabel11.setForeground(new java.awt.Color(45, 49, 66));
        jLabel11.setText("Welcome");

        balance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        balance.setForeground(new java.awt.Color(180, 34, 242));
        balance.setText("RS ");
        balance.setText("RS " + loggedUser.getBalance());

        jLabel12.setForeground(new java.awt.Color(45, 49, 66));
        jLabel12.setText("Balance:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(username)
                    .addComponent(jLabel12)
                    .addComponent(balance))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(deposit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(investment)
                                .addComponent(investmentIcon))
                            .addComponent(depositIcon))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(withdraws)
                    .addComponent(withdrawIcon)
                    .addComponent(accountIcon)
                    .addComponent(account))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(transactionIcon)
                    .addComponent(transactions)
                    .addComponent(exitIcon)
                    .addComponent(exit))
                .addGap(30, 30, 30))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(transactionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transactions))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(withdrawIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(withdraws))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(depositIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deposit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(investmentIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(investment))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(exitIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(exit)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(accountIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(account)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void depositclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositclicked
        boolean validInput = false;
        double amount = -1;

        while (!validInput) {
            try {
                try {
                    amount = Double.parseDouble(JOptionPane.showInputDialog(rootPane, "Amount you want to deposit: "));
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Input is null");
                    break;
                }
                validInput = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Input should be number");
            }
        }
        if (amount >= 1) {
            String purpose = JOptionPane.showInputDialog(rootPane, "Purpose: ");
            try {
                loggedUser.deposit(amount, purpose);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
            balance.setText("RS " + loggedUser.getBalance());
            LocalDate ldate = LocalDate.now();
            date = ldate.toString();
            userTransaction.push("Deposit", date, String.valueOf(amount), purpose);
            JOptionPane.showMessageDialog(rootPane, "Amount Deposit Successful");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Invalid Amount!");
        }
    }//GEN-LAST:event_depositclicked

    private void withdrawClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withdrawClicked
        boolean validInput = false;
        double amount = 0;

        while (!validInput) {
            try {
                try {
                    amount = Double.parseDouble(JOptionPane.showInputDialog(rootPane, "Amount you want to Withdraw: "));
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Input is null");
                    break;
                }
                validInput = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Input should be number");
            }
        }
        if (amount >= 1) {
            String purpose = JOptionPane.showInputDialog(rootPane, "Purpose: ");
            String message = "";
            try {
                message = loggedUser.withdraw(amount, purpose);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
            if ("Withdraw Successful".equals(message)) {
                balance.setText("RS " + loggedUser.getBalance());
                LocalDate ldate = LocalDate.now();
                date = ldate.toString();
                userTransaction.push("Withdraw", date, String.valueOf(amount), purpose);

            }
            JOptionPane.showMessageDialog(rootPane, message);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Invalid Amount!");
        }
    }//GEN-LAST:event_withdrawClicked

    private void exitClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitClicked
        System.exit(0);
    }//GEN-LAST:event_exitClicked

    private void transactionClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionClicked

        RecentTransactions trans = new RecentTransactions(loggedUser, userTransaction.peek());
        trans.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        trans.setVisible(true);

    }//GEN-LAST:event_transactionClicked

    private void accClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accClicked
        Account acc;
        acc = new Account(loggedUser);
        acc.setVisible(true);
        dispose();
    }//GEN-LAST:event_accClicked

    private void investmentClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_investmentClicked
        InvestmentAdvice advice = new InvestmentAdvice();
        advice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        advice.setVisible(true);
    }//GEN-LAST:event_investmentClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel account;
    private javax.swing.JLabel accountIcon;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel deposit;
    private javax.swing.JLabel depositIcon;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exitIcon;
    private javax.swing.JLabel investment;
    private javax.swing.JLabel investmentIcon;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel transactionIcon;
    private javax.swing.JLabel transactions;
    private javax.swing.JLabel username;
    private javax.swing.JLabel withdrawIcon;
    private javax.swing.JLabel withdraws;
    // End of variables declaration//GEN-END:variables

    private void linkedListCreation() throws FileNotFoundException {
        File transData = new File(loggedUser.getUid() + "_transactions.txt");
        Scanner reader = new Scanner(transData);
        String content = "";
        while (reader.hasNextLine()) {
            content = reader.nextLine();
            String[] tempData = content.split(" split ");
            userTransaction.push(tempData[0], tempData[1], tempData[2], tempData[3]);
        }
    }

}
