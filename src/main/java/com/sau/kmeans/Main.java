package com.sau.kmeans;

import com.sau.utils.MyCompare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<double[]> dataSet = new ArrayList<>();

        dataSet.add(new double[] { 1});
        dataSet.add(new double[] { 3});
        dataSet.add(new double[] { 3});
        dataSet.add(new double[] { 5});
        dataSet.add(new double[] { 8});
        dataSet.add(new double[] { 8});
        dataSet.add(new double[] { 4});
        dataSet.add(new double[] { 6});
        dataSet.add(new double[] { 3});
        dataSet.add(new double[] { 5});
        dataSet.add(new double[] { 4});
        dataSet.add(new double[] { 1});
        dataSet.add(new double[] { 7});
        dataSet.add(new double[] { 7});

//        dataSet.add(1d);
//        dataSet.add(3d);
//        dataSet.add(3d);
//        dataSet.add(5d);
//        dataSet.add(8d);
//        dataSet.add(8d);
//        dataSet.add(4d);
//        dataSet.add(6d);
//        dataSet.add(3d);
//        dataSet.add(5d);
//        dataSet.add(4d);
//        dataSet.add(1d);
//        dataSet.add(7d);
//        dataSet.add(7d);

        KMeansRun kRun =new KMeansRun(4, dataSet);

        Cluster[] clusters = kRun.run().toArray(new Cluster[0]);
        Arrays.sort(clusters, new MyCompare()) ; // 进行排序操作

      /*  Set<Cluster> clusterSet = kRun.run();
        Arrays.sort(clusterSet.toArray(new Cluster[0]), new MyCompare()) ; // 进行排序操作*/
        System.out.println("单次迭代运行次数："+kRun.getIterTimes());
        for (Cluster cluster : clusters) {
            System.out.println(cluster);
        }
    }
}
