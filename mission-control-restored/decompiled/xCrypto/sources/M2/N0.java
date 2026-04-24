package M2;

import M2.C0433m0;
import M2.Q0;
import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public final class N0 extends L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0433m0.b f1946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1947b;

    public N0(C0433m0.b bVar) {
        this.f1946a = bVar;
    }

    @Override // M2.L, M2.C0433m0.b
    public void a(Q0.a aVar) {
        if (!this.f1947b) {
            super.a(aVar);
        } else if (aVar instanceof Closeable) {
            S.e((Closeable) aVar);
        }
    }

    @Override // M2.L
    public C0433m0.b b() {
        return this.f1946a;
    }

    @Override // M2.L, M2.C0433m0.b
    public void c(boolean z4) {
        this.f1947b = true;
        super.c(z4);
    }

    @Override // M2.L, M2.C0433m0.b
    public void e(Throwable th) {
        this.f1947b = true;
        super.e(th);
    }
}
