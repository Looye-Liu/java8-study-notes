package main.java.com.looye.stream.test;

import main.java.com.looye.stream.bean.Trader;
import main.java.com.looye.stream.bean.Transaction;

import java.util.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by looye on 2018/1/13.
 *
 * @author looye
 * @date 2018/1/13
 */
public class StreamApp2 {
    public static void main(String[] args) {
        List<Transaction> transactions = genTrans();
        List<Transaction> findTranIn2017 = findTranIn2017(transactions);
        findTranIn2017.forEach(System.out::println);
        System.out.println("---------------");
        List<String> city = findCity(transactions);
        city.forEach(System.out::println);
        System.out.println("---------------");
        Set<String> city2 = findCity2(transactions);
        city2.forEach(System.out::println);
        System.out.println("---------------");

        List<Trader> traderInSH = findTraderInSH(transactions);
        traderInSH.forEach(System.out::println);
        System.out.println("---------");

        String name = findName(transactions);
        String name2 = findName2(transactions);
        System.out.println(name + "---" + name2);

        boolean workInJvm = findTraderInJvm(transactions);
        System.out.println(workInJvm);
        System.out.println("--------");
        printTradMoney(transactions);
        System.out.println("--------");

        int max = findMaxValue(transactions);
        int max2 = findMaxValue2(transactions);
        System.out.println(max + "-" + max2);

        Transaction minTran = findMinTran(transactions);
        Transaction minTran2 = findMinTran2(transactions);
        System.out.println(minTran + "--" + minTran2);
    }

    /**
     * 找出2017年的所有交易并按交易额排序
     *
     * @return
     */
    private static List<Transaction> findTranIn2017(List<Transaction> param) {
        return param.stream()
                .filter(tran -> 2017 == tran.getYear())
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());
    }

    /**
     * 交易员都在哪些不同的城市工作过
     *
     * @return
     */
    private static List<String> findCity(List<Transaction> param) {
        return param.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
    }

    private static Set<String> findCity2(List<Transaction> param) {
        return param.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());
    }

    /**
     * 查找所有来自上海的交易员并按名称排序
     *
     * @return
     */
    private static List<Trader> findTraderInSH(List<Transaction> param) {
        return param.stream()
                .filter(transaction -> "ShangHai".equals(transaction.getTrader().getCity()))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());
    }

    /**
     * 返回所有交易员的姓名字符串，按字母顺序排序
     *
     * @return
     */
    private static String findName(List<Transaction> param) {
        return param.stream().
                map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b);
    }

    private static String findName2(List<Transaction> param) {
        return param.stream().
                map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());
    }

    /**
     * 有没有交易员在JVM工作的
     *
     * @return
     */
    private static boolean findTraderInJvm(List<Transaction> param) {
        return param.stream().anyMatch(transaction -> "JVM".equals(transaction.getTrader().getCity()));
    }

    /**
     * 打印生活在上海的交易员的所有交易额
     *
     * @return
     */
    private static void printTradMoney(List<Transaction> param) {
        param.stream()
                .filter(transaction -> "ShangHai".equals(transaction.getTrader().getCity()))
                .map(transaction -> transaction.getValue())
                .forEach(System.out::println);
    }

    /**
     * 所有交易额中的最高交易额
     *
     * @return
     */
    private static int findMaxValue(List<Transaction> param) {
        return param.stream()
                .max(Comparator.comparing(Transaction::getValue))
                .map(Transaction::getValue)
                .orElse(0);
    }

    private static int findMaxValue2(List<Transaction> param) {
        return param.stream()
                .map(transaction -> transaction.getValue())
                .reduce(0, Integer::max);
    }

    /**
     * 找到交易额最小的交易
     *
     * @return
     */
    private static Transaction findMinTran(List<Transaction> param) {
        return param.stream()
                .reduce(null, (t1, t2) -> (t1 != null && t1.getValue() < t2.getValue()) ? t1 : t2);
    }

    private static Transaction findMinTran2(List<Transaction> param) {
        return param.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .orElse(null);
    }

    private static List<Transaction> genTrans() {
        Trader trader1 = new Trader("Looye", "ShangHai");
        Trader trader2 = new Trader("Joon", "BeiJing");
        Trader trader3 = new Trader("Frank", "HangKong");
        Trader trader4 = new Trader("TomCat", "JVM");
        Trader trader5 = new Trader("Haweye", "JVM");
        Trader trader6 = new Trader("Sally", "ShangHai");

        return Arrays.asList(
                new Transaction(trader1, 2017, 200000),
                new Transaction(trader1, 2018, 500000),

                new Transaction(trader2, 2017, 200),
                new Transaction(trader2, 2018, 4556),

                new Transaction(trader3, 2017, 3444),
                new Transaction(trader3, 2018, 22224),

                new Transaction(trader4, 2017, 1245),
                new Transaction(trader4, 2018, 55332),

                new Transaction(trader5, 2017, 23555),
                new Transaction(trader5, 2018, 23444),

                new Transaction(trader6, 2017, 11333),
                new Transaction(trader6, 2018, 1445));
    }
}
