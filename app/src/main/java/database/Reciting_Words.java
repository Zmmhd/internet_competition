package database;

// 主要用于设计背单词挖矿相关方法与数据的管理

import java.util.Random;

public class Reciting_Words{
    //  存放单词的数组列表，后续数据结构会改变，存取方式待实现
    static String[][] words_array ={{"able","能够"},{"bubble","气泡"},{"colorful","丰富的"},{"define","定义"},
            {"effect","影响"},{"filter","滤波器"},{"genius","天才"},{"Hitler","希特勒"},{"infinite","无限"},
            {"jungle","丛林"},{"knock","敲打"},{"lonely","孤独"},{"mon","月亮"},{"option","选项"},{"none","没有一个人"}};

    // 记录当前时间权重

    public String[][] getRandomWords(){
        Random r = new Random();
        //  正确单词
        String[] target = words_array[r.nextInt(words_array.length)];
        //  干扰选项
        String[] JammingOptions = {words_array[r.nextInt((int)(words_array.length/3))][1],
                words_array[r.nextInt((int)(words_array.length/3*2))+(int)(words_array.length/3)][1],
                words_array[r.nextInt((int)(words_array.length))+(int)(words_array.length/3*2)][1]};
        String[][] src = {target,JammingOptions};
        return src;
    }

}
