package challenge;
import java.lang.Exception;
import java.lang.String;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
		IsEmpityOrNull(texto);
		texto = texto.toLowerCase(); //Converte, se necessário todo o texto para minúsculas
		Integer n = texto.length();//Tamanho da String
		char caracterControle;
		String cifrado =  new String();

     	for (int i = 0; i<n;i++) //Varre toda a String desde a posição 0 até o tamanho desta String
		{
			if(((texto.charAt(i)<'a')) || ((texto.charAt(i)>'z'))) // teste se os caracteres estão estão fora do alfabeto minúsculo, se for o caso, eles serão mantidos como estão.
			{	
				caracterControle = (texto.charAt(i));
				cifrado = cifrado.concat(String.valueOf(caracterControle));

			}else if ((int) (texto.charAt(i) + numero_casas) >'z' )//se o caracter, convertido ( menos o númeto de casas) for maior que 'z'
				{
                    caracterControle = (char)((texto.charAt(i) + numero_casas)-26);//volta para o fim o alfabeto para pegar a letra criptografada
                    cifrado = cifrado.concat(String.valueOf(caracterControle));
                } else 
						{
                			caracterControle = (char)(texto.charAt(i) + numero_casas);
                			cifrado = cifrado.concat(String.valueOf(caracterControle));
						}
		}
       	return  cifrado;
      
    }

    @Override
    public String descriptografar(String texto) {
	    IsEmpityOrNull(texto);
		texto = texto.toLowerCase(); //Converte, se necessário todo o texto para minúsculas
		Integer n = texto.length();//Tamanho da String
		char caracterControle;
		String decifrado =  new String();

     	for (int i = 0; i<n;i++) //Varre toda a String desde a posição 0 até o tamanho desta String
		{
			if(((texto.charAt(i)<'a')) || ((texto.charAt(i)>'z'))) // teste se os caracteres estão estão fora do alfabeto minúsculo, se for o caso, eles serão mantidos como estão.
			{	
				caracterControle = (texto.charAt(i));
				decifrado = decifrado.concat(String.valueOf(caracterControle));

			}else if ((int) (texto.charAt(i) - numero_casas) <'a' )//se o caracter, convertido ( menos o númeto de casas) for menor que 'a'
				{
                    caracterControle = (char)((texto.charAt(i) - numero_casas)+26);//volta para o fim o alfabeto para pegar a letra criptografada
                    decifrado = decifrado.concat(String.valueOf(caracterControle));
                } else 
						{
                			caracterControle =(char) (texto.charAt(i) - numero_casas);
                			decifrado = decifrado.concat(String.valueOf(caracterControle));
						}
		}
       	return  decifrado;
    }

	public void IsEmpityOrNull (String texto) {
	   if (texto == null){throw new NullPointerException(); }
	   if (texto.isEmpty()){throw new IllegalArgumentException();}	    
    }

}
