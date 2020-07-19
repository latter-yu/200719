import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main1(String[] args) {

        // 输入一个整形数组（可能有正数和负数），求数组中连续子数组（最少有一个元素）的最大和。
        // 要求时间复杂度为O(n)。

        // 输入描述:
        //【重要】第一行为数组的长度 N（N >= 1）
        // 接下来 N 行，每行一个数，代表数组的 N 个元素
        // 输出描述:
        // 最大和的结果
        // 示例:
        // 输入
        // 8
        // 1
        // -2
        // 3
        // 10
        // -4
        // 7
        // 2
        // -5
        // 输出
        // 18
        // 说明
        // 最大子数组为 3, 10, -4, 7, 2

        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i], map.get(arr[i] + 1));
            }
            int count = 1;
            int x = 0;
            int y = 0;
            for (int m : map.keySet()) {
                int value = map.get(m);
                if (value % 2 != 0) {
                    if (count == 1) {
                        x = m;
                        count++;
                    } else {
                        y = m;
                    }
                }
            }
            if (x > y) {
                System.out.println(y);
                System.out.println(x);
            } else {
                System.out.println(x);
                System.out.println(y);
            }
        }
    }

    public static void main2(String[] args) {

        // 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
        // 例如，输入 ” They are students. ” 和 ” aeiou ”
        // 删除之后的第一个字符串变成 ” Thy r stdnts. ”

        // 输入描述:
        // 每个测试输入包含 2 个字符串
        // 输出描述:
        // 输出删除后的字符串

        // 示例:
        // 输入
        // They are students.
        // aeiou
        // 输出
        // Thy r stdnts.

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 只能 nextLine
            String strs = in.nextLine();
            String deleteStrs = in.next();
            char[] str = strs.toCharArray();
            String[] deleteStr = new String[str.length];
            for (int i = 0; i < str.length; i++) {
                if (!deleteStrs.contains(String.valueOf(str[i]))) {
                    System.out.print(str[i]);
                }
            }
        }
    }

    // sc.next() 和 nextLine 的区别:
    // next（）一定要读取到有效字符后才可以结束输入
    // 对输入有效字符之前遇到的空格键、Tab键或Enter键等结束符，next（）方法会自动将其去掉
    // 只有在输入有效字符之后，next（）方法才将其后输入的空格键、Tab键或Enter键等视为分隔符或结束符。
    // 所以next方法不能得到带空格的字符串

    // nextLine（）方法的结束符只是Enter键
    // 即nextLine（）方法返回的是Enter键之前的所有字符，它是可以得到带空格的字符串的。

    public static void main3(String[] args)  {
        // 大神版
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String pattern = "[" + s2 + "]"; // 正则表达式
            String result = s1.replaceAll(pattern, "");
            System.out.println(result);
        }
    }


    public static void main(String[] args) {

        // 将一个英文语句以单词为单位逆序排放。
        // 例如 “ I am a boy ”，逆序排放后为 “ boy a am I ”
        // 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符

        //接口说明
        //
        ///**
        // * 反转句子
        // *
        // * @param sentence 原句子
        // * @return 反转后的句子
        // */
        // public String reverse(String sentence);

        // 输入描述:
        // 将一个英文语句以单词为单位逆序排放。
        // 输出描述:
        // 得到逆序的句子

        // 示例:
        // 输入
        // I am a boy
        // 输出
        // boy a am I

        Scanner sc = new Scanner(System.in);
        // 只能 nextLine
        String strs = sc.nextLine();
        String[] str = strs.split(" ");
        for (int i = str.length - 1; i > 0; i--) {
            System.out.print(str[i] + " ");
        }
        System.out.println(str[0]);
    }

}
