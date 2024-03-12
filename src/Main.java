//<---------------------HAR HAR MAHADEV------------------------>

//import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static long mod = (long)1e9+7;
    static int Size = (int) (5e5+5);
    static int TreeSize = 4*Size;
    static long [][]tree = new long[TreeSize][2];
    static long []arr = new long[Size];
    public static void buildTree(int st, int end, int node)
    {
        if(st==end) {
            tree[node][0] = arr[st];
            tree[node][1]=1;
            return;
        }
        int mid=(st+end)/2;
        buildTree(st,mid,2*node); //for 0 base indexing make 2*node+1 && 2*node+2
        buildTree(mid+1,end,2*node+1);
       if(tree[2*node][0]==tree[2*node+1][0])
       {
           tree[node][0]=tree[2*node][0];
           tree[node][1]=tree[2*node][1]+tree[2*node+1][1];
       }
       else if(tree[2*node][1]==tree[2*node+1][1])
       {
           tree[node][0]=tree[2*node][0];
           tree[node][1]=0;
       }
       else if(tree[2*node][1]>tree[2*node+1][1])
       {
           tree[node][0]=tree[2*node][0];
           tree[node][1]=tree[2*node][1]-tree[2*node+1][1];
       }
       else {
           tree[node][0]=tree[2*node+1][0];
           tree[node][1]=tree[2*node+1][1]-tree[2*node][1];
       }




    }
    public static long[] rangeQuery(int st, int end, int QueryStart, int QueryEnd, int node) {

        if (end < QueryStart || st > QueryEnd) {
            long x[] = {0, 0};
            return x;
        }
        if (end <= QueryEnd && st >= QueryStart) {
            long[] x = new long[2];
            x[0] = tree[node][0];
            x[1] = tree[node][1];
            return x;
        }
        int mid = (st + end) / 2;
        long left[] = rangeQuery(st, mid, QueryStart, QueryEnd, 2 * node);
        long right[] = rangeQuery(mid + 1, end, QueryStart, QueryEnd, 2 * node + 1);
        long a[]=new long[2];
        if(left[0]==right[0])
        {
            a[0]=left[0];
            a[1]=left[1]+right[1];
        }
        else if(left[1]==right[1])
        {
            a[0]=left[0];
        }
        else if(left[1]>right[1])
        {
            a[0]=left[0];
            a[1]=left[1]-right[1];
        }
        else{
            a[0]=right[0];
            a[1]=-left[1]+right[1];
        }
        return a;

    }
    public static int bsearchl(ArrayList<Integer>a ,int key)
    {
        int st=0,ed=a.size()-1;
        int ans=-1;
        while(st<=ed)
        {
            int mid=(st+ed)/2;
            if(a.get(mid)<=key)
            {
                ans=mid;
                st=mid+1;
            }
            else {
                ed=mid-1;
            }
        }
        return  ans+1;
    }



    static void Khud_Bhi_Krle_Kuch(int ct) throws IOException {
        int n=ni();
        int q=ni();
        arr=al(n);
        HashMap<Long ,ArrayList<Integer>>h=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer>a=new ArrayList<>();
            if(h.containsKey(arr[i]))
                a=h.get(arr[i]);
            a.add(i);
            h.put(arr[i],a);
        }
        buildTree(0,n-1,1);
        for(int i=0;i<q;i++)
        {
            int qs=ni()-1,qe=ni()-1;
            long cand=rangeQuery(0,n-1,qs,qe,1)[0];
            if(cand<1)
            {
                yes();
            }
            else {
                ArrayList<Integer> ax = h.get(cand);
//                out.println(cand);
                if (ax == null) {
                    yes();
                } else {
//            out.println(ax);
                    int cl = bsearchl(ax, qs - 1);
                    int cr = bsearchl(ax, qe);
//            /out.println(cr+" "+cl);
                    if (cr - cl > (qe - qs + 1) / 2)
                        no();
                    else
                        yes();
                }
            }


        }

    }
    //--------------------------------------MAIN--------------------------------------------//
    public static void main(String[] args) throws Exception {
//        sieve(1000007);
//        modFact();
//
        int t=ni();
//        int t=1;
        int ct=1;

        while (t--!=0)
        {

            Khud_Bhi_Krle_Kuch(ct);
            ct++;

        }
//
        out.close();}
    //--------------------------------------------Other Functions----------------------------------------------------//
    public static double nth_Root(double x, double y) {
        double a = 1, b = x;
        double mid = b;
        while (b - a > 0.000001) {
            mid = (a + b) / 2;
            float p = 1;
            for (int i = 0; i < y; i++) {
                p *= mid;
            }
            if (p < x) a = mid;
            else b = mid;
        }
        return mid;
    }

    public static int sum(int[] arr) {
        int s = 0;
        for (long i : arr) s += i;
        return s;
    }

    public static long sum(long[] arr) {
        long s = 0;
        for (long i : arr) s += i;
        return s;
    }

    public static long lower(long a) {
        long l = (long) Math.floor(Math.sqrt(a));
        return l * l;
    }

    public static long upper(long a) {
        long l = (long) Math.ceil(Math.sqrt(a));
        return l * l;
    }

    static long gcd(long a, long b) {
        BigInteger x = BigInteger.valueOf(a).gcd(BigInteger.valueOf(b));
        return Long.parseLong(String.valueOf(x));
    }

    static long expo(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) res = (res * a);
            a = (a * a);
            b >>= 1;
        }
        return res;
    }

    static long modexp(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    static int[] permute(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static long min(long[] arr) {
        long min = Long.MAX_VALUE;
        for (long l : arr) {
            if (l < min) min = l;
        }
        return min;
    }

    public static long max(long[] arr) {
        long max = Long.MIN_VALUE;
        for (long l : arr) {
            if (l > max) max = l;
        }
        return max;
    }

    public static int min(int[] arr) {
        Integer min = Integer.MAX_VALUE;
        for (int l : arr) {
            if (l < min) min = l;
        }
        return min;
    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int l : arr) {
            if (l > max) max = l;
        }
        return max;
    }

    public static void sort(long[] arr) {
        List<Long> list = new ArrayList<>();
        for (long i : arr) {
            list.add(i);
        }
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    public static void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    public static long countfactors(long n) {
        long ans = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                ans += 2;
                if (n / i == i) ans--;
            }
        }
        return ans;
    }

    public static boolean isprime(long n) {
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int[] copy(int[] arr) {
        int[] brr = new int[arr.length];
        System.arraycopy(arr, 0, brr, 0, arr.length);
        return brr;
    }
    public static char[] copy(char[] arr) {
        char[] brr = new char[arr.length];
        System.arraycopy(arr, 0, brr, 0, arr.length);
        return brr;
    }

    public static long[] copy(long[] arr) {
        long[] brr = new long[arr.length];
        System.arraycopy(arr, 0, brr, 0, arr.length);
        return brr;
    }


    public static long countDigit(long n) {
        long count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }

    public static List<pair> sortpair(long[] n, long[] h) {
        List<pair> A = new ArrayList<>();
        for (int i = 0; i < n.length; i++) {
            A.add(new pair(h[i], n[i]));
        }
        A.sort(Comparator.comparingLong(a -> a.first));
        return A;
    }

    public static long kadane(long a[]) {
        long max_so_far = Long.MIN_VALUE, max_ending_here = 0;
        for (long l : a) {
            max_ending_here = max_ending_here + l;
            if (max_so_far < max_ending_here) max_so_far = max_ending_here;
            if (max_ending_here < 0) max_ending_here = 0;
        }
        return max_so_far;
    }

    public static long gcd(long arr[]) {
        long gc = arr[0];
        for (int i = 1; i < arr.length; i++) gc = gcd(arr[i], gc);
        return gc;
    }

    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static boolean isSorted(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    static int msbNumber(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    static int msbNumber(long n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    public static void reverse(int[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }

    public static int justLower(long[] a, long t) {
        int l = 0, r = a.length - 1;
        if (t < a[0]) {
            return -1;
        }
        if (t >= a[r]) {
            return r;
        }
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (a[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return a[r] <= t ? r : l;
    }

    public static int justLower(long[] a, long t, int l, int r) {
        if (t < a[l]) {
            return l - 1;
        }
        if (t >= a[r]) {
            return r;
        }
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (a[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return a[r] <= t ? r : l;
    }

    public static int justUpper(long[] a, long t, int l, int r) {
        if (t <= a[l]) {
            return l;
        }
        if (t > a[r]) {
            return -1;
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= t) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return r;
    }

    public static int justUpper(long[] a, long t) {
        int l = 0, r = a.length - 1;
        if (t <= a[0]) {
            return 0;
        }
        if (t > a[r]) {
            return a.length;
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= t) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    public static void reverse(long[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            long temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }

    public static boolean isPalindrome(char ac[]) {
        for (int i = 0; i < ac.length / 2; i++) {
            if (ac[i] != ac[ac.length - i - 1]) return false;
        }
        return true;
    }

    static ArrayList<Long> sieve = new ArrayList<>();
    static HashSet<Long> primeSet = new HashSet<>();

    public static void sieve(int n) {
        int[] flag = new int[n + 1];
        for (int i = 2; i*i <= n; i++) {
            if (flag[i] == 0) {
                flag[i] = i;
//                sieve.add((long) i);
//                primeSet.add((long)i);


                for (int j = i * i; j <= n; j += i) {
                    flag[j] = 1;
                }
            }

        }
        for(int i=2;i<flag.length;i++)
        {
            if (flag[i]==i||flag[i]==0)
                primeSet.add((long)(i));
        }

    }

    static ArrayList<Long> allPrime;

    public static void allprimeFactors(long n) {
        // Print the number of 2s that divide n
        allPrime = new ArrayList<>();
        while (n % 2 == 0) {
            allPrime.add(2L);
            n /= 2;
        }

        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                allPrime.add(i);
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            allPrime.add(n);

    }

    static long[][] nCr;

    public static void ncr(int n, int k) {
        nCr = new long[n + 1][k + 1];
        for (int i = 1; i < nCr.length; i++) {
            nCr[i][0] = 1;
        }
        for (int i = 1; i < nCr.length; i++) {
            for (int j = 1; j <= i && j < nCr[0].length; j++) {
                if (i == 1 && j == 1) {
                    nCr[i][j] = 1;
                } else {
                    nCr[i][j] = (nCr[i - 1][j] + nCr[i - 1][j - 1]) % (mod);
                }
            }
        }
    }static long  fact[]=new long[4050];

    static void modFact() {

        fact[0] = 1;
        for (long i = 1; i < fact.length; i++) {
            fact[(int) i] = (i * fact[(int) i-1]) % mod;
        }
    }

    static class pair {
        long first;
        long second;

        pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        pair(long first, boolean f) {
            if (f) this.first = first;
            else this.second = first;
        }
    }

    static class Reader {
        BufferedReader in;
        StringTokenizer st;

        public Reader() {
            in = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        public String nextLine() throws IOException {
            st = new StringTokenizer("");
            return in.readLine();
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    static Reader in = new Reader();
    static PrintWriter out = new PrintWriter(System.out);




    //-----------------------------INPUT-------------------------------------------------//
    public static int ni() throws IOException {
        return in.nextInt();
    }

    public static long nl() throws IOException {
        return in.nextLong();
    }

    public static double nd() throws IOException {
        return in.nextDouble();
    }

    public static String rl() throws IOException {
        return in.next();
    }

    public static char nc() throws IOException {
        return in.next().charAt(0);
    }

    //----------------------------ARRAYS INPUT--------------------------------------------//
    public static int[] ai(long n) throws IOException {
        int[] arr = new int[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static long[] al(long n) throws IOException {
        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        return arr;
    }

    public static char[] ac() throws IOException {
        String s = in.next();
        return s.toCharArray();
    }

    public static int[] ac(int n) throws IOException {
        String s = in.next();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    //----------------------------Print---------------------------------------------------//
    public static void pt(int[] arr) {
        for (int j : arr) out.print(j + " ");
        out.println(" ");
    }

    public static void pt(long[] arr) {
        for (long l : arr) out.print(l + " ");
        out.println();
    }

    public static void pt(char[] arr) {
        for (char l : arr) out.print(l);
        out.println();
    }

    public static void yes() {
        out.println("YES");
    }

    public static void no() {
        out.println("NO");
    }


}