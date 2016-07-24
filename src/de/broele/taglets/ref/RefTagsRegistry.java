package de.broele.taglets.ref;

import java.util.Map;

import com.sun.tools.doclets.Taglet;

/**
 * The taglet registry to manage and register all relevant tags (right now this is only the {@link ReferenceTag "ref"} tag).
 * This registry can be used in the javadoc call to add the support for reference tags. For doing so, add the 
 * command line parameters {@code -taglet de.broele.taglets.ref.RefTagsRegistry -tagletpath path/to/the/refTags.jar}.
 *
 * Further information can be found in the web<a class="cite" href="#taglet" ></a>.
 *
 * @ref taglet Oracle. Taglet Overview. http://docs.oracle.com/javase/7/docs/technotes/guides/javadoc/taglet/overview.html
 */
public class RefTagsRegistry {
	/**
     * Register the {@link ReferenceTag} taglet.
     * @param tagletMap The taglet map to register this taglet to.
     */
    public static void register(Map tagletMap) {
       ReferenceTag tag = new ReferenceTag();
       registerTag(tagletMap, tag);
    }
    
    /**
     * Registeres a Taglet
     * @param tagletMap The map to register a taglet to.
     * @param tag The taglet.
     */
    protected static void registerTag(Map tagletMap, Taglet tag) {
    	Taglet t = (Taglet) tagletMap.get(tag.getName());
        if (t != null) {
            tagletMap.remove(tag.getName());
        }
        tagletMap.put(tag.getName(), tag);
    }
}
