package com.gb.postupaylo.quarter.two.homework1.participants;

public class Human implements Participant {
    private final String name;
    private final int runLimitation;
    private final int jumpLimitation;

    public Human(String name, int runLimitation, int jumpLimitation){
        this.name = name;
        this.runLimitation = runLimitation;
        this.jumpLimitation = jumpLimitation;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public boolean run(int distance) {
        if (distance < runLimitation) {
            System.out.println(String.format("%s run %s", name, distance));
            return true;
        }

        System.out.println(String.format("Impossible to run %s for %s", distance, name));
        return false;
    }

    @Override
    public boolean jump(int height) {
        if (height < jumpLimitation) {
            System.out.println(String.format("%s jumped %s", name, height));
            return true;
        }

        System.out.println(String.format("Impossible to jump %s for %s", height, name));
        return false;
    }

    @Override
    public String toString(){
        return "Human: " +
                " name:" + name +
                " runLimit: " + runLimitation +
                " jumpLimit: " + jumpLimitation;
    }
}
