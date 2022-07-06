public enum Station {
    KTDI(6), KTR(3), KTF(2), KTC(10), KP(11), K9K10(12),
    KTHO(4), KDOJ(15), KDSE(13), KRP(1);
    private int address;

    private Station(int address){
        this.address = address;
    }
    public int getAddress(){
        return address;
    }
}


