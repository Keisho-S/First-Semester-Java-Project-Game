package COMP1030.finalProject;

/**
 * Application Purpose: Final Project --RPG Game
 * Author: Keisho Seiho 200553984
 * 
 * Structure: 
 * Function discription:  public int pHP is hero HP, public int pMANA is hero MANA
 * 
 * Date: 2023-6-27
 */
import java.io.Console;
import java.util.Random;
import java.util.Scanner;

public class StructureObj {

    /*
     * Instantiate new object "st" of static StructureObj class, that could be
     * called in MapObj class and Main class.
     * Reason of setting static:the data of player HP, mana, treasure would be cross
     * the hole Project,I must use the same data in MapObj class and Main class.
     * Create in this class is much more convenient than any other class.
     */
    static StructureObj st = new StructureObj();

    // Instantiate new hero object and enemy object
    GameCharactersObj hero = new GameCharactersObj(null, null, null, 0, 0, 0, 0);
    GameCharactersObj enemy = new GameCharactersObj(0, 0);

    /*
     * Instantiate public variables for player HP, MANA, jesasTear and jesasBread,
     * that could be able to use in MapObj class.
     * The reason why create pHP and pMANA is that player HP and MANA would be
     * changed when to rest or fight with monsters.
     * I use HP and MANA setter to set the player original HP and MANA, use getter
     * as a container for recovering HP and MANA, pHP and pMANA could be changeable,
     * For example: when the player gets to rest,
     * I can use the HP getter to rewrite the player current HP(pHP) instead of
     * resetting it everytime (except for finding treasure, which will reset HP or
     * MANA to a higher lv).
     */
    public int pHP = hero.getPlayerHP();
    public int pMANA = hero.getPlayerMANA();

    public double jesasTear = hero.getJesasTear();
    public double jesasBread = hero.getJesasBread();

    public void gameStart() {

        collectPlayerInfo();
        createPlayerStatus();
        showPlayerInfo();
        setGameDifficulty();
        showBackgroundStory();
        initialHP_MANA();
    }

    /*-------------------------instantiate player information collector-------------------------------------------------*/
    public void collectPlayerInfo() {

        // Require player input name and gender
        System.out.println("Welcome to Hello World Game, please create your game character.");
        System.out.println("Enter Player First Name: ");
        Console con = System.console();
        Scanner in = new Scanner(con.reader());
        String heroFirstName = in.nextLine();
        hero.setHeroFirstName(heroFirstName);
        System.out.println("Enter Player Last Name: ");
        String heroLastName = in.nextLine();
        hero.setHeroLastName(heroLastName);
        System.out.println("Choose Player Gender: 1.Male 2.Neutral 3.Female");
        int input = in.nextInt();
        String gender = hero.gender(input);
        hero.setGender(gender);

    }

    /*--------------------instantiate creating player status method-(USE SUB SUPPORT METHOD 1,2,3,4)--------------------*/
    public void createPlayerStatus() {
        // Choose The Way of Creating Player HP & MANA
        System.out.println("Whitch method do you want to use to create hero HP and MANA?");
        System.out.println("1. By answering questions  2. By throwing dice");
        Console con = System.console();
        Scanner in = new Scanner(con.reader());
        int inputChooseCreate = in.nextInt();
        switch (inputChooseCreate) {
            case 1:
                askQuestion1();
                askQuestion2();
                break;

            case 2:
                betOnHP();
                betOnMANA();
                break;
            default:
                System.out.println(
                        "As you didn't choose the option, I will set your player by default 25 HP and 25 MANA...(Keisho)");
                hero.setPlayerHP(25);
                hero.setPlayerMANA(25);
                break;
        }
    }

    /*-----------------------------instantiate player information printer------------------------------------------ */
    public void showPlayerInfo() {
        System.out.println("Hero First Name: " + hero.getHeroFirstName());
        System.out.println("Hero Last Name: " + hero.getHeroLastName());
        System.out.println("Hero Gender: " + hero.getGender());
        System.out.println("Hero Current HP: " + hero.getPlayerHP());
        System.out.println("Hero Current MANA: " + hero.getPlayerMANA());

    }

    /*--------instantiate Game difficulity setting method-(USE SUB SUPPORT METHOD 5,6)-------------------------------------- */
    public void setGameDifficulty() {
        chooseDifficultyOptions();
        enemy.setMonsterHP(shiftDifficultyLV());
        enemy.setBossHP(10 * enemy.getMonsterHP());
        System.out.println("Monster HP: " + enemy.getMonsterHP());
        System.out.println("Boss HP: " + enemy.getBossHP());

    }

    /*--------- instantiate Game Background Story method--(USE SUB SUPPORT METHOD 7) ------------------------------------------------------------------------------------------------------------*/

    public void showBackgroundStory() {
        String s0 = "**ANNOUNCEMENT: The characters in this story are purely fictitious. The author respects God and religion and refers to Bible stories. (Press Enter key to continue...)**";
        String s1 = "*****Adventure start *****";
        String s2 = "Once upon a time, a hero was summoned to another world called 'Hello World' by Jesas.";
        String s3 = "There is a country named ChessBoard, where people lived a happy life.";
        String s4 = "But one day, a dragon called Satan ruined this country and killed the King and Queen.";
        String s5 = "Jesas: As the most just and strongest knight I summoned you to this ChessBoard to fight with Satan.";
        String s6 = hero.getHeroFirstName()
                + ": My Jesus, you are so powerful that you can beat the dragon! Why chose me?";
        String s7 = "Jesas: I am busy! I am playing Chess with Sanan now, this is the reason I summoned you to my Chess Board!";
        String s8 = hero.getHeroFirstName() + ": ..........!!! My God!!! How can I beat a dragon?";
        String s9 = "Jesas: Don't worry, find pieces of my bread and drops of my tears on ChessBoard could make you become stronger and more powerful!";
        String s10 = "Jesas: Remember, The dragon's lair is South-East END of the world (8,8),the Rest Point is your original location(1,1),\n       you are available to recover there. Hurry up!! GO, GO, GO!";
        String story[] = { s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10 };
        for (int i = 0; i < story.length; i++) {
            System.out.println(story[i]);
            pressEnterToContinue();
        }
    }

    /*--------- instantiate Game ending Story method--(USE SUB SUPPORT METHOD 7) ------------------------------------------------------------------------------------------------------------*/
    public void showEndingStory() {
        String s0 = "After an earth-shattering battle, " + hero.getHeroFirstName()
                + " fell to the ground weakly, looking up at the dawn sky. (Press Enter key to continue...)";
        String s1 = "Although the demon is dead, the terrifying roar still lingers in the ears.";
        String s2 = hero.getHeroFirstName() + ": All finished...I could finally go home...";
        String s3 = "Jesas: Well done My Kinght, " + hero.getHeroFirstName() + " " + hero.getHeroLastName()
                + ", but not now...";
        String s4 = hero.getHeroFirstName() + ": What do you mean!!! I have to stay here forever?";
        String s5 = "Jesas: You don't have to go home, but you can't stay here (smirk)";
        String s6 = hero.getHeroFirstName() + ": My Jesus, what do you want me to do for you?";
        String s7 = "Jesas: Become the dragon and I will play another round with Satan, HAHAHAHA, \n       do you know one of the game settings is the strongest hero and also the strongest boss?";
        String s8 = hero.getHeroFirstName() + ": ..........!!! My God!!! How can I become a dragon?";
        String s9 = "Jesas: Don't worry, I was just kidding. The dragon you killed was once a hero in the Hello World, but was seduced by the devil.";
        String s10 = "Jesas: Remember, Keep your heart pure and uphold justice even in the real world!\n       I am taking you home now. Hurry up!! GO, GO, GO!";
        String story[] = { s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10 };
        for (int i = 0; i < story.length; i++) {
            System.out.println(story[i]);
            pressEnterToContinue();
        }
    }

    /*-------instantiate player rest method: HP & MANA recover-(USE SUB SUPPORT METHOD 8,9) ------------------------------------------*/
    public void initialHP_MANA() {
        initialHP();
        System.out.println("Full HP recovered");
        initialMANA();
        System.out.println("Full MANA recovered");
    }

    /*--SUB SUPPORT METHOD  1-----------------instantiate qusetion 1 to determine player HP---------------------------*/
    public int askQuestion1() {

        int playerHP;
        System.out.println("How many push ups can you do?");
        Console con = System.console();
        Scanner in = new Scanner(con.reader());
        int answer = in.nextInt();
        in.close();
        if (answer >= 50) {
            playerHP = 100;
        } else {
            playerHP = 50;
        }
        System.out.println("Initial HP: " + playerHP);
        hero.setPlayerHP(playerHP);
        return playerHP;
    }

    /*--SUB SUPPORT METHOD  2-----------------instantiate qusetion 2 to determine player MANA-----------------------*/
    public int askQuestion2() {

        int playerMANA;
        System.out.println(
                "A princess is as old as the prince will be when the princess is twice as old as the prince was when the princess's age was half the sum of their present age. Now, what is the solution of the prince age divided by the princess age?");
        Console con = System.console();
        Scanner in = new Scanner(con.reader());
        double answer = in.nextDouble();
        in.close();
        if (answer == 0.75) {
            playerMANA = 100;
        } else {
            playerMANA = 50;
        }
        System.out.println("Initial MANA: " + playerMANA);
        hero.setPlayerMANA(playerMANA);
        return playerMANA;
    }

    /*--SUB SUPPORT METHOD   3-----------------instantiate bet on HP method----------------------------------------*/
    public int betOnHP() {
        String inputBetHP = null;
        int playerHP;
        Random random = new Random();
        do {
            playerHP = random.nextInt(2, 11) * 10;
            System.out.println("Hero have " + playerHP + "HP");
            System.out.println("Are you ready for hero HP? Y/N");
            Console con = System.console();
            Scanner in = new Scanner(con.reader());
            inputBetHP = in.nextLine().toUpperCase();

        } while (inputBetHP.equals("N"));

        System.out.println("Initial HP: " + playerHP);
        hero.setPlayerHP(playerHP);
        return playerHP;

    }

    /*--SUB SUPPORT METHOD   4-----------------instantiate bet on MANA method-----------------------------------------*/
    public int betOnMANA() {
        String inputBetMANA = null;
        int playerMANA;
        Random random = new Random();
        do {
            playerMANA = random.nextInt(2, 11) * 10;
            System.out.println("Hero have " + playerMANA + "MANA");
            System.out.println("Are you ready for hero MANA? Y/N");
            Console con = System.console();
            Scanner in = new Scanner(con.reader());
            inputBetMANA = in.nextLine().toUpperCase();

        } while (inputBetMANA.equals("N"));

        System.out.println("Initial MANA: " + playerMANA);
        hero.setPlayerMANA(playerMANA);
        return playerMANA;

    }

    /*--SUB SUPPORT METHOD   5-----------------instantiate difficulty options method---------------------------------------*/
    public void chooseDifficultyOptions() {

        if (hero.getPlayerHP() >= 80 && hero.getPlayerMANA() >= 80) {
            System.out.println("You are strong enough to choose 3 game difficulty level: 1.EASY 2.NORMAL 3.HARD");
        } else if (hero.getPlayerHP() < 50 || hero.getPlayerMANA() < 50) {
            System.out.println("You are so weak! But...take it easy! You can choose 1 difficulty level: 1.EASY");
        } else {
            System.out.println("You are a good player can choose 2 game difficulty level: 1.EASY 2.NORMAL");
        }

    }

    /*--SUB SUPPORT METHOD   6-----------------instantiate shift difficulty lv to change enemy HP------------------------*/
    public int shiftDifficultyLV() {
        Console con = System.console();
        Scanner in = new Scanner(con.reader());
        int option = in.nextInt();
        int monsterHP;
        switch (option) {
            case 1:
                monsterHP = 25;
                break;
            case 2:
                monsterHP = 50;
                break;
            case 3:
                monsterHP = 75;
                break;
            default:
                monsterHP = 25;
                break;
        }
        in.close();
        return monsterHP;
    }

    /*--SUB SUPPORT METHOD   7-----------------instantiate press Enter to continue method ---------------------------------------------*/
    public void pressEnterToContinue() {
        Console console = System.console();
        System.out.println("...");
        try {
            console.readLine();
            ;
        } catch (Exception e) {
        }
    }

    /*--SUB SUPPORT METHOD   8-----------------instantiate player initial HP method------------------------------*/
    public int initialHP() {
        pHP = hero.getPlayerHP();
        return pHP;
    }

    /*--SUB SUPPORT METHOD   9-----------------instantiate player initial MANA method-------------------------- */
    public int initialMANA() {
        pMANA = hero.getPlayerMANA();
        return pMANA;
    }

}
