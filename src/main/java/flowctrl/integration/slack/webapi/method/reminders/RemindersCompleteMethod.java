package flowctrl.integration.slack.webapi.method.reminders;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

public class RemindersCompleteMethod extends AbstractMethod {


    private final String reminderId;

    public RemindersCompleteMethod(String reminderId) {

        this.reminderId = reminderId;
    }

    @Override
    public String getMethodName() {
        return SlackWebApiConstants.REMINDERS_COMPLETE;
    }

    @Override
    public void validate(List<ValidationError> errors) {
        if (reminderId == null) {
            addError(errors, "reminder", Problem.REQUIRED);
        }
    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        parameters.put("reminder", reminderId);
    }

}
