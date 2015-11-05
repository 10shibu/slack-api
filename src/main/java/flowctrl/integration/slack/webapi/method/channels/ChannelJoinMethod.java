package flowctrl.integration.slack.webapi.method.channels;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class ChannelJoinMethod extends AbstractMethod {

	public ChannelJoinMethod(String name) {
		this.name = name;
	}

	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.CHANNELS_JOIN;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (name == null) {
			addError(errors, "name", Problem.REQUIRED, null);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("name", name);
	}

}
