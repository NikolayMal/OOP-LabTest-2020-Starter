package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;


public class Gantt extends PApplet
{
	public ArrayList<Task> tasks = new ArrayList<Task>();

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
		for(TableRow row:t.rows())
		{
			Task tk = new Task(row);
			tasks.add(tk);
		}
	}

	public void printTasks()
	{
		for(Task tk:tasks)
		{
			println(tk);
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}

	public void displayTasks(){
		fill(255);
		stroke(255);
		int days = 31;

		textAlign(CENTER);
/*
		for(int i = 0; i < numofdays; i++)
		{
			float x1 = map(i, 1,30, 125, 40);
			line(x1, 80,x1, 500);
		}
*/
		// Drawing Lines + Days of the Month
		for(int i = 1; i < days; i++) {
			float x = map(i, 0, days, 75, width);
			text(i, x, height-510);
			line(x, 100, x, height - 50);
		}

		// Drawing Tasks
	}
/*
map(value, start1, stop1, start2, stop2)
Parameters
value	float: the incoming value to be converted
start1	float: lower bound of the value's current range
stop1	float: upper bound of the value's current range
start2	float: lower bound of the value's target range
stop2	float: upper bound of the value's target range*/
	public static void main (String...args){
		PApplet.main("ie.tudublin.Gantt");
	}
}