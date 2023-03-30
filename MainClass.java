
class TripleInOne {
    private int stackSize;
    private int[] arr;
    private int[] top = new int[3];

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[stackSize * 3];
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
        if (top[stackNum] == -1)
            return -1;
        else {
            int position = stackNum * stackSize + top[stackNum] + 1;
            System.out.println("position = " + position);
            int temp = arr[position];
            top[stackNum]--;
            return temp;
        }
    }

    public int peek(int stackNum) {
        if (top[stackNum] == -1)
            return -1;
        else {
            int position = stackNum * stackSize + top[stackNum] + 1;
            int temp = arr[position];
            return temp;
        }
    }

    public boolean isEmpty(int stackNum) {
        return (top[0] == -1 && top[1] == -1 && top[2] == -1);
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