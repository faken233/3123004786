package com.faken233;

import java.io.*;
import java.text.DecimalFormat;

/**
 *@author faken233
 * @date 2025/3/7
 * @description
 */
public class FileIO {

    /**
     * 读取文件内容
     */
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    /**
     * 将结果写入文件
     */
    public static void writeResult(String outputPath, double similarity) throws IOException {
        DecimalFormat df = new DecimalFormat("0.00");
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(df.format(similarity) + "%");
        }
    }
}
