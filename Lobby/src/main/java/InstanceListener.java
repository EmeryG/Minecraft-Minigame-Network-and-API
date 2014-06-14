import lilypad.client.connect.api.event.EventListener;
import lilypad.client.connect.api.event.MessageEvent;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by Ali on 08/06/2014.
 */
public class InstanceListener {

    static HashMap<String, State> instances = new HashMap<String, State>();

    @EventListener
    public void onMessage(MessageEvent messageEvent) {
        String sender = messageEvent.getSender();
        try {
            String messageAsString = messageEvent.getMessageAsString();
        } catch(UnsupportedEncodingException exception) {
            //ignore
        }
    }

    public static String getHighestPriority() {
        State s = new State(0, 5, true);
        String server = "";
        for(String serv : instances.keySet()) {
            if(instances.get(serv).getMaxPlayers() > instances.get(serv).getCurrentPlayers() && instances.get(serv).isLazy()) {
                if(instances.get(serv).getCurrentPlayers() > s.getCurrentPlayers()) {
                    s = instances.get(serv);
                    server = serv;
                }
            }
        }
        return server;
    }
}
