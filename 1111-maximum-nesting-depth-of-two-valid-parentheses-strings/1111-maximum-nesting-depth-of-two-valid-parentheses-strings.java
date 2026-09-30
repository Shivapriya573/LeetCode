class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n= seq.length();
        int[] ans= new int[n];
        int dept=0;
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                ++dept;
                ans[i]=dept%2;
            }else{
                ans[i]=dept%2;
                --dept;
            }
        }
        return ans;
    }
}