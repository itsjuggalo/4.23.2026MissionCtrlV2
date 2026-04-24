package w3;

import java.io.IOException;
import java.util.Currency;

/* JADX INFO: loaded from: classes.dex */
public class V extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        String strZ = aVar.z();
        try {
            return Currency.getInstance(strZ);
        } catch (IllegalArgumentException e) {
            StringBuilder sbP = a3.d.p("Failed parsing '", strZ, "' as Currency; at path ");
            sbP.append(aVar.n());
            throw new t3.i(sbP.toString(), e);
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        bVar.v(((Currency) obj).getCurrencyCode());
    }
}
