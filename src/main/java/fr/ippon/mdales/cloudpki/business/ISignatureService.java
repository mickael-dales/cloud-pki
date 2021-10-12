package fr.ippon.mdales.cloudpki.business;

public interface ISignatureService {

	byte[] sign(byte[] fileContent);
}
