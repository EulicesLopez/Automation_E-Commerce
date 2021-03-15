package com.bot.frontend.baseClass.service;

import com.bot.frontend.utility.services.HeaderConfigurations;

public class BaseClassService {

    HeaderConfigurations headerConfigurations;
    public HeaderConfigurations headerConfigurations() {
        headerConfigurations = new HeaderConfigurations();
        headerConfigurations.setHeader("Content-type", "application/json");
        headerConfigurations.setHeader("Accept", "application/json");
        return headerConfigurations;
    }



}
