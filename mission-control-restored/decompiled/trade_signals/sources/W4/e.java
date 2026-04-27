package W4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends AtomicReference implements S4.b {
    public boolean a(S4.b bVar) {
        return b.i(this, bVar);
    }

    public boolean b(S4.b bVar) {
        return b.l(this, bVar);
    }

    @Override // S4.b
    public void dispose() {
        b.a(this);
    }

    @Override // S4.b
    public boolean g() {
        return b.b((S4.b) get());
    }
}
