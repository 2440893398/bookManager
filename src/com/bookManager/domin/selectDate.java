package com.bookManager.domin;

public class selectDate {
    private  String id="";
    private  String name="";
    private  String category="";
    private  double min = 0;
    private  double max = Double.MAX_VALUE;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        if(max>0){
            this.max = max;
        }

    }
    @Override
    public String toString() {
        return "selectDate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
