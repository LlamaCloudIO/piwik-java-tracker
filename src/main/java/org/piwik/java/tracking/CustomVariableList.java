/*
 * Piwik Java Tracker
 *
 * @link https://github.com/piwik/piwik-java-tracker
 * @license https://github.com/piwik/piwik-java-tracker/blob/master/LICENSE BSD-3 Clause
 */
package org.piwik.java.tracking;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author brettcsorba
 */
class CustomVariableList {
    private final Map<Integer, CustomVariable> map = new HashMap<>();

    void add(CustomVariable cv) {
        boolean found = false;
        for (Entry<Integer, CustomVariable> entry : map.entrySet()) {
            if (entry.getValue().getKey().equals(cv.getKey())) {
                map.put(entry.getKey(), cv);
                found = true;
            }
        }
        if (!found) {
            int i = 1;
            while (map.containsKey(i)) {
                ++i;
            }

            map.put(i, cv);
        }
    }

    void add(CustomVariable cv, int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Index must be greater than 0.");
        }
        map.put(index, cv);
    }

    CustomVariable get(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Index must be greater than 0.");
        }
        return map.get(index);
    }

    String get(String key) {
        return map.values().stream().filter(value -> value.getKey().equals(key)).findFirst().map(CustomVariable::getValue).orElse(null);
    }

    void remove(int index) {
        map.remove(index);
    }

    void remove(String key) {
        map.entrySet().removeIf(entry -> entry.getValue().getKey().equals(key));
    }

    boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public String toString() {
        JsonObjectBuilder ob = Json.createObjectBuilder();

        map.forEach((key, value) -> {
            JsonArrayBuilder ab = Json.createArrayBuilder();
            ab.add(value.getKey());
            ab.add(value.getValue());
            ob.add(key.toString(), ab);
        });

        return ob.build().toString();
    }
}
