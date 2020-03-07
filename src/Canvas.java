public class Canvas {

    /**
     * Класс-холст для отрисовки
     */

    // ширина и высота
    private int width;
    private int height;
    // матрица, на которой отрисовываем объекты
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
    }

    /**
     * Обозначение объектов:
     * 🏠 (1) - здание;
     * 🚧 (2) - перекрытие дороги;
     * ― (-3) - горизонтальная граница отрисовки;
     * 🚓 (4) - машина с хладогентами (место отправления, "Home";
     * * (5) - проеханный путь;
     *  (0) - пустая клетка;
     *  ➕ (6) - пункт назначения;
     */

    /**
     * * Помещаем объект на карту: (x, y) - координаты, c - объект
     */

    void setPoint(int x, int y, char c) {
        if (y < 0 || y >= matrix.length) return;
        if (x < 0 || x >= matrix[0].length) return;
        matrix[y][x] = c;
    }

    /**
     * Печатаем переданную фигуру в указанных координатах символом с.
     * Если переданный массив содержит '1', то на холсте ему будет соответсвовать символ 'c'.
     *
     */

    void drawMatrix(int x, int y, int[][] matrix, char c) {
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1)
                    setPoint(x + j, y + i, c);
            }
        }
    }


    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    /**
     * Вывод на экран
     */

    void print() {
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * Рисуем объекты на матрице
     */



}
