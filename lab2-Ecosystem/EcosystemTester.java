public class EcosystemTester
{
    public static void main(String[] args)
    {
        Ecosystem a = new Ecosystem(20);
        try{
            for(int i = 0; i < 10; i++){
                a.visualize();
                a.runStep();
                System.out.println();
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
}