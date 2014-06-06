package mineplicity.hub.TeamData;

/**
 * @author Blackeiled
 * Created by Blackeiled (Adam Canfield) on 6/6/2014.
 */


/**
 * This custom player type can be sent invitation requests.
 * @return
 */
public interface Invitable {

    /**
     * Sends an invitation to the selected player.
     * @return 1 if True; 0 if Pending; -1 if False;
     */
    public int invite();

    /**
     * Accepts the invitation.
     * @return 1
     */
    public int acceptInvite();

    /**
     * Declines the invite.
     * @return -1
     */
    public int declineInvite();

}
