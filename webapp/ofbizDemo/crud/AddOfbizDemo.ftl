<div class="screenlet-body">
  <form id="createOfbizDemoEvent" method="post" action="<@ofbizUrl>DemoPartyEvents</@ofbizUrl>">
    <input type="hidden" name="addOfbizDemoFromFtl" value="Y"/>
    <fieldset>
      <div>
        <span class="label">${uiLabelMap.demoPartyTypeId}</span>
        <select name="demoPartyTypeId" class='required'>
          <#list demoPartyTypes as demoType>
            <option value='${demoType.demoPartyTypeId}'>${demoType.demoPartyTypeId}</option>
          </#list>
        </select>
      </div>
      <div>
        <span class="label">${uiLabelMap.status}</span>
        <input type="text" name="status" id="status" class='required' maxlength="20" />*
      </div>
      <div>
        <span class="label">${uiLabelMap.description}</span>
        <input type="text" name="description" id="description" class='required' maxlength="20" />*
      </div>
    </fieldset>
    <input type="submit" value="${uiLabelMap.CommonAdd}" />
  </form>
</div>

