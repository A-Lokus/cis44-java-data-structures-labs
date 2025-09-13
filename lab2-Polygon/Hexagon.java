public class Hexagon implements Polygon{
    private double side;

    public Hexagon(double sideLength){
        side = sideLength;
    }

    @Override
    public double area(){
        return ((3*Math.sqrt(3))/2)*Math.pow(side,2);
    }
    @Override
    public double perimeter(){
        return side * 6;
    }
    @Override
    public boolean isValidShape(){return true;}
}
