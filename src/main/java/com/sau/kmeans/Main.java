package com.sau.kmeans;

import java.util.ArrayList;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<float[]> dataSet = new ArrayList<>();

        dataSet.add(new float[] { 1});
        dataSet.add(new float[] { 3});
        dataSet.add(new float[] { 3});
        dataSet.add(new float[] { 5});
        dataSet.add(new float[] { 8});
        dataSet.add(new float[] { 4});
        dataSet.add(new float[] { 6});
        dataSet.add(new float[] { 3});
        dataSet.add(new float[] { 5});
        dataSet.add(new float[] { 4});
        dataSet.add(new float[] { 1});
        dataSet.add(new float[] { 7});
        dataSet.add(new float[] { 7});

        KMeansRun kRun =new KMeansRun(4, dataSet);

        Set<Cluster> clusterSet = kRun.run();
        System.out.println("单次迭代运行次数："+kRun.getIterTimes());
        for (Cluster cluster : clusterSet) {
            System.out.println(cluster);
        }
    }
}
