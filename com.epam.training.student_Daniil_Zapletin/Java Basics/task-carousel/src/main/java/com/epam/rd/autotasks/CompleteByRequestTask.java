package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    boolean isCompleted;
    boolean executedAfterCompleted;

    @Override
    public void execute() { if (isCompleted) executedAfterCompleted = true; }

    @Override
    public boolean isFinished() { return executedAfterCompleted; }

    public void complete() { isCompleted = true; }
}
