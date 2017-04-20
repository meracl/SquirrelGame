public class BoardConfig {
    private XY size=new XY(3,3);
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
    public void setgoodPlantCount(int i){
        goodPlantCount =i;
    }
    public int getgoodPlantCount(){
        return goodPlantCount;
    }
    public void setbadPlantCount(int i){
        badPlantCount =i;
    }
    public int getbadPlantCount(){
        return badPlantCount;
    }
    public void setgoodBeastCount(int i){
        goodBeastCount =i;
    }
    public int getgoodBeastCount(){
        return goodBeastCount;
    }
    public int setBadBeastCount(int i) {
        badBeastCount=i;
    }
    public int getBadBeastCount() {
        return badBeastCount;
    }

}
