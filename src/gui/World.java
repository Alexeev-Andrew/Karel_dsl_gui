package gui;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GRect;

// my implementation of karel world
public class World extends GCompound {

	private static int WIDTH_OF_LINE = 4;
	private static double WIDTH_OF_CASE = 70;
	private int AMOUNT_OF_CASES = 8;
	private int AMOUNT_OF_CASES_X = 8;
	private int AMOUNT_OF_CASES_Y = 8;
	private double WIDTH_OF_WORLD = WIDTH_OF_CASE*AMOUNT_OF_CASES_X+(AMOUNT_OF_CASES_X-1)*WIDTH_OF_LINE+(WIDTH_OF_LINE+2)*2;
	private double HEIGHT_OF_WORLD = WIDTH_OF_CASE*AMOUNT_OF_CASES_Y+(AMOUNT_OF_CASES_Y-1)*WIDTH_OF_LINE+(WIDTH_OF_LINE+2)*2;
	
	private GCompound border;
	private GCompound walls;

	private final int[][] cell_info;
	
	public World(int[][] inf ){		
		super();
		cell_info = inf;
		AMOUNT_OF_CASES_Y = inf.length;
		AMOUNT_OF_CASES_X = inf[0].length;
		WIDTH_OF_WORLD = WIDTH_OF_CASE*AMOUNT_OF_CASES_X+(AMOUNT_OF_CASES_X-1)*WIDTH_OF_LINE+(WIDTH_OF_LINE+2)*2;
		HEIGHT_OF_WORLD = WIDTH_OF_CASE*AMOUNT_OF_CASES_Y+(AMOUNT_OF_CASES_Y-1)*WIDTH_OF_LINE+(WIDTH_OF_LINE+2)*2;
		
		border = new GCompound();
		Color borderColor = Color.RED;
		GRect borderX = new GRect(0,0,WIDTH_OF_WORLD,WIDTH_OF_LINE+2);
		borderX.setFilled(true);
		borderX.setFillColor(borderColor);
		GRect borderY = new GRect(0,0,WIDTH_OF_LINE+2,HEIGHT_OF_WORLD);
		borderY.setFilled(true);
		borderY.setFillColor(borderColor);
		GRect borderY1 = new GRect(WIDTH_OF_WORLD-WIDTH_OF_LINE-2,0,WIDTH_OF_LINE+2,HEIGHT_OF_WORLD);
		borderY1.setFilled(true);
		borderY1.setFillColor(borderColor);
		GRect borderX1 = new GRect(0,HEIGHT_OF_WORLD-WIDTH_OF_LINE-2,WIDTH_OF_WORLD,WIDTH_OF_LINE+2);
		borderX1.setFilled(true);
		borderX1.setFillColor(borderColor);
		border.add(borderY);
		border.add(borderY1);
		border.add(borderX);
		border.add(borderX1);
		border.setColor(Color.BLACK);
		
		this.add(border);
		
		walls = new GCompound();

		
		for(int i = 0;i<inf.length;i++){
			for(int j=0;j<inf[i].length;j++)createWalls(j+1,i+1,inf[i][j]);
		}
		
		this.add(walls);
	}
	
	/**
	 * parametr  *   *   *   *
	 * 			 2^3 2^2 2^1 2^0
	 * 			  L	  D   R   U
	 */
	private void createWalls(int x,int y,int parametr){
			
		if(parametr>=8){
			parametr-=8;
			createLeftWall(x,y);
		}
		
		if(parametr>=4){
			parametr-=4;
			createDownWall(x,y);
		}
		if(parametr>=2){
			parametr-=2;
			createRightWall(x,y);
		}
		if(parametr==1){
			parametr-=1;
			createUpWall(x,y);
		}
	
	}
	
	
	private void createLeftWall(int x,int y){
		GRect w;
		w = new GRect((x-1)*WIDTH_OF_CASE+(x-2)*WIDTH_OF_LINE+WIDTH_OF_LINE+2,(y-1)*WIDTH_OF_CASE+WIDTH_OF_LINE+2+(y-1)*WIDTH_OF_LINE-WIDTH_OF_LINE,WIDTH_OF_LINE,WIDTH_OF_CASE+2*WIDTH_OF_LINE);
		w.setFilled(true);
		w.setFillColor(colorOfWalls);
		w.setColor(colorOfWalls);
		walls.add(w);
	}
	
	
	private void createRightWall(int x,int y){
		GRect w;
		if(y>=2)
		w = new GRect(x*WIDTH_OF_CASE+WIDTH_OF_LINE+2+(x-1)*WIDTH_OF_LINE, (y-1)*WIDTH_OF_CASE+WIDTH_OF_LINE+2+(y-2)*WIDTH_OF_LINE,  WIDTH_OF_LINE,WIDTH_OF_CASE+2*WIDTH_OF_LINE);
		else w= new GRect(x*WIDTH_OF_CASE+WIDTH_OF_LINE+2+(x-1)*WIDTH_OF_LINE, (y-1)*WIDTH_OF_CASE+WIDTH_OF_LINE+2,  WIDTH_OF_LINE,WIDTH_OF_CASE+WIDTH_OF_LINE*1);
		w.setFilled(true);
		w.setFillColor(colorOfWalls);
		w.setColor(colorOfWalls);
		walls.add(w);
	}
	
	private void createDownWall(int x,int y){
		GRect w;
		//if(x>=2)
		w = new GRect((x-1)*WIDTH_OF_CASE+WIDTH_OF_LINE+2+(x-1)*WIDTH_OF_LINE-WIDTH_OF_LINE, y*WIDTH_OF_CASE+WIDTH_OF_LINE+2+(y-1)*WIDTH_OF_LINE,  WIDTH_OF_CASE+WIDTH_OF_LINE*2,WIDTH_OF_LINE);
		//else w= w = new GRect((x-1)*WIDTH_OF_CASE+WIDTH_OF_LINE+2, y*WIDTH_OF_CASE+WIDTH_OF_LINE+2+(y-1)*WIDTH_OF_LINE,  WIDTH_OF_CASE,WIDTH_OF_LINE);
		w.setFilled(true);
		w.setFillColor(colorOfWalls);
		w.setColor(colorOfWalls);
		walls.add(w);
	}
	
	
	private void createUpWall(int x,int y){
		GRect w;
		w = new GRect((x-1)*WIDTH_OF_CASE+WIDTH_OF_LINE+2+(x-1)*WIDTH_OF_LINE-WIDTH_OF_LINE, (y-1)*WIDTH_OF_CASE+WIDTH_OF_LINE+2+(y-2)*WIDTH_OF_LINE,  WIDTH_OF_CASE+WIDTH_OF_LINE*2,WIDTH_OF_LINE);
		w.setFilled(true);
		w.setFillColor(colorOfWalls);
		w.setColor(colorOfWalls);
		walls.add(w);
	}
	
	Color colorOfWalls = Color.DARK_GRAY;

	public static int getWIDTH_OF_LINE() {
		return WIDTH_OF_LINE;
	}

	public static double getWIDTH_OF_CASE() {
		return WIDTH_OF_CASE;
	}

	public int getAMOUNT_OF_CASES() {
		return AMOUNT_OF_CASES;
	}

	public int getAMOUNT_OF_CASES_X() {
		return AMOUNT_OF_CASES_X;
	}

	public int getAMOUNT_OF_CASES_Y() {
		return AMOUNT_OF_CASES_Y;
	}

	public double getWIDTH_OF_WORLD() {
		return WIDTH_OF_WORLD;
	}

	public double getHEIGHT_OF_WORLD() {
		return HEIGHT_OF_WORLD;
	}

	public GCompound getBorder() {
		return border;
	}

	public Color getColorOfWalls() {
		return colorOfWalls;
	}

	private boolean isClear(int x, int y, int direction){
		int bit = 0;
		switch (direction){
			case 0:
				bit = 0;
				break;
			case 90:
				bit = 1;
				break;
			case 180:
				bit = 2;
				break;
			case 270:
				bit = 3;
				break;
		}

		return getBit(cell_info[x][y], bit) == 0;
	}

	public boolean frontIsClear(Karel karel){
		return isClear(karel.getX_cell(), karel.getY_cell(), karel.getOrientation());
	}
	public boolean frontIsBlocked(Karel karel){
		return !isClear(karel.getX_cell(), karel.getY_cell(), karel.getOrientation());
	}
	public boolean leftIsClear(Karel karel){
		int rotation = karel.getOrientation() - 90;
		if(rotation<0)
			rotation+=360;
		return isClear(karel.getX_cell(), karel.getY_cell(), rotation);
	}
	public boolean leftIsBlocked(Karel karel){
		return !leftIsClear(karel);
	}
	public boolean rightIsClear(Karel karel){
		int rotation = karel.getOrientation() + 90;
		if(rotation>=360)
			rotation-=360;
		return isClear(karel.getX_cell(), karel.getY_cell(), rotation);
	}
	public boolean rightIsBlocked(Karel karel){
		return rightIsClear(karel);
	}
	public boolean beepersPresent(Karel karel){
		return false;
	}
	public boolean facingNorth(Karel karel){
		return karel.getOrientation() == 0;
	}
	public boolean facingEast(Karel karel){
		return karel.getOrientation() == 90;
	}
	public boolean facingSouth(Karel karel){
		return karel.getOrientation() == 180;
	}
	public boolean facingWest(Karel karel){
		return karel.getOrientation() == 270;
	}

	private int getBit(int n, int k){
		return (n >> k) & 1;
	}
	
}
