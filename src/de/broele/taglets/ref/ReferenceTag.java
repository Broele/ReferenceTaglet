package de.broele.taglets.ref;

import com.sun.javadoc.Tag;
import com.sun.tools.doclets.Taglet;

/**
 * This class represents a reference taglet "ref" that can be used to
 * reference some sources for your code.
 *
 */
public class ReferenceTag implements Taglet {
	
	private static final String TAG = "ref";

	@Override
	public String getName() {
		return TAG;
	}


	@Override
	public boolean inConstructor() {
		return false;
	}

	@Override
	public boolean inField() {
		return false;
	}

	@Override
	public boolean inMethod() {
		return false;
	}

	@Override
	public boolean inOverview() {
		return true;
	}

	@Override
	public boolean inPackage() {
		return true;
	}

	@Override
	public boolean inType() {
		return true;
	}

	@Override
	public boolean isInlineTag() {
		return false;
	}

	@Override
	public String toString(Tag tag) {
		return toString(new Tag[]{tag});
	}

	@Override
	public String toString(Tag[] tags) {
		String result = "<h4>References:</h4>";
		int i = 0;
		for (Tag tag: tags) {
			i++;
			result += "<li>" + tag.text() + "</li>";
		}
			
		result += "";
		return result;
	}
}
