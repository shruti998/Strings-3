// Problem 1
//TC O(logn)
//SC O(1)
class Solution {
     String thousands[]={"", "Thousand","Million","Billion"};
     String below_20[]={"","One","Two","Three","Four","Five","Six","Seven",
     "Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
     "Sixteen","Seventeen","Eighteen","Nineteen"};
     String tens[]={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
       if(num==0)
       {
        return "Zero";
       }
       int i=0;
       String result="";
       while(num>0)
       {
        if(num%1000!=0)
        {
            result=recurse(num%1000)+thousands[i]+" "+result;
            
        }
        i++;
            num=num/1000;
       }
       return result.trim();
    }
    private String recurse(int num)
    {
        if(num==0)
        {
            return "";
        }
       else if(num<20)
       {
        return below_20[num]+" ";
       }
       else if(num<100)
       {
        return tens[num/10]+ " "+recurse(num%10);
       }
       else{
        return below_20[num/100]+" Hundred "+recurse(num%100);
       }
    }
}

// Problem 2
//TC O(n)
//SC O(n)
class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0)
        {
            return 0;
        }
        int cur =0;
        char lastsign='+';
       Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                cur=cur*10+c-'0';
            }
            if((!Character.isDigit(c)&& c!=' ')|| i==s.length()-1)
            {
                if(lastsign=='+')
                {
                   stack.push(+cur);
                 
                }
                if(lastsign=='-')
                {
                   stack.push(-cur);
                }
                if(lastsign=='*')
                {
                    stack.push(stack.pop()*cur);
                }
                if(lastsign=='/')
                {
                   stack.push(stack.pop()/cur);
                }
                lastsign=c;
                cur=0;
            }
        }
        int res=0;

        while(!stack.isEmpty())
        {
res=res+stack.pop();
        }
return res;
    }
}