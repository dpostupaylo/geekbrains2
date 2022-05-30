package com.gb.postupaylo.quarter.two.homework1.obstacles;

import com.gb.postupaylo.quarter.two.homework1.participants.Participant;

public interface Obstacle {
    boolean overcome(Participant participant);
    String getName();
}
