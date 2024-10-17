package com.purchase.process;

import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

public class ApprovePurchaseRequestsProcess extends SvrProcess {

    @Override
    protected void prepare() {
    }

    @Override
    protected String doIt() throws Exception {
        int count = 0;

        String sql = "SELECT C_PurchaseRequest_ID FROM C_PurchaseRequest WHERE Status = 'Pendente'";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = DB.prepareStatement(sql, get_TrxName());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String updateSQL = "UPDATE C_PurchaseRequest SET Status = 'Aprovado' WHERE C_PurchaseRequest_ID = ?";
                PreparedStatement updatePstmt = DB.prepareStatement(updateSQL, get_TrxName());
                updatePstmt.setInt(1, rs.getInt("C_PurchaseRequest_ID"));
                if (updatePstmt.executeUpdate() > 0) {
                    count++;
                }
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Erro ao aprovar solicitações de compra", e);
            throw e;
        } finally {
            DB.close(rs, pstmt);
        }

        return count + " solicitações de compra aprovadas.";
    }
}
