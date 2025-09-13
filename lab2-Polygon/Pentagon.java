public class Pentagon implements Polygon{
    private double side;

    public Pentagon(double sideLength){
        side = sideLength;
    }

    @Override
    public double area(){
        return (0.25*Math.sqrt(5*(5+2*Math.sqrt(5))))*Math.pow(side,2);
    }
    @Override
    public double perimeter(){
        return side * 5;
    }
    @Override
    public boolean isValidShape(){return true;}
}