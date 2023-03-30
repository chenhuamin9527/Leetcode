class TripleInOne {
    private int stackSize;
    private int[] arr;
    private int[] top;

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[stackSize * 3];
        top = new int[3];
        for (int i = 0; i < 3; i++) {
            top[i] = -1;
        }
    }

    public void push(int stackNum, int value) {
        int position = stackNum * stackSize + top[stackNum] + 1;
        if (top[stackNum] + 1 < stackSize) {
            arr[position] = value;
            top[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum))
            return -1;
        else {
            int position = stackNum * stackSize + top[stackNum];
            int temp = arr[position];
            top[stackNum]--;
            return temp;
        }
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum))
            return -1;
        else {
            int position = stackNum * stackSize + top[stackNum];
            int temp = arr[position];
            return temp;
        }
    }

    public boolean isEmpty(int stackNum) {
        return top[stackNum] == -1;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */