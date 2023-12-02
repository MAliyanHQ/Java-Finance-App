
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Transaction {

    String purpose;
    double amount;
    String date;
    String transact;
    
    public Transaction(String purpose, double amount, String transact, String id) {
        this.purpose = purpose;
        this.amount = amount;
        this.transact = transact;
        LocalDate ldate = LocalDate.now();
        date = ldate.toString();
        String filename = id + "_transactions.txt";
        try {
            WriteFile(filename, purpose, amount, transact, date);
            // Push the transaction data onto the stack
        } catch (IOException ex) {
            String error = ex.getMessage();
        }
    }
    
    static void WriteFile(String name, String purpose, double amount, String transact, String date) throws FileNotFoundException, IOException {
        File f1 = new File(name);
        if (f1.createNewFile()) {
            FileWriter wf = new FileWriter(name);
            wf.write(transact + " split " + date + " split " + amount + " split " + purpose + "\n");
            wf.close();
        } else {
            FileWriter af = new FileWriter(name, true);
            af.write(transact + " split " + date + " split " + amount + " split " + purpose + "\n");
            af.close();
        }
    }
}
