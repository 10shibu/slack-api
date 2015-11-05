package flowctrl.integration.slack.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class ChannelNameValidator {

	private static final String CHANNEL_NAME_REGEX = "^[a-z0-9]{1}[a-z0-9-_]{0,20}$";
	private static final Set<String> RESERVED_WORDS = new HashSet<String>(Arrays.asList(
		"archive", "archived", "archives", "all", "channel",
		"channels", "create", "delete", "deleted-channel", "edit",
		"everyone", "general", "group", "groups", "here", "me",
		"ms", "slack", "slackbot", "today", "you")
	);
	
	public static final String ERROR_MSG = "check the link. https://slack.zendesk.com/hc/en-us/articles/201402297-Creating-a-channel";

	/**
	 * <p> Channel names can be up to 21 characters in length, and may include
	 * lowercase letters, numbers, hyphens(-), underscore(_). </p>
	 * 
	 * <p> Channel Names cannot be a single hyphen(-) or underscore(_). </p>
	 * 
	 * <p> Some names are reserved, which means they can't be used for channels
	 * or @usernames in Slack. These are: archive, archived, archives, all,
	 * channel, channels, create, delete, deleted-channel, edit, everyone,
	 * general, group, groups, here, me, ms, slack, slackbot, today, you. </p>
	 * 
	 * @param name
	 * @return
	 */
	public static boolean valid(String name) {
		return !(name == null || !name.matches(CHANNEL_NAME_REGEX) || RESERVED_WORDS.contains(name));
	}
	
}
