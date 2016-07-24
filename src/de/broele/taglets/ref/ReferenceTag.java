package de.broele.taglets.ref;

import com.sun.javadoc.Tag;
import com.sun.tools.doclets.Taglet;

import java.io.InputStream;
import java.util.Scanner;

/**
 * This class provides the function for dealing with a {@code @ref} Tag.
 * This allows to build bibliography of relevant sources for your code.
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

		result += "<ol>";
		int i = 0;
		for (Tag tag: tags) {
			i++;
			result += Reference.fromTagText(tag.text()).toHtml();
		}
			
		result += "</ol>";
        result += "<script type='text/javascript'>";
        try {
            InputStream stream = getClass().getClassLoader().getResourceAsStream("updateCites.js");
            if (stream == null)
                System.out.println("OhOh");
            result += new Scanner(stream, "UTF-8").useDelimiter("\\A").next();
//            result += new String(Files.readAllBytes(Paths.get(getClass().getResource("updateCites.js").toURI())));
        } catch (Exception e) {
            result += "alert('" + e.toString() +"');\n";
            e.printStackTrace();
        }
        result += "</script>";
		return result;
	}
}
