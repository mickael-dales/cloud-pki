package fr.ippon.mdales.cloudpki.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FileTest {

	@Test
	void should_create_signed_file_when_sign_file() {
		File file = new File("Hello World".getBytes(), "test");

		var signedFile = file.sign(new FakeSignatureService());

		assertThat(signedFile).isInstanceOf(SignedFile.class);
		assertThat(file).isEqualTo(signedFile.file);
		assertThat(signedFile.signature).isEqualTo("Signature".getBytes());
	}

	class FakeSignatureService implements ISignatureService {

		@Override
		public byte[] sign(byte[] fileContent) {
			return "Signature".getBytes();
		}
	}
}