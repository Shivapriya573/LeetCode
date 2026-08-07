class DataStream {
 private final int tempValue;
 private final int k;
 private int consectiveStreak;
    public DataStream(int value, int k) {
        this.tempValue=value;
        this.k=k;
        this.consectiveStreak=0;
    }
    
    public boolean consec(int num) {
        
        if(num==this.tempValue){
            consectiveStreak++;
        }
        else{
            this.consectiveStreak=0;
        }
        return this.consectiveStreak>=this.k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */