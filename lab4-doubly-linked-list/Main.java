import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            TextEditor textEditor = new TextEditor();
            String userChoice;

            System.out.println("-----Text Editor Interface-----");
            System.out.println("1. Add to current text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Exit program");

            do{
                System.out.print("\nInput choice: ");
                userChoice = input.nextLine();
                switch(userChoice) {
                    case "1":
                        System.out.println("Enter text to add: ");
                        String text = input.nextLine();
                        textEditor.add(text);
                        break;
                    case "2":
                        textEditor.undo();
                        break;
                    case "3":
                        textEditor.redo();
                        break;
                    case "4":
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                if(!userChoice.equals("4")){
                    System.out.print("\nCurrent text: ");
                    textEditor.printCurrent();
                }
            }while(!userChoice.equals("4"));
        }
    }