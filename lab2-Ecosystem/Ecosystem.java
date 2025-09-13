import java.util.Random;
import java.util.ArrayList;

public class Ecosystem {
    private Animal[] river;
    private Animal[] nextState;
    private int riverSize;
    private Random random;

    public Ecosystem(int size){
        riverSize = size;
        river = new Animal[riverSize];
        nextState = new Animal[riverSize];
        random = new Random();
        for(int i = 0; i < riverSize; i++){
            switch(random.nextInt(6)){
                case 4:
                    river[i] = new Bear();
                    break;
                case 5:
                    river[i] = new Fish();
                    break;
            }
        }
        for(int i = 0; i < riverSize; i++){ nextState[i] = river[i]; }
    }


    public void runStep(){
        for(int i = 0; i < riverSize; i++){
            if(river[i] instanceof Animal && random.nextInt(2) == 1){
                if((random.nextInt() < 1 && i != 0) || i == riverSize-1){
                    move(river[i], i, i-1);
                }
                else{
                    move(river[i], i, i+1);
                }
            }
        }
        for(int i = 0; i < riverSize; i++){river[i] = nextState[i];}
    }


    public void move(Animal a, int current, int i){
        if(a instanceof Bear && nextState[i] instanceof Bear){
            birth(new Bear());
        }
        else if(a instanceof Fish && nextState[i] instanceof Fish){
            birth(new Fish());
        }
        else if(a instanceof Bear && nextState[i] instanceof Fish){
            river[i] = null;
            nextState[i] = new Bear();
            nextState[current] = null;
        }
        else if(a instanceof Fish && nextState[i] instanceof Bear){
            nextState[current] = null;
            river[current] = null;
        }
        else if(nextState[i] == null){
            nextState[i] = a;
            nextState[current] = null;
        }
    }

    public void birth(Animal child){
        ArrayList<Integer> openIndices = new ArrayList<>();
        for(int i = 0; i < riverSize; i++){
            if(nextState[i] == null){
                openIndices.add(i);
            }
        }
        if(openIndices.size() > 0)
            nextState[openIndices.get(random.nextInt(openIndices.size()))] = child;
    }

    public void visualize(){
        for(Animal animal : river){
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
    }
}