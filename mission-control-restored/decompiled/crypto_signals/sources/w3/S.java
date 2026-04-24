package w3;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes.dex */
public class S extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        try {
            String strZ = aVar.z();
            if (strZ.equals("null")) {
                return null;
            }
            return new URI(strZ);
        } catch (URISyntaxException e) {
            throw new t3.i(e);
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        URI uri = (URI) obj;
        bVar.v(uri == null ? null : uri.toASCIIString());
    }
}
