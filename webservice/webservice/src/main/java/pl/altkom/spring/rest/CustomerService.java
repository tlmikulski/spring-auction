package pl.altkom.spring.rest;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wordnik.swagger.annotations.ApiParam;

@RestController
public class CustomerService {
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Customer find(@ApiParam("value dla id") @PathVariable Long id) {
		return new Customer(id);

	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_XHTML_XML_VALUE)
	public @ResponseBody String handleFileUpload(
			@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				File savedFile = new File(name);
				saveStreamToFile(file, savedFile);

				return "You successfully uploaded "
						+ savedFile.getAbsolutePath() + "!";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}

	private void saveStreamToFile(MultipartFile file, File savedFile)
			throws FileNotFoundException, IOException {
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(savedFile));

		byte[] bbuf = new byte[1024];
		int length = 0;
		DataInputStream in = new DataInputStream(file.getInputStream());
		while ((in != null) && ((length = in.read(bbuf)) != -1)) {
			stream.write(bbuf, 0, length);
			stream.flush();
		}

		in.close();
		stream.close();
	}

}
