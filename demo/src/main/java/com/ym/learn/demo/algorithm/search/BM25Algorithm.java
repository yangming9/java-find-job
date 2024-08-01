package com.ym.learn.demo.algorithm.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BM25Algorithm {

    private static final double k1 = 1.5; // 参数，控制 term saturation
    private static final double b = 0.75; // 参数，控制文档长度对相关性的影响

    public static double calculateBM25(List<String> document, String query, Map<String, Integer> documentFrequency, int totalDocuments, Map<String, Integer> documentLengths) {
        double score = 0.0;
        double avgDocumentLength = calculateAverageDocumentLength(documentLengths);

        for (String term : documentFrequency.keySet()) {
            int termFrequencyInDocument = calculateTermFrequencyInDocument(document, term);
            int documentLength = documentLengths.getOrDefault(term, 0);

            double idf = calculateIDF(totalDocuments, documentFrequency.get(term));
            double term1 = (k1 + 1) * termFrequencyInDocument / (k1 * ((1 - b) + b * (documentLength / avgDocumentLength)) + termFrequencyInDocument);
            double term2 = idf;

            if (query.contains(term)) {
                score += term1 * term2;
            }
        }

        return score;
    }

    private static int calculateTermFrequencyInDocument(List<String> document, String term) {
        int frequency = 0;
        for (String word : document) {
            if (word.equals(term)) {
                frequency++;
            }
        }
        return frequency;
    }

    private static double calculateIDF(int totalDocuments, int documentFrequency) {
        return Math.log((totalDocuments - documentFrequency + 0.5) / (documentFrequency + 0.5) + 1.0);
    }

    private static double calculateAverageDocumentLength(Map<String, Integer> documentLengths) {
        int totalDocumentLength = documentLengths.values().stream().mapToInt(Integer::intValue).sum();
        return (double) totalDocumentLength / documentLengths.size();
    }

    public static void main(String[] args) {
        // 示例数据
        List<String> document = List.of("java", "programming", "language", "java", "algorithm");
        String query = "java algorithm";
        Map<String, Integer> documentFrequency = new HashMap<>();
        documentFrequency.put("java", 2);
        documentFrequency.put("programming", 1);
        documentFrequency.put("language", 1);
        documentFrequency.put("algorithm", 1);

        Map<String, Integer> documentLengths = new HashMap<>();
        documentLengths.put("java", 5);

        int totalDocuments = 1;

        double bm25Score = calculateBM25(document, query, documentFrequency, totalDocuments, documentLengths);
        System.out.println("BM25 Score: " + bm25Score);
    }
}

