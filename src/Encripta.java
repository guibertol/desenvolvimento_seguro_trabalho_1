
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encripta {
    
    private static String chaveencriptacao;
    private static String textopuro;

     //CHAVE DEVE TER 16 CARACTERES: EXEMPLO AAAAAAAAAAAAAAAA
    
    public Encripta() {
    }
    
    

    public static void executar() {

      try {

         System.out.println("Texto Puro: " + textopuro);

         byte[] textoencriptado = encrypt(textopuro, chaveencriptacao);

         System.out.print("Texto Encriptado: ");

         for (int i=0; i<textoencriptado.length; i++)
                System.out.print(new Integer(textoencriptado[i])+" ");


      } catch (Exception e) {
         e.printStackTrace();
      }
    }

    public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
      Cipher encripta = Cipher.getInstance("AES/ECB/PKCS5Padding");
      SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
      encripta.init(Cipher.ENCRYPT_MODE, key);
      return encripta.doFinal(textopuro.getBytes("UTF-8"));
    }

    public String getChaveencriptacao() {
        return chaveencriptacao;
    }

    public void setChaveencriptacao(String chaveencriptacao) {
        this.chaveencriptacao = chaveencriptacao;
    }

    public String getTextopuro() {
        return textopuro;
    }

    public void setTextopuro(String textoPuro) {
        Encripta.textopuro = textoPuro;
    }
    
}
