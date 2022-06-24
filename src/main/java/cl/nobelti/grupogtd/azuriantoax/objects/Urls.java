package cl.nobelti.grupogtd.azuriantoax.objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Urls {

	private List<Url> urls;
	
	public List<Url> getUrls() {
		return urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}


	@Override
	public String toString() {
		return urls.toString();
	}
	
	public void getPDF(List<Url> urls) throws IOException, InterruptedException {
		for(Url str: urls) {	
			Runtime rt = Runtime.getRuntime();
			rt.exec("rundll32 url.dll,FileProtocolHandler " + str);
			
			TimeUnit.SECONDS.sleep(1);
			File directory = new File("C:\\Users\\Kevin Uribe S\\Downloads");
			File[] files = directory.listFiles();
			Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
			File lastFile = files[0];
			System.out.println(lastFile);
			File destination = new File("C:\\Users\\Kevin Uribe S\\Desktop\\facturas\\" + lastFile.getName());
		
			try {
				Files.copy(lastFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// mover a directorio correspondiente(sftp, ftp, etc)
			// TODO
		}
	}
	

}
