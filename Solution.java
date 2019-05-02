// you can also use imports, for example:
// import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    int[] counter = new int[26]; //alphabat counter array
    
    public int solution(String S, int K) {
        // write your code in Java SE 8
        int MIN_CNT = S.length();
        int i=0,j=0;
        
        for(i=0;i<counter.length;i++)
        {
            counter[i] = 0;
        }
        
        for(i=0;i<S.length();i++)
        {
            int alpha = (int)S.charAt(i);
            if( alpha >= 97 && alpha <= 122 ) counter[alpha-97] ++;
        }
        
        if( sumAlpha() < K ) return -1;
        if( sumAlpha() == K ) return 0;
        int p1=0,p2=0,c=0;
        while(true)
        {
            c=sumAlpha();
            
            if( p2 < S.length() )
            {
                if( c>K )
                {
                    counter[(int)S.charAt(p2)-97]--;
                    p2++;
                }
                else if( c==K )
                {
                    int min = p2 -p1;
                    if( MIN_CNT > min )
                        MIN_CNT = min;
                        
                    counter[(int)S.charAt(p1) - 97]++;
                    p1++;
                }
            }
            else if( p2 == S.length() )
            {
                if( c==K )
                {
                    int min = p2 -p1 ;
                    if( MIN_CNT > min )
                        MIN_CNT = min;
                }
                counter[(int)S.charAt(p1)-97]++;
                p1++;
            }
            
            if( p2 == S.length() && p1 == S.length() )
                break;
                
        }
        return MIN_CNT;
    }
    
    public int sumAlpha()
    {
        int cnt = 0;
        for(int i=0;i<counter.length;i++)
        {
            if(counter[i]>0)
               cnt++;  
        }
        return cnt;
    }
}
