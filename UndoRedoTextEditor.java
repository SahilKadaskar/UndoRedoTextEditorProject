import java.util.Scanner;
import java.util.Stack;

public class UndoRedoTextEditor {
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();
    private String text =" ";

    public void write(String newText){
        undoStack.push(text);   // current text save before changes
        text = text +" "+newText;   // add new text
        redoStack.clear();      //clear stack after new entry
    }

    public void undo(){
        if(!undoStack.isEmpty()){
            redoStack.push(text);
            text = undoStack.pop();
        }else{
            System.out.println("Nothing to undo!");
        }
    }

    public void redo(){
        if(!redoStack.isEmpty()){
            undoStack.push(text);
            text = redoStack.pop();
        }else{
            System.out.println("Nothing to redo!");
        }
    }

    public void show(){
        System.out.println("Present text:"+text);
    }
    public static void main(String[] args) {
        UndoRedoTextEditor editor = new UndoRedoTextEditor();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Text Editor");

        while(true){
            System.out.println();
            System.out.print("Choose below any one option ");
            System.out.println("\nChoose : 1.Write | 2.Undo | 3.Redo | 4.Show | 5.EXIT");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1: 
                    System.out.println("Enter text to add ");
                    String input = sc.nextLine();
                    editor.write(input);
                    break;

                case 2: 
                    editor.undo();
                    break;
                
                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.show();
                    break;

                case 5:
                    System.exit(0);
                
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
