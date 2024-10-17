package com.mom.process;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

public class MoMDurationTime extends SvrProcess {

    @Override
    protected void prepare() {
       log.info("Preparando o processo MoMDurationTime.");
    }

    @Override
    protected String doIt() throws Exception {
        log.info("Processo MoMDurationTime iniciado.");
        
        String sql = "UPDATE C_Mom SET duration = ABS(EXTRACT(EPOCH FROM (end_time - start_time)) / 60) "
                   + "WHERE start_time IS NOT NULL AND end_time IS NOT NULL AND duration is NOT NULL";
        
        int updatedRows = DB.executeUpdate(sql, get_TrxName());

        if (updatedRows < 0) {
            throw new Exception("Erro ao atualizar os registros.");
        }

        return updatedRows + " registros atualizados com sucesso!";
    }

}
