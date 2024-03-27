
<div class="screenlet-body">
  <#if demoPartyList?has_content>
    <table cellspacing=0 cellpadding=2 border=0 class="basic-table">
      <thead><tr>
        <th>${uiLabelMap.demoPartyId}</th>
        <th>${uiLabelMap.demoPartyTypeId}</th>
        <th>${uiLabelMap.status}</th>
        <th>${uiLabelMap.description}</th>
      </tr></thead>
      <tbody>
        <#list demoPartyList as demoParty>
          <tr>
            <td>${demoParty.demoPartyId}</td>
            <td>${demoParty.demoPartyTypeId}</td>
            <td>${demoParty.demoPartyStatus?default("NA")}</td>
            <td>${demoParty.description?default("NA")}</td>
          </tr>
        </#list>
       </tbody>
    </table>
  </#if>
</div>