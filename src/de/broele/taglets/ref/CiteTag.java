package de.broele.taglets.ref;

import com.sun.javadoc.Tag;
import com.sun.tools.doclets.Taglet;

import java.util.Map;

/**
 * This class adds support for a "cite" - tag that allows to cite references, specified by the {@link ReferenceTag ref - tag}.
 */
public class CiteTag implements Taglet {

    private static final String TAG = "cite";

    @Override
    public boolean inField() {
        return true;
    }

    @Override
    public boolean inConstructor() {
        return true;
    }

    @Override
    public boolean inMethod() {
        return true;
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
        return true;
    }

    @Override
    public String getName() {
        return TAG;
    }

    @Override
    public String toString(Tag tag) {
        return "<a class=\"cite\" href=\"#" + tag.text() + "\" ></a>";
    }

    @Override
    public String toString(Tag[] tags) {
        return null;
    }

    public static void register(Map tagletMap) {
        tagletMap.put(TAG, new CiteTag());
    }
}
