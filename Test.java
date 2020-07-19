import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public int calculateMax(int[] prices) {

        // 风口之下，猪都能飞。
        // 当今中国股市牛市，真可谓 “错过等七年”。
        // 给你一个回顾历史的机会，已知一支股票连续 n 天的价格走势
        // 以长度为 n 的整数数组表示，数组中第 i 个元素（prices[i]）代表该股票第 i 天的股价。
        // 假设你一开始没有股票，但有至多两次买入 1 股而后卖出 1 股的机会，并且买入前一定要先保证手上没有股票。
        // 若两次交易机会都放弃，收益为 0。
        // 设计算法，计算你能获得的最大收益。
        // 输入数值范围：2 <= n <= 100,0 <= prices[i] <= 100

        // 示例:
        // 输入
        // 3, 8, 5, 1, 7, 8
        // 输出
        // 12

        int firstBuy = Integer.MAX_VALUE; // 32767
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE; // -32768
        int secondSell = 0;
        for (int cur : prices) {
            // 第一次买入最小的股 = firstBuy
            firstBuy = Math.min(firstBuy, cur);
            // 第一次卖出所得最大的利润 = firstSell
            firstSell = Math.max(firstSell, cur - firstBuy);
            // 第二次买入的利润 = 第一次所得利润 - 第二次买入开销
            secondBuy = Math.max(secondBuy, firstSell - cur);
            // 总共最大利润 = 买入利润 + 第二次卖出利润
            secondSell = Math.max(secondSell, secondBuy + cur);
        }
        return secondSell;
    }
}

class Main {
    public static void main1(String[] args) {

        // 输入一行字符串，计算其中 A - Z 大写字母出现的次数

        // 输入描述:
        // 案例可能有多组，每个案例输入为一行字符串。
        // 输出描述:
        // 对每个案例按 A - Z 的顺序输出其中大写字母出现的次数。

        // 示例:
        // 输入
        // DFJEIWFNQLEF0395823048+_+JDLSFJDLSJFKK
        // 输出
        // A:0
        // B:0
        // C:0
        // D:3
        // E:2
        // F:5
        // G:0
        // H:0
        // I:1
        // J:4
        // K:2
        // L:3
        // M:0
        // N:1
        // O:0
        // P:0
        // Q:1
        // R:0
        // S:2
        // T:0
        // U:0
        // V:0
        // W:1
        // X:0
        // Y:0
        // Z:0

        Scanner in = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        while (in.hasNext()) {
            String strs = in.next();
            char[] str = strs.toCharArray();
            for (char i = 'A' ; i >= 'A' && i <= 'Z'; i++) {
                map.put(i, 0);
            }
            for (int i = 0; i < str.length; i++) {
                if (str[i] >= 'A' && str[i] <= 'Z') {
                    map.put(str[i], map.get(str[i]) + 1);
                }
            }
            for (Character m : map.keySet()) {
                System.out.println(m + ":" + map.get(m));
                // 没有空格
            }
        }
    }


    public static void main2(String[] args) {

        // 写出一个程序，接受一个十六进制的数值字符串
        // 输出该数值的十进制字符串(注意可能存在的一个测试用例里的多组数据)。

        // 输入描述:
        // 输入一个十六进制的数值字符串。
        // 输出描述:
        // 输出该数值的十进制字符串。

        // 示例:
        // 输入
        // 0xA
        // 输出
        // 10
        
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String strs = in.next();
            int str = Integer.parseInt(strs.substring(2), 16);
            // substring(int beginIndex):
            // 返回一个字符串，该字符串是此字符串的子字符串
            // 从第三位开始（前两位是 0x, 不译）
            // parseInt(String s, int radix):
            // 将字符串参数解析为第二个参数指定的基数(16)中的有符号整数。
            System.out.println(str);
        }
    }
}