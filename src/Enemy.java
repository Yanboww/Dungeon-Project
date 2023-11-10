public class Enemy {
    private int ehp;
    private int eatk;
    private int count;
    private String enemy;

    public Enemy()
    {}

    /** A method that randomly rolls a die to determine between 3 enemy characters and adds 1
     * to the variable count. When count is 3 or more, it guarantees the boss to be generated
     *
     * @return returns the enemy name based on the dice roll and calculations
     */
    public String generateEnemies()
    {
        count++;
        String name ="";
        int diceNum = (int)(Math.random()*6)+1;
        if (diceNum<4)
        {
            enemy = "Very Extremely Scary Clown";
            name = "Very Extremely Scary Clown";
        }
        else if (diceNum == 4)
        {
            enemy = "??????";
            name = "??????";
        }
        else if(diceNum == 5 || diceNum ==6)
        {
            enemy = "Cute Slime that you must murder(you have no choice)";
            name = "Cute Slime that you must murder(you have no choice)";
        }
        if (count>=3)
        {
            enemy = "The Ancient One";
            name = "The Ancient One";
        }
        setEnemy();
        return name;
    }

    /** Set the enemy stats such as ehp and eatk based on the name assigned to the variable
     * enemy. This process is after the generateEnemies() method which assigned the enemy variable
     * values.
     *
     */
    public void setEnemy()
    {
        if (enemy.equals("The Ancient One"))
        {
            ehp = 400;
            eatk = 20;

        }
        else if (enemy.equals("??????"))
        {
            ehp = 120;
            eatk = 7;

        }
        else if (enemy.equals("Cute Slime that you must murder(you have no choice)"))
        {
            ehp = 400;
            eatk = 0;

        }
        else {
            ehp = 100;
            eatk = 5;

        }
    }

    /** Describes the enemy by formatting string into sentences so that the player
     * gets a better understanding of their opponent's background.
     *
     * @return returns the formatted strings based on the value assigned to private
     * variable enemy.
     */
    public String describeEnemy()
    {
        String words;
        if (enemy.equals("The Ancient One"))
        {
            words = "A being of the past, forgotten through time, a nameless god";
        }
        else if (enemy.equals("??????"))
        {
            words = "... I don't quite know what it is perhaps its identity will be revealed later";
        }
        else if (enemy.equals("Cute Slime that you must murder(you have no choice)"))
        {
            words = "The cutest thing you have and will ever see";
        }
        else {
            words = "Just a regular old clown";
        }
        return words;
    }

    /** A method that returns the private variable ehp.
     *
     * @return returns the private variable ehp
     */
    public int returnEHP()
    {
        return ehp;
    }

    /** This method is similar to the useMove method. It determines the damage dealt to the player
     * by testing for the string value of the variable enemy and calculate for the return value of dmg.
     *
     * @return returns an integer representing the amount of damage dealt to the player by the enemy.
     */
    public int enemyMove()
    {
        int dmg=0;
        if (enemy.equals("The Ancient One"))
        {
            dmg = eatk+ (int)(Math.random()*10)+5;
            ehp+=7;
            int diceNum = (int)(Math.random()*1000);
            if (diceNum == 10)
            {
                dmg=2147483647;
            }
        }
        else if (enemy.equals("??????"))
        {
            dmg = eatk+ (int)(Math.random()*6);
        }
        else if (enemy.equals("Cute Slime that you must murder(you have no choice)"))
        {
            return dmg;
        }
        else if(enemy.equals("Very Extremely Scary Clown")){
            dmg = eatk;
        }
        return dmg;
    }

    /** Change the ehp variable based on the damage parameter.
     *
     * @param dmg used to subtract from the set ehp variable.
     */
    public void changeEHP (int dmg)
    {
        ehp-=dmg;
    }

    public String returnName()
    {
        return enemy;
    }

}
