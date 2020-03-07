import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static Solution app;
    // размерность поля
    private int N;
    // список зданий
    private List<Building> buildings;
    // место отправления
    private Home home;
    // место назначения
    private School school;

    public List<Building> getBuildings() {
        return buildings;
    }

    public Solution(int N) {
        this.N = N;
        buildings = new ArrayList<>();
    }

    public void draw(Canvas canvas) {
        // рисуем границы
        drawBorder(canvas);
        // рисуем здания
        setBuildings();
        for (Building building : buildings) {
            building.draw(canvas);
        }
        // рисуем пункт отправления
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

    /**
     * Создаем метод, который возвращает кол-во зданий на карте
     */

    public void setBuildings() {
        // координаты здания
        int x, y;
        // требуемое количество зданий
        int quantity = (int) (N + Math.random() * (1.5 * N));

        Building building;

        while (Building.getQuantity() < quantity) {
            do {
                x = (int) (1 + Math.random() * (N - 1));
                y = (int) (1 + Math.random() * (N - 1));
                building = new Building(x, y);
                if (!buildings.contains(building)) break;
            } while (true);
            buildings.add(building);
        }
    }

    public void setHome() {
        // координаты дома
        int x, y;
    }

    public static void main(String[] args) {
        // создаем карту размером 10х10
        app = new Solution(10);
        // расставляем здания на карте
        app.run();
        // выводим информацию об объектах
        System.out.println("Кол-во здания на карте: " + app.buildings.size());
    }
}
