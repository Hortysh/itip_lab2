abstract class GeometricFigure {
    private String name;
    private String color;
    private double volume;

    protected static int objectCount = 0;

    public GeometricFigure() {
        this.name = "Неизвестная фигура";
        this.color = "Белый";
        this.volume = 0.0;
        objectCount++;
    }

    public GeometricFigure(String name, String color) {
        this.name = name;
        this.color = color;
        objectCount++;
    }

    public abstract double calculateVolume();
    public abstract void displayInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public static int getObjectCount() {
        return objectCount;
    }
}

class Sphere extends GeometricFigure {
    private double radius;

    public Sphere() {
        super("Шар", "Белый");
        this.radius = 1.0;
    }

    public Sphere(String color, double radius) {
        super("Шар", color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateVolume() {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        setVolume(volume);
        return volume;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Фигура: %s, Цвет: %s, Радиус: %.2f, Объём: %.2f%n",
                getName(), getColor(), radius, calculateVolume());
    }
}

class Parallelepiped extends GeometricFigure {
    private double length;
    private double width;
    private double height;

    public Parallelepiped() {
        super("Параллелепипед", "Серый");
        this.length = 1.0;
        this.width = 1.0;
        this.height = 1.0;
    }

    public Parallelepiped(String color, double length, double width, double height) {
        super("Параллелепипед", color);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        double volume = length * width * height;
        setVolume(volume);
        return volume;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Фигура: %s, Цвет: %s, Размеры: %.2fx%.2fx%.2f, Объём: %.2f%n",
                getName(), getColor(), length, width, height, calculateVolume());
    }
}

class Cylinder extends GeometricFigure {
    private double radius;
    private double height;

    public Cylinder() {
        super("Цилиндр", "Синий");
        this.radius = 1.0;
        this.height = 1.0;
    }

    public Cylinder(String color, double radius, double height) {
        super("Цилиндр", color);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        double volume = Math.PI * Math.pow(radius, 2) * height;
        setVolume(volume);
        return volume;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Фигура: %s, Цвет: %s, Радиус: %.2f, Высота: %.2f, Объём: %.2f%n",
                getName(), getColor(), radius, height, calculateVolume());
    }
}

public class Main {
    public static void main(String[] args) {
        GeometricFigure sphere = new Sphere("Красный", 3.5);
        GeometricFigure parallelepiped = new Parallelepiped("Зелёный", 2, 3, 4);
        GeometricFigure cylinder = new Cylinder("Жёлтый", 2.5, 5);

        sphere.displayInfo();
        parallelepiped.displayInfo();
        cylinder.displayInfo();

        System.out.println("\nВсего создано геометрических фигур: " + GeometricFigure.getObjectCount());
    }
}
