package builders;

import model.commands.ActionSequence;
import model.commands.*;

import java.util.ArrayList;

public class ActionSequenceGenerator {

    private ArrayList<Command> body;

    public static Builder newBuilder(){
        return new ActionSequenceGenerator().new Builder();
    }

    private ActionSequenceGenerator(){}

    public class Builder{
        public Builder initialize(){
            if(ActionSequenceGenerator.this.body == null)
                ActionSequenceGenerator.this.body = new ArrayList<>();

            return this;
        }

        public Builder singleAction(Action a) {
            if(ActionSequenceGenerator.this.body == null)
                ActionSequenceGenerator.this.body = new ArrayList<>();

            ActionSequenceGenerator.this.body.add(a);
            return this;
        }

        public Builder forLoop(ForLoop a) {
            if(ActionSequenceGenerator.this.body == null)
                ActionSequenceGenerator.this.body = new ArrayList<>();

            ActionSequenceGenerator.this.body.add(a);
            return this;
        }

        public Builder whileLoop(WhileLoop a) {
            if(ActionSequenceGenerator.this.body == null)
                ActionSequenceGenerator.this.body = new ArrayList<>();

            ActionSequenceGenerator.this.body.add(a);
            return this;
        }


        public Builder operatorIf(IfCommand a) {
            if(ActionSequenceGenerator.this.body == null)
                ActionSequenceGenerator.this.body = new ArrayList<>();

            ActionSequenceGenerator.this.body.add(a);
            return this;
        }

        public Builder function(FunctionCall a) {
            if(ActionSequenceGenerator.this.body == null)
                ActionSequenceGenerator.this.body = new ArrayList<>();

            ActionSequenceGenerator.this.body.add(a);
            return this;
        }

        public ActionSequence build() {
            return new ActionSequence(body);
        }
    }

}
