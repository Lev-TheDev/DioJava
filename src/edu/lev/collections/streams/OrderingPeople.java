package edu.lev.collections.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderingPeople {

    private List<PeopleStream> peopleList;

    public OrderingPeople() {
        this.peopleList = new ArrayList<>();
    }

    public List<PeopleStream> heightOrdering() {
        if (!peopleList.isEmpty()) {
            List<PeopleStream> peopleByHeight = new ArrayList<>(peopleList);
            peopleByHeight.sort((p1, p2) -> Double.compare(p1.getHeight(), p2.getHeight()));
            // peopleByHeight.sort(Comparator.comparingDouble(PeopleStream::getHeight)); // with method reference
            return peopleByHeight;
        } else {
            throw new RuntimeException("People list is empty, cannot order by height.");
        }
    }
}
