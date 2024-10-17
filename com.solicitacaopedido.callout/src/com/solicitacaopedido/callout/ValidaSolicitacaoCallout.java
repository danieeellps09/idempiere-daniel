package com.solicitacaopedido.callout;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;

import java.util.Properties;

public class ValidaSolicitacaoCallout extends CalloutEngine {

    public String generateDocumentNo(Properties ctx, int windowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
        String documentNo = (String) mTab.getValue("DocumentNo");
        if (documentNo != null && !documentNo.trim().isEmpty()) {
            return "";
        }

        String prefix = "REQ-";
        String year = String.valueOf(java.time.Year.now().getValue());
        int nextSeq = getNextSequenceNumber();

        String newDocumentNo = prefix + year + "-" + String.format("%04d", nextSeq);
        mTab.setValue("DocumentNo", newDocumentNo);

        return "";
    }

    private int getNextSequenceNumber() {
        String sql = "SELECT COALESCE(MAX(CAST(SUBSTRING(DocumentNo, 10, 4) AS INTEGER)), 0) + 1 FROM C_PurchaseRequest WHERE DocumentNo LIKE 'REQ-%'";
        return DB.getSQLValue(null, sql);
    }
}
