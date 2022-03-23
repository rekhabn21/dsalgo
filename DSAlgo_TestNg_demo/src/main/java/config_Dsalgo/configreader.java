package config_Dsalgo;
import java.util.*;
import java.io.*;
public class configreader {
		
		public static void main(String[] args)throws Exception{
		FileReader reader=new FileReader("Config.properties");
		Properties p=new Properties();
		p.load(reader);
	}

}
