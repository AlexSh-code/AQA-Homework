public class Circle implements Shape {
    private final double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius) {
        this.radius = radius;
    }

    private boolean isValidCircle() {
        return radius>0;
    }

    @Override
    public double calcPerimeter() {
        if (!isValidCircle()) {
            System.out.println("Радиус не может быть отрицательным числом");
            return 0;
        } else {
        return 2*Math.PI*radius;
        }
    }

    @Override
    public double calcSquare() {
        if (!isValidCircle()) {
            System.out.println("Радиус не может быть отрицательным числом");
            return 0;
        } else {
            return Math.PI * radius * radius;
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
