public class RomanNum {
    public static String toRoman(int n) {

        int a,b,c,d=0;
        StringBuffer sb = new StringBuffer();

        a = n/1000;
        b = (n-a*1000)/100;
        c = (n-a*1000-b*100)/10;
        d = n-a*1000-b*100-c*10;

        if(a>0){
            for(int i = 0; i<a; i++){
                sb.append("M");
            }
        }

        if(b>0){
            if(0<b && b<4){
                for(int i = 0; i<b; i++){ sb.append("C");}
            }
            else if(b==4){sb.append("CD");}
            else if(b==5){sb.append("D");}
            else if(5<b && b<9){
                sb.append("D");
                for(int i = 0; i<b-5; i++){ sb.append("C");}
            }
            else if(b==9){sb.append("CM");}
        }

        if(c>0){
            if(0<c && c<4){
                for(int i = 0; i<c; i++){ sb.append("X");}
            }
            else if(c==4){sb.append("XL");}
            else if(c==5){sb.append("L");}
            else if(5<c && c<9){
                sb.append("L");
                for(int i = 0; i<c-5; i++){ sb.append("X");}
            }
            else if(c==9){sb.append("XC");}
        }

        if(d>0){
            if(0<d && d<4){
                for(int i = 0; i<d; i++){ sb.append("I");}
            }
            else if(d==4){sb.append("IV");}
            else if(d==5){sb.append("V");}
            else if(5<d && d<9){
                sb.append("V");
                for(int i = 0; i<d-5; i++){ sb.append("I");}
            }
            else if(d==9){sb.append("IX");}
        }
        String result = sb.toString();
        return result;
    }

    public static int fromRoman(String romanNumeral) {
        int result = 0,vol = 0;
        String[] romalNum = romanNumeral.split("");
        String roma1 = null;
        String roma2 = null;
        String roma3 = null;

        for(int i = 0; i<romalNum.length; i++){
            System.out.println(romalNum[i]);


            if(romalNum[i].contains("C")||romalNum[i].contains("D")){
                vol = 100;
                roma1 = "C";
                roma2 = "D";
                roma3 = "M";
            }else if(romalNum[i].contains("X")||romalNum[i].contains("L")){
                vol = 10;
                roma1 = "X";
                roma2 = "L";
                roma3 = "C";
            }else if(romalNum[i].contains("I")||romalNum[i].contains("V")){
                vol = 1;
                roma1 = "I";
                roma2 = "V";
                roma3 = "X";
            }
            if(romalNum[i].contains("M")){
                result += 1000;
            }
            else if(romalNum[i].contains(roma1)){
                result += vol;

                try {
                    if(romalNum[i+1].contains(roma3)){
                        result += 8*vol;
                        i += 1;
                        continue;
                    }
                    else if(romalNum[i+1].contains(roma2)){
                        result += 3*vol;
                        i += 1;
                        continue;
                    }
                    else if(romalNum[i+1].contains(roma1)){
                        result +=vol;
                        if(romalNum[i+2].contains(roma1)){
                            result +=vol;
                            i += 2;
                        }else {
                            i += 1;
                        }
                        continue;
                    }
                }catch(Exception e) {
                    i++;
                }
            }
            else if(romalNum[i].contains(roma2)){
                result +=5*vol;
                try {
                    if(romalNum[i+1].contains(roma1)){
                        result += vol;
                        if(romalNum[i+2].contains(roma1)){
                            result += vol;
                            if(romalNum[i+3].contains(roma1)){
                                result += vol;
                                i += 3;
                                continue;
                            }
                            i += 2;
                            continue;
                        }
                        i += 1;
                        continue;
                    }
                }catch(Exception e) {
                    i++;
                    break;
                }
            }

        }
        return result;
    }
}
