package com.bookManager.domin;

public class pageinf {
    private int allpage;
    private int currentpage=0;
    private int endelecode;
    private int count=4;

    public int getEndelecode() {
        return endelecode;
    }

    public void setEndelecode(int endelecode) {
        this.endelecode = endelecode;
    }

    public int getAllpage() {
        return allpage;
    }

    public void setAllpage(int allpage) {
        this.allpage = allpage;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
