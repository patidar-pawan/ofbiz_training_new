package com.companyname.ofbizdemo.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;

public class DemoPartyEvents {

    public static final String MODULE = DemoPartyEvents.class.getName();

    public static String DemoPartyEvents(HttpServletRequest request, HttpServletResponse response) {
        Delegator delegator = (Delegator) request.getAttribute("delegator");
        LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");

        String demoPartyTypeId = request.getParameter("demoPartyTypeId");
        String demoPartyStatus = request.getParameter("status");
        String description = request.getParameter("description");

        if (UtilValidate.isEmpty(demoPartyStatus) || UtilValidate.isEmpty(description)) {
            String errMsg = "First Name and Last Name are required fields on the form and can't be empty";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }

        try {
            Debug.logInfo("=======Creating OfbizDemo record in event using service createOfbizDemoByGroovyService=========", MODULE);
            dispatcher.runSync("demoPartyService", UtilMisc.toMap("demoPartyTypeId", demoPartyTypeId,
                    "demoPartyStatus", demoPartyStatus, "description", description, "userLogin", userLogin));
        } catch (GenericServiceException e) {
            String errMsg = "Unable to create new records in OfbizDemo entity: " + e.toString();
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
        request.setAttribute("_EVENT_MESSAGE_", "party add Demo created succesfully.");
        return "success";
    }
}