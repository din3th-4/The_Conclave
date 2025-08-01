package cardinal;

import static cardinal.Characters.* ;
import java.security.SecureRandom;
import java.util.* ;

/*
Entire work of a cardinal, cardinal number is set in the main when the cardinal is created.
All attributes are private with getter methods, tester method is way out in the bottom to test out characteristics
 */

public class Cardinal implements Runnable {

    public int num ; //identify cardinal by number
    public int votes ;

    private String name ;
    private int age ;
    private int continent ;
    private double mainCharEnergy ;
    private double likability ;
    private LinkedHashMap<String, Double> profile ;

    private LinkedHashMap<String, Double> whoIVote ;
    private HashSet<Integer> interactedWith ;

    /* one cardinal also needs to be a moderator, will be set based on church authority, moderator methods will be in a
    separate class, default is false, when selected will be set to true */
    private boolean moderator = false ;

    private SecureRandom random = new SecureRandom() ;

    //constructor
    public Cardinal() {

        identity() ; //set name and continent

        //self-explanatory
        setAge() ;
        generateProfile() ;
        setMainCharacterEnergy() ;
        setLikability() ;

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

    private void setMainCharacterEnergy() {

        //weights
        final double w1 = 25 ;
        final double w2 = 5 ;
        final double w3 = 1 ;

        //first category affecting score with weight 1
        double w1List = ( ( this.age - 65 )* 6 + this.profile.get("health") )* w1 ;
        double w2List = 0 ;
        double w3List = 0 ;

        for (String category: medium){ //second category affecting score
            w2List += this.profile.get(category) ;
        }
        for (String category: light){ //third category affecting score
            w3List += this.profile.get(category) ;
        }

        this.mainCharEnergy = ( w1List + (w2List * w2 ) + (w3List * w3) ) / ( (2*w1) + (5*w2) + (5*w3) ) ;


    }

    private void setLikability() {

        this.likability =  ( profile.get("charisma") + profile.get("popularity") + profile.get("deception") ) / 3 ;

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

    public HashSet<Integer> getInteractedWith() {

        return interactedWith ;

    }

    public double getMainCharEnergy() {

        return mainCharEnergy ;

    }
    public double getLikability() {

        return likability ;

    }



    //method for testing
    public static void printCardinal( Cardinal c ) {

        System.out.println("name " + c.getName()) ;
        System.out.println("age " + c.getAge()) ;
        System.out.println("continent " + c.getContinent()) ;
        System.out.println("profile " + c.getProfile()) ;
        System.out.println("mainCharEnergy " + c.getMainCharEnergy()) ;
        System.out.println("setLikability "+ c.getLikability());

    }


}
