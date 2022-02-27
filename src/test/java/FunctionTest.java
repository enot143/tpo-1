import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionTest {
    final double EPS = 1.0e-5;
    final double INF = 1.0e8;
    private final Function calculator = new Function();
    double x;


    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI / 2, Math.PI / 2, 3 * Math.PI / 2, 5 * Math.PI / 2})
    public void undetermined(double x) {
        Assertions.assertEquals(calculator.calculateSec(x), INF, EPS);
    }

    // ( -3 * Pi / 2 + 2 * Pi * n; - Pi / 2 + 2 * Pi * n )
    @ParameterizedTest
    @ValueSource(doubles = {-19 * Math.PI / 6, -5 * Math.PI / 6, 8 * Math.PI / 6, 17 * Math.PI / 6})
    public void firstAreaEq(double x) {
        Assertions.assertEquals(calculator.calculateSec(x), 1 / Math.cos(x), EPS);
    }

    // ( - Pi / 2 + 2 * Pi * n; Pi / 2 + 2 * Pi * n )
    @ParameterizedTest
    @ValueSource(doubles = {-13 * Math.PI / 6, -5 * Math.PI / 6, 10 * Math.PI / 6, 23 * Math.PI / 6})
    public void secondAreaEq(double x) {
        Assertions.assertEquals(calculator.calculateSec(x), 1 / Math.cos(x), EPS);
    }
}