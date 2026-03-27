package t5;

import java.io.Closeable;
import t5.C2688m0;
import t5.Q0;

/* JADX INFO: loaded from: classes2.dex */
public final class N0 extends L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2688m0.b f23497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23498b;

    public N0(C2688m0.b bVar) {
        this.f23497a = bVar;
    }

    @Override // t5.L, t5.C2688m0.b
    public void a(Q0.a aVar) {
        if (!this.f23498b) {
            super.a(aVar);
        } else if (aVar instanceof Closeable) {
            S.d((Closeable) aVar);
        }
    }

    @Override // t5.L
    public C2688m0.b b() {
        return this.f23497a;
    }

    @Override // t5.L, t5.C2688m0.b
    public void c(boolean z7) {
        this.f23498b = true;
        super.c(z7);
    }

    @Override // t5.L, t5.C2688m0.b
    public void e(Throwable th) {
        this.f23498b = true;
        super.e(th);
    }
}
