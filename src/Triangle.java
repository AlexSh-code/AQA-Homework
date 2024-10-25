public class Triangle implements Shape {
    private final double a;
    private final double b;
    private final double c;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean isValidTriangle() {
        return (a+b>c)&&(a+c>b)&&(b+c>a);
    }

    @Override
    public double calcPerimeter() {
        if (!isValidTriangle()) {
            System.out.println("Треугольник с такими сторонами не существует");
            return 0;
        } else {
            return a + b + c;
        }
    }

    @Override
    public double calcSquare() {
        if (!isValidTriangle()) {
            System.out.println("Треугольник с такими сторонами не существует");
            return 0;
        } else {
            double s = calcPerimeter() / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }
}
