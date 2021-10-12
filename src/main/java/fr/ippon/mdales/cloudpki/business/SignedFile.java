package fr.ippon.mdales.cloudpki.business;

import java.io.*;
import java.util.zip.*;

public class SignedFile {

	File file;

	byte[] signature;

	public SignedFile(File file, byte[] signature) {
		this.file = file;
		this.signature = signature;
	}

	public byte[] getSignature() {
		return signature;
	}

	public byte[] toByteArray() {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byteArrayOutputStream.write(file.getFileContent());
			byteArrayOutputStream.write("\n".getBytes());
			byteArrayOutputStream.write(getSignature());
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			return new byte[0];
		}
	}

	public String getFileName() {
		return file.getFileName();
	}

}
