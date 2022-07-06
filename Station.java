public enum Station {
    KTDI(6), KTR(3), KTF(2), KTC(10), KP(11), K9K10(12),
    KTHO(4), KDOJ(15), KDSE(13), KRP(1);
    private int distance;

    private Station(int distance){
        this.distance = distance;
    }
    public int getDistance(){
        return distance;
    }
}


