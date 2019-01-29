
package playfairAlgorithm;

public class playfair {
	public static void main(String[] args) {
		new playfair();
	}
    
    char[][] key = new char[5][5];
    
    String dummyKey = "ASHIMMAHARZAN";
    
   public playfair()
   {
       KeyGeneration();
       Display();
       EncryptionDecryption();
   }

    public void KeyGeneration() {
        int k=0;
        char alphabet = 'A';
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(k<dummyKey.length())
                {
                    if(check(dummyKey.charAt(k)))
                    {
                    key[i][j] = dummyKey.charAt(k);
                    k++;
                    }
                    else{
                        k++;
                        j--;
                    }
                }
                else if(check(alphabet))
                {
                    if(alphabet == 'J')
                    {
                        alphabet++;
                        j--;
                        continue;
                    }
                    else{
                    key[i][j] = alphabet;
                    alphabet++;
                    }
                }
                else
                {
                    alphabet++;
                    j--;
                }
            }
        }
    }
    
    public boolean check(char c)
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(c == key[i][j])
                {
                    return false;
                }
            }
        }
        return true;
        
    }
    
    public void Display()
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(key[i][j]+"   ");
            }
            System.out.println("");
        }
    }
    
    public void EncryptionDecryption()
    {
        String plainText = "BALLOONMAJANOO";
        
        System.out.println("Plaintext = "+plainText);
        String fragmentedText = FragmentText(plainText);
        
        System.out.println("Fragmented Text  =  "+fragmentedText);
        
        String cipherText = CipherTextCreator(fragmentedText);
        
        System.out.println("Ciphertext = "+cipherText);
        
        
        
    }
    
    public String FragmentText(String str)
    {
        String str2 = "";
        for(int i=0;i<str.length();i=i+2)
        {
        if((i+1)<str.length())
          {
            if(str.charAt(i)!=str.charAt(i+1))
            {
                str2=str2+str.charAt(i)+str.charAt(i+1)+" ";
            }
            else
            {
             str2=str2+str.charAt(i)+'X'+" ";  
             i--;
            }
          }
        else
        {
            str2=str2+str.charAt(i)+'X';
        }
        }
        
        return str2;
    }
    
    public String CipherTextCreator(String str)
    {
        str.replace('J', 'I');
        String str2 = "";
        int[] position = new int[2];
         int x1,x2,y1,y2;
        for(int i=0;i<str.length();i=i+3)
        {
            position = FindPosition(str.charAt(i));
            x1 = position[0];
            y1 = position[1];
            
            position = FindPosition(str.charAt(i+1));
            x2 = position[0];
            y2 = position[1];
            
            
            if(x1==x2)
            {
                str2 = str2+key[x1][(y1+1)%5]+key[x2][(y2+1)%5];
                
            }
            else if(y1==y2)
            {
                str2 = str2+key[(x1+1)%5][y1]+key[(x2+1)%5][y2];
            }
            else
            {
                str2 = str2+key[x1][y2]+key[x2][y1];
            }
            
        } 
        return str2;
    }
    
    public int[] FindPosition(char c)
    {
        int[] position = new int[2];
        int check = 0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(c==key[i][j])
                {
                    position[0]=i;
                    position[1]=j;
                    check++;
                    break;
                }
            }
            if(check!=0)
            {
                break;
            }
        }
        
        return position;
    }
    
}
