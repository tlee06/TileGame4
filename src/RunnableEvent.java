import java.util.ArrayList;

public class RunnableEvent {
    private final ArrayList<Runnable> listners = new ArrayList<>();

    public void subscribe(Runnable listner){
        listners.add(listner);
    }

    public void invoke(){
        for(Runnable r : listners){
            r.run();
        }
    }
}
