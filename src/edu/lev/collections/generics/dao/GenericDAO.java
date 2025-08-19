package edu.lev.collections.generics.dao;

import edu.lev.collections.generics.domain.GenericDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class GenericDAO<ID, T extends GenericDomain<ID>> {

    private final List<T> db = new ArrayList<>();

    private T save(T domain){
        db.add(domain);
        return domain;
    }

    public boolean save(int batch, T... domains) {
        /*boolean result = true;
        for (T domain : domains) {
            if (db.contains(domain)) {
                result = false;
            } else {
                db.add(domain);
            }
        }
        return result;*/
        System.out.println("Saving " + batch + " domains");
        return db.addAll(List.of(domains));
    }

    public T update(ID id, T domain){
       var stored = find(d -> d.getId().equals(id)).orElseThrow();
       db.remove(stored);
       return save(domain);
    }

    public boolean delete(T domain) {
        return db.remove(domain);
    }

    public Optional<T> find(Predicate<T> predicate) {
        return db.stream()
                .filter(predicate)
                .findFirst();
    }

    public List<T> findAll() {
        return new ArrayList<>(db);
    }

    public int count(){
        return db.size();
    }

}
