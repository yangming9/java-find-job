package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.state;

public class DispenseState extends State {
    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    void deductMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    void dispensePrize() {
        if (activity.getCount() > 0){
            System.out.println("恭喜中奖了");
            activity.setState(activity.getNoRafflleState());
        }else {
            System.out.println("很遗憾，奖品发放完毕！");
            activity.setState(activity.getDispenseOutState());
        }
    }
}
