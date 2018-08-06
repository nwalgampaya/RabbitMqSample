package General;

import org.springframework.web.client.RestTemplate;

public class ReadRestService {

	public String getMessage() {

		final String uri = "http://localhost:8080/topics/1/";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
		return result;
	}
}
