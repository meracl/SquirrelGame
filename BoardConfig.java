public class BoardConfig {
    private XY size=new XY(15,15);
    private int wallCount=10;
    private int goodPlantCount=3;
    private int badPlantCount=3;
    private int goodBeastCount=3;
    private int badBeastCount=3;

    public void setSize(XY xy){
        size =xy;
    }
    public XY getSize (){
        return size;
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
