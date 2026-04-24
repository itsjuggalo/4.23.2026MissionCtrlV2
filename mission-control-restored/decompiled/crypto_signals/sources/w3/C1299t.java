package w3;

import java.io.IOException;

/* JADX INFO: renamed from: w3.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1299t extends t3.s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1298s f10809b = new C1298s(new C1299t(t3.q.f10251b), 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t3.q f10810a;

    public C1299t(t3.q qVar) {
        this.f10810a = qVar;
    }

    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        int iB = aVar.B();
        int iC = S.i.c(iB);
        if (iC == 5 || iC == 6) {
            return this.f10810a.a(aVar);
        }
        if (iC == 8) {
            aVar.x();
            return null;
        }
        throw new t3.i("Expecting number, got: " + k0.a.j(iB) + "; at path " + aVar.l());
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        bVar.u((Number) obj);
    }
}
