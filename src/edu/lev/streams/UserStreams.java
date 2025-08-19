package edu.lev.streams;

import java.util.List;

public record UserStreams (String name, int age, Sex sex, List<ContactStreams> contacts){
}
