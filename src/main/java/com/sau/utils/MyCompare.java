package com.sau.utils;

import com.sau.kmeans.Cluster;

import java.util.Comparator;

public class MyCompare implements Comparator<Cluster> {
    @Override
    public int compare(Cluster o1, Cluster o2) {
        double result = o1.getCenter().getlocalArray()[0] - o2.getCenter().getlocalArray()[0];
        if(result > 0)
            return 1;
        else if(result == 0)
            return 0;
        else
            return -1;
    }
}
