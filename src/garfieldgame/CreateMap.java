/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package garfieldgame;

import java.util.Random;

public class CreateMap{
    private static int lowDefaultYCoordObstacle, highDefaultYCoordObstacle, midDefaultYCoordObstacle;   
    
    /**
     * Below is a number of different maps that can be created with powerbottles and obstacles at different coordinates.
     * The only relevant map is map 3. The rest is for testing purpose 
     * @param map the map to create
     * @param mapNumber a number between 1 and 5 to choose map
     */
    public static void createMap(Map map, int mapNumber) {
        lowDefaultYCoordObstacle = map.getHeight() - 100;
        highDefaultYCoordObstacle = map.getHeight() - 300;
        midDefaultYCoordObstacle = map.getHeight() - 160;
        switch (mapNumber) {
            case 1:
                createMap1(map);
                break;
            case 2:
                createMap2(map);
                break;
            case 3:
                createMap3(map);
                break;
            case 4:
                createMap4(map);
                break;
            case 5:
                createMap5(map);
                break;
            default:
                createMap3(map);
                break;
        }
    }

    
    private static Obstacle createObstacle(Map map, int xCoord) {
        Random generator = new Random();
        int height = 50 + generator.nextInt(100);
        return new Obstacle(height, 50 + generator.nextInt(100), xCoord, generator.nextInt(map.getHeight() - height));
    }

    private static Powerbottle createPowerbottle(Map map, int xCoord) {
        Random generator = new Random();
        return new Powerbottle(20, 10, xCoord, generator.nextInt(map.getHeight()));
    }

    private static void createMap1(Map map) {
        //Skapa bana 1
        for (int i = 0; i < 300; i++) {
            map.addPowerbottle(new Powerbottle(20, 10, 950 + i * 300, 300));
        }

        for (int i = 0; i < 100; i++) {
            map.addObstacle(new Obstacle(100, 100, i * 900 + 1300, lowDefaultYCoordObstacle));
        }
        for (int i = 0; i < 100; i++) {
            map.addObstacle(new Obstacle(100, 100, i * 900 + 1600, midDefaultYCoordObstacle));
        }
        for (int i = 0; i < 100; i++) {
            map.addObstacle(new Obstacle(100, 100, i * 900 + 1900, highDefaultYCoordObstacle));
        }


    }

    private static void createMap2(Map map) {
        map.addPowerbottle(new Powerbottle(20, 10, 1300, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 1500, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 1700, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 2000, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 2400, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 2700, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 2900, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 3300, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 3400, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 3700, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 4000, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 4300, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 4600, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 4900, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 5300, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 5700, 300));


        map.addObstacle(new Obstacle(100, 100, 1600, lowDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 1900, highDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 2200, lowDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 2400, midDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 2700, highDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 500, 3000, lowDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 3500, highDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 3600, midDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 3800, lowDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 4500, lowDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 4900, midDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 5300, highDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 5600, lowDefaultYCoordObstacle));
    }
    /**
     * Creates a map with powerbottles and obstacles on random places
     * @param map 
     */
    private static void createMap3(Map map) {
        for (int i = 0; i < 300; i++) {
            map.addPowerbottle(createPowerbottle(map, i * 120 + 1200));
        }
        for (int i = 0; i < 300; i++) {
            map.addObstacle(createObstacle(map, i * 170 + 1000));
        }

    }

    private static void createMap4(Map map) {
        map.addPowerbottle(new Powerbottle(20, 10, 1300, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 1500, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 1700, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 2000, 300));
        map.addPowerbottle(new Powerbottle(20, 10, 2400, 300));


        map.addObstacle(new Obstacle(100, 100, 1600, lowDefaultYCoordObstacle));
        map.addObstacle(new Obstacle(100, 100, 1900, highDefaultYCoordObstacle));
    }

    private static void createMap5(Map map) {
        for (int i = 0; i < 300; i++) {
            map.addObstacle(new Obstacle(100, 100, i * 300, highDefaultYCoordObstacle + 10));
        }
        for (int i = 0; i < 300; i++) {
            map.addPowerbottle(new Powerbottle(20, 10, i * 300, 500));
        }
    }
    
}
