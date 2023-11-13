package com.example.laboratory5.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Locale;

/**
 * Locale bean for the internationalization of the application
 */
@Named
@RequestScoped
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

