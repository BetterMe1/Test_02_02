package xust;

/*
1. ��������
ע�⣺
0 �� x, y < 2^31.
ʾ��:
����: x = 1, y = 4
���: 2
����:
1   (0 0 0 1)
4   (0 1 0 0)
       ��   ��

����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�
 */
/*
 * ���������� �������� ָ�������������ֵĶ���������Ӧλ��ͬ��������
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
2. ���������ܺ�
���������� �������� ָ�������������ֵĶ���������Ӧλ��ͬ��������
����һ�������У�����������֮�人��������ܺ͡�

ʾ��:
����: 4, 14, 2
���: 6
����: �ڶ����Ʊ�ʾ�У�4��ʾΪ0100��14��ʾΪ1110��2��ʾΪ0010����������ʾ��Ϊ�����ֺ���λ֮���ϵ��
���Դ�Ϊ��
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

ע��:
������Ԫ�صķ�ΧΪ�� 0�� 10^9��
����ĳ��Ȳ����� 10^4��
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
3. �ظ������ַ���
����һ���ǿյ��ַ������ж����Ƿ����������һ���Ӵ��ظ���ι��ɡ��������ַ���ֻ����СдӢ����ĸ�����ҳ��Ȳ�����10000��
ʾ�� 1:
����: "abab"
���: True
����: �������ַ��� "ab" �ظ����ι��ɡ�

ʾ�� 2:
����: "aba"
���: False

ʾ�� 3:
����: "abcabcabcabc"
���: True
����: �������ַ��� "abc" �ظ��Ĵι��ɡ� (�������ַ��� "abcabc" �ظ����ι��ɡ�)
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