
public class Car extends BaseObject {
    // матрица для отрисовки машины
    private static int[][] matrix = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
    };

    @Override
    void draw(Canvas canvas) {
        canvas.drawMatrix(x, y, matrix, '8');
    }

    protected Car(int x, int y) {
        super(x, y);
    }
}
