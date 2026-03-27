package w3;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class c0 extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() != 9) {
            return Boolean.valueOf(aVar.z());
        }
        aVar.x();
        return null;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        Boolean bool = (Boolean) obj;
        bVar.v(bool == null ? "null" : bool.toString());
    }
}
