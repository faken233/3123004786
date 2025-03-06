package com.faken233;

/**
 * @author faken233
 * @date 2025/3/7
 * @description
 */
public class TextProcessor {

    /**
     * 预处理文本：去除标点符号和空白字符
     */
    public static String preprocess(String text) {
        // 保留中文、字母和数字
        return text.replaceAll("[^\\u4e00-\\u9fa5a-zA-Z0-9]", "");
    }
}
