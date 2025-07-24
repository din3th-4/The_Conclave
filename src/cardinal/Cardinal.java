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

    private void generateProfile() {

        for (String characteristic : characteristics) {

            if (characteristic.equals("continent")){

                //continent is assigned as a number so that in a cardinal interaction comparing continents will be fast
                this.profile.put(characteristic, random.nextInt(6)) ;

            } else if (characteristic.equals("age")) {

                //generates cardinal age from 65-80
                this.profile.put(characteristic, random.nextInt(14) + 65) ;

            } else {

                this.profile.put( characteristic, random.nextDouble(101) ) ;

            }

        }

    }

    private void makeName() {

        int attempts = 0 ;
        int maxAttempts = 25 ;

        int contiNum = (Integer) this.profile.get("continent") ;

        int nameIndex = random.nextInt(25) ;

        this.name = switch (contiNum) {

            case 0 -> Asia[nameIndex];
            case 1 -> Europe[nameIndex];
            case 2 -> Africa[nameIndex];
            case 3 -> NAmerica[nameIndex];
            case 4 -> SAmerica[nameIndex];
            case 5 -> Australia[nameIndex];
            default -> this.name ;

        } ;

        if (usedNames.contains(this.name)) {

        }

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
