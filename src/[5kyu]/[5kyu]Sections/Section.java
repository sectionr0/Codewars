import java.util.ArrayList;

class Section {

    public static int c(long k) {

        int count=1;
        long z = k;
        if(z==1){return 1;}

        long x = (long) Math.sqrt(z);
        if(x*x == z) {
            long n = (long) Math.pow(x, 3);

            for(long i=2; i<=n; i++)
            {
                int e = 0;
                for(; n%i==0; e++){n/=i;}

                count*= e+1;
            }
        }
        else return 0;

        return count;
    }
}