package PasswordGenerator;

public class Password {
    String value;
    int length;

    public Password(String str){
        value=str;
        length=str.length();
    }

    public int charType(char ch){
        int val;
        if((int)ch>=65 && (int)ch<=90){
            val=1;
        }else if((int)ch>=97 && (int)ch<=122){
            val=2;
        }else if((int)ch>=48 && (int)ch<=57){
            val=3;
        }else{
            val=4;
        }
        return val;
    }

    public int PasswordStrength(){
        String s=this.value;
        boolean usedUpper=false;
        boolean usedLower=false;
        boolean usedNum=false;
        boolean usedSym=false;
        int type;
        int score=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            type=charType(ch);

            if(type==1){
                usedUpper=true;
            }else if(type==2){
                usedLower=true;
            }else if(type==3){
                usedNum=true;
            }else{
                usedSym=true;
            }
        }

        if(usedUpper) score++;
        if(usedLower) score++;
        if(usedNum) score++;
        if(usedSym) score++;

        if(s.length()>=8) score++;
        if(s.length()>=16) score++;

        return score;
    }

    public String calculateScore(){
        int Score=this.PasswordStrength();
        if(Score==6){
            return "Very Strong Password...";
        }else if(Score>=4){
            return "Good Password. See useful info section to make it stronger...";
        }else if(Score>=3){
            return "Weak Password. Try making it stronger by following guidelines from useful info section...";
        }else{
            return "Very Weak Password. Follow guidelines from useful info section...";
        }
    }

    @Override
    public String toString(){
        return value;
    }
}
