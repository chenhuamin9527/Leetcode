class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> stk1;
    stack<int> min_stk;
    MinStack() {
        
    }
    
    void push(int x) {
       stk1.push(x);
       if(min_stk.empty())
       {
           min_stk.push(x);
       } 
       else if(min_stk.top() >= x)
       {
           min_stk.push(x);
       }
    }
    
    void pop() {
        if(stk1.top() == min_stk.top())
        {
            min_stk.pop();
        }
        stk1.pop();
    }
    
    int top() {
        return stk1.top();
    }
    
    int min() {
        return min_stk.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->min();
 */