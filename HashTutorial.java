import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTutorial {



    HashTutorial(){
        compare();
    }

   
    static void compare(){
    	
        byte[] userDefined=null;
    
        int inp=0;
        try{
       
            inp = Integer.parseInt(JOptionPane.showInputDialog(null,"���������� ������� ��� ���: "));
            userDefined=hash(inp);
        }
       
        catch(Exception e){
            compare();
        }
     
        if(inp<0){
            try {
               
                JOptionPane.showMessageDialog(null, "����� ����� ������ ���� ������ ��� ����� 0! ");
            }
          
            catch(NullPointerException e){
                System.exit(-1);
            }
          
            compare();
        }

       
        for(int i=0;i<2147483647;i++){
            
            System.out.println(i);
          
            if(MessageDigest.isEqual(hash(i),userDefined)){
                
                try {
                    JOptionPane.showMessageDialog(null, "������� ���������� " + i);
                }
                catch(Exception e){
                    System.out.println("������� ���������� " + i);
                }
              
                System.exit(0);
                break;
            }
        }
        
        System.out.println("�� ������� ����������: ");
    }

   
    static byte[] hash(int input){
       
        byte[] output=null;
        
        String inp=Integer.toString(input);
        
        try{
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            output = digest.digest(inp.getBytes(StandardCharsets.UTF_8));
        }
       
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return output;
    }


    public static void main(String[] args){
        new HashTutorial();
    }
}