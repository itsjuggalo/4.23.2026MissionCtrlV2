package w3;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class e0 extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        try {
            int iT = aVar.t();
            if (iT <= 65535 && iT >= -32768) {
                return Short.valueOf((short) iT);
            }
            StringBuilder sbO = a3.d.o("Lossy conversion from ", iT, " to short; at path ");
            sbO.append(aVar.n());
            throw new t3.i(sbO.toString());
        } catch (NumberFormatException e) {
            throw new t3.i(e);
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        if (((Number) obj) == null) {
            bVar.m();
        } else {
            bVar.s(r4.shortValue());
        }
    }
}
