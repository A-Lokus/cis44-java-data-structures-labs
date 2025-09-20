public class Main
{
    public static void main(String[] args){
        Matrix a = new Matrix(3,2);
        Matrix b = new Matrix(2,5);
        a.populateRandom();
        b.populateRandom();
        System.out.println(a);
        System.out.println();
        System.out.println(b);
        System.out.println("\nMatrices Multiplied: ");
        System.out.println(a.multiply(b));
    }
}