package com.example.lab3.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;

/**
 * Locale bean for the internationalization of the application
 */
@ManagedBean
@SessionScoped
public class LocaleBean implements Serializable {
    private Locale currentLocale;

    public LocaleBean() {
        currentLocale = new Locale("en"); // Default locale is English
    }
    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public String changeLocale(String localeCode) {
        currentLocale = new Locale(localeCode);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(currentLocale);
        return null;
    }
}

