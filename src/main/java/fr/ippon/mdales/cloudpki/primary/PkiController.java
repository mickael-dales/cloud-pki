package fr.ippon.mdales.cloudpki.primary;

import java.io.IOException;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import fr.ippon.mdales.cloudpki.business.*;

@RestController
public class PkiController {

	private final ISignatureService signatureService;

	public PkiController(ISignatureService signatureService) {
		this.signatureService = signatureService;
	}

	@PostMapping(value = "/sign", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> sign(@RequestParam MultipartFile file) throws IOException {
		var signedFile = new File(file.getBytes(), file.getName()).sign(signatureService);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(signedFile.getFileName()).build().toString()).body(signedFile.toByteArray());
	}

}