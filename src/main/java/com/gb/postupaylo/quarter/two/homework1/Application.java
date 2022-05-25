package com.gb.postupaylo.quarter.two.homework1;

import com.gb.postupaylo.quarter.two.homework1.obstacles.Obstacle;
import com.gb.postupaylo.quarter.two.homework1.obstacles.Treadmill;
import com.gb.postupaylo.quarter.two.homework1.obstacles.Wall;
import com.gb.postupaylo.quarter.two.homework1.participants.Cat;
import com.gb.postupaylo.quarter.two.homework1.participants.Human;
import com.gb.postupaylo.quarter.two.homework1.participants.Participant;
import com.gb.postupaylo.quarter.two.homework1.participants.Robot;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        String[] catNames = new String[]{"Tom", "Joy", "Sam", "Son", "Moh"};
        String[] humanNames = new String[]{"Ivan", "Petr", "Andrey", "Dmitry", "Sergey"};
        String[] robotNames = new String[]{"R2D2", "C-3PO", "BB-8", "T3-M4", "B1"};
        Random rnd = new Random();


        Participant[] participants = new Participant[15];
        Obstacle[] obstacles = new Obstacle[]{
                new Wall(rnd.nextInt(100)),
                new Treadmill(rnd.nextInt(100)),
                new Wall(rnd.nextInt(100)),
                new Treadmill(rnd.nextInt(100)),
                new Wall(rnd.nextInt(100)),
                new Treadmill(rnd.nextInt(100))};

        for (int i = 0; i < 5; i++) {
            Cat cat = new Cat(catNames[i], rnd.nextInt(100), rnd.nextInt(100));
            Human human = new Human(humanNames[i], rnd.nextInt(100), rnd.nextInt(100));
            Robot robot = new Robot(robotNames[i], rnd.nextInt(100), rnd.nextInt(100));

            participants[i * 3] = cat;
            participants[i * 3 + 1] = human;
            participants[i * 3 + 2] = robot;
        }

        for (Participant participant : participants) {

            System.out.println(participant.toString());
            for (Obstacle obstacle : obstacles) {
                if (obstacle.overcome(participant)) {
                    System.out.println(String.format("%s could overcome %s. ", participant.getName(), obstacle.getName()));
                } else {
                    System.out.println(String.format("%s couldn't overcome %s. ", participant.getName(), obstacle.getName()));
                    break;
                }
            }
        }

        System.out.println();
    }
}
