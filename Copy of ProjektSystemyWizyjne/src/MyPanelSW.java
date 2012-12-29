import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.SortedSet;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MyPanelSW extends JPanel {

	private static final long serialVersionUID = 1L;

	private BufferedImage image;
	private Dimension dimension;
	
	float[] yellowLab = {97,-22,94};
	float[] orangeLab = {68,23,56};
	float[] redLab = {53,80,67};
	float[] limeLab = {88,-86,83};
	float[] greenLab = {46,-52,50};
	float[] aquaLab = {91,-48,-14};
	float[] blueLab = {32,79,-108};
	float[] violetLab = {22,35,-18};
	float[] fuchsiaLab = {60,98,-61};
	float[] brownLab = {22,10,22};
	float[] brown2Lab = {14,10,10};
	float[] whiteBLab = {100,0,0};
	float[] grayLab = {70,0,0};
	float[] darkGrayLab = {40,0,0};
	float[] blackLab = {10,0,0};
	float[] pinkLab = {76,40,-4};
	float[] m1Lab = {66,9,15};
	float[] m2Lab = {47,14,27};
	float[] whiteLab = {87,6,0};
	float[] darkRedLab = {45,58,29};
	float[] darkPinkLab = {43,60,-3};
	float[] darkOrangeLab = {74,26,78};
	float[] darkWhiteLab = {75,4,7};
	float[] darkRed2Lab = {32,50,28};
	float[] darkRed3Lab = {21,42,22};
	float[] darkPink2Lab = {32,50,0};
	float[] lightPinkLab = {78,35,-8};
	float[] red2Lab = {51,73,44};
	float[] red3Lab = {42,65,42};
	
	private URL[] url = new URL[23];
	private URL fileURL1;
	private URL fileURL2;
	private URL fileURL3;
	private URL fileURL4;
	private URL fileURL5;
	private URL fileURL6;
	private URL fileURL7;
	private URL fileURL8;
	private URL fileURL9;
	private URL fileURL10;
	private URL fileURL11;
	private URL fileURL12;
	private URL fileURL13;
	private URL fileURL14;
	private URL fileURL15;
	private URL fileURL16;
	private URL fileURL17;
	private URL fileURL18;
	private URL fileURL19;
	private URL fileURL20;
	private URL fileURL21;
	private URL fileURL22;
	private URL fileURL23;
	
	
//	private File[] files = new File[24];
//	private File imageFile1 = new File("leg.jpg");
//	private File imageFile2 = new File("leg2.jpg");
//	private File imageFile3 = new File("leg3.jpg");
//	private File imageFile4 = new File("leg4.jpg");
//	private File imageFile5 = new File("leg5.jpg");
//	private File imageFile6 = new File("bransolet.jpg");
//	private File imageFile7 = new File("bransolet2.jpg");
//	private File imageFile8 = new File("bransolet3.jpg");
//	private File imageFile9 = new File("bransolet4.jpg");
//	private File imageFile10 = new File("bransolet5.jpg");
//	private File imageFile11 = new File("cap.jpg");
//	private File imageFile12 = new File("cap2.jpg");
//	private File imageFile13 = new File("cap3.jpg");
//	private File imageFile14 = new File("cap4.jpg");
//	private File imageFile16 = new File("gloves2.jpg");
//	private File imageFile17 = new File("gloves3.jpg");
//	private File imageFile19 = new File("bag2.jpg");
//	private File imageFile20 = new File("bag3.jpg");
//	private File imageFile21 = new File("strap4.jpg");
//	private File imageFile22 = new File("strap2.jpg");
//	private File imageFile23 = new File("strap3.jpg");
//	private File imageFile24 = new File("strap5.jpg");
//	private File imageFile25 = new File("earings.jpg");
//	private File imageFile26 = new File("earings2.jpg");
	
	private TreeMap<String, float[]> colorsLab = new TreeMap<String, float[]>();	// FINAL??!!
	private TreeMap<String, Integer> colorsQuant = new TreeMap<String, Integer>();
	SortedSet<String> subSet;
	
	public MyPanelSW(int index) {
		
		downloadFiles();
		
		url[0] = fileURL1;
		url[1] = fileURL2;
		url[2] = fileURL3;
		url[3] = fileURL4;
		url[4] = fileURL5;
		url[5] = fileURL6;
		url[6] = fileURL7;
		url[7] = fileURL8;
		url[8] = fileURL9;
		url[9] = fileURL10;
		url[10] = fileURL11;
		url[11] = fileURL12;
		url[12] = fileURL13;
		url[13] = fileURL14;
		url[14] = fileURL15;
		url[15] = fileURL16;
		url[16] = fileURL17;
		url[17] = fileURL18;
		url[18] = fileURL19;
		url[19] = fileURL20;
		url[20] = fileURL21;
		url[21] = fileURL22;
		url[22] = fileURL23;
		
//		files[0]=imageFile1;
//		files[1]=imageFile2;
//		files[2]=imageFile3;
//		files[3]=imageFile4;
//		files[4]=imageFile5;
//		files[5]=imageFile6;
//		files[6]=imageFile7;
//		files[7]=imageFile8;
//		files[8]=imageFile9;
//		files[9]=imageFile10;
//		files[10]=imageFile11;
//		files[11]=imageFile12;
//		files[12]=imageFile13;
//		files[13]=imageFile14;
//		files[14]=imageFile16;
//		files[15]=imageFile17;
//		files[16]=imageFile19;
//		files[17]=imageFile20;
//		files[18]=imageFile21;
//		files[19]=imageFile22;
//		files[20]=imageFile23;
//		files[21]=imageFile24;
//		files[22]=imageFile25;
//		files[23]=imageFile26;

//		URL url=null;
//		try {
//			url = new URL("http://www.lauralaudi.pl/ii/photo-8115eac4-4576-47c7-9637-d5dae1bb8943_s_900.600.a.jpg");
//		} catch (MalformedURLException e1) {
//			e1.printStackTrace();
//		}
		
		try {
			image = ImageIO.read(url[index]);		//files[index]
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);
        
        colorsQuant.put("Yellow", 0);
        colorsQuant.put("Orange", 0);
        colorsQuant.put("Red", 0);
        colorsQuant.put("Lime", 0);
        colorsQuant.put("Green", 0);
        colorsQuant.put("Aqua", 0);
        colorsQuant.put("Blue", 0);
        colorsQuant.put("Violet", 0);
        colorsQuant.put("Fuchsia", 0);
        colorsQuant.put("Brown", 0);
        colorsQuant.put("White",0);
        colorsQuant.put("Gray", 0);
        colorsQuant.put("Dark gray", 0);
        colorsQuant.put("Black", 0);
        colorsQuant.put("Pink", 0);
        colorsQuant.put("M1", 0);
        colorsQuant.put("M2", 0);
        colorsQuant.put("B1", 0);
        
        colorsLab.put("Yellow", yellowLab);
        colorsLab.put("Orange", orangeLab);
        colorsLab.put("Red", redLab);
        colorsLab.put("Red", red2Lab);
        colorsLab.put("Red", red3Lab);
        colorsLab.put("Lime", limeLab);
        colorsLab.put("Green", greenLab);
        colorsLab.put("Aqua", aquaLab);
        colorsLab.put("Blue", blueLab);
        colorsLab.put("Violet", violetLab);
        colorsLab.put("Fuchsia", fuchsiaLab);
        colorsLab.put("Brown", brownLab);
        colorsLab.put("Brown", brown2Lab);
        colorsLab.put("White", whiteLab);
        colorsLab.put("Gray", grayLab);
        colorsLab.put("Dark gray", darkGrayLab);
        colorsLab.put("Black", blackLab);
        colorsLab.put("Pink", pinkLab);
        colorsLab.put("M1", m1Lab);
        colorsLab.put("M2", m2Lab);
        colorsLab.put("B1", whiteBLab);
        colorsLab.put("Red", darkRedLab);
        colorsLab.put("Pink", darkPinkLab);
        colorsLab.put("Orange", darkOrangeLab);
        colorsLab.put("White", darkWhiteLab);
        colorsLab.put("Red", darkRed2Lab);
        colorsLab.put("Red", darkRed3Lab);
        colorsLab.put("Pink", darkPink2Lab);
        colorsLab.put("Pink", lightPinkLab);
        
        subSet = (SortedSet<String>) colorsLab.keySet();	//names of colors
	}
	
	public void readColors(String[] colors){
		for (int x = 0; x < (int) dimension.width; x++) { // (int)dimension.width
		for (int y = 0; y < (int) dimension.height; y++) { // (int)dimension.height
			Color color = new Color(image.getRGB(x, y));	//take RGB color from pixel
			
			float[] c = {0,0,0};
			color.getColorComponents(CIELab.getInstance(), c);	//LAB from RGB
			
			TreeMap<Float, String> map = new TreeMap<Float, String>();
			float[] temp = {0,0,0};
			
			for(String name : subSet){		//for each color name
			temp = colorsLab.get(name);		//get LAB
			//count distance between "color" and "name color" in 3D
			float distance = (float) Math.sqrt(Math.pow(c[0] - temp[0], 2) + Math.pow(c[1] - temp[1], 2) + Math.pow(c[2] - temp[2],2));
			//put into temporary map
			map.put(distance, name);
			}
			float minDistance = 0;
			//map is ordered ascending so the minimal distance:
			try{
			minDistance = map.firstKey();
			}catch(Exception e){
				e.printStackTrace();
			}
			//and name of nearest color:
			String minDistanceName = map.get(minDistance);
			
			//incrementing quantity of color in colorsQuant map
			int tempVal = colorsQuant.get(minDistanceName);
			tempVal++;
			colorsQuant.put(minDistanceName, tempVal);
		}
	}
	
	int thr = 12000;
	int i = 0;
	for(String name : subSet){
		int temp = colorsQuant.get(name);
		if(name=="Gray" || name=="Dark gray" || name=="B1" || name=="M1" || name=="M2");
		else if(temp > thr) {
			System.out.println(name + ": " + temp); 
			colors[i] = name; 
			i++;
		}
		if(name=="Gray" || name=="Dark gray") if(temp > 4*thr){
			System.out.println(name + ": " + temp);
			colors[i] = "Gray";
		}
	}
	}

	public void downloadFiles(){
		if(fileURL1==null){
		try{
			fileURL1 = getClass().getResource("obrazy/brans1.jpg");
			fileURL2 = getClass().getResource("obrazy/brans2.jpg");
			fileURL3 = getClass().getResource("obrazy/brans3.jpg");
			fileURL4 = getClass().getResource("obrazy/brans4.jpg");
			fileURL5 = getClass().getResource("obrazy/brans5.jpg");
			fileURL6 = getClass().getResource("obrazy/brans6.jpg");
			fileURL7 = getClass().getResource("obrazy/czap1.jpg");
			fileURL8 = getClass().getResource("obrazy/czap2.jpg");
			fileURL9 = getClass().getResource("obrazy/czap3.jpg");
			fileURL10 = getClass().getResource("obrazy/czap4.jpg");
			fileURL11 = getClass().getResource("obrazy/czap5.jpg");
			fileURL12 = getClass().getResource("obrazy/kol1.jpg");
			fileURL13 = getClass().getResource("obrazy/kol2.jpg");
			fileURL14 = getClass().getResource("obrazy/kol3.jpg");
			fileURL15 = getClass().getResource("obrazy/leg1.jpg");
			fileURL16 = getClass().getResource("obrazy/leg2.jpg");
			fileURL17 = getClass().getResource("obrazy/leg3.jpg");
			fileURL18 = getClass().getResource("obrazy/leg4.jpg");
			fileURL19 = getClass().getResource("obrazy/leg5.jpg");
			fileURL20 = getClass().getResource("obrazy/pas1.jpg");
			fileURL21 = getClass().getResource("obrazy/pas2.jpg");
			fileURL22 = getClass().getResource("obrazy/pas3.jpg");
			fileURL23 = getClass().getResource("obrazy/tor1.jpg");
			
//			fileURL1 = new URL("brans1.jpg");
//			fileURL2 = new URL("brans2.jpg");
//			fileURL3 = new URL("brans3.jpg");
//			fileURL4 = new URL("brans4.jpg");
//			fileURL5 = new URL("brans5.jpg");
//			fileURL6 = new URL("brans6.jpg");
//			fileURL7 = new URL("czap1.jpg");
//			fileURL8 = new URL("czap2.jpg");
//			fileURL9 = new URL("czap3.jpg");
//			fileURL10 = new URL("czap4.jpg");
//			fileURL11 = new URL("czap5.jpg");
//			fileURL12 = new URL("kol1.jpg");
//			fileURL13 = new URL("kol2.jpg");
//			fileURL14 = new URL("kol3.jpg");
//			fileURL15 = new URL("leg1.jpg");
//			fileURL16 = new URL("leg2.jpg");
//			fileURL17 = new URL("leg3.jpg");
//			fileURL18 = new URL("leg4.jpg");
//			fileURL19 = new URL("leg5.jpg");
//			fileURL20 = new URL("pas1.jpg");
//			fileURL21 = new URL("pas2.jpg");
//			fileURL22 = new URL("pas3.jpg");
//			fileURL23 = new URL("tor1.jpg");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
	
	@Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, this);
    }
}
