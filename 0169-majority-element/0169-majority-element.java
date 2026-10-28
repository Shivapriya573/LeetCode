class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
       
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int count:map.keySet()){
            if(map.get(count)>nums.length/2){
                return count;
            }
        }
        return -1;
        
    }
}