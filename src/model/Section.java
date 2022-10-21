package model;

import model.Implementations.*;

import java.util.ArrayList;

public class Section {

    private IPriorityQueue<Patient> priorityQueue;
    private Patient lastAdd;
    private Patient lastExit;

    public Section() {
        priorityQueue = new Heap<>();
    }

    public void enqueue(int priorityValue, Patient pacient) {
        priorityQueue.insertElement(priorityValue, pacient);
    }

    public Patient removeFromQueue() {
        return priorityQueue.extractMax();
    }

    public Patient getLastAdd() {
        return lastAdd;
    }

    public void setLastAdd(Patient lastAdd) {
        this.lastAdd = lastAdd;
    }

    public Patient getLastExit() {
        return lastExit;
    }

    public void setLastExit(Patient lastExit) {
        this.lastExit = lastExit;
    }


    public String showElements() {

        String information = priorityQueue.showElements();

        return information;
    }

}
