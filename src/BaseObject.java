/**
 * Базовый класс для всех объектов нашего приложения
 */

public abstract class BaseObject {
    // координаты
    protected int x;
    protected int y;

    protected BaseObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Отрисовка объекта
     */
    abstract void draw(Canvas canvas);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
