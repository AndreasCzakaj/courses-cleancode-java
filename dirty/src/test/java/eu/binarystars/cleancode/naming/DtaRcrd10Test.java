package eu.binarystars.cleancode.naming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DtaRcrd10Test {

    @Test
    void DtaRcrd10() {
        var dataRecord = new DtaRcrd10();
        dataRecord.serverProt = "12345";
        
        assertThat(dataRecord.serverProt).isEqualTo("12345");
    }
}
