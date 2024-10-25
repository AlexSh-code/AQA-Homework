public class Rectangle implements Shape {
    private final double a;
    private final double b;
    private String fillColor;
    private String borderColor;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    private boolean isValidRectangle() {
        return (a>0)&&(b>0);
    }

    @Override
    public double calcPerimeter() {
        if (!isValidRectangle()) {
            System.out.println("Стороны прямоугольника не могут быть отрицательными");
            return 0;
        } else {
            return (a + b) * 2;
        }
    }

    @Override
    public double calcSquare() {
        if (!isValidRectangle()) {
            System.out.println("Стороны прямоугольника не могут быть отрицательными");
            return 0;
        } else {
            return a * b;
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
