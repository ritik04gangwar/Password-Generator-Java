package PasswordGenerator;

public class Alphabet {

    public static final String upper_case_letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower_case_letters="abcdefghijklmnopqrstuvwxyz";
    public static final String numbers="1234567890";
    public static final String symbols="!@#$%^&*()_+{}|:<>?/[];-=";

    private final StringBuilder pool;

    public Alphabet(boolean upperCaseInclude,boolean lowerCaseInclude,boolean numbersInclude,boolean specialCharactersInclude){
        pool=new StringBuilder();
        if(upperCaseInclude==true){
            pool.append(upper_case_letters);
        }
        if(lowerCaseInclude==true){
            pool.append(lower_case_letters);
        }
        if(numbersInclude==true){
            pool.append(numbers);
        }
        if(specialCharactersInclude==true){
            pool.append(symbols);
        }
    }

    public String getAlphabet(){
        return pool.toString();
    }
}
