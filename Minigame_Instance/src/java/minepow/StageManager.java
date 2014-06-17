package minepow;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/15/14
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class StageManager {

    @Getter
    static State state;

    public static void change(){
        if(state == State.PRE) {
            state = State.DURING;
        } else if(state == State.DURING) {
            state = State.AFTER;
        } else {
            state = State.PRE;
        }
    }

    public enum State{
        PRE,
        DURING,
        AFTER
    }
}
