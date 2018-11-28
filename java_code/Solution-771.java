/*
 *char charAt(index):获取指定index位置的字符
 *String.length():获取字符串的长度
 *==:判断  =：赋值
 */
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(int i=0; i<J.length(); i++){            //String.length():获取字符串的长度
            for(int k=0; k<S.length(); k++){
                if(J.charAt(i) == S.charAt(k)){     //==:判断  =：赋值
                    count += 1;
                }
            }
        }
        return count;
    }
}

