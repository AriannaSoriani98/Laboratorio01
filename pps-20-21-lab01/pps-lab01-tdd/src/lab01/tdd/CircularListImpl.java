package lab01.tdd;

import java.util.ArrayList;
import java.util.Optional;

public class CircularListImpl implements CircularList {


    private ArrayList<Integer> circularList = new ArrayList<Integer>();
    private Integer next_element;
    private Integer previous_element;
    private Integer current_element;
    private int currentElementIndex = 0;

    public CircularListImpl(ArrayList<Integer> circularList) {
        this.circularList = circularList;
    }

    @Override
    public void add(int elementToAdd) {
        circularList.add(elementToAdd);
    }

    @Override
    public int size() {
        return circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return circularList.isEmpty();
    }

    @Override
    public Integer next() {

        // If we're at the end, go back to the beginning
        // or if the list has only one element
        if(currentElementIndex >= circularList.size() || circularList.size() == 1){
            currentElementIndex = 0;
        } else{
            currentElementIndex ++;
        }

        return next_element = circularList.get(currentElementIndex);
    }

    @Override
    public Integer previous() {

        // If we're at the beginning, go to the end
        // or if the list has only one element
        if(currentElementIndex == circularList.lastIndexOf(circularList)){
            currentElementIndex = 0;
        } else{
            currentElementIndex --;
        }

        return previous_element = circularList.get(currentElementIndex);
    }

    @Override
    public void reset() {
        current_element = circularList.get(currentElementIndex);
        circularList.remove(currentElementIndex);
        circularList.set(0,current_element);
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
