package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Sieve of Eratosthenes


public class sieveEratosthenes {


    // count
    private static int findPrimeCounts (int N) {

        boolean[] isPrime =  new boolean[N+1];

        int count = 0;

        for (int i = 2; i * i <= N; i++) {  // Loop from 2 to sqrt(N)

            // If current number is prime
            if (!isPrime[i]) {

                // Start marking multiples of i from i * i, since smaller multiples are already marked
                for (int j = i * i; j < N; j += i) {
                    isPrime[j] = true;
                    count++;
                }
            }
        }

        return count;
    }


    // list
    private static List<Integer> findPrimeSOE(int N) {

        boolean[] isPrime =  new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {  // Loop from 2 to sqrt(N)

            // If current number is prime
            if (isPrime[i]) {

                // Start marking multiples of i from i * i, since smaller multiples are already marked
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;  // Mark multiple of i as non-prime
                }
            }
        }



        List<Integer> result = new ArrayList<>();

        for (int i=2; i<N; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }

        return result;
    }


    public static void main(String[] args) {
//        List<Integer> ans = findPrimeSOE(10);
//        System.out.println(ans);
        int count = findPrimeCounts(10);
        System.out.println(count);
    }


}
