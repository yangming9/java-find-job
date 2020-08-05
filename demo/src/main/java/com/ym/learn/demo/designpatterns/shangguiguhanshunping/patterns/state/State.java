package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.state;

/**
 * 状态抽象类
 */
public abstract class State {
    /**扣除积分 -50*/
    abstract void deductMoney();
    /**是否抽中奖品*/
    abstract boolean raffle();
    /**发放奖品*/
    abstract void dispensePrize();
}
