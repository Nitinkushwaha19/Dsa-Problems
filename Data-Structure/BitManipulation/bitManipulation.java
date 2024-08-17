public class bitManipulation {

    public static void oddOrEven(int num) {
        int bitmask = 1;
        if ((num & bitmask) == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int clearIBits(int n, int i) {
        int bitMask = (~0) << i;
        return n & bitMask;
    }

    public static int clearInRangeBits(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = ((1 << i) - 1);
        int bitMask = a | b;
        return n & bitMask;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) { // check our lsb
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // // Bitwise & operator
        // System.out.println(5&4);

        // // OR | operator
        // System.out.println(5|6);

        // // XOR ^ operator
        // System.out.println(5^6);

        // // Binary 1's complement
        // System.out.println(~0);

        // // Binary left shift <<
        // System.out.println(5<<2);

        // // Binary right shift >>
        // System.out.println(5>>2);

        // // Check odd or even
        // oddOrEven(3);
        // oddOrEven(6);

        // get ith bit
        // System.out.println(getIthBit(10, 3));

        // set ith bit
        // System.out.println(setIthBit(10, 2));

        // clear ith bit
        // System.out.println(clearIthBit(10, 1));

        // update ith bit
        // System.out.println(updateIthBit(10, 2, 1));

        // clear last ith bits
        // System.out.println(clearIBits(15, 2));

        // Clear bits in range
        // System.out.println(clearInRangeBits(10, 2, 4));

        // Is power of 2 or not
        // System.out.println(isPowerOfTwo(16));

        // Count 1
        // System.out.println(countSetBits(2));

        // Fast Exponentiation 
        System.out.println(fastExpo(5, 3));
    }
}
