public class Algorithm{
    public static void main(String[] args) {
        String s1 = "ABCDCBDCBDACBDABDCBADF";
        String s2 = "ADF";
        System.out.println(occurance(s1, s2));
        System.out.println(search(s2, s1));
    }

    public static int occurance(String s1, String s2){
        int position = -1;
        boolean found = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                position = i;
                for (int j = 0; j < s2.length(); j++) {
                    if (s1.charAt(i) != s2.charAt(j)) {
                        i = position;
                        position = -1;
                        found = false;
                        break;
                    }                    
                    found = true;
                    i++;
                }
            }
            if (found) {
                break;
            }
        }
        return position;
    }

    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);
     
        for (int i = 0; i <= N - M; i++) {
           long txtHash = hash(txt.substring(i, i+M), M);
           if (patHash == txtHash)
              return i;
        }
        return N;
     }

     public static long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
           h = (h * 26 + s.charAt(j)) % Integer.MAX_VALUE;
        return h;
     }
}
