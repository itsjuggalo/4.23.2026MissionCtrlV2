package w3;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class J extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        int iB = aVar.B();
        if (iB != 9) {
            return iB == 8 ? Boolean.toString(aVar.r()) : aVar.z();
        }
        aVar.x();
        return null;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        bVar.v((String) obj);
    }
}
