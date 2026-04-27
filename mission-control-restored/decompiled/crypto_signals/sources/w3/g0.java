package w3;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class g0 extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) {
        try {
            return new AtomicInteger(aVar.t());
        } catch (NumberFormatException e) {
            throw new t3.i(e);
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        bVar.s(((AtomicInteger) obj).get());
    }
}
