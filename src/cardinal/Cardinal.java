package cardinal;

import static cardinal.Characters.* ;
import java.security.SecureRandom;
import java.util.* ;

public class Cardinal implements Runnable {

    private String name ;
    private int age ;
    private int continent ;
    private LinkedHashMap<String, Double> profile ;
    private LinkedHashMap<String, Double> whoIVote ;
    private HashSet<String> interactedWith ;

    private SecureRandom random = new SecureRandom() ;

    public Cardinal() {

        identity() ;
        setAge() ;
        generateProfile() ;

    }

    //generates profile of doubles
    private void generateProfile() {

        profile = new LinkedHashMap<>() ;

        for (String characteristic : characteristics) {

            profile.put( characteristic , random.nextDouble(101) ) ;

        }



    }

    private void setAge() {

        this.age = random.nextInt(14) + 65 ;

    }

    //generates continent and name
    private void identity() {

        this.continent = random.nextInt(5) ;

        int attempts = 0 ;
        int maxAttempts = 25 ;

        //loop used to generate the name for the cardinal based on continent and avoids duplicate names
        do {
            if (attempts++ > maxAttempts) {

                this.continent = random.nextInt(5) ;
                attempts = 0 ;

            }

            int index = random.nextInt(25) ;

            this.name = switch (continent) {
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


    //method for testing
    public static void printCardinal( Cardinal c ) {

        System.out.println(c.getName()) ;
        System.out.println(c.getAge()) ;
        System.out.println(c.getContinent()) ;
        System.out.println(c.getProfile()) ;

    }


}
