package cardinal;

import static cardinal.Characters.* ;
import java.security.SecureRandom;
import java.util.* ;

public class Cardinal implements Runnable {

    private String name ;
    private int age ;
    private int continent ; ;
    private LinkedHashMap<String, Double> profile ;
    private LinkedHashMap<String, Double> whoIVote ;
    private HashSet<String> interactedWith ;

    private SecureRandom random = new SecureRandom() ;

    //generates profile of doubles
    private void generateProfile() {

        for (String characteristic : characteristics) {

            profile.put( characteristic, random.nextDouble(101) ) ;

        }

    }

    //generates continent and name
    private void identity() {

        continent = random.nextInt(5) ;

        int attempts = 0 ;
        int maxAttempts = 25 ;

        //loop used to generate the name for the cardinal based on continent and avoids duplicate names
        do {
            if (attempts++ > maxAttempts) {
                continent = random.nextInt(5) ;
                attempts = 0 ;
            }
            int index = random.nextInt(25) ;

            name = switch (continent) {
                case 0 -> Asia[index];
                case 1 -> Europe[index];
                case 2 -> Africa[index];
                case 3 -> NAmerica[index];
                case 4 -> SAmerica[index];
                case 5 -> Australia[index];
                default -> name;
            };
        } while ( usedNames.contains(name) ) ;

        usedNames.add(name) ;
    }



    @Override
    public void run() {

    }




    //methods to get characteristics
    public String getName() {

        return name ;

    }

    public int getAge() {

        return age ;

    }

    public int getContinent() {

        return continent ;

    }

    public LinkedHashMap<String, Double> getProfile() {

        return profile ;

    }



}
