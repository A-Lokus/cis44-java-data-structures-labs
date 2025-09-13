public class Square extends Rectangle{
    public Square(double sideLength){
        super(sideLength, sideLength);
    }

    @Override
    public double area(){
        return super.area();
    }
    @Override
    public double perimeter(){
        return super.perimeter();
    }
    @Override
    public boolean isValidShape(){return true;}
}
