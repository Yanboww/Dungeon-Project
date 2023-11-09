import java.util.Scanner;
public class DungeonRunner {
    public static void main(String[] args) {
        //color ASNI codes for changing string color
        final String blue = "\u001B[34m";
        final String red ="\u001B[31m";
        final String green = "\u001B[32m";
        final String reset = "\u001B[0m";
        final String blackBG= "\u001B[40m";
        //create new scanner object
        Scanner s = new Scanner(System.in);

        //Introduction to the game
        System.out.println(green + "Welcome nameless hero, will it be you who clear this dungeon?" + reset);
        System.out.print("Choose your class(type mage, warrior ,or paladin): ");
        String classChar = s.nextLine();
        Enemy enemy = new Enemy();
        DungeonConquestSim newGame = new DungeonConquestSim(classChar, enemy);
        System.out.println(green + "Welcome, oh great " + classChar + "\nOh? You have amnesia? tsk..." + reset);
        newGame.wait(1500);
        System.out.println(green +"Oh apologies what I meant is but of course! I shall present you your skills" + reset);
        newGame.wait(1000);
        System.out.println(blue + newGame + reset);
        newGame.wait(1500);
        System.out.println(green + "What do you think? Pretty cool right? You better be grateful of me! You rarely find someone as kind as me after all"+ reset);
        newGame.wait(2000);
        System.out.println(green + "Now off you go!" + reset);
        System.out.printf("|%s|%n", "You were pushed into the dungeon by a mysterious force... ");
        System.out.println("\nSystem pop up!");
        newGame.wait(2000);
        System.out.println(blue + "Move: " + newGame.describeMove(1) +reset);
        System.out.println(blue + "Ultimate: " + newGame.describeMove(2) + reset);
        //start of the game
        int count=0;
        int hp = newGame.returnHP();
        while (!newGame.finale() && hp>0 && count<2)
        {
            //spawns enemy
            count++;
            System.out.println("\nAn enemy appears before you...");
            newGame.wait(2000);
            String enemy = newGame.generateEnemies();
            String describeEnemy = newGame.describeEnemy();
            System.out.println("A wild " + enemy + " appeared!");
            System.out.println(blue + describeEnemy + reset);
            newGame.wait(2000);
            System.out.println(green + "Now go kill it!" + reset +" says a distant voice");
            newGame.wait(1500);
            boolean victory = newGame.victory();
            while (!victory && hp>0)
            {
                //player actions
                int stamina = newGame.returnStamina();
                int ehp = newGame.returnEHP();
                System.out.println(green + "Player Health: " + hp + reset);
                System.out.println(blue + "Stamina: " + stamina + reset);
                System.out.println(red + "Enemy Health: " + ehp + reset);
                System.out.print("What is your move?\n1) use skill(2 stamina)\n2) use ultimate(10 stamina)\n3) heal(2 stamina)\n4) do nothing\n:");
                String moveNumString = s.nextLine();
                int moveNum = Integer.parseInt(moveNumString);
                int dmg = newGame.useMove(moveNum);
                newGame.wait(1000);
                System.out.println(newGame.moveMessage(moveNum,dmg,stamina,hp));
                newGame.wait(1000);
                newGame.changeStamina();
                victory = newGame.victory();
                //enemy move
                if(!victory)
                {
                    int enemyDMG = newGame.enemyMove();
                    System.out.println("\n"+enemy + " does " + red + enemyDMG +" damage!\n" + reset);
                }
                hp = newGame.returnHP();
            }
            //add hp after each round of enemy if player still alive
            if (hp>0)
            {
                newGame.resetHP();
            }

        }
        hp = newGame.returnHP();
        //if the while loop is finished and hp is greater than 0 then boss fight starts
        if (hp>0)
        {
            //boss speech
            count++;
            String enemy = newGame.generateEnemies();
            newGame.wait(1000);
            System.out.println(green + "Good job hero, you have made it far. Far exceeding my expectations" + reset);
            newGame.wait(1000);
            System.out.println(green+"You have performed well so far but you have yet to face your greatest challenge...");
            newGame.wait(1000);
            System.out.println(blackBG + red + "Throughout heaven and earth, I alone am the honored one." + reset);
            newGame.wait(1000);
            System.out.println(blackBG + red + "It is I! DIO! No wait I meant IT IS I! The Ancient One!" + reset);
            while(!newGame.finale() && !newGame.victory() && hp>=0)
            {
                //player move
                newGame.wait(1500);
                int stamina = newGame.returnStamina();
                int ehp = newGame.returnEHP();
                hp = newGame.returnHP();
                System.out.println(green + "Player Health: " + hp + reset);
                System.out.println(blue + "Stamina: " + stamina + reset);
                System.out.println(red + "Enemy Health: " + ehp + reset);
                System.out.print("What is your move?\n1) use skill(2 stamina)\n2) use ultimate(10 stamina)\n3) heal(2 stamina)\n4) do nothing\n:");
                String moveNumString = s.nextLine();
                int moveNum = Integer.parseInt(moveNumString);
                int dmg = newGame.useMove(moveNum);
                newGame.wait(1000);
                System.out.println(newGame.moveMessageBoss(moveNum,dmg,stamina,hp));
                newGame.changeStamina();
                //boss move
                if(!newGame.victory())
                {
                    int enemyDMG = newGame.enemyMove();
                    // changes print statement depending on the hp and enemyDMG
                    if(enemyDMG>hp)
                    {
                        System.out.println("\n" + blackBG + red + "Unlimited technique, Lime Green" +reset);
                        System.out.println("You just got off screened!\n");
                    }
                    else {
                        System.out.println("\n"+enemy + " does " + red + enemyDMG +" damage!\n" + reset);
                    }
                }
            }
        }
        //the end and prints a message depending on how the player ended the game.
        String message = newGame.endMessage(count);
        System.out.println("\n"+message);

    }

}
