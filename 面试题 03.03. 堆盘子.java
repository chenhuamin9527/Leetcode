class StackOfPlates {
    List<LinkedList> stacks;
    int max_Num = 0;

    public StackOfPlates(int cap) {
        // 1. 初始化以LinkedList为元素的List集合
        stacks = new ArrayList<LinkedList>();
        // 2. 保存每个LinkedList最多存多少个数据
        max_Num = cap;
    }

    public void push(int val) {
        if (max_Num == 0)
            return;
        // 1. 入栈时，List集合为空，则新建栈加入集合
        if (stacks.size() == 0) {
            LinkedList<Integer> ls = new LinkedList<Integer>();
            stacks.add(ls);
        }
        // 2. 获得当前操作的栈cur_Stack，如果cur_Stack已满，新建栈加入List集合，重新获取cur_Stack;
        LinkedList<Integer> cur_Stack = stacks.get(stacks.size() - 1);
        if (cur_Stack.size() >= max_Num) {
            LinkedList<Integer> ls = new LinkedList<Integer>();
            stacks.add(ls);
        }
        cur_Stack = stacks.get(stacks.size() - 1);
        // 3. 元素入栈
        cur_Stack.add(val);
    }

    public int pop() {
        // 1. 集合为空 或者 每个栈最多保存的元素数量为0 返回-1
        if (stacks.size() == 0 || max_Num == 0) {
            return -1;
        }
        // 2. 当前栈元素数量为零，则在集合中删除当前栈，再判断 集合是否为空，为空返回-1，不为空则获取当前操作栈
        LinkedList<Integer> cur_Stack = stacks.get(stacks.size() - 1);
        if (cur_Stack.size() == 0) {
            stacks.remove(stacks.size() - 1);
            if (stacks.size() == 0)
                return -1;
            cur_Stack = stacks.get(stacks.size() - 1);
        }
        // 3. 出栈
        int result = cur_Stack.removeLast();
        // 4. 判断进行出栈操作后的当前栈是否为空，为空则删除当前栈
        if (cur_Stack.size() == 0)
            stacks.remove(stacks.size() - 1);
        // 5. 返回出栈元素
        return result;
    }

    public int popAt(int index) {
        // 1. 当 集合为空 || 每个栈最多保存的元素数量为0 || index <0 || index >=集合中栈的数量，返回-1
        if (max_Num == 0 || stacks.size() == 0 || index >= stacks.size() || index < 0)
            return -1;
        // 2. 获得索引位置的操作栈，如果栈元素数量==0，删除栈，返回-1
        LinkedList<Integer> cur_Stack = stacks.get(index);
        int result = -1;
        if (cur_Stack.size() == 0) {
            stacks.remove(index);
            return result;
        } else {
            // 3. 否则进行出栈，再判断进行出栈操作后的当前栈是否为空，为空则删除当前栈
            result = cur_Stack.removeLast();
            if (cur_Stack.size() == 0)
                stacks.remove(index);
        }
        // 4. 返回出栈元素
        return result;
    }
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */