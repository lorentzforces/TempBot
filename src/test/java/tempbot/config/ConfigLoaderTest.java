package tempbot.config;

import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class
ConfigLoaderTest {

	private static final String TEST_CLIENT_CONFIG_FILE = "test-load-client-config.yml";

	InputStream testClientConfigFileStream;

	@Before
	public void
	setup() {
		testClientConfigFileStream =
				Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream(TEST_CLIENT_CONFIG_FILE);
	}

	@Test
	public void
	loadingConfigurationProducesConfigObject() throws Exception {
		ClientConfig clientConfig = ConfigLoader.loadConfigurationFromFile(testClientConfigFileStream);

		assertThat(clientConfig.clientId, is("test-client-id"));
		assertThat(clientConfig.secret, is("test-secret"));
	}

}