package w3;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class K extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        String strZ = aVar.z();
        try {
            return v3.d.j(strZ);
        } catch (NumberFormatException e) {
            StringBuilder sbP = a3.d.p("Failed parsing '", strZ, "' as BigDecimal; at path ");
            sbP.append(aVar.n());
            throw new t3.i(sbP.toString(), e);
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        bVar.u((BigDecimal) obj);
    }
}
