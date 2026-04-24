package w3;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class h0 extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) {
        return new AtomicBoolean(aVar.r());
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        bVar.w(((AtomicBoolean) obj).get());
    }
}
