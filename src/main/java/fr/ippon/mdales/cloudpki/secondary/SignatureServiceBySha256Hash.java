package fr.ippon.mdales.cloudpki.secondary;

import java.security.*;

import org.springframework.stereotype.Service;

import fr.ippon.mdales.cloudpki.business.ISignatureService;

@Service
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
