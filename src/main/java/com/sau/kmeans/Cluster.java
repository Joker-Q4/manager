package com.sau.kmeans;

import com.sau.utils.MyCompare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cluster implements Comparator<Cluster> {
    private final int id;// 标识
    private Point center;// 中心
    private List<Point> members = new ArrayList<>();// 成员

    public Cluster(int id, Point center) {
        this.id = id;
        this.center = center;
    }

    public Cluster(int id, Point center, List<Point> members) {
        this.id = id;
        this.center = center;
        this.members = members;
    }

    public void addPoint(Point newPoint) {
        members.add(newPoint);
      /*  if (!members.contains(newPoint)){
            members.add(newPoint);
        }else{
            System.out.println("样本数据点 {"+newPoint.toString()+"} 已经存在！");
        }*/
    }

    public int getId() {
        return id;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public List<Point> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("Cluster \n" + "Cluster_id=" + this.id + ", center:{" + this.center.toString() + "}");
        for (Point point : members) {
            toString.append("\n").append(point.toString());
        }
        return toString.toString()+"\n";
    }

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