package PasswordGenerator;
import java.util.*;

public class Generator {
    Alphabet alphabet;
    public static Scanner scanner;

    public Generator(Scanner sc){
        scanner=sc;
    }

    public Generator(boolean upperInclude,boolean lowerInclude,boolean numbersInclude,boolean symbolsInclude){
        alphabet=new Alphabet(upperInclude,lowerInclude,numbersInclude,symbolsInclude);
    }

    public void mainLoop(){
        System.out.println("Welcome to Password Generator Services... ");
        printMenu();
        int userOption=-1;
        while(userOption!=4){
            userOption=scanner.nextInt();
            switch(userOption){
                case 1: requestPassword();
                        printMenu();
                        break;
                case 2: checkPassword();
                        printMenu();
                        break;
                case 3: printUsefulInfo();
                        printMenu();
                        break;
                case 4: printQuitMessage();
                        break;
                default: System.out.println("Invalid input. Kindly input one of the choices....");
                         printMenu();
            }
        }
    }
    private Password generatePassword(int length){
        final StringBuilder pass=new StringBuilder("");
        final int alphabetLength=alphabet.getAlphabet().length();
        int mx=alphabetLength-1;
        int mn=0;
        int range=mx-mn+1;
        for(int i=0;i<length;i++){
            int idx=(int)(Math.random()*range)+mn;
            pass.append(alphabet.getAlphabet().charAt(idx));
        }
        return new Password(pass.toString());
    }

    private void printUsefulInfo(){
        System.out.println("Use a minimum length of 8 characters for the password...");
        System.out.println("Include uppercase, lowercase, numbers and symbols if possible....");
        System.out.println("Avoid using personal info like DOB,phone number etc....");
    }

    private void requestPassword(){
        boolean upperInclude=false;
        boolean lowerInclude=false;
        boolean numbersInclude=false;
        boolean symbolsInclude=false;

        boolean correctParameters;
        System.out.println("Welcome to Password Generator: ");
        System.out.println("Enter the answers to the asked questions in Yes or No....");

        do{
            String input;
            correctParameters=false;
            do{
                System.out.println("Do you want lowercase characters to be used? ");
                input=scanner.next();
                passwordRequestError(input);
            }while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            if(isInclude(input)){
                lowerInclude=true;
            }

            do{
                System.out.println("Do you want uppercase characters to be used? ");
                input=scanner.next();
                passwordRequestError(input);
            }while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            if(isInclude(input)){
                upperInclude=true;
            }

            do{
                System.out.println("Do you want numbers to be used? ");
                input=scanner.next();
                passwordRequestError(input);
            }while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            if(isInclude(input)){
                numbersInclude=true;
            }

            do{
                System.out.println("Do you want symbols to be used? ");
                input=scanner.next();
                passwordRequestError(input);
            }while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            if(isInclude(input)){
                symbolsInclude=true;
            }

            if(!upperInclude && !lowerInclude && !numbersInclude && !symbolsInclude){
                System.out.println("You selected no characters...");
                correctParameters=true;
            }

        }while(correctParameters);

        System.out.println("Great. Kindly enter the length of password....");
        int length=scanner.nextInt();
        final Generator generator=new Generator(upperInclude,lowerInclude,numbersInclude,symbolsInclude);
        final Password password=generator.generatePassword(length);
        System.out.println("Your generated password is : "+password);
    }

    private boolean isInclude(String input){
        if(input.equalsIgnoreCase("yes")){
            return true;
        }else{
            return false;
        }
    }

    private void passwordRequestError(String str){
        if(!str.equalsIgnoreCase("yes") && !str.equalsIgnoreCase("no")){
            System.out.println("You have entered something invalid....");
        }
    }

    private void checkPassword(){
        String input;
        System.out.println("Enter your password: ");
        input=scanner.next();
        final Password p=new Password(input);
        System.out.println(p.calculateScore());
    }

    private void printMenu(){
        System.out.println("1. Password Generator ");
        System.out.println("2. Password Strength Checker ");
        System.out.println("3. Userful Info. Section ");
        System.out.println("4. Exit ");
        System.out.println("Enter your choice: ");
    }

    private void printQuitMessage(){
        System.out.println("Exiting the program... Have a nice day :)");
    }
}
