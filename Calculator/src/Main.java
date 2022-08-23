public class Main {

    public static void main(String[] args) {
        int vol1 = 2;
        int vol2 = 2;
        double dbl1 = 2.5;
        double dbl2 = 3.5;
        String str1 = "Hello";
        String str2 = " World";

        Calculator<String> a = new Expression<String>();
        Calculator<Integer> b = new Expression<Integer>();
        Calculator<Double> c = new Expression<Double>();

        String sum1 = a.addition(str1, str2);
        int sum2 = b.addition(vol1, vol2);
        double sum3 = c.addition(dbl1, dbl2);

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);

       
    }
}
