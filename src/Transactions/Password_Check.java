package Transactions;
import java.util.regex.*;

public class Password_Check{
    //final private String regString = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*+-()])(?=\\S+$).{8,25}$";
    //final private Pattern p = Pattern.compile(regString);
    //String Pass;
    private int count = 0;
    private int flag_count1 = 0;
    private int flag_count2 = 0;

    public int checkPassword(String password){

        if((password.length() >= 8) && (password.length() <= 35)) {
            count++;
        }
        if(!(password.contains(" "))){
            count++;
        }
        for(int i = 0; i <= 9; i++){
            String str1 = Integer.toString(i);
            if(password.contains(str1)){
                flag_count1++;
            }
        }
        if(password.matches(".*[@#$%^&*+-()].*")){
            count++;
        }
        for(char c : password.toCharArray()){
            if(Character.isUpperCase(c)){
                flag_count2++;
            }
        }
        for(char c : password.toCharArray()) {
            if(Character.isLowerCase(c)) {
                flag_count2++;
            }
        }
        
        if(count >= 2 && flag_count1 >=3 && flag_count2 >=5){
            count = 0; flag_count1 = 0; flag_count2 = 0;
            return 1;
        }
        else if(count == 2 && flag_count1 >=1 && flag_count2 >= 3){
            count = 0; flag_count1 = 0; flag_count2 = 0;
            return 0;
        }
        else if(count == 1 && (flag_count1 <= 5 || flag_count2 <= 5)){
            count = 0; flag_count1 = 0; flag_count2 = 0;
            return -1;
        }
        else{
            return 2;
        }
    }
}
