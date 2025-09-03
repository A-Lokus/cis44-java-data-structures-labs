public class DotProduct {
    public static void main(String[] args) {
        dotProduct(5);
    }
    public static void dotProduct(int n) {
        int[] a = new int[n], b = new int[n], c = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = (int)(Math.random()*100);
            b[i] = (int)(Math.random()*100);
            c[i] = a[i] * b[i];
        }
        System.out.println("Array a: "+arrayToString(a));
        System.out.println("Array b: "+arrayToString(b));
        System.out.println("Array c: "+arrayToString(c));
    }

    public static String arrayToString(int[] arr){
        String printed = "[";
        for(int i = 0; i < arr.length; i++){
            printed += arr[i];
            if(i != arr.length-1){
                printed += ",";
            }
        }
        printed += "]";
        return printed;
    }
}