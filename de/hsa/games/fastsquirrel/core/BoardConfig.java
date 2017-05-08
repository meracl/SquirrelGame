package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.XY;

public class BoardConfig {
    int height=15;
    int width=15;
    private XY size=new XY(height,width);
    private int wallCount=0;
    private int goodPlantCount=3;
    private int badPlantCount=3;
    private int goodBeastCount=3;
    private int badBeastCount=3;

    public void setSize(XY xy){
        size =xy;
    }
    public XY getSize(){
        return size;
    }
    public int getSizeX(){
        return height;
    }
    public int getSizeY(){
        return width;
    }
    public void setWallCount(int i){
        wallCount =i;
    }
    public int getWallCount(){
        return wallCount;
    }
    public void setGoodPlantCount(int i){
        goodPlantCount =i;
    }
    public int getGoodPlantCount(){
        return goodPlantCount;
    }
    public void setBadPlantCount(int i){
        badPlantCount =i;
    }
    public int getBadPlantCount(){
        return badPlantCount;
    }
    public void setGoodBeastCount(int i){
        goodBeastCount =i;
    }
    public int getGoodBeastCount(){
        return goodBeastCount;
    }
    public void setBadBeastCount(int i) {
        badBeastCount=i;
    }
    public int getBadBeastCount() {
        return badBeastCount;
    }

}