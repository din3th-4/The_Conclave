package cardinal;

import static cardinal.Characters.* ;
import java.security.SecureRandom;
import java.util.* ;

public class Cardinal implements Runnable {

    private String name ;
    private LinkedHashMap<String, Object> profile ;
    private LinkedHashMap<String, Double> whoIVote ;
    private HashSet<String> interactedWith ;

    private SecureRandom random = new SecureRandom() ;

    private LinkedHashMap<String, Object> generateProfile() {

        LinkedHashMap<String, Object> profile = this.profile ;

        for (String characteristic : characteristics) {

            if (characteristic.equals("continent")){

                //continent is assigned as a number so that in a cardinal interaction comparing continents will be fast
                profile.put(characteristic, random.nextInt(6)) ;

            } else if (characteristic.equals("age")) {

                //generates cardinal age from 65-80
                profile.put(characteristic, random.nextInt(14) + 65) ;

            } else {

                profile.put( characteristic, random.nextDouble(101) ) ;

            }


        }

        return profile ;
    }

    private void makeName() {

    }










    @Override
    public void run() {

    }


    public String getName() {

        return name ;

    }

    public LinkedHashMap<String, Object> getProfile() {

        return profile ;

    }

}
