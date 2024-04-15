import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class GameObject {
    private static final LinkedList<GameObject> allObjects = new LinkedList<>();
    private static final LinkedList<GameObject> queuedForCreation = new LinkedList<>();
    private static final LinkedList<GameObject> queuedForRemoval = new LinkedList<>();

    public GameObject(){
        queuedForCreation.add(this);
    }

    public static void updateObjectList(){
        allObjects.addAll(queuedForCreation);
        allObjects.removeAll(queuedForRemoval);
    }

    public static Collection<GameObject> getAllObjects(){
        return Collections.unmodifiableCollection(allObjects);
    }

    public abstract void render(Renderer r);
    public abstract void tick();
}
