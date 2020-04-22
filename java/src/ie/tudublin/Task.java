package ie.tudublin;

import processing.data.Table;
import processing.data.TableRow;

public class Task {

    private String Task;
    private int Start;
    private int End;

    public Task(String Task, int Start, int End) {
        this.Task = Task;
        this.Start = Start;
        this.End = End;
    }

    public Task(TableRow row) {
        this(
                row.getString("Task")
                , row.getInt("Start")
                , row.getInt("End")
        );
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String Task) {
        this.Task = Task;
    }

    public int getStart(){
        return Start;
    }

    public void setStart(int Start) {
        this.Start = Start;
    }

    public int getEnd(){
        return End;
    }

    public void setEnd(int End) {
        this.End = End;
    }

    public String toString()
    {
        return Task + ": Task= " + Task + " Start= " + Start + " End= " + End;
    }
}