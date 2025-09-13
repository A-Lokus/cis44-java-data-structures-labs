import java.util.Scanner;

public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Polygon obj;
        String shape;
        do{
            System.out.print("Input shape type: ");
            shape = input.nextLine();
            switch(shape.toLowerCase()){
                case "rectangle":
                    System.out.print("Length: ");
                    double rl = input.nextDouble();
                    System.out.print("Height: ");
                    double rh = input.nextDouble();
                    obj = new Rectangle(rl,rh);
                    break;
                case "triangle":
                    System.out.print("Side Length 1: ");
                    double ts1 = input.nextDouble();
                    System.out.print("Side Length 2: ");
                    double ts2 = input.nextDouble();
                    System.out.print("Side Length 3: ");
                    double ts3 = input.nextDouble();
                    obj = new Triangle(ts1,ts2,ts3);
                    break;
                case "square":
                    System.out.print("Side Length: ");
                    double len = input.nextDouble();
                    obj = new Square(len);
                    break;
                case "quadrilateral":
                    System.out.print("Side Length 1: ");
                    double qs1 = input.nextDouble();
                    System.out.print("Side Length 2: ");
                    double qs2 = input.nextDouble();
                    System.out.print("Side Length 3: ");
                    double qs3 = input.nextDouble();
                    System.out.print("Side Length 4: ");
                    double qs4 = input.nextDouble();
                    obj = new Quadrilateral(qs1,qs2,qs3,qs4);
                    break;
                case "pentagon":
                    System.out.print("Side length: ");
                    double ps = input.nextDouble();
                    obj = new Pentagon(ps);
                    break;
                case "octagon":
                    System.out.print("Side length: ");
                    double os = input.nextDouble();
                    obj = new Octagon(os);
                    break;
                case "isosceles triangle":
                    System.out.print("Base: ");
                    double itb = input.nextDouble();
                    System.out.print("Height: ");
                    double ith = input.nextDouble();
                    obj = new IsoscelesTriangle(itb,ith);
                    break;
                case "hexagon":
                    System.out.print("Side length: ");
                    double hs = input.nextDouble();
                    obj = new Hexagon(hs);
                    break;
                case "equilateral triangle":
                    System.out.print("Side length: ");
                    double eqts = input.nextDouble();
                    obj = new EquilateralTriangle(eqts);
                    break;
                case "exit":
                    obj = null;
                    System.out.println("Calculator exited");
                    break;
                default:
                    obj = null;
                    System.out.println("Invalid Shape Type");
                    System.out.println();
                    break;
            }
            if(obj instanceof Polygon && obj.isValidShape()){
                System.out.println("Area: "+obj.area());
                System.out.println("Perimeter: "+obj.perimeter());
                input.nextLine();
                System.out.println();
            }
            else if(obj instanceof Polygon){
                System.out.println("Invalid Shape Dimensions");
                input.nextLine();
                System.out.println();
            }
        }while(!shape.toLowerCase().equals("exit"));
        input.close();
    }
}