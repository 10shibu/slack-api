package flowctrl.integration.slack;

import com.fasterxml.jackson.databind.JsonNode;

import flowctrl.integration.slack.rtm.EventListener;

public class HelloEventListener implements EventListener {

	@Override
	public void handleMessage(JsonNode message) {
		System.out.println(message);
	}

}
