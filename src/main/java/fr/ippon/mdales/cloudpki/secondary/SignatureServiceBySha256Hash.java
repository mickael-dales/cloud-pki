package fr.ippon.mdales.cloudpki.secondary;

import java.security.*;

import fr.ippon.mdales.cloudpki.business.ISignatureService;

public class SignatureServiceBySha256Hash implements ISignatureService {

	@Override
	public byte[] sign(byte[] fileContent) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			return messageDigest.digest(fileContent);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
}
