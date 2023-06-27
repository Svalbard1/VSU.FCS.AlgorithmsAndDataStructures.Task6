import java.util.ArrayList;
import java.util.List;

public class MyHash<K, V> {
    private List<Entry<K, V>> entries; // список элементов с ключом и значение

    public MyHash() {
        entries = new ArrayList<>();
    }

    public void put(K key, V value) { // добавление ключ-значение в словарь
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) { // так же проверка на существование такого ключа
                entry.setValue(value);
                return;
            }
        }
        entries.add(new Entry<>(key, value));
    }

    public V get(K key) { // возвращение значения по ключу
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(K key) { // проверка на наличие заданного ключа
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
    public List<V> getValues() { // Возвращение списка всех значений
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry : entries) {
            values.add(entry.getValue());
        }
        return values;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

