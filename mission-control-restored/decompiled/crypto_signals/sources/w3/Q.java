package w3;

import java.io.IOException;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class Q extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        String strZ = aVar.z();
        if (strZ.equals("null")) {
            return null;
        }
        return new URL(strZ);
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        URL url = (URL) obj;
        bVar.v(url == null ? null : url.toExternalForm());
    }
}
