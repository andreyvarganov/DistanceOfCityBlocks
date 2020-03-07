import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static Solution app;
    // размерность поля
    private int N;
    // список зданий
    private List<Building> buildings;
    // место отправления
    private Car car;
    // место назначения
    private List<Warehouse> warehouses;

    public List<Building> getBuildings() {
        return buildings;
    }

    public Solution(int N) {
        this.N = N;
        buildings = new ArrayList<>();
        warehouses = new ArrayList<>();
    }

    public void draw(Canvas canvas) {
        // рисуем границы
        drawBorder(canvas);
        // рисуем здания
        setBuildings();
        for (Building building : buildings) {
            building.draw(canvas);
        }
        // рисуем пункты доставки
        setWarehouses();
        for (Warehouse warehouse : warehouses) {
            warehouse.draw(canvas);
        }
        // рисуем пункт отправления
        setCar();
        car.draw(canvas);
    }

    private void drawBorder(Canvas canvas) {
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                canvas.setPoint(i, j, '.');
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
        int quantity = (int) (N + Math.random() *  (1.5 * N));

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

    public void setWarehouses() {
        // координаты склада
        int x, y;
        // требуемое количество складов
        int quantity = (int) (2 + Math.random() * 4);

        Warehouse warehouse;
        boolean flag = true;
        while (Warehouse.getQuantity() < quantity) {
            do {
                x = (int) (Math.random() * N);
                y = (int) (Math.random() * N);
                warehouse = new Warehouse(x, y);
                for (int i = 0; i < getBuildings().size(); i++) {
                    int xB = getBuildings().get(i).getX();
                    int yB = getBuildings().get(i).getY();
                    if (x == xB && y == yB) flag = false;
                }
                if (!warehouses.contains(warehouse) && flag) break;
            } while (true);
            warehouses.add(warehouse);
        }
    }

    public void setCar() {
        // координаты дома
        int x, y;
        boolean flag = true;

        do {
            x = (int) (Math.random() * N);
            y = (int) (Math.random() * N);

            for (int i = 0; i < getBuildings().size(); i++) {
                int xB = getBuildings().get(i).getX();
                int yB = getBuildings().get(i).getY();
                if (x == xB && y == yB) flag = false;
            }
            for (int i = 0; i < getWarehouses().size(); i++) {
                int xW = getWarehouses().get(i).getX();
                int yW = getWarehouses().get(i).getY();
                if (x == xW && y == yW) flag = false;
            }
            if (flag) break;
        } while (true);

        car = new Car(x, y);
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public static void main(String[] args) {
        // создаем карту размером NхN
        int N = 0;
        System.out.print("Введите N: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        app = new Solution(N);

        // расставляем здания на карте
        app.run();
        // выводим информацию об объектах
        System.out.println("Кол-во здания на карте: " + app.buildings.size());
        System.out.println("Кол-во пунктов назначения на карте: " + app.warehouses.size());
        System.out.println();
    }
}
