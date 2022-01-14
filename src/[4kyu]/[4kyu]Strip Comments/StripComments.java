import java.util.ArrayList;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        StringBuilder text1 = new StringBuilder();
        ArrayList<String> list = editString(text);
        for(String line:list) {
            text1.append(removeString(line, commentSymbols)).append("\n");
        }
        text1.deleteCharAt(text1.length()-1);
        if(SpaceAll(text1)) { return ""; }

        return text1.toString();
    }

    private static ArrayList<String> editString(String text) {
        StringBuilder text2 = new StringBuilder(text);
        ArrayList<String> result = new ArrayList<>();
        int index;
        for(int i=0; i<=result.size(); i++) {
            index = text2.indexOf("\n");
            if(index == -1) { break; }
            result.add(text2.substring(0, index));
            text2.delete(0, index+1);
        }
        result.add(text2.toString());
        System.out.println(result);

        return result;
    }


    private static Object removeString(String line, String[] commentSymbols) {
        StringBuilder result2 = new StringBuilder();
        char checkchar;
        boolean checking = true;

        for(int i=0; i<line.length(); i++) {
            checkchar = line.charAt(i);
            for(int j=0; j<commentSymbols.length; j++) {
                if( checkchar == commentSymbols[j].charAt(0)) {
                    checking = false;
                    break;
                }
            }

            if(checking) { result2.append(checkchar); }
            else break;
        }

        if(result2.length() != 0 && result2.charAt(result2.length()-1) == ' ') {
            result2.deleteCharAt(result2.length()-1);
        }

        return result2;
    }

    private static boolean SpaceAll(StringBuilder text){
        int count = 0;
        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) == ' ') { count++; }
        }

        if(count==text.length()) { return true; }
        return false;
    }

}