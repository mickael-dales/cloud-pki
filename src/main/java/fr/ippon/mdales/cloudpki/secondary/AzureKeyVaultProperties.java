package fr.ippon.mdales.cloudpki.secondary;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "azure.key-vault")
@Configuration
public class AzureKeyVaultProperties {

	private String url;

	private final Key key = new Key();

	public String getUrl() {
		return url;
	}

	public AzureKeyVaultProperties setUrl(String url) {
		this.url = url;
		return this;
	}

	public Key getKey() {
		return key;
	}

	public static class Key {

		private String name;
		private String version;

		public String getName() {
			return name;
		}

		public Key setName(String name) {
			this.name = name;
			return this;
		}

		public String getVersion() {
			return version;
		}

		public Key setVersion(String version) {
			this.version = version;
			return this;
		}
	}


}
