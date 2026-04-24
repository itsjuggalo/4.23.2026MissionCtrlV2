package G4;

import G4.C0541m0;
import G4.Q0;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class N0 extends L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0541m0.b f2534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2535b;

    public N0(C0541m0.b bVar) {
        this.f2534a = bVar;
    }

    @Override // G4.L, G4.C0541m0.b
    public void a(Q0.a aVar) {
        if (!this.f2535b) {
            super.a(aVar);
        } else if (aVar instanceof Closeable) {
            S.e((Closeable) aVar);
        }
    }

    @Override // G4.L
    public C0541m0.b b() {
        return this.f2534a;
    }

    @Override // G4.L, G4.C0541m0.b
    public void c(boolean z7) {
        this.f2535b = true;
        super.c(z7);
    }

    @Override // G4.L, G4.C0541m0.b
    public void e(Throwable th) {
        this.f2535b = true;
        super.e(th);
    }
}
