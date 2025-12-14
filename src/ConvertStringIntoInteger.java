public class ConvertStringIntoInteger {

    public static int stringToInt(String str){

        int result = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            int digit = c - '0';

            result = result * 10 + digit;
        }
        return result;
    }


    public static void main(String[] args) {
        String str = "45678";
        int result = stringToInt(str);
        System.out.println(result);



    }


}
