package com.library.repository;

import java.util.ArrayList;
import java.util.List;

/**
 Generic Repository class to used to store and manage the collections of any type(
 Book, Member, LendingRecord)
 this avoids code duplicity and promotes Reusability.
 */
public class Repository<T>{
//    internal storage for all elements(List<Book>, List<Member>)
    private List<T> elements;
//    constructor initializes the list when a new repository is created.
    public Repository(){
        this.elements = new ArrayList<>();
    }
//  adds a new element to the repository
    public void add(T element){
        elements.add(element);
    }
// removes the given element from the repository
    public void remove(T element){
        elements.remove(element);
    }
// returns all the elements
    public List<T> getAll(){
        return elements;
    }
// clears all the elements from the repository
    public void clear(){
        elements.clear();
    }
}
