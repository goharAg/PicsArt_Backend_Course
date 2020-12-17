import java.util.Scanner;
import java.util.Stack;
import java.util.logging.SocketHandler;

public class StackHw {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        String text = sc.next();

        System.out.println(isMatching(text));

    }

    public static boolean isMatching(String text){
        Stack<Character> stc = new Stack<>();
        String opening = "({[";
        String closing = ")}]";

        for(char c : text.toCharArray()){
            if(opening.indexOf(c) != -1 ){
                stc.push(c);
            }
            else if(closing.indexOf(c) !=-1){
                if(stc.empty()){
                    return false;
                }
                if(closing.indexOf(c) != opening.indexOf(stc.peek()) ){
                    return false;
                }
                stc.pop();
            }

        }
        if(stc.empty()){
            return true;
        }
        else{
            return false;
        }
    }

}


