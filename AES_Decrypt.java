package symmetric;

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class AES_Decrypt {
	public static void main(String[] args) throws Exception{
		byte[] ct = CryptoTools.hexToBytes("FB0692B011F74F8BF77EDE2630852C1700C204407EDF2222D965F74A8BCEB236");//set up values
		byte[] ky = CryptoTools.hexToBytes("444F204E4F542054454C4C2045564521");
		byte[] iv = CryptoTools.hexToBytes("20FC19123087BF6CAC8D0F1254123004");
		SecretKeySpec secret = new SecretKeySpec(ky, "AES");
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		AlgorithmParameterSpec aps = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, secret, aps);
		
		byte[] pt = cipher.doFinal(ct);  //decrypt
		for (int i = 0; i < pt.length; i++) {
			System.out.print(Character.toString((char)pt[i]));//when printing out each character turn them from byte to english
		}
	}
}
