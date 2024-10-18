package src;

public class Riyaziyyat {
    public static int Üstegel(int a, int b) {
        int c = a + b;
        return c;
    }

    public static int Vur(int a, int b) {
        int c = a * b;
        return c;
    }
    public static int Minus(int a, int b) {
        int c = a - b;
        return c;
    }

    public static double[] QuadraticEquation(int a, int b, int c) throws Exception {
        double d= b * b - 4.0 * a * c;
        double [] output = null;
        if (d> 0.0) { // iki kök
            double r1 = (-b + Math.pow(d, 0.5)) / (2.0 * a);
            double r2 = (-b - Math.pow(d, 0.5)) / (2.0 * a);
            output = new double[] { r1, r2 };
        }
        else if (d == 0.0) { // 1 kök
            double r1 = -b / (2.0 * a);
            output = new double[] { r1 };
        }
        /*
        else {  // BURA UNUDULMUŞ ! YAZILMAMIŞ !
            // heç (0) həqiqi-ədəd kök -- d < 0
            //System.out.println("Roots are not real."); // No real roots
            throw new Exception("Heç həqiqi-ədəd kök");
        }*/
        return output;

    }// function
}// class





