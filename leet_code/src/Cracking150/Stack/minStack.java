package Cracking150.Stack;

import java.util.Stack;

public class minStack {
    private Stack<Integer> values;
    private Stack<Integer> minValues;

    public minStack() {
        values = new Stack<>();
        minValues = new Stack<>();
    }
    
    public void push(int val) {
        values.push(val);   
        if (minValues.isEmpty() || val <= minValues.peek().intValue()) {
            minValues.push(val);
        }
    }
    
    public void pop() {
        //Be careful about the type of the values in the stack when comparing
        if (values.peek().intValue() == minValues.peek().intValue()) {
            minValues.pop();
        }
        values.pop();
    }
    
    public int top() {
        return values.peek().intValue();
    }
    
    public int getMin() {
        return minValues.peek().intValue();
    }
}
