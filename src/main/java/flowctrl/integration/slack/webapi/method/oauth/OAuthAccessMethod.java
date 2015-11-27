package flowctrl.integration.slack.webapi.method.oauth;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class OAuthAccessMethod extends AbstractMethod {

	public OAuthAccessMethod(String client_id, String client_secret, String code) {
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.code = code;
	}

	protected String client_id;
	protected String client_secret;
	protected String code;
	protected String redirect_uri;

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_secret() {
		return client_secret;
	}

	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRedirect_uri() {
		return redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.OAUTH_ACCESS;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (client_id == null) {
			addError(errors, "client_id", Problem.REQUIRED, null);
		}
		if (client_secret == null) {
			addError(errors, "client_secret", Problem.REQUIRED, null);
		}
		if (code == null) {
			addError(errors, "code", Problem.REQUIRED, null);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("client_id", client_id);
		parameters.put("client_secret", client_secret);
		parameters.put("code", code);
		if (redirect_uri != null) {
			parameters.put("redirect_uri", redirect_uri);
		}
	}

}
