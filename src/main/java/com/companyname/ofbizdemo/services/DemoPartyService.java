package com.companyname.ofbizdemo.services;
import java.util.Map;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;

public class DemoPartyService {

    public static final String MODULE = DemoPartyService.class.getName();

    public static Map<String, Object> demoPartyService(DispatchContext dctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = ServiceUtil.returnSuccess();
        Delegator delegator = dctx.getDelegator();
        try {
            GenericValue demoParty = delegator.makeValue("demoParty");
            // Auto generating next sequence of ofbizDemoId primary key
            demoParty.setNextSeqId();
            // Setting up all non primary key field values from context map
            demoParty.setNonPKFields(context);
            // Creating record in database for OfbizDemo entity for prepared value
            demoParty = delegator.create(demoParty);
            result.put("demoPartyId", demoParty.getString("demoPartyId"));
             Debug.log("====This is my first Java Service implementation in Apache OFBiz. " +
            "demoParyt record created successfully with demoPartyId:"
            + demoParty.getString("demoPartyId"));

        } catch (GenericEntityException e) {
            Debug.logError(e, MODULE);
            return ServiceUtil.returnError("Error in creating record in OfbizDemo entity ........" + MODULE);
        }
        return result;
    }
} 
