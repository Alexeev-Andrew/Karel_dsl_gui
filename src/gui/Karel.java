package gui;

import java.awt.Color;

import acm.graphics.*;
import model.Exceptions.KarelCrashedIntoTheWallException;

public class Karel extends GImage {

	private double x;
	private double y;
	private int orientation;

	private GUI world;

	private int x_cell;
	private int y_cell;

	public static final int WIDTH = 70;
	public static final int HEIGHT = 70;

	
	public Karel(double x, double y, int orientation, Color color, GUI world){
		super("D:\\KarelEast.PNG");
		this.orientation = orientation;
		this.world = world;
		this.x = x;
		this.y = y;
		this.x_cell = 0;
		this.y_cell = 0;

		this.setLocation(x,y);
		this.setSize(WIDTH, HEIGHT);
	}


	public void moveForvard() throws KarelCrashedIntoTheWallException{
		if(world.getWorld().frontIsBlocked(this)) {
			System.out.println("Error: WALL!");
			throw new KarelCrashedIntoTheWallException(this.world);
		}

		switch (orientation){
			case 0:
				move(0, -World.getWIDTH_OF_CASE()-World.getWIDTH_OF_LINE());
				y-=World.getWIDTH_OF_CASE()+World.getWIDTH_OF_LINE();
				x_cell -= 1;
				break;
			case 90:
				move(World.getWIDTH_OF_CASE()+World.getWIDTH_OF_LINE(), 0);
				x+=World.getWIDTH_OF_CASE()+World.getWIDTH_OF_LINE();
				y_cell += 1;
				break;
			case 180:
				move(0, World.getWIDTH_OF_CASE()+World.getWIDTH_OF_LINE());
				y+=World.getWIDTH_OF_CASE()+World.getWIDTH_OF_LINE();
				x_cell += 1;
				break;
			case 270:
				move(-World.getWIDTH_OF_CASE()-World.getWIDTH_OF_LINE(), 0);
				x-=World.getWIDTH_OF_CASE()+World.getWIDTH_OF_LINE();
				y_cell -= 1;
				break;
		}
		pause(1000);

	}

	public void rotateRight(){
		switch (orientation){
			case 0:
				saveImage("D:\\KarelEast.PNG");
				break;
			case 90:
				saveImage("D:\\KarelSouth.PNG");
				break;
			case 180:
				saveImage("D:\\KarelWest.PNG");
				break;
			case 270:
				saveImage("D:\\KarelNorth.PNG");
				break;
		}
		orientation += 90;
		while(orientation>=360)
			orientation -= 360;
	}

	public void putBeeper(){
		GImage beeper = new GImage("D:\\bpng.png");
		beeper.setSize(70,70);
		beeper.setLocation(x,y);
		world.add(beeper);

	}

	public void rotateLeft(){
		switch (orientation){
			case 180:
				saveImage("C:\\Users\\Andrew\\IdeaProjects\\Karel_dsl_gui\\resources\\KarelEast.PNG");
				break;
			case 270:
				saveImage("C:\\Users\\Andrew\\IdeaProjects\\Karel_dsl_gui\\resources\\KarelSouth.PNG");
				break;
			case 0:
				saveImage("C:\\Users\\Andrew\\IdeaProjects\\Karel_dsl_gui\\resources\\KarelWest.PNG");
				break;
			case 90:
				saveImage("C:\\Users\\Andrew\\IdeaProjects\\Karel_dsl_gui\\resources\\KarelNorth.PNG");
				break;
		}
		orientation -= 90;
		while(orientation<0)
			orientation += 360;
	}
	
	public static double getY(GPoint p1,GPoint p2,double xx){
		return (xx-p2.getX())*(p2.getY()-p1.getY())/(p2.getX()-p1.getX()) + p2.getY();
	}
	public static double getX(GPoint p1,GPoint p2,double yy){
		return (yy-p2.getY())*(p2.getX()-p1.getX())/(p2.getY()-p1.getY()) + p2.getX();
	}
	
	
	public static double angleInRadians(double angel){
		return angel*Math.PI/180;
	}
	
	public static double angleInDegrees(double angle){
		return angle*180/Math.PI;
	}


	public int getOrientation() {
		return orientation;
	}


	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}


	public int getX_cell() {
		return x_cell;
	}

	public void setX_cell(int x_cell) {
		this.x_cell = x_cell;
	}

	public int getY_cell() {
		return y_cell;
	}

	public void setY_cell(int y_cell) {
		this.y_cell = y_cell;
	}
}
