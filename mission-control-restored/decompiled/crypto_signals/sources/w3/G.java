package w3;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class G extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() != 9) {
            return Float.valueOf((float) aVar.s());
        }
        aVar.x();
        return null;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        Number numberValueOf = (Number) obj;
        if (numberValueOf == null) {
            bVar.m();
            return;
        }
        if (!(numberValueOf instanceof Float)) {
            numberValueOf = Float.valueOf(numberValueOf.floatValue());
        }
        bVar.u(numberValueOf);
    }
}
