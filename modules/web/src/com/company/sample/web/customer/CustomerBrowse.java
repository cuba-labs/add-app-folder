package com.company.sample.web.customer;

import com.haulmont.cuba.core.entity.AppFolder;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractLookup;

import javax.inject.Inject;

public class CustomerBrowse extends AbstractLookup {

    @Inject
    private Metadata metadata;
    @Inject
    private DataManager dataManager;

    public void onAddFolderClick() {
        AppFolder appFolder = metadata.create(AppFolder.class);
        appFolder.setName("My customers");
        appFolder.setFilterComponentId("[sample$Customer.browse].filter");
        appFolder.setTabName("My customers");
        appFolder.setFilterXml("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<filter>\n" +
                "  <and>\n" +
                "    <c name=\"name\" class=\"java.lang.String\" operatorType=\"CONTAINS\" width=\"1\" type=\"PROPERTY\"><![CDATA[e.name like :component$filter.name63023 ESCAPE '\\' ]]>\n" +
                "      <param name=\"component$filter.name63023\" javaClass=\"java.lang.String\">NULL</param>\n" +
                "    </c>\n" +
                "  </and>\n" +
                "</filter>");
        dataManager.commit(appFolder);
        showNotification("AppFolder has been added. Re-login to see it.");
    }
}