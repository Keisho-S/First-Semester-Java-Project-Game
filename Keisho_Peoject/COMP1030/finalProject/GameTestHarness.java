package COMP1030.finalProject;

/**
 * Application Purpose: Final Project --RPG Game
 * Author: Keisho Seiho 200553984
 * 
 * Structure: I am not allowed to write more than 7 rows in main method.
 * Date: 2023-6-27~30
 */
public class GameTestHarness {
    public static void main(String[] args) {

        StructureObj.st.gameStart();
        System.out.println("Player HP: " + StructureObj.st.hero.getPlayerHP());
        System.out.println("Player MANA: " + StructureObj.st.hero.getPlayerMANA());
        // Create new map object, player initial location is (1,1)
        MapObj map = new MapObj();
        map.walkAroundTheMap();

    }
}
