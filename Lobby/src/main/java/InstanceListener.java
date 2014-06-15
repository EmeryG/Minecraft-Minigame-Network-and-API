import lilypad.client.connect.api.event.EventListener;
import lilypad.client.connect.api.event.MessageEvent;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by Ali on 08/06/2014.
 */
public class InstanceListener {

    static HashMap<String, State> instances = new HashMap<String, State>();

    // The format for @onMessage is info:cur:{number}max:{number}lazy:{0 or 1}
    // 0 means not lazy, 1 means lazy
    @EventListener
    public void onMessage(MessageEvent messageEvent) {
        String sender = messageEvent.getSender();
        try {
            String messageAsString = messageEvent.getMessageAsString();
            if(messageAsString.startsWith("info:")) {
                messageAsString = messageAsString.substring(5);

                // Getting value from min
                if(messageAsString.startsWith("cur:")) {
                    messageAsString = messageAsString.substring(4);
                    String cur = "";
                    while(!messageAsString.startsWith("cur:")) {
                        cur += messageAsString.charAt(0);
                        messageAsString = messageAsString.substring(1);
                    }

                    // Getting value from main
                    messageAsString = messageAsString.substring(4);
                    String max = "";
                    while(!messageAsString.startsWith("working:")) {
                        max += messageAsString.charAt(0);
                        messageAsString = messageAsString.substring(1);
                    }

                    // Getting value from working
                    messageAsString = messageAsString.substring(8);

                    // Updating the values
                    instances.get(sender).setCurrentPlayers(Integer.parseInt(cur));
                    instances.get(sender).setMaxPlayers(Integer.parseInt(max));
                    if(messageAsString.equals("0")) {
                        instances.get(sender).setLazy(false);
                    } else {
                        instances.get(sender).setLazy(true);
                    }
                }
            }
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
