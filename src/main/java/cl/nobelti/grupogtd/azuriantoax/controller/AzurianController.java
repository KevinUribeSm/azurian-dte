package cl.nobelti.grupogtd.azuriantoax.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.nobelti.grupogtd.azuriantoax.objects.Url;
import cl.nobelti.grupogtd.azuriantoax.objects.Urls;

@RestController
@RequestMapping("/azurian/dte")
public class AzurianController {
	
	private List<Url> urls;
	
	@PostMapping
	public ResponseEntity<?> saveUrl(@RequestBody Urls url) throws IOException, InterruptedException {
		urls = url.getUrls();
		url.getPDF(urls);

		return ResponseEntity.status(HttpStatus.OK).body(url);
	}

}
