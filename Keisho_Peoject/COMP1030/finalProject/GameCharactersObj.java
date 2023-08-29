package COMP1030.finalProject;

/**
 * Application Purpose: Final Project --RPG Game
 * Author: Keisho Seiho 200553984
 * 
 * Structure: simple settings for characters
 * 
 * Date: 2023-6-27~30
 */
public class GameCharactersObj {

    private String heroFirstName;
    private String heroLastName;
    private String gender;// gender is used for boss event
    private int playerHP;
    private int playerMANA;
    private double jesasBread = 0.0;// bread is uncountable nouns so use double type (for English grammatical
                                    // meaning)
    private double jesasTear = 0.0;
    private int monsterHP;
    private int bossHP;

    // Create gender method
    public String gender(int input) {

        String gender = "";
        switch (input) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Neutral";
                break;
            case 3:
                gender = "Female";
                break;
        }
        return gender;
    }

    /*---------------------------------------------------Create constructor for enemy------------------------------- */
    public GameCharactersObj(int monsterHP, int bossHP) {
        this.monsterHP = monsterHP;
        this.bossHP = bossHP;
    }

    /*---------------------------------------------------Create constructor for player------------------------------- */
    public GameCharactersObj(String heroFirstName, String heroLastName, String gender, int playerHP, int playerMANA,
            double jesasBread, double jesasTear) {
        this.heroFirstName = heroFirstName;
        this.heroLastName = heroLastName;
        this.gender = gender;
        this.playerHP = playerHP;
        this.playerMANA = playerMANA;
        this.jesasBread = jesasBread;
        this.jesasTear = jesasTear;
    }

    /*-----------------------------------Create setters and getters------------------------------------- */
    public String getHeroFirstName() {
        return heroFirstName;
    }

    public void setHeroFirstName(String heroFirstName) {
        this.heroFirstName = heroFirstName;
    }

    public String getHeroLastName() {
        return heroLastName;
    }

    public void setHeroLastName(String heroLastName) {
        this.heroLastName = heroLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public int getPlayerMANA() {
        return playerMANA;
    }

    public void setPlayerMANA(int playerMANA) {
        this.playerMANA = playerMANA;
    }

    public double getJesasBread() {
        return jesasBread;
    }

    public void setJesasBread(double jesasBread) {
        this.jesasBread = jesasBread;
    }

    public double getJesasTear() {
        return jesasTear;
    }

    public void setJesasTear(double jesasTear) {
        this.jesasTear = jesasTear;
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public void setMonsterHP(int monsterHP) {
        this.monsterHP = monsterHP;
    }

    public int getBossHP() {
        return bossHP;
    }

    public void setBossHP(int bossHP) {
        this.bossHP = bossHP;
    }
    /*--------------------------------------------------------------------------------------------- */
}
