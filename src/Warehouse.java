public class Warehouse extends BaseObject {
    // количество складов
    private static int quantity;
    // матрица для отрисовки склада
    private static int[][] matrix = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
    };

    protected Warehouse(int x, int y) {
        super(x, y);
        quantity++;
    }

    @Override
    void draw(Canvas canvas) {
        canvas.drawMatrix(x, y, matrix, 'O');
    }

    public static void setQuantity(int quantity) {
        Warehouse.quantity = quantity;
    }

    public static void setMatrix(int[][] matrix) {
        Warehouse.matrix = matrix;
    }

    public static int getQuantity() {
        return quantity;
    }

    public static int[][] getMatrix() {
        return matrix;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Warehouse warehouse = (Warehouse) obj;
        return (warehouse.getX() == this.getX() && warehouse.getY() == this.getY());
    }
}
