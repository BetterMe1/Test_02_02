package xust;

/*
1. 汉明距离
注意：
0 ≤ x, y < 2^31.
示例:
输入: x = 1, y = 4
输出: 2
解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
 */
/*
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 */
//public class Test_0202 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int x = 1;
//		int y = 4;
//		System.out.println(So.hammingDistance(x, y));
//	}
//}
//class Solution {
//    public int hammingDistance(int x, int y) {
//        if(x<0 || y<0){
//        	return -1;
//        }
//        int HammingDistance = 0;
//        for(int i=0; i<32; i++){
//        	if(((x>>i & 1) ^ (y>>i & 1)) == 1){
//        		HammingDistance++;
//        	}
//        } 
//        return HammingDistance;
//    }
//}
/*
2. 汉明距离总和
两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
计算一个数组中，任意两个数之间汉明距离的总和。

示例:
输入: 4, 14, 2
输出: 6
解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
所以答案为：
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

注意:
数组中元素的范围为从 0到 10^9。
数组的长度不超过 10^4。
 */
//public class Test_0202 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] nums = {4, 14, 2};
//		System.out.println(So.totalHammingDistance(nums));
//	}
//}
//class Solution {
//    public int totalHammingDistance(int[] nums) {
//       int SumDistance = 0;
//       for(int k=0; k<30; k++){
//    	   int oneCount=0;
//    	   for(int i=0; i<nums.length; i++){
//    		   if((nums[i]>>k & 1) == 1)
//    			   oneCount++;
//    	   }
//    	   SumDistance += oneCount*(nums.length -oneCount);
//       }
//       return SumDistance;
//   }
//}
/*
 * 
3. 重复的子字符串
给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
示例 1:
输入: "abab"
输出: True
解释: 可由子字符串 "ab" 重复两次构成。

示例 2:
输入: "aba"
输出: False

示例 3:
输入: "abcabcabcabc"
输出: True
解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Test_0202 {
	public static void main(String[] args) {
		Solution So = new Solution();
		String s= "abcabcabcabc";
		System.out.println(So.repeatedSubstringPattern(s));
	}
}
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String subString =String.valueOf(s.charAt(0));
        String resString="";
        int i=1;
        while(i<s.length()/2 && s.charAt(i)!=s.charAt(0)){
        	subString += String.valueOf(s.charAt(i));
        	i++;
        }
        i=i-1;
        while(i<s.length()/2){
        	if(s.length() % subString.length() == 0){
        		int count = s.length()/subString.length();
                for(int j=0; j<count; j++){
                	resString += subString;	   
                }
                if(s.equals(resString)){
                	return true;
                }
        	}
        	i++;
            resString="";
            subString += String.valueOf(s.charAt(i));
            System.out.println(i+subString);
        }
        return false;
    }
}