
public class Main{

    public Mode mode;

    private static Thread thread = new Thread(new GUI());

    public static void main(String[] args){
        thread.start();
    }


}
