public class Quadrilateral implements Polygon{
    private double a;
    private double b;
    private double c;
    private double d;

    public Quadrilateral(double s1, double s2, double s3, double s4){
        a = s1;
        b = s2;
        c = s3;
        d = s4;
    }

    @Override
    public double area(){
        double s = perimeter()/2;
        return Math.sqrt((s-a)*(s-b)*(s-c)*(s-d));
    }
    @Override
    public double perimeter(){
        return a + b + c + d;
    }
    @Override
    public boolean isValidShape(){
        return a < (perimeter()/2) &&
                b < (perimeter()/2) &&
                c < (perimeter()/2) &&
                d < (perimeter()/2);
    }
}
