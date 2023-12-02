
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author sufiy
 */
public class User {
    private String name, role, uid;
    private String pin;
    private char gender;
    private double balance, income = 0;

    public User(String name, String role, String uid, String pin, char gender, double balance, double income) {
        this.name = name;
        this.role = role;
        this.uid = uid;
        this.pin = pin;
        this.gender = gender;
        this.balance = balance;
        this.income = income;
    }

    public double getBalance() {
        return balance;
    }

    public void setIncome(double income) throws IOException {
        String oldincome = String.valueOf(this.income);
        this.income = income;
        String newincome = String.valueOf(income);
        File pinUp = new File(uid + ".txt");
        BufferedReader reader = new BufferedReader(new FileReader(pinUp));
        String line = reader.readLine();
        String oldContent = "";
        while (line != null) {
            oldContent += line + System.lineSeparator();
            line = reader.readLine();
        }
        String newContent = oldContent.replaceAll(oldincome, newincome);
        FileWriter writer = new FileWriter(uid + ".txt");
        writer.write(newContent);
        writer.close();
        reader.close();
    }

    public String getUid() {
        return uid;
    }

    public String getRole() {
        return role;
    }

    public String getPin() {
        return pin;
    }

    public char getGender() {
        return gender;
    }

    public void setPin(String pin) throws IOException {
        String oldpin = this.pin;
        String newpin = pin;
        this.pin = pin;
        File pinUp = new File(uid + ".txt");
        BufferedReader reader = new BufferedReader(new FileReader(pinUp));
        String line = reader.readLine();
        String oldContent = "";
        while (line != null) {
            oldContent += line + System.lineSeparator();
            line = reader.readLine();
        }
        String newContent = oldContent.replaceAll(oldpin, newpin);
        FileWriter writer = new FileWriter(uid + ".txt");
        writer.write(newContent);
        writer.close();
        reader.close();
    }

    public String withdraw(double amount, String purpose) throws FileNotFoundException, IOException {
        if (amount < balance) {
            String oldbal;
            if (balance != 0) {
                oldbal = String.valueOf(balance);
            } else {
                oldbal = "0";
            }
            balance -= amount;
            Transaction t = new Transaction(purpose, amount, "Withdraw", uid);
            File balUp = new File(uid + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(balUp));
            String line = reader.readLine();
            String oldContent = "";
            while (line != null) {
                oldContent += line + System.lineSeparator();
                line = reader.readLine();
            }
            String newbal = String.valueOf(balance);
            String newContent = oldContent.replaceFirst(oldbal, newbal);
            FileWriter writer = new FileWriter(uid + ".txt");
            writer.write(newContent);
            writer.close();
            reader.close();
            return "Withdraw Successful";
        } else {
            return "You have not enough balance or Balance could not be Zero";
        }
    }

    public void deposit(double amount, String purpose) throws IOException {
        String oldbal;
        if (balance != 0) {
            oldbal = String.valueOf(balance);
        } else {
            oldbal = "0";
        }
        balance += amount;
        Transaction t = new Transaction(purpose, amount, "Deposit", uid);
        File balUp = new File(uid + ".txt");
        BufferedReader reader = new BufferedReader(new FileReader(balUp));
        String line = reader.readLine();
        String oldContent = "";
        while (line != null) {
            oldContent += line + System.lineSeparator();
            line = reader.readLine();
        }
        String newbal = String.valueOf(balance);
        String newContent = oldContent.replaceFirst(oldbal, newbal);
        FileWriter writer = new FileWriter(uid + ".txt");
        writer.write(newContent);
        writer.close();
        reader.close();
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

}

class Student extends User {

    private String educationlvl;
    private double pocketmoney;

    public Student(String educationlvl, double balance, String name, String role, String uname, String pin, char gender, double income) {
        super(name, role, uname, pin, gender, balance, income);
        this.educationlvl = educationlvl;
        this.pocketmoney = income;
    }

}

class Dependantonspouse extends User {

    private double monthlyallowance;

    public Dependantonspouse(double balance, String name, String role, String uname, String pin, char gender, double income) {
        super(name, role, uname, pin, gender, balance, income);
        this.monthlyallowance = income;
    }

}

class Employee extends User {

    private String companyname, jobtitle;
    private double salary;

    public Employee(String companyname, String jobtitle, double balance, String name, String role, String uname, String pin, char gender, double income) {
        super(name, role, uname, pin, gender, balance, income);
        this.companyname = companyname;
        this.jobtitle = jobtitle;
        this.salary = income;
    }

}

class Businessman extends User {

    private String businessname;
    private double avgincome;

    public Businessman(String businessname, double balance, String name, String role, String uname, String pin, char gender, double income) {
        super(name, role, uname, pin, gender, balance, income);
        this.businessname = businessname;
        this.avgincome = income;
    }

    public String getBusinessname() {
        return businessname;
    }

    public double getAvgincome() {
        return avgincome;
    }

}
