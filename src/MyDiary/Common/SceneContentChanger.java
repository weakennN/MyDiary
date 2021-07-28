package MyDiary.Common;

import MyDiary.UI.Designer;
import javafx.scene.layout.Region;

import java.util.HashMap;
import java.util.Map;

public class SceneContentChanger {

    private static Map<String, Region> roots = new HashMap<>();

    public static void addContent(String key, Region region) {
        roots.put(key, region);
    }

    public static Region getContent(String key) {
        return roots.get(key);
    }

    public static void changeContent(String key) {
        Designer.setSceneRoot(roots.get(key));
    }
}
