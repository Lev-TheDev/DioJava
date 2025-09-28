package edu.lev.exceptions.dao;

import edu.lev.exceptions.exceptions.EmptyStorageException;
import edu.lev.exceptions.exceptions.UserNotFoundException;
import edu.lev.exceptions.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private long nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    public UserModel save(UserModel model) {
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(UserModel model) {
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete(Long id) {
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public List<UserModel> findAll() {
        List<UserModel> result;
        try {
            verifyStorage();
            result = models;
        } catch (EmptyStorageException e) {
            e.printStackTrace();
            result = new ArrayList<>();
        }
        return result;
    }

    public UserModel findById(Long id) {
        /*for (UserModel model : models) {
            if (model.getId().equals(id)) {
                return model;
            }
        }
        return null;
    }*/
        verifyStorage();
        var message = String.format("User with id [%d] not found", id);
        return models.stream()
                .filter(model -> model.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));
    }

    private void verifyStorage(){
        if (models.isEmpty()){
            throw new EmptyStorageException("Storage is empty");
        }
    }
}
