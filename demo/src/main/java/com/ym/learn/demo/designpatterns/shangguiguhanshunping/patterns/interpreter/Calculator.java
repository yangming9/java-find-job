package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.interpreter;

import java.util.HashMap;
import java.util.Stack;

public class Calculator {
    //定义表达式
    private Expression expression;

    public Calculator(String expStr){
        //安排运算先后顺序
        Stack<Expression> stack = new Stack<>();
        // 表达式拆分成字符数组
        char[] charArray = expStr.toCharArray();

        Expression left = null;
        Expression right = null;

        for (int i=0;i<charArray.length;i++){
            switch (charArray[i]){
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left,right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left,right));
                    break;
                    default:
                        stack.push(new VarExpression(String.valueOf(charArray[i])));
                        break;
            }
        }
        this.expression = stack.pop();
    }

    public int run(HashMap<String,Integer> var){
        return this.expression.interpreter(var);
    }
}
