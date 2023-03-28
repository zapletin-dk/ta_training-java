package com.epam.rd.autotasks;

import java.util.ArrayList;

public class TaskCarousel {
    private final int capacity;
    private int index = 0;
    public static ArrayList <Task> taskList;

    public TaskCarousel(int capacity) {
        if (capacity < 0){ throw new UnsupportedOperationException();}
        this.capacity = capacity;
        taskList = new ArrayList<>(capacity);
    }
    public boolean checkTaskAdding(Task task){
        return task != null && !isFull() && !task.isFinished();
    }
    public boolean addTask(Task task) {
        if (checkTaskAdding(task)) {
            return taskList.add(task);
        }
        return false;
    }

    public boolean execute() {
        if (!isEmpty()) {
            if (index >= taskList.size()) index = 0;
            taskList.get(index).execute();
            if (taskList.get(index).isFinished()) {
                taskList.remove(index);
            } else {
                index++;
            }
            return true;
        }
        return false;
    }

    public boolean isFull() { return taskList.size() == capacity && !isEmpty(); }

    public boolean isEmpty() { return taskList.isEmpty(); }

}
