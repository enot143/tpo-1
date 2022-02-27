public class Function {
    public double calculateSec (double x){
            double xn = 1.0, prevSum = 0.0, sum = 1.0;
            final double EPS = 1e-10, INF = 1.0e8;
            int i = 0;
            while (Math.abs(sum - prevSum) > EPS){
                prevSum = sum;
                xn = xn * (-1.0 * Math.pow(x, 2.0) / ((2*i + 2) * (2*i + 1)));
                sum += xn;
                i++;
            }
            if (Math.abs(1/sum) > INF){
                return INF;
            }else return 1/sum;
    }
}
