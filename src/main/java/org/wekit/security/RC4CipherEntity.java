package org.wekit.security;

public  class RC4CipherEntity 
{
    static String RC4(String keys,String encrypt) 
    {
        char[] keyBytes=new char[256];
        char[] cypherBytes=new char[256];

        for(int i=0; i<256; ++i) 
        {
            keyBytes[i]=keys.charAt(i % keys.length());           
            cypherBytes[i]=(char)i;
        }
        
        int jump=0;        
        for(int i=0; i<256; ++i) 
        {
            jump=(jump+cypherBytes[i]+keyBytes[i]) & 0xFF;
            char tmp=cypherBytes[i]; 
            cypherBytes[i]=cypherBytes[jump];
            cypherBytes[jump]=tmp;
        }
        
        int i=0;
        jump=0;
        String Result="";        
        for(int x=0; x < encrypt.length(); ++x) 
        {
            i=(i+1) & 0xFF;
            char tmp=cypherBytes[i];
            jump=(jump+tmp) & 0xFF;
            char t=(char)((tmp+cypherBytes[jump]) & 0xFF);
            cypherBytes[i]=cypherBytes[jump]; 
            cypherBytes[jump]=tmp;
            
            try
            {
                Result+=new String(new char[]{(char)(encrypt.charAt(x)^cypherBytes[t])});
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        return Result; 
    }    
    
    
    static String Data2ASCIIhex(String inputString) 
    {
        String result = "";
        String Chars = "0123456789ABCDEF";

        for (int i = 0; i < inputString.length(); ++i) {
            char Byte1 = (char) inputString.charAt(i);
            char lo = (char) (Byte1 & 0x0F);
            char hi = (char) (Byte1 >> 4);
            result += new String(new char[] { Chars.charAt(hi),
                    Chars.charAt(lo) });
        }

        return result;
    }
}