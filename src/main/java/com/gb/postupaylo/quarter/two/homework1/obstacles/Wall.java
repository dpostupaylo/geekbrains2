package com.gb.postupaylo.quarter.two.homework1.obstacles;

import com.gb.postupaylo.quarter.two.homework1.participants.Participant;

public class Wall implements Obstacle {
    private final String name = "wall";
    private final int height;

    public Wall(int height){
        this.height = height;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.jump(height);
    }
}
