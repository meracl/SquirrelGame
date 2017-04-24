public class BoardConfig {
    int height=30;
    int width=30;
    private XY size=new XY(height,width);
    private int wallCount=10;
    private int goodPlantCount=5;
    private int badPlantCount=5;
    private int goodBeastCount=5;
    private int badBeastCount=5;

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
