package main;

import builders.ActionSequenceGenerator;
import builders.WorldGenerator;
import model.Karel;
import model.Program;
import model.Wall;
import model.World;
import model.commands.Action;
import model.commands.ActionSequence;
import model.commands.ForLoop;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.grammar.ProgramLexer;
import parser.grammar.ProgramListener;
import parser.grammar.ProgramParser;
import parser.grammar.impl.ProgramListenerImpl;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        World w = WorldGenerator.newBuilder()
//                .initialize(6,6)
//                .wall(new Wall(), 1,1)
//                .wall(new Wall(), 2,2)
//                .karel(new Karel(),0,0)
//                .build();
//
//        ActionSequence algorithm = ActionSequenceGenerator.newBuilder()
//                .initialize()
//                .singleAction(Action.MOVE)
//                .singleAction(Action.MOVE)
//                .singleAction(Action.MOVE)
//                .singleAction(Action.PUT_BEEPER)
//                .singleAction(Action.TURN_LEFT)
//                .singleAction(Action.TURN_LEFT)
//                .forLoop(new ForLoop(3, ActionSequenceGenerator.newBuilder().initialize()
//                        .singleAction(Action.MOVE)
//                        .build()))
//                .forLoop(new ForLoop(2, ActionSequenceGenerator.newBuilder().initialize()
//                        .singleAction(Action.TURN_LEFT)
//                        .build()))
//                .build();

        try {
            CharStream cs = CharStreams.fromFileName("resources/algorithm_example.test");
            ProgramLexer pl = new ProgramLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(pl);
            ProgramParser parser = new ProgramParser(tokens);
            ParseTree tree = parser.programm();

            ParseTreeWalker treeWalker = new ParseTreeWalker();
            ProgramListenerImpl listener = new ProgramListenerImpl(null);
                treeWalker.walk(listener, tree);

            Program p = listener.getProgram();
//            p.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
