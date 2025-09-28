package edu.lev.exceptions.validator;

import edu.lev.exceptions.exceptions.ValidatorException;
import edu.lev.exceptions.model.UserModel;

public class UserValidator {

    private UserValidator(){

    }

    public static void verifyModel(final UserModel model) throws ValidatorException {
        if (stringIsBlank(model.getName())){
            throw new ValidatorException("Name is required. Please provide a valid name.");
        }
        if (model.getName().length() <= 1){
            throw new ValidatorException("Name must have more than 1 character. Please provide a valid name.");
        }
        if (stringIsBlank(model.getEmail())){
            throw new ValidatorException("Email is required. Please provide a valid email.");
        }
        if (!model.getEmail().contains("@") || !model.getEmail().contains(".")){
            throw new ValidatorException("Email must contain '@' and '.' characters. Please provide a valid email.");
        }
    }

    private static boolean stringIsBlank(final String str){
        return str == null || str.isEmpty() || str.isBlank();
    }
}
