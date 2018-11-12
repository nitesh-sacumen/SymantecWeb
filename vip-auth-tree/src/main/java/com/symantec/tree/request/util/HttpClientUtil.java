package com.symantec.tree.request.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Base64;
import java.util.Properties;
import javax.net.ssl.SSLContext;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.forgerock.openam.utils.AMKeyProvider;
import org.forgerock.security.keystore.KeyStoreBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Symantec
 * Utility class to read key-store values to authenticate vip requests.
 *
 */
public class HttpClientUtil {

	static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	private static final String ADMIN_STORE_FILE_LOCATION = System.getenv("SYMANTEC_HOME");
	private static final String ADMIN_STORE_FILE = ADMIN_STORE_FILE_LOCATION + "\\symantecConfig.properties";

	/**
	 * 
	 * @param KEYSTOREPATH
	 * @param KEYSTOREPASS
	 * @return KeyStore
	 * @throws Exception
	 */
	private KeyStore readStore(String KEYSTOREPATH, String KEYSTOREPASS) throws Exception {
		logger.info("reading key store values");
		try (InputStream keyStoreStream = new FileInputStream(KEYSTOREPATH)) {
			KeyStore keyStore = KeyStore.getInstance("JKS"); // or "PKCS12"
			keyStore.load(keyStoreStream, KEYSTOREPASS.toCharArray());
			return keyStore;
		}
	}

	/**
	 * @return HttpClient
	 */
	public HttpClient getHttpClient() {
		logger.info("getting http client");
		HttpClient httpClient = null;
		Properties prop = new Properties();
		FileInputStream input;

		String KEY_STORE_PATH;
		String KEY_PASS;
		String KEY_STORE_PASS;

		try {

			input = new FileInputStream(ADMIN_STORE_FILE);

			// load a properties file
			prop.load(input);

			KEY_STORE_PATH = prop.getProperty("KeyStore.location");
			KEY_STORE_PASS = new String(Base64.getDecoder().decode(prop.getProperty("keyStore.password")));
			KEY_PASS = KEY_STORE_PASS;
			logger.debug(KEY_STORE_PATH);
			logger.debug(KEY_STORE_PASS);
			SSLContext sslContext = SSLContexts.custom()
					.loadKeyMaterial(readStore(KEY_STORE_PATH, KEY_STORE_PASS), KEY_PASS.toCharArray()).build();
			httpClient = HttpClients.custom().setSSLContext(sslContext).build();
		} catch (Exception e) {
			//TODO need to handle this with a Node Process Exception. Also should only have try catch where required,
			// not around so much extra code.
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return httpClient;
	}


	//TODO This method is not used
	/**
	 * This method is used to get key store values form forgerock configurations
	 * @return httpClient
	 * @throws FileNotFoundException
	 */
	public HttpClient getHttpClientForgerock() throws FileNotFoundException {
		logger.info("getting http client");
		HttpClient httpClient = null;

		AMKeyProvider AM = new AMKeyProvider();
		final KeyStore keyStore = new KeyStoreBuilder().withKeyStoreFile(AM.getKeystoreFilePath())
				.withPassword(AM.getKeystorePass()).withKeyStoreType(AM.getKeystoreType()).build();

		try {

			SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, AM.getKeystorePass()).build();
			httpClient = HttpClients.custom().setSSLContext(sslContext).build();
		} catch (Exception e) {
			//TODO need to handle this with a Node Process Exception or any exception which is wrapped into Node
			// Process exception in the node.
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return httpClient;
	}
}
