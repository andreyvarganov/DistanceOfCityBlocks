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

}
