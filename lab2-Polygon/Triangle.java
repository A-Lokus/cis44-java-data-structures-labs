public class Triangle implements Polygon{
    private double a;
    private double b;
    private double c;

    public Triangle(double s1, double s2, double s3){
        a = s1;
        b = s2;
        c = s3;
    }

    @Override
    public double area(){
        double s = perimeter()/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    @Override
    public double perimeter(){
        return a + b + c;
    }
    public boolean isValidShape(){
        return a < (perimeter()/2) &&
                b < (perimeter()/2) &&
                c < (perimeter()/2);
    }
}
