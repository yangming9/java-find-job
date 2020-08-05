package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.state;

import java.util.Random;

public class CanRafflleState extends State{

    RaffleActivity activity;

    public CanRafflleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    void deductMoney() {
        System.out.println("已经扣除过积分了");
    }

    @Override
    boolean raffle() {
        System.out.println("正在抽奖，请稍等！");
        Random r = new Random();
        int num = r.nextInt(10);
        // 10%中奖机会
        if (num == 0){
            activity.setState(activity.getDispenseState());
            return true;
        }else {
            System.out.println("很遗憾没有抽中奖品！");
            activity.setState(activity.getNoRafflleState());
            return false;
        }
    }

    @Override
    void dispensePrize() {
        System.out.println("没有中奖，不能发放奖品！");
    }
}
