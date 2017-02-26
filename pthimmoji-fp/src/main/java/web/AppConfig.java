/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.TimeZone;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * App Configuration
 * @author sas691
 */
@Named
@ApplicationScoped
public class AppConfig {

    public TimeZone getDefaultTimeZone() {
        return TimeZone.getDefault();
    }
}
