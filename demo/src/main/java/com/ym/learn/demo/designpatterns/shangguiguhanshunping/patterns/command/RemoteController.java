package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.command;

public class RemoteController {
    //开 按钮命令数组
    Command[] onCommands;
    Command[] offCommands;

    //撤销的命令
    Command undoCommand;

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i=0;i<5;i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    //给按钮设置需要的命令
    public void setCommand(int no,Command onCommand,Command offCommand){
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    public void onButtonWasPushed(int no){
        //找到你按下的按钮 执行命令
        onCommands[no].execute();
        //记录这次的操作，用于撤销
        undoCommand = onCommands[no];
    }

    public void offButtonWasPushed(int no){
        //找到你按下的按钮 执行命令
        offCommands[no].execute();
        //记录这次的操作，用于撤销
        undoCommand = offCommands[no];
    }

    //按下撤销按钮
    public void undoButtonWasPushed(){
        undoCommand.undo();
    }
}
