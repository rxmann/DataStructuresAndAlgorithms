
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> primes =  segentedSieve(100);
        System.out.println(primes);
    }

    private static List<Integer> segentedSieve (int n) {

        int limit = (int) Math.sqrt(n);
        List<Integer> primes = new ArrayList<>();
        simpleSieve(limit, primes);

        int start = limit;
        int end = limit + limit;

        while (start < end) {

            if (end >= n) end = n;

            boolean[] isComposite = new boolean[limit];

            // find the smallest multiple equal or greater than the start
            // because we have to find the primes in this range
            // start , start+1, start+2, start+3, ... end-2, end-1, end.

            for (int i=0; i<primes.size(); i++) {
                int currentPrime = primes.get(i);

                int lowPrime = (start/currentPrime) * currentPrime;

                int startIdx = Math.max(lowPrime, lowPrime+currentPrime);

                for (int j=startIdx; j<end; j+=currentPrime) {
                    isComposite[j - start] = true;
                }

            }

            // collect primes
            for (int i=start; i<end; i++) {
                if (!isComposite[i - start]) {
                    primes.add(i);
                }
            }

            start += limit;
            end += limit;
        }
        return primes;
    }

    private static void simpleSieve (int n, List<Integer> primes) {

        if (n <= 1) return;

        boolean[] isComposite = new boolean[n];

        // select all primes and mark its multiple as composite
        for (int i=2; i*i<n; i++) {
            if (!isComposite[i]) {
                for (int j=i*i; j<n; j+=i) {
                    isComposite[j] = true;
                }
            }
        }


        // collect primes
        for (int i=2; i<isComposite.length; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }

    }


}
