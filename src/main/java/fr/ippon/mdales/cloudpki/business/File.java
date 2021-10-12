package fr.ippon.mdales.cloudpki.business;

public class File {

	private final byte[] fileContent;

	private final String fileName;

	public File(byte[] content, String fileName) {
		this.fileContent = content;
		this.fileName = fileName;
	}

	public SignedFile sign(ISignatureService signatureService) {
		return new SignedFile(this, signatureService.sign(fileContent));
	}

	public String getFileName() {
		return fileName;
	}

	public byte[] getFileContent() {
		return fileContent;
	}
}
