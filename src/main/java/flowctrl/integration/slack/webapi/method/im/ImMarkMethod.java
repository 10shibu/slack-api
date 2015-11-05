package flowctrl.integration.slack.webapi.method.im;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class ImMarkMethod extends AbstractMethod {

	public ImMarkMethod(String channel, String ts) {
		this.channel = channel;
		this.ts = ts;
	}

	protected String channel;
	protected String ts;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.IM_MARK;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (channel == null) {
			addError(errors, "channel", Problem.REQUIRED, null);
		}
		if (ts == null) {
			addError(errors, "ts", Problem.REQUIRED, null);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("channel", channel);
		parameters.put("ts", ts);
	}

}
