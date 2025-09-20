import java.util.Random;

public class Matrix {
    private int[][] data;
    private Random random;
    private int dataRows;
    private int dataCols;

    public Matrix(int rows, int cols){
        data = new int[rows][cols];
        dataRows = rows;
        dataCols = cols;
        random = new Random();
    }
    public Matrix(int[][] arr){
        data = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                data[i][j] = arr[i][j];
            }
        }
        dataRows = data.length;
        dataCols = data[0].length;
    }

    public int get(int row, int col) throws ArrayIndexOutOfBoundsException{
        if(row >= dataRows){
            throw new ArrayIndexOutOfBoundsException("Invalid row: "+row);
        }
        else if(col >= dataCols){
            throw new ArrayIndexOutOfBoundsException("Invalid column: "+col);
        }
        return data[row][col];
    }
    public int getRows(){
        return dataRows;
    }
    public int getCols(){
        return dataCols;
    }

    public void populateRandom(){
        for(int i = 0; i < dataRows; i++){
            for(int j = 0; j < dataCols; j++){
                data[i][j] = (int)(1 + random.nextInt(10));
            }
        }
    }
    public Matrix add(Matrix other) throws IllegalArgumentException{
        if(other.getRows() != dataRows || other.getCols() != dataCols){
            throw new IllegalArgumentException("Error: Matrices do not have the same dimensions.");
        }
        int[][] newMatrix = new int[dataRows][dataCols];
        for(int i = 0; i < dataRows; i++){
            for(int j = 0; j < dataCols; j++){
                newMatrix[i][j] = data[i][j] + other.get(i,j);
            }
        }
        return new Matrix(newMatrix);
    }
    public Matrix multiply(Matrix other) throws IllegalArgumentException{
        if(other.getRows() != dataCols){
            throw new IllegalArgumentException("Error: Invalid Matrix Dimensions");
        }
        int[][] newMatrix = new int[dataRows][other.getCols()];
        int currentSum;
        for(int row = 0; row < newMatrix.length; row++){
            for(int col = 0; col < newMatrix[0].length; col++){
                currentSum = 0;
                for(int i = 0; i < dataCols; i++){
                    currentSum += (data[row][i]*other.get(i,col));
                }
                newMatrix[row][col] = currentSum;
            }
        }
        return new Matrix(newMatrix);
    }

    @Override
    public String toString(){
        String printed = "";
        for(int i = 0; i < data.length; i++){
            printed += "[";
            for(int j = 0; j < data[0].length; j++){
                printed += data[i][j];
                if(j != data[0].length-1){
                    printed += " ";
                    if(data[i][j] < 10){printed += " ";}
                }
            }
            printed += "]";
            if(i != data.length-1){printed += "\n";}
        }
        return printed;
    }
}