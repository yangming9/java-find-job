package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.state;

/**
 * 不能抽奖状态
 */
public class NoRafflleState extends State {
    RaffleActivity activity;

    public NoRafflleState(RaffleActivity activity) {
        this.activity = activity;
    }

    /**
     * 当前状态可以扣除积分，扣除后将状态设置成可以抽奖的状态
     */
    @Override
    void deductMoney() {
        System.out.println("扣除积分成功，您可以抽奖了");
        activity.setState(activity.getCanRafflleState());
    }

    /**
     * 当前状态不能抽奖
     */
    @Override
    boolean raffle() {
        System.out.println("扣除了积分后才可以抽奖！");
        return false;
    }

    /**
     * 当前状态不能发放奖品
     */
    @Override
    void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
