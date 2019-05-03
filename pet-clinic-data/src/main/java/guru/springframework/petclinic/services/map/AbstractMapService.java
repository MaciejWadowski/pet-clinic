package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.model.BaseEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if (map == null) {
            map = new HashMap<>();
        }

        if (object != null) {
            if (object.getId() == null) {
                object.setId((getNextId()));
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("error");
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() { return (long) (map.keySet().size()+ 1);
    }
}
