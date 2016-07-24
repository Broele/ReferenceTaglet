package de.broele.taglets.ref;

/**
 * This class contains all information about a reference.
 *
 * @author Klaus
 */
public class Reference {
    private static int count = 0;

    private String id;   // The reference id
    private String text; // The reference text

    /**
     * Creates a new html.
     * @param id The identifier of the reference.
     * @param text The textual description of the reference.
     */
    public Reference(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public static Reference fromTagText(String text) {
        int p = text.indexOf(' ');
        if (p > 0) {
            String id = text.substring(0, p).trim();
            text = text.substring(p+1).trim();
            return new Reference(id, text);
        }
        return new Reference("ref" + (++count), text.trim());
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    /**
     * Creates the html code for displaying the reference as a list item.
     * @return A list item with the id of the reference as id tag.
     */
    public String toHtml() {
        return "<li id='" + getId() + "'>" + getText() + "</li>";
    }
}
