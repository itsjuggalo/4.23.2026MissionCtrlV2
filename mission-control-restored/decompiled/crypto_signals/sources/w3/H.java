package w3;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class H extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() != 9) {
            return Double.valueOf(aVar.s());
        }
        aVar.x();
        return null;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            bVar.m();
        } else {
            bVar.r(number.doubleValue());
        }
    }
}
