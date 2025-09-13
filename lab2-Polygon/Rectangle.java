public class Rectangle extends Quadrilateral{
    public Rectangle(double l, double h){
        super(l,l,h,h);
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
