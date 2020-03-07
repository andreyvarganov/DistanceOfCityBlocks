/**
 * Класс здания, обозначается 'H' в консоле и '🏠' в приложении
 */

public class Building extends BaseObject {
    // количество зданий
    private static int quantity;
    // маска для отрисовки зданий
    private static int[][] matrix = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
    };

    public Building(int x, int y) {
        super(x, y);
        quantity++;
    }

    @Override
    void draw(Canvas canvas) {
        canvas.drawMatrix(x, y, matrix, 'H');
    }

    public static int getQuantity() {
        return quantity;
    }

    public static int[][] getMatrix() {
        return matrix;
    }

    public static void setQuantity(int quantity) {
        Building.quantity = quantity;
    }

    public static void setMatrix(int[][] matrix) {
        Building.matrix = matrix;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Building building = (Building) obj;
        return (building.getX() == this.getX() && building.getY() == this.getY());
    }
}
