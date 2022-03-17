package ru.mirea.task7.lightweight;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EnemyFactory {
    private static  Map<String, EnemyType> enemyTypes = new HashMap<>();
    private static Random random = new SecureRandom();

    private static EnemyType getEnemyType(String type) {

        EnemyType enemyType = enemyTypes.get(type);

        if (enemyType == null) {
            System.out.println("Create new "+ type + " type");
            switch (type) {
                case "Archer": {

                    enemyType = new EnemyType(Skin.Archer, 40, 10);
                    break;
                }
                case "Warrior": {
                    enemyType = new EnemyType(Skin.Warrior, 25, 15);
                    break;
                }
                case "Defender": {
                    enemyType = new EnemyType(Skin.Defender, 50, 5);
                    break;
                }
                default:
                    break;
            }
            enemyTypes.put(type, enemyType);
        }

        return enemyType;
    }

    public static Enemy getEnemy(String type) {
        EnemyType enemyType = getEnemyType(type);
        int x = random.nextInt(50);
        int y = random.nextInt(50);

        return new Enemy(x, y, enemyType);
    }
}
