public class Octagon implements Polygon{
    private double side;

    public Octagon(double sideLength){
        side = sideLength;
    }

    @Override
    public double area(){
        return 2*(1+Math.sqrt(2))*Math.pow(side,2);
    }
    @Override
    public double perimeter(){
        return side * 8;
    }
    @Override
    public boolean isValidShape(){return true;}
}
