import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        try {
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            String[] array = stdin.readLine().trim().split(",");
            int[] nums = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                nums[i] = Integer.parseInt(array[i]);
            }
            int target = Integer.parseInt(stdin.readLine());

            System.out.print(AmountOfCombination(nums, target));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int AmountOfCombination(int[] nums, int target) {
        // 请在这里实现算法并返回结果
        int amount = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int right = n - 1, left = 0;
        int tempSum = 0;
        while (right >= left) {
            tempSum += nums[right];
            if (tempSum == target) {
                amount++;
                right--;
                System.out.println("B1");
                System.out.println("tempSum = " + tempSum);
                System.out.println("amount = " + amount);
                tempSum = 0;
            } else if (tempSum > target) {
                tempSum -= nums[right];
                System.out.println("B2");
                System.out.println("tempSum = " + tempSum);
                right--;

            } else if (tempSum < target) {
                tempSum += nums[left];
                System.out.println("B3");
                System.out.println("tempSum = " + tempSum);
                left++;
            }
        }
        return amount;
    }
}