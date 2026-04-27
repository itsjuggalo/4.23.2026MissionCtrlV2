package w3;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class L extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        String strZ = aVar.z();
        try {
            v3.d.d(strZ);
            return new BigInteger(strZ);
        } catch (NumberFormatException e) {
            StringBuilder sbP = a3.d.p("Failed parsing '", strZ, "' as BigInteger; at path ");
            sbP.append(aVar.n());
            throw new t3.i(sbP.toString(), e);
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        bVar.u((BigInteger) obj);
    }
}
