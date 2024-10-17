package com.pedido.analisepedido.process;

import org.compiere.process.SvrProcess;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

public class FiltroPedidos extends SvrProcess {

    private String dataInicial;
    private String dataFinal;

    @Override
    protected void prepare() {
        ProcessInfoParameter[] params = getParameter();
        for (ProcessInfoParameter param : params) {
            String name = param.getParameterName();
            if (name == null) {
                continue;
            }
            if (name.equals("DataInicial")) {
                dataInicial = param.getParameter().toString();
            } else if (name.equals("DataFinal")) {
                dataFinal = param.getParameter().toString();
            }
        }

        log.info("Filtrando pedidos entre " + dataInicial + " e " + dataFinal);

        if (!isDataValida(dataInicial, dataFinal)) {
            throw new IllegalArgumentException("A data final não pode ser menor que a data inicial.");
        }
    }

    @Override
    protected String doIt() throws Exception {
        StringBuilder resultado = new StringBuilder();
        int count = 0;

        String sql = "SELECT C_PurchaseRequest_ID, DocumentNo, Status, DateRequested FROM C_PurchaseRequest "
                   + "WHERE DateRequested::date BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD')";
        try (PreparedStatement pstmt = DB.prepareStatement(sql, get_TrxName())) {
            pstmt.setString(1, dataInicial);
            pstmt.setString(2, dataFinal);
            try (ResultSet rs = pstmt.executeQuery()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                resultado.append(String.format("%-10s %-20s %-10s %-15s%n", "ID", "Documento", "Status", "Data Requerida"));
                resultado.append("-------------------------------------------------------------\n");

                while (rs.next()) {
                    int purchaseRequestId = rs.getInt("C_PurchaseRequest_ID");
                    String documentNo = rs.getString("DocumentNo");
                    String status = rs.getString("Status");
                    Date dateRequested = rs.getDate("DateRequested");

                    String formattedDate = dateRequested != null ? dateFormat.format(dateRequested) : "N/A";

                    resultado.append(String.format("%-10d %-20s %-10s %-15s%n",
                            purchaseRequestId,
                            documentNo,
                            status != null ? status : "N/A",
                            formattedDate));

                    count++;
                }
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Erro ao filtrar pedidos por intervalo de datas", e);
            throw e;
        }

        return count + " pedidos encontrados entre " + formatarData(dataInicial) + " e " + formatarData(dataFinal) + ".\n" + resultado.toString();
    }

    private String formatarData(String data) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(data);
            return outputFormat.format(date);
        } catch (Exception e) {
            return data;
        }
    }

    private boolean isDataValida(String dataInicial, String dataFinal) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dataInicio = dateFormat.parse(dataInicial);
            Date dataFim = dateFormat.parse(dataFinal);
            return !dataFim.before(dataInicio); 
        } catch (Exception e) {
            return false; 
        }
    }
}
