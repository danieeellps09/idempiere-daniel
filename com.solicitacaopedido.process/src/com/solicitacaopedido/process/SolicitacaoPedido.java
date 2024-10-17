package com.solicitacaopedido.process;

import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

public class SolicitacaoPedido extends SvrProcess {

    @Override
    protected void prepare() {
        log.info("Preparando o processo Aprovar pedidos");
    }

    @Override
    protected String doIt() throws Exception {
        int count = 0;
        StringBuilder aprovados = new StringBuilder();

        String sql = "SELECT C_PurchaseRequest_ID FROM C_PurchaseRequest WHERE Status = 'IP'";
        try (PreparedStatement pstmt = DB.prepareStatement(sql, get_TrxName());
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int purchaseRequestId = rs.getInt("C_PurchaseRequest_ID");
                String updateSQL = "UPDATE C_PurchaseRequest SET Status = 'CO' WHERE C_PurchaseRequest_ID = ?";

                try (PreparedStatement updatePstmt = DB.prepareStatement(updateSQL, get_TrxName())) {
                    updatePstmt.setInt(1, purchaseRequestId);
                    if (updatePstmt.executeUpdate() > 0) {
                        count++;
                        if (aprovados.length() > 0) {
                            aprovados.append(", ");
                        }
                        aprovados.append(purchaseRequestId);
                    }
                }
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Erro ao aprovar solicitações de compra", e);
            throw e;
        }

        return count + " solicitações de compra aprovadas. IDs: " + aprovados.toString();
    }
}
