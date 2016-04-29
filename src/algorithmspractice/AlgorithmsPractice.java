
package algorithmspractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class AlgorithmsPractice {

    public static void main(String[] args) {
        int [] arr = {1, 1, 1, 0, 0};
    }

    public static void stopAfter42() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while((n = in.nextInt()) != 42) {
            System.out.println(n);
        }
    }
    public static void genPrimes(int lower, int upper) {
        for(int i = lower; i < upper + 1; i++) {
            int k = i - 1;
            boolean prime = true;
            while(k > 1) {
                if(i % k == 0)
                    prime = false;
                k -= 1;
            }
            if(prime)
                System.out.println(i);
        }
    }
    public static void isSub(String s, String sub) {
        for(int i=0; i < s.length(); i++) {
            
            int j = i;
            int k = 0;
            
            while(s.charAt(j) == sub.charAt(k) && k < sub.length() && j < s.length()) {
                if(k == sub.length() - 1) {
                    System.out.println("Yes");
                    return;
                }
                j += 1;
                k += 1;
            }
        }
        System.out.println("No");
    }
    public static void toRPN(String expresssion) {
        Stack<Character> s = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for(Character c : expresssion.toCharArray()) {
            if(c >= '0' && c <= '9')
                builder.append(c);
            else {
                switch(c) {
                        case('^'):
                            s.push(c);
                        case('*'):
                            if(s.contains('^')) {
                                builder.append(s.toString());
                                s.removeAllElements();
                            }
                            else
                                s.push(c);
                        case('/'):
                            if(s.contains('^') || s.contains('*')) {
                                builder.append(s.toString());
                                s.removeAllElements();
                            }
                            else
                                s.push(c);
                        case('+'):
                            if(s.contains('^') || s.contains('*') || s.contains('/'))
                            {
                                builder.append(s.toString());
                                s.removeAllElements();
                            }
                        case('-'):
                            if(s.contains('^') || s.contains('*') || s.contains('/') || s.contains('+'))
                            {
                                builder.append(s.toString());
                                s.removeAllElements();
                            }
                        case('('):
                            s.push(c);
                        case(')'):
                            // remove (
                            builder.append(s.toString());
                            s.removeAllElements();
                }
            }
        } // for
        if(!s.empty())
            builder.append(s.toString());
        System.out.println("result: " + builder.toString());
    }
    public static void nextPalindrone(int n) {
        n += 1;
        while(n < 1000000) {
            String nstr = Integer.toString(n);
            if(nstr.equals(reverse(nstr))) {
                System.out.println(nstr);
                return;
            }
            n += 1;
        }
    }
    public static String reverse(String s) {
        String reversed = "";
        int i = s.length() - 1;
        while(i >= 0) {
            reversed += s.charAt(i);
            i -= 1;
        }
        return reversed;
    }
    public static void lexographicGrid(char [][] grid) {
        char prev = ' ';
        for(char [] line : grid) {
            line = insertionSort(line);
            if(prev == ' ')
                prev = line[line.length - 1];
            else if(prev > line[0])
            { System.out.println("NO"); return;}
            else
                prev = line[line.length - 1];
        }
        System.out.println("YES");
    }
    public static char [] insertionSort(char [] arr) {
        int i = 1;
        while(i < arr.length) {
            int k = i;
            while(k > 0 && arr[k - 1] > arr[k]) {
                char tmp = arr[k];
                arr[k] = arr[k - 1];
                arr[k - 1] = tmp;
                k -= 1;
            }
            i += 1;
        }
        return arr;
    }
    public static int [] rotate(int [] arr, int offset) {
        int [] result = new int [arr.length];
        for(int i=0; i < arr.length; i++) {
            int tmp = arr[i];
            int val = i + offset;
            if(val >= arr.length) {
                result[val - arr.length] = tmp;
            }
            else
                result[val] = tmp;
        }
        return result;
    }
    public static int squareRoot(int num) {
        int i = num - 1;
        List<Integer> factors = new ArrayList<>();
        while(i >= 1) {
            if(num % i == 0)
                factors.add(i);
            i -= 1;
        }
        for(int factor : factors) {
            if(Math.sqrt(num) == factor)
                return factor;
        }
        return -1;
    }

}
