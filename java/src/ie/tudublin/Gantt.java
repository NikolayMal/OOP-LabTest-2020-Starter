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
		int days = 30;
		colorMode(HSB);
		int margin = 25;
		int right= 70;


		textAlign(CENTER);

		// Drawing Lines + Days of the Month
		for(int i = 1; i <= days; i++) {
			float x = map(i, 0, days, right, width-right);
			text(i, x, margin);
			line(x, margin*2, x, height - margin);
		}

		// Drawing Tasks
		for(int j = 0; j < tasks.size(); j++)
		{
			Task TaskY= tasks.get(j);

			fill(map(j, 0, tasks.size(), 0, 255), 255, 255);
			stroke(map(j, 0, tasks.size(), 0, 255), 255, 255);

			float y = map(j, 0, tasks.size(), 2 * margin, height - margin);
			text(tasks.get(j).getTask(), margin, y + margin);


			float Start = map(tasks.get(j).getStart(), 1, days, 90, width-right);
			float End = map(tasks.get(j).getEnd(), 1, days,95, width-right);
			rect(Start, y + 10, End - Start, 20, 5);

		}
	}
}