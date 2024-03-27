import org.apache.ofbiz.entity.GenericEntityException;

def demoPartyServiceUsingGroovyMethod() {
    result = [:];
    try {
        demoParty = delegator.makeValue("demoParty");
        // Auto generating next sequence of ofbizDemoId primary key
        demoParty.setNextSeqId();
        // Setting up all non primary key field values from context map
        demoParty.setNonPKFields(context);
        // Creating record in database for OfbizDemo entity for prepared value
        demoParty = delegator.create(demoParty);
        result.demoParytId = demoParty.demoPartyId;
        logInfo("==========This is my first Groovy Service implementation in Apache OFBiz. OfbizDemo record "
                + "created successfully with ofbizDemoId: "+demoParty.getString("demoPartyId"));
    } catch (GenericEntityException e) {
        logError(e.getMessage());
        return error("Error in creating record in OfbizDemo entity ........");
    }
    return result;
}