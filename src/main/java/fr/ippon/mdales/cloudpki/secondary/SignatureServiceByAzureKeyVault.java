package fr.ippon.mdales.cloudpki.secondary;

import java.net.*;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.keys.cryptography.*;
import com.azure.security.keyvault.keys.cryptography.models.SignatureAlgorithm;

import fr.ippon.mdales.cloudpki.business.ISignatureService;

@Service
public class SignatureServiceByAzureKeyVault implements ISignatureService {

	final CryptographyClient cryptographyClient;

	static final String KEY_ROUTE = "/keys";

	public SignatureServiceByAzureKeyVault(AzureKeyVaultProperties azureKeyVaultProperties) throws URISyntaxException {
		this.cryptographyClient = new CryptographyClientBuilder().keyIdentifier(new URI(azureKeyVaultProperties.getUrl()).resolve(Paths.get(KEY_ROUTE, azureKeyVaultProperties.getKey().getName(), azureKeyVaultProperties.getKey().getVersion()).toString()).toString()).credential(new DefaultAzureCredentialBuilder().build()).buildClient();
	}

	@Override
	public byte[] sign(byte[] fileContent) {
		var result = cryptographyClient.signData(SignatureAlgorithm.RS256, fileContent);
		return result.getSignature();
	}
}
