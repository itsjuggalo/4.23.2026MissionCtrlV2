package w3;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class f0 extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        try {
            return Integer.valueOf(aVar.t());
        } catch (NumberFormatException e) {
            throw new t3.i(e);
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        if (((Number) obj) == null) {
            bVar.m();
        } else {
            bVar.s(r4.intValue());
        }
    }
}
