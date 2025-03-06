package com.faken233;

import java.io.IOException;

public class PlagiarismChecker {

    public static void main(String[] args) {
        // 检查参数数量
        if (args.length != 3) {
            System.out.println("Usage: java -jar main.jar <originalFile> <copiedFile> <outputFile>");
            return;
        }

        // 获取文件路径
//        String originalFilePath = "E:\\someprogrammes\\essay\\src\\main\\resources\\orig.txt";
//        String copiedFilePath = "E:\\someprogrammes\\essay\\src\\main\\resources\\orig_0.8_add.txt";
//        String outputFilePath = "E:\\someprogrammes\\essay\\src\\main\\resources\\answers.txt";
        String originalFilePath = args[0];
        String copiedFilePath = args[1];
        String outputFilePath = args[2];
        try {
            // 读取文件内容
            String originalText = FileIO.readFile(originalFilePath);
            String copiedText = FileIO.readFile(copiedFilePath);

            // 预处理文本
            String processedOriginal = TextProcessor.preprocess(originalText);
            String processedCopied = TextProcessor.preprocess(copiedText);

            // 计算最长公共子序列（LCS）长度
            int lcsLength = LCSCalculator.calculateLCS(processedOriginal, processedCopied);

            // 计算相似度
            double similarity = SimilarityCalculator.calculateSimilarity(lcsLength, processedOriginal.length(), processedCopied.length());

            // 将结果写入输出文件
            FileIO.writeResult(outputFilePath, similarity);

            System.out.println("查重完成，结果已写入: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("文件读写错误: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("程序运行错误: " + e.getMessage());
        }
    }
}