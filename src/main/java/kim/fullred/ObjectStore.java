package kim.fullred;

import java.util.HashMap;
public class ObjectStore {

    private HashMap<String, Object> store;

    public ObjectStore() {
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