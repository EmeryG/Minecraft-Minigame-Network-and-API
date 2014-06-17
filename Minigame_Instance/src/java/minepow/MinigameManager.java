package minepow;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/15/14
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class MinigameManager {

    @Getter
    static State state;

    public static void start(){

    }

    public enum State{
        PRE,
        DURING,
        AFTER
    }
}
