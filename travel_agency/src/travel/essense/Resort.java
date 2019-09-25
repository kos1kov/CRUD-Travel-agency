package travel.essense;

import org.w3c.dom.Text;

public class Resort {
    private String name;
    private Text Description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Text getDescription() {
        return Description;
    }

    public void setDescription(Text description) {
        Description = description;
    }
}
