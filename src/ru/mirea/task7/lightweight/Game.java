package ru.mirea.task7.lightweight;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private  List<Enemy> enemies = new ArrayList<>();
    public Game() {
        enemies.add(EnemyFactory.getEnemy("Archer"));
        enemies.add(EnemyFactory.getEnemy("Archer"));
        enemies.add(EnemyFactory.getEnemy("Archer"));
        enemies.add(EnemyFactory.getEnemy("Archer"));
        enemies.add(EnemyFactory.getEnemy("Archer"));
        enemies.add(EnemyFactory.getEnemy("Archer"));

        enemies.add(EnemyFactory.getEnemy("Warrior"));
        enemies.add(EnemyFactory.getEnemy("Warrior"));
        enemies.add(EnemyFactory.getEnemy("Warrior"));
        enemies.add(EnemyFactory.getEnemy("Warrior"));
        enemies.add(EnemyFactory.getEnemy("Warrior"));
        enemies.add(EnemyFactory.getEnemy("Warrior"));

        enemies.add(EnemyFactory.getEnemy("Defender"));
        enemies.add(EnemyFactory.getEnemy("Defender"));
        enemies.add(EnemyFactory.getEnemy("Defender"));
        enemies.add(EnemyFactory.getEnemy("Defender"));
        enemies.add(EnemyFactory.getEnemy("Defender"));
        enemies.add(EnemyFactory.getEnemy("Defender"));


    }

    public static void main(String[] args) {
        new Game();
    }
}
