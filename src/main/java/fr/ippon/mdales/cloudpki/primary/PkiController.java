package fr.ippon.mdales.cloudpki.primary;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class PkiController {

	@PostMapping(value = "/sign", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> sign() {
		return ResponseEntity.ok("Hello World".getBytes());
	}
}