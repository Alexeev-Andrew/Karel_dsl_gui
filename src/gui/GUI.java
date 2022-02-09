package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import acm.program.*;
import acm.graphics.*;
import model.*;
import model.Exceptions.KarelCrashedIntoTheWallException;
import model.commands.Command;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.grammar.ProgramLexer;
import parser.grammar.ProgramParser;
import parser.grammar.impl.ProgramListenerImpl;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class GUI extends GraphicsProgram{

	private World world;
	private Karel karel;
	private int worldDX = 30;
	private int worldDY = 30;

	private int width;
	private int height;
	
	public void init(){

	}

	public void run(){
		world = new World(randomWorld());
		this.setSize((int)(world.getWIDTH_OF_WORLD()+worldDX*2+50+200+120),(int)world.getHEIGHT_OF_WORLD()+worldDY*2);
		width = this.getWidth();
		height = this.getHeight();

		add(world,30,30);

		karel = new Karel(World.getWIDTH_OF_CASE()/2+4,World.getWIDTH_OF_CASE()/2,90, Color.GREEN, this); //new Color(70,130,180)  300,200,45
		add(karel);

//		karel.move(World.getWIDTH_OF_CASE(), 0);
//		pause(500);
//		karel.move(World.getWIDTH_OF_CASE(), 0);
//		pause(500);
//		karel.move(World.getWIDTH_OF_CASE(), 0);
//		pause(500);
//		karel.move(World.getWIDTH_OF_CASE(), 0);
//		pause(500);


		try {
			CharStream cs = CharStreams.fromFileName("C:\\Users\\Andrew\\IdeaProjects\\Karel_dsl_gui\\resources\\algorithm_example.test");
			ProgramLexer pl = new ProgramLexer(cs);
			CommonTokenStream tokens = new CommonTokenStream(pl);
			ProgramParser parser = new ProgramParser(tokens);
			ParseTree tree = parser.programm();

			ParseTreeWalker treeWalker = new ParseTreeWalker();
			ProgramListenerImpl listener = new ProgramListenerImpl(this);
			treeWalker.walk(listener, tree);

			model.Program p = listener.getProgram();
			p.setWorld(this);
			try{
				p.execute();
			} catch(KarelCrashedIntoTheWallException e){
				e.printStackTrace();
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public int[][] randomWorld(){
//		return allWorld[random.nextInt(allWorld.length)];
		return allWorld[2];
	}
	int rand;
	public double randomYPosition(){
		rand =  random.nextInt(1,world.getAMOUNT_OF_CASES_Y());
		return (rand-0.5)*world.getWIDTH_OF_CASE()+(rand)*world.getWIDTH_OF_LINE()+worldDY;
	}
	
	public double randomX2Position(){
		rand =  random.nextInt(world.getAMOUNT_OF_CASES_X()/2+1,world.getAMOUNT_OF_CASES_X());
		return (rand-0.5)*world.getWIDTH_OF_CASE()+(rand)*world.getWIDTH_OF_LINE()+worldDX;
	}
	public double randomX1Position(){
		rand =  random.nextInt(1,world.getAMOUNT_OF_CASES_X()/2-1);
		return (rand-0.5)*world.getWIDTH_OF_CASE()+(rand)*world.getWIDTH_OF_LINE()+worldDX;
	}
	
	public int randomDegree(){
		return random.nextInt(360);
	}

	public World getWorld() {
		return world;
	}

	public Karel getKarel() {
		return karel;
	}



	RandomGenerator random = new RandomGenerator();
	
	int[][] world1 = {{9,7,13,3,9,5,5,3},{8,1,3,10,10,9,5,6},{10,14,10,8,4,4,3,11},{12,3,8,0,7,9,2,10},{9,4,2,10,9,2,12,2},{14,9,2,10,10,12,1,6},{13,2,14,8,0,5,0,3},{13,4,7,14,14,13,6,14}};
	int[][] world2 = {{13,5,1,3,9,7,1,13,3},{9,1,2,14,10,11,8,7,10},{14,10,12,6,8,4,2,8,6},{13,2,9,5,0,3,8,4,3},{11,12,2,9,6,8,2,13,6},{8,7,8,4,3,10,10,13,3},{12,5,4,5,4,6,12,5,6}};
	int[][] world3 = {{13,1,3,9,1,1,1,1,7},{9,2,12,2,10,10,14,8,7},{10,14,13,0,6,12,5,0,7},{12,1,3,8,7,9,3,10,11},{13,6,12,6,13,6,12,4,6}};
	int[][] world4 = {{13,3,13,5,1,1,1,1,7},{11,12,5,1,2,10,14,10,11},{10,11,9,6,14,10,13,0,6},{10,8,6,9,5,2,11,8,7},{10,10,9,4,1,4,2,12,7},{12,6,14,13,4,7,12,5,7}};
	
	int[][][] allWorld = {world1,world2,world3,world4};
	
}
