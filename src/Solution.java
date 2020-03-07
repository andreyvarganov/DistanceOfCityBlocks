import java.util.List;

public class Solution {

    public static Solution app;

    private int N; // размерность поля

    private List<Building> buildings; // список зданий

    private Home home; // место отправления

    private School school; // место назначения


    public Solution(int N) {
        this.N = N;
    }

    public void draw(Canvas canvas) {
        drawBorder(canvas);
    }

    private void drawBorder(Canvas canvas) {
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                canvas.setPoint(i, j, ' ');
            }
        }

        for (int i = 0; i < N + 2; i++) {
            canvas.setPoint(i, 0, '―');
            canvas.setPoint(i, N + 1, '―');
        }

        for (int i = 0; i < N + 2; i++) {
            canvas.setPoint(0, i, '|');
            canvas.setPoint(N + 1, i, '|');
        }
    }

    private void run() {
        // создаем холст для отрисовки
        Canvas canvas = new Canvas(N, N);
        draw(canvas);
        canvas.print();
    }

    public static void main(String[] args) {
        app = new Solution(10);
        app.run();
    }
}
