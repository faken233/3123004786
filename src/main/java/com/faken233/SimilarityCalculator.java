package com.faken233;

/**
 * @author faken233
 * @date 2025/3/7
 * @description
 */
public class SimilarityCalculator {

    /**
     * 计算相似度
     */
    public static double calculateSimilarity(int lcsLength, int len1, int len2) {
        if (len1 == 0 && len2 == 0) {
            return 100.0; // 如果两段文本都为空，认为完全相似
        }
        return (2.0 * lcsLength) / (len1 + len2) * 100;
    }
}