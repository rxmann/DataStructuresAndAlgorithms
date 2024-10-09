package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

public class segmentedSieve {



    // splits the range into smaller segments and processes them one at a time, reducing memory consumption
    // a better solution to sieve of eratosthenes

        private static List<Integer> simpleSieve (int N) {

            if (N <= 1) return new ArrayList<>();

            boolean[] isComposite = new boolean[N+1];
            // check for each element in range 2 to square root of N
            for (int i=2; i*i<=N; i++) {
                if (!isComposite[i]) {
                    // since this is a prime number, we would cancel all multiple of it up to N
                    for (int j=i*i; j<=N; j+=i) {
                        isComposite[j] = true;
                    }
                }
            }
            List<Integer> res = new ArrayList<>();
            // collect primes
            for (int i=2; i<isComposite.length; i++) {
                if (!isComposite[i]) {
                    res.add(i);
                }
            }
            return res;

        }

    private static List<Integer> findSegmentedSieve(int n) {

        int limit = (int) Math.sqrt(n);
        System.out.println("Square root N, limit: " + limit);
        List<Integer> primes = simpleSieve(limit);

        System.out.println("Initial primes for limit: " + primes);
        List<Integer> result = new ArrayList<>(primes); // Add initial primes to the result
        int start = limit;
        int end = start * 2;

        // Process segments of size "limit"
        while (start < n) {
            // Check if the end exceeds n
            if (end > n) end = n;

            // Create an array for marking primes in the current segment
            boolean[] isPrime = new boolean[end - start + 1];
            Arrays.fill(isPrime, true); // Initially mark all as prime

            // Mark non-primes using the previously found primes
            for (int i = 0; i < primes.size(); i++) {
                int currentPrime = primes.get(i);

                // Find the first multiple of currentPrime in the current segment
                // because we have to find the primes in this range
                // start , start+1, start+2, start+3, ... end-2, end-1, end.
                int lowPrime = Math.max(currentPrime * currentPrime, (start / currentPrime) * currentPrime);
                if (lowPrime < start) lowPrime += currentPrime;

                // Mark multiples of currentPrime as non-prime in the current segment
                for (int j = lowPrime; j < end; j += currentPrime) {
                    isPrime[j - start] = false; // Mark non-prime
                }
            }

            // Collect all primes in this segment
            for (int i = start; i < end; i++) {
                if (isPrime[i - start]) {
                    result.add(i); // Add prime to result list
                }
            }

            // Move to the next segment
            start += limit;
            end += limit;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> ans = findSegmentedSieve(100);
//        List<Integer> res = simpleSieve(10);
        System.out.println(ans);
    }
}
