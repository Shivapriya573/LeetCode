/**
 * @param {string} seq
 * @return {number[]}
 */
var maxDepthAfterSplit = function(seq) {
    const ans= new Array(seq.length);
    let dept=0;
    for(let i=0;i<seq.length;i++){
        if(seq[i]==='('){
            ++dept;
            ans[i] = dept%2;

        }else{
           ans[i] = dept%2;
           --dept; 
        }
    }
    return ans;
};