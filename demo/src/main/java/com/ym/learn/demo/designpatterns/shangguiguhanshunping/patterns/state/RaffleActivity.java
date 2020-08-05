package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.state;

public class RaffleActivity {

    //表示活动当前的状态 是变化的
    State state = null;
    //奖品数量
    int count = 0;

    //四种属性 表示四种状态
    State noRafflleState = new NoRafflleState(this);

    State canRafflleState = new CanRafflleState(this);

    State dispenseState = new DispenseState(this);

    State dispenseOutState = new DispenseOutState(this);

    public RaffleActivity(int count) {
        this.state = getNoRafflleState();
        this.count = count;
    }

    public void deductMoney(){
        state.deductMoney();
    }

    public void raffle(){
        if (state.raffle()){
            state.dispensePrize();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getNoRafflleState() {
        return noRafflleState;
    }

    public void setNoRafflleState(State noRafflleState) {
        this.noRafflleState = noRafflleState;
    }

    public State getCanRafflleState() {
        return canRafflleState;
    }

    public void setCanRafflleState(State canRafflleState) {
        this.canRafflleState = canRafflleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispenseOutState() {
        return dispenseOutState;
    }

    public void setDispenseOutState(State dispenseOutState) {
        this.dispenseOutState = dispenseOutState;
    }
}
