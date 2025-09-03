public class SimpleCalculator {
    String printed;
    public SimpleCalculator(){
        printed = "";
    }

    public String input(String s){
        switch(s){
            case "exit":
                return "Calculator exit";
            case "=":
                printed = evaluate(printed);
                break;
            default:
                printed += s;
        }
        return printed;
    }

    public String evaluate(String line){
        double value1 = 0;
        double value2 = 0;
        double answer = 0;
        int opIndex = 0;
        for(int i = 0; i<line.length(); i++){
            String j = line.substring(i,i+1);
            switch(j){
                case "*":
                case "/":
                case "-":
                case "+":
                case "=":
                    opIndex = i;
            }
        }
        value1 = Double.parseDouble(line.substring(0,opIndex));
        value2 = Double.parseDouble(line.substring(opIndex+1));
        switch(line.substring(opIndex, opIndex+1)){
            case "*":
                answer = value1*value2;
                break;
            case "/":
                if(value2 != 0){
                    answer = value1/value2;
                }
                else{
                    System.out.println("ERROR: Division by zero");
                }
                break;
            case "-":
                answer = value1-value2;
                break;
            case "+":
                answer = value1+value2;
                break;
        }
        if(answer == (int)answer){
            return "" + (int)answer;
        }
        return "" + answer;
    }
}