import lilypad.client.connect.api.event.EventListener;
import lilypad.client.connect.api.event.MessageEvent;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by Ali on 08/06/2014.
 */
public class InstanceListener {

    static HashMap<String, Slots> instances = new HashMap<String, Slots>();

    @EventListener
    public void onMessage(MessageEvent messageEvent) {
        String sender = messageEvent.getSender();
        String channel = messageEvent.getChannel();
        byte[] message = messageEvent.getMessage();
        try {
            String messageAsString = messageEvent.getMessageAsString();
        } catch(UnsupportedEncodingException exception) {
            //ignore
        }
    }

}
