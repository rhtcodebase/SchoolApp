/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolapp.utilities;

/**
 *
 * @author prohit
 */
public class Template {
    private String templateId;
    private String shortForm;
    private String Description;

    public Template(String templateId, String shortForm, String Description) {
        this.templateId = templateId;
        this.shortForm = shortForm;
        this.Description = Description;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getShortForm() {
        return shortForm;
    }

    public void setShortForm(String shortForm) {
        this.shortForm = shortForm;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
    
}
