public class Algorithm{
    public static void main(String[] args){
        String s1 = "ABCDCBDCBDACBDABDCBADF";
        String s2 = "ADF";
        System.out.println(occurance(s1, s2));        
    }

    public static int occurance(String s1, String s2){
        int auxCounter = 0;
        int position = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (auxCounter >= s2.length() - 1) {
                break;
            }
            if (auxCounter > 0 && s1.charAt(i) != s2.charAt(auxCounter)) {
                auxCounter = 0;
                position = -1;
            }
            if (s1.charAt(i) == s2.charAt(auxCounter)) {
                if (auxCounter == 0) {
                    position = i;
                }
                auxCounter++;
            }            
        }
        return position;
    }

    
}