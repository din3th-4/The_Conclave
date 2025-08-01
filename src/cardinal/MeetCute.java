package cardinal;


public class MeetCute {

    public static double interactionScore ( Cardinal me, Cardinal you ) {

        me.getInteractedWith().add(you.num) ;
        you.getInteractedWith().add(me.num) ;

        //judgement based on the meeting cardinals main character energy
        double areUImportant = you.getMainCharEnergy() - 50 ;
        //judgement based on the meeting cardinals likability
        double likableIsh = ( you.getLikability() - me.getProfile().get("rigidness") ) / 10 ;

        //compatibility based on characters of me and meeting cardinal
        double compatibility = 0 ;
        //myMan depends on if meeting cardinal is from the same continent as me
        double myMan ;

        if ( me.getContinent() == you.getContinent() ) {
            myMan = me.getProfile().get("loyalty") / 10 ;

        } else {
            myMan = (me.getProfile().get("loyalty") / 10 ) * (-1) ;

        }

        for (String s : cardinal.Characters.views) {
            compatibility += ( you.getProfile().get(s) - me.getProfile().get(s) ) ;
        }

        return areUImportant + likableIsh + (myMan - (me.getProfile().get("voteSelf") / 10 )) - (compatibility/21) + you.votes ;


    }



}
