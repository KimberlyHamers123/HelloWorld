package kim.fullred;

import java.util.HashMap;
public class ObjectStore {

    private HashMap<String, Object> store;

    private static ObjectStore instance;

    public static ObjectStore getInstance(){
        if(instance == null){
            instance = new ObjectStore();
        }
        return instance;
    }

    private ObjectStore() {
        this.store = new HashMap<>();
    }

    public void put(String key, Object value) {
        this.store.put(key, value);
    }

    public <T> T get(String key) {
        return (T) this.store.get(key);
    }

    public void clear() {
        this.store.clear();
    }
}