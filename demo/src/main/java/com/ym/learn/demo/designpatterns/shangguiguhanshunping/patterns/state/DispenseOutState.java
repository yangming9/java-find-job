package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.state;

public class DispenseOutState extends State{

    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    void deductMoney() {
        System.out.println("奖品发送完毕，请下次参加");
    }

    @Override
    boolean raffle() {
        System.out.println("奖品发送完毕，请下次在参加");
        return false;
    }

    @Override
    void dispensePrize() {
        System.out.println("奖品发送完毕，请下次在参加");
    }
}
