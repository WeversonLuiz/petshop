package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class ManipulaImagem {
	
	public static BufferedImage setImagemDimensao(String caminhoImagem, Integer imagemLargura, Integer imagemAltura){
		Double novaImagemLargura = null;
		Double novaImagemAltura = null;
		Double imagemProporcao = null;
		BufferedImage imagem = null;
		Graphics2D g2d = null;
		BufferedImage novaImagem = null;
		
		try {
			//obetem a imagem para ser redimensionada
			imagem = ImageIO.read(new File(caminhoImagem));
		} catch (Exception e) {
			Logger.getLogger(ManipulaImagem.class.getName()).log(null, e);;
		}
		
		//obtem a largura da imagem
		novaImagemLargura = (double) imagem.getWidth();
		
		//obtém a altura da imagem
		novaImagemAltura = (double) imagem.getHeight();
		
		if (novaImagemLargura >= imagemLargura) {
			imagemProporcao = (novaImagemAltura / novaImagemLargura);
			novaImagemLargura = (double) imagemLargura;
			
			//
			while (novaImagemAltura > imagemAltura) {
				novaImagemLargura = (double) (--imagemLargura);
				novaImagemAltura = (novaImagemLargura * imagemProporcao);
			}
			
		}else if(novaImagemAltura >= imagemAltura){
			imagemProporcao = (novaImagemLargura / novaImagemAltura);
			novaImagemAltura = (double) imagemAltura;
			
			while (novaImagemLargura > imagemLargura) {
				novaImagemAltura = (double) (--imagemAltura);
				novaImagemLargura = (novaImagemAltura * imagemProporcao);
			}
		}
		
		novaImagem = new BufferedImage(novaImagemLargura.intValue(), novaImagemAltura.intValue(), BufferedImage.TYPE_INT_RGB);
		g2d = novaImagem.createGraphics();
		g2d.drawImage(imagem, 0, 0, novaImagemLargura.intValue(), novaImagemAltura.intValue(), null);
		
		return novaImagem;
		
	}
	
	public static byte[] getImgBytes(BufferedImage image){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "JPEG", baos);
		} catch (IOException e) {
			
		}
		
		InputStream is = new ByteArrayInputStream(baos.toByteArray());
		
		return baos.toByteArray();
	}
	
	public static void exibirImagem(byte[] minhaImagem){
		
		if (minhaImagem != null) {
			InputStream input = new ByteArrayInputStream(minhaImagem);
			try {
				BufferedImage imagem = ImageIO.read(input);
				
				//jogar no componente
			} catch (IOException e) {
				// TODO: handle exception
			}
		}else{
			// seta null na tela
		}
		
	}

}
