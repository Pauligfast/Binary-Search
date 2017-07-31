package com.company;

//Pavlo Khryshcheniuk


import java.util.Scanner;

public class Main {

    public static Scanner inScan = new Scanner(System.in);

    public static int find(long searchKey, long[] tab, int n, boolean ifbegin) {
        int low = 0;
        int upp = n - 1;

        int cur = -1;

        while (low <= upp) {

            cur = (low + upp) / 2;

            if (tab[cur] == searchKey) {

                if (ifbegin) {
                    if (cur - 1 >= 0 && tab[cur] == tab[cur - 1]) {
                        upp = cur - 1;
                    } else {
                        return cur;
                    }
                } else {
                    if (cur + 1 < n && tab[cur] == tab[cur + 1]) {
                        low = cur + 1;
                    } else {
                        return cur;
                    }
                }
            } else {
                if (tab[cur] < searchKey) {
                    low = cur + 1;
                } else {
                    upp = cur - 1;
                }

            }
        }
        return cur;
    }

    public static void main(String[] args) {

        int numofreps = inScan.nextInt();

        while (numofreps-- > 0) {

            int n = inScan.nextInt();
            long[] tab = new long[n];

            for (int i = 0; i < n; i++) {
                tab[i] = inScan.nextLong();
            }

            int qreps = inScan.nextInt();

            int[] tabcount = new int[qreps];
            for (int w = 0; w < qreps; w++) {

                long a = inScan.nextLong();
                long b = inScan.nextLong();
                tabcount[w] = 0;
                if (b >= a) {

                    int begin = find(a, tab, n, true);

                    int end = find(b, tab, n, false);

                    tabcount[w] = 0;
                    for (int i = begin; i <= end; i++) {
                        if (tab[i] >= a && b >= tab[i])
                            tabcount[w]++;
                    }

                }

            }

            for (int i = 0; i < qreps; i++) {
                System.out.println(tabcount[i]);
            }
        }
    }

}
