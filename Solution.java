class Solution {
    public static int[] mergeSortedArrays(int[] arrayA, int[] arrayB) {
        int aLength = arrayA.length;
        int bLength = arrayB.length;

        // 新数组长度等于原数组长度之和
        int[] mergedArray = new int[aLength + bLength];

        int i = 0, j = 0, k = 0;
        // 将arrayA和arrayB中的元素按顺序拷贝到mergedArray中
        while (i < aLength && j < bLength) {
            if (arrayA[i] < arrayB[j]) {
                mergedArray[k++] = arrayA[i++];
            } else {
                mergedArray[k++] = arrayB[j++];
            }
        }

        // 将剩余未拷贝的元素添加到mergedArray中
        while (i < aLength) {
            mergedArray[k++] = arrayA[i++];
        }
        while (j < bLength) {
            mergedArray[k++] = arrayB[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arrayA = { 1, 3, 4, 12, 55, 56, 71, 81 };
        int[] arrayB = { 2, 12, 13, 19, 32, 55, 57, 100 };

        int[] mergedArray = mergeSortedArrays(arrayA, arrayB);

        for (int i = 0; i < mergedArray.length; i++) {
            System.out.print(mergedArray[i] + " ");
        }
    }
}