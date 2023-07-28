import Dictionary.MyHashtable;
import java.util.Scanner;

public class PasswordManager {
// password manager uses a hashtable to store and retrieve passwords 
 private MyHashtable psTable;

 public PasswordManager(int s){
   psTable = new MyHashtable(s);
 //Constructor calls MyHashtable
}

public String getP(String s)
{
    return (String) psTable.get(s);
    //gets the password
}

public void removeP(String s)
{
    psTable.remove(s);
    // removes the password
}

public boolean empty()
{
return psTable.isEmpty();
 // returns a boolean value based off the size in MyHashtable
}

 
  public void add(String a, String s) 
{
    psTable.put(a, s);
    // add password
}



public void clear() {
    psTable.clear();
    // clear password
}


 public void printP() {
    String[] PasswordAccounts = psTable.getKeys();
    for (String a : PasswordAccounts) {
        System.out.println("Your Account is: " + a + ", Password: " + psTable.get(a));
    }
    // print account and password
}

    public static void main(String[] args) {
        PasswordManager p = new PasswordManager(8);
    // hashtable can store 8
        Scanner s = new Scanner(System.in);
 
        while (true) {
            System.out.println("1. Print password");
            System.out.println("2. Get password");
            System.out.println("3. Add password");
            System.out.println("4. Remove password");     
            System.out.println("5. Is the manager empty?");           
            System.out.println("6. Clear all passwords");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
       // provide a list of options of the individual
         int descision = s.nextInt();
            s.nextLine();

       switch (descision) {
        case 1:
        p.printP();
        // print
        break;
        case 2:
        System.out.print("Please provide account name: ");
       String pass =  p.getP(s.nextLine());
        if (pass == null)
        {
            System.out.println("Not found");
        }
        else
        {
            System.out.println("Here is your password " + pass);
        }
        //get password
        break;
        case 3:
        System.out.print("Please provide account: ");
        String a = s.nextLine();
                    System.out.print("Please provide password: ");
                    String c = s.nextLine();
                    p.add(a,c);
                    break;
        // add password
        case 4:
        System.out.print("Please enter account name: ");                  
                    p.removeP(s.nextLine());
                    break;
         // remove password           
        case 5:
        System.out.println(p.empty());
                    break;
        // is it empty?
        case 6:
        p.clear();
        System.out.println("Cleared.");
                    break;
        // clear
        case 7:
                    s.close();
                    System.exit(0);
        // exit
        default:
        System.out.println("Try again, please.");
                }
       
       // did not recieve a number applicable
        }
    }
}