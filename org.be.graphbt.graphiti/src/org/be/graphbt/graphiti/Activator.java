package org.be.graphbt.graphiti;

import java.util.StringTokenizer;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	// The plug-in ID

	private static final String GRAPHBT_PREFERENCE = "graphbt";

	private static final String DEFAULT_GRAPHBT = "graphbt_default";

	private static final String PREFERENCE_DELIMITER = ";";

	private static final String GIT_ACCOUNT_PREFERENCE = "git";

	// The plug-in ID
	public static final String PLUGIN_ID = "org.be.graphbt.graphiti"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/** 
	 * Initializes a preference store with default preference values 
	 * for this plug-in.
	 * @param store the preference store to fill
	 */
	protected void initializeDefaultPreferences(IPreferenceStore store) {
		store.setDefault(GRAPHBT_PREFERENCE, DEFAULT_GRAPHBT);
		//PreferenceConverter.setDefault(store,GIT_ACCOUNT,"");
	}
	
	/**
	 * Return the bad words preference default
	 * as an array of Strings.
	 * @return String[]
	 */
	public String[] getDefaultBadWordsPreference() {
		return convert(
			getPreferenceStore().getDefaultString(GRAPHBT_PREFERENCE));
	}

	/**
	 * Return the bad words preference as an array of
	 * Strings.
	 * @return String[]
	 */
	public String[] getBadWordsPreference() {
		return convert(getPreferenceStore().getString(GRAPHBT_PREFERENCE));
	}

	/**
	 * Convert the supplied PREFERENCE_DELIMITER delimited
	 * String to a String array.
	 * @return String[]
	 */
	private String[] convert(String preferenceValue) {
		StringTokenizer tokenizer =
			new StringTokenizer(preferenceValue, PREFERENCE_DELIMITER);
		int tokenCount = tokenizer.countTokens();
		String[] elements = new String[tokenCount];

		for (int i = 0; i < tokenCount; i++) {
			elements[i] = tokenizer.nextToken();
		}

		return elements;
	}

	/**
	 * Set the bad words preference
	 * @param String [] elements - the Strings to be 
	 * 	converted to the preference value
	 */
	public void setGitAccountPreference(String[] elements) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < elements.length; i++) {
			buffer.append(elements[i]);
			buffer.append(PREFERENCE_DELIMITER);
		}
		getPreferenceStore().setValue(GIT_ACCOUNT_PREFERENCE, buffer.toString());
	}

	/**
	 * Set the bad words preference
	 * @param String [] elements - the Strings to be 
	 * 	converted to the preference value
	 */
	public String[] getGitAccountPreference() {
		return convert(getPreferenceStore().getString(GIT_ACCOUNT_PREFERENCE));
	}	
	public String[] getDefaultGitAccountPreference() {
		// TODO Auto-generated method stub
		return convert(
				getPreferenceStore().getDefaultString(GIT_ACCOUNT_PREFERENCE));
	}
}
