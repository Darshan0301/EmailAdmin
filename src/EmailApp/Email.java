package EmailApp;


import java.util.Scanner;

public class Email {
    private String companysuffix="Techforce";
    private String firstname;
    private String lastname;
    private String email;
    private static int numid=1;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String altemail;


    //Constructor
    public Email(String firstname,String lastname){
        this.firstname=firstname;
        this.lastname=lastname;
        System.out.println("Email Created: "+this.firstname+" "+this.lastname);

        this.department=setDepartment();
        System.out.println("Department: "+this.department);

        this.email=this.firstname.toLowerCase()+"."+this.lastname.toLowerCase()+(numid++)+
                    "@"+this.department.toLowerCase()+"."+companysuffix.toLowerCase()+".com";
        System.out.println("Email Id is: "+this.email);

        this.password=setRandomPassword();
        System.out.println("You're Password: "+this.password);
        DataSaver.saveEmailData(firstname, lastname, email, password);
    }

    //Ask for department
    private String setDepartment(){
        System.out.print("Department Code\n1:Sales\n2:Development\n3:Accounting\nEnter Department Code: ");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();

        if(choice==1){ return "Sales"; }
        else if(choice==2){ return "Development"; }
        else if(choice==3){ return "Accounting"; }
        else {return "";}
    }

    //Generate Random Password
    private String setRandomPassword(){
        String passwordSet="QWERTYUIOPASDFGHJKLZXCVBNMmnbvcxzlkjhgfdsapoiuytrewq1234567890!@#$%^&*()-_+=";
        int passlen=8;
        char[] password=new char[passlen];

        for(int i=0;i<passlen;i++){
            int rand=(int)(Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }

        return new String(password);
    }

    //Set the mailbox capacity

    //set alternate email

    //change Password
    public void changePassword() {
        System.out.println("Please Enter Password");
        Scanner scanner=new Scanner(System.in);
        String password=scanner.nextLine();
        if(!(checkPassword(password))){
            throw new IllegalArgumentException("Please Enter a Valid Password: " +
                    "It must contain at least one uppercase letter, " +
                    "one lowercase letter, one digit, and one special character.");
      }
        scanner.close();
        this.password=password;
        DataSaver.saveEmailData(firstname, lastname, email, password);
        System.out.println("Password for "+this.email+" is: "+this.password);
    }
    private boolean checkPassword(String password){
        if(!(password.length()>6 && password.length()<15)){
            return false;
        }
        boolean uppercase=false;
        boolean lowercase=false;
        boolean digit=false;
        boolean spchar=false;

        for(char ch:password.toCharArray()){
            if(Character.isUpperCase(ch)) { uppercase=true; }
            else if (Character.isLowerCase(ch)) { lowercase=true; }
            else if(Character.isDigit(ch)) { digit=true; }
            else if (!(Character.isLetterOrDigit(ch))){ spchar=true; }
        }

        return uppercase && lowercase && digit && spchar;
    }

}
