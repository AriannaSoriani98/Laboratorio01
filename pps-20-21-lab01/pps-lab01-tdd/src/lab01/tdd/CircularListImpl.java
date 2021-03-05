package lab01.tdd;

import java.util.ArrayList;
import java.util.List;


public class CircularListImpl implements CircularList{
    private Integer nextByStrategy = -1;
    private ArrayList<Integer> circularList;
    private Integer next_element;
    private Integer previous_element;
    private Integer current_element;
    private int currentElementIndexForNext = 0;
    private int currentElementIndexForPrevious = 0;
    private int elementIndexToRemove = 0;

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
        if(currentElementIndexForNext == circularList.size() -1 || circularList.size() == 1){
            currentElementIndexForNext = 0;
        } else{
            currentElementIndexForNext++;
        }
        System.out.println(currentElementIndexForNext);
        return next_element = circularList.get(currentElementIndexForNext);
    }

    @Override
    public Integer previous() {

        // If we're at the beginning, go to the end
        // or if the list has only one element
        if(currentElementIndexForPrevious == 0){
            currentElementIndexForPrevious = 1;
            return previous_element = circularList.get(circularList.size()-1);
        } else if( currentElementIndexForPrevious== circularList.size()-1) {
            previous_element = circularList.get(currentElementIndexForPrevious-1);
            currentElementIndexForPrevious = 0;
        } else{
            previous_element = circularList.get(currentElementIndexForPrevious-1);
            currentElementIndexForPrevious++;

        }
        return previous_element;
    }

    @Override
    public Integer reset() {
        elementIndexToRemove = (int) (Math.random() * circularList.size()-2) +1;
        current_element = circularList.get(elementIndexToRemove);
        circularList.remove(elementIndexToRemove);
        circularList.set(0,current_element);
        System.out.println(elementIndexToRemove);
        return  elementIndexToRemove;
    }



    public Integer getElementFromIndex(int index) {
        return circularList.get(index);
    }

    public void InitializeCircularList(int size) {
        for(int i = 0; i<= size; i++){
            circularList.add(i);
        }
    }


    public Integer nextPari() {

        // If we're at the end, go back to the beginning
        // or if the list has only one element
        do {
            if (currentElementIndexForNext == circularList.size() - 1 || circularList.size() == 1) {
                currentElementIndexForNext = 0;
            } else {
                currentElementIndexForNext++;
            }
        } while(circularList.get(currentElementIndexForNext) %2 != 0);
        return next_element = circularList.get(currentElementIndexForNext);
    }

    public Integer nextDispari() {

        // If we're at the end, go back to the beginning
        // or if the list has only one element
        do {
            if (currentElementIndexForNext == circularList.size() - 1 || circularList.size() == 1) {
                currentElementIndexForNext = 0;
            } else {
                currentElementIndexForNext++;
            }
        } while(circularList.get(currentElementIndexForNext) %2 == 0);
        return next_element = circularList.get(currentElementIndexForNext);
    }

    public Integer nextByStrategy(String strategy){
        nextByStrategy= -1;
        switch (strategy){
            case "pari":
                nextByStrategy = nextPari();
                break;
            case "dispari":
                nextByStrategy = nextDispari();
                break;
            default:nextByStrategy=-1;
                break;
        }
        return nextByStrategy;
    }



}
