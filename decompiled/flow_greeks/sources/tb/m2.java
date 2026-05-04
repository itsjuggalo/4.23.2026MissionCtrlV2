package tb;

import java.io.Closeable;
import tb.l1;
import tb.p2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m2 extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1.b f21537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21538b;

    public m2(l1.b bVar) {
        this.f21537a = bVar;
    }

    @Override // tb.l0, tb.l1.b
    public void a(p2.a aVar) {
        if (!this.f21538b) {
            super.a(aVar);
        } else if (aVar instanceof Closeable) {
            r0.d((Closeable) aVar);
        }
    }

    @Override // tb.l0
    public l1.b b() {
        return this.f21537a;
    }

    @Override // tb.l0, tb.l1.b
    public void c(boolean z10) {
        this.f21538b = true;
        super.c(z10);
    }

    @Override // tb.l0, tb.l1.b
    public void e(Throwable th) {
        this.f21538b = true;
        super.e(th);
    }
}
