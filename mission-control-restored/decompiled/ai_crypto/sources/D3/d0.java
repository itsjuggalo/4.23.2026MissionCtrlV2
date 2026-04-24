package D3;

import D3.C0445o;
import K3.AbstractC0612b;

/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f1281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0445o.b f1282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final A3.r f1283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1284d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a0 f1285e = a0.UNKNOWN;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z0 f1286f;

    public d0(c0 c0Var, C0445o.b bVar, A3.r rVar) {
        this.f1281a = c0Var;
        this.f1283c = rVar;
        this.f1282b = bVar;
    }

    public c0 a() {
        return this.f1281a;
    }

    public boolean b() {
        if (this.f1282b != null) {
            return !r0.f1383d.equals(A3.T.CACHE);
        }
        return true;
    }

    public void c(com.google.firebase.firestore.f fVar) {
        this.f1283c.a(null, fVar);
    }

    public boolean d(a0 a0Var) {
        this.f1285e = a0Var;
        z0 z0Var = this.f1286f;
        if (z0Var == null || this.f1284d || !h(z0Var, a0Var)) {
            return false;
        }
        f(this.f1286f);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(D3.z0 r14) {
        /*
            r13 = this;
            java.util.List r0 = r14.d()
            boolean r0 = r0.isEmpty()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L15
            boolean r0 = r14.a()
            if (r0 == 0) goto L13
            goto L15
        L13:
            r0 = r2
            goto L16
        L15:
            r0 = r1
        L16:
            java.lang.String r3 = "We got a new snapshot with no changes?"
            java.lang.Object[] r4 = new java.lang.Object[r2]
            K3.AbstractC0612b.d(r0, r3, r4)
            D3.o$b r0 = r13.f1282b
            boolean r0 = r0.f1380a
            if (r0 != 0) goto L6c
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r0 = r14.d()
            java.util.Iterator r0 = r0.iterator()
        L30:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L48
            java.lang.Object r3 = r0.next()
            D3.m r3 = (D3.C0443m) r3
            D3.m$a r4 = r3.c()
            D3.m$a r5 = D3.C0443m.a.METADATA
            if (r4 == r5) goto L30
            r7.add(r3)
            goto L30
        L48:
            D3.z0 r0 = new D3.z0
            D3.c0 r4 = r14.h()
            G3.m r5 = r14.e()
            G3.m r6 = r14.g()
            boolean r8 = r14.k()
            r3.e r9 = r14.f()
            boolean r10 = r14.a()
            r11 = 1
            boolean r12 = r14.i()
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r14 = r0
        L6c:
            boolean r0 = r13.f1284d
            if (r0 != 0) goto L7c
            D3.a0 r0 = r13.f1285e
            boolean r0 = r13.h(r14, r0)
            if (r0 == 0) goto L89
            r13.f(r14)
            goto L8a
        L7c:
            boolean r0 = r13.g(r14)
            if (r0 == 0) goto L89
            A3.r r0 = r13.f1283c
            r2 = 0
            r0.a(r14, r2)
            goto L8a
        L89:
            r1 = r2
        L8a:
            r13.f1286f = r14
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: D3.d0.e(D3.z0):boolean");
    }

    public final void f(z0 z0Var) {
        AbstractC0612b.d(!this.f1284d, "Trying to raise initial event for second time", new Object[0]);
        z0 z0VarC = z0.c(z0Var.h(), z0Var.e(), z0Var.f(), z0Var.k(), z0Var.b(), z0Var.i());
        this.f1284d = true;
        this.f1283c.a(z0VarC, null);
    }

    public final boolean g(z0 z0Var) {
        if (!z0Var.d().isEmpty()) {
            return true;
        }
        z0 z0Var2 = this.f1286f;
        boolean z7 = (z0Var2 == null || z0Var2.j() == z0Var.j()) ? false : true;
        if (z0Var.a() || z7) {
            return this.f1282b.f1381b;
        }
        return false;
    }

    public final boolean h(z0 z0Var, a0 a0Var) {
        AbstractC0612b.d(!this.f1284d, "Determining whether to raise first event but already had first event.", new Object[0]);
        if (!z0Var.k() || !b()) {
            return true;
        }
        a0 a0Var2 = a0.OFFLINE;
        boolean zEquals = a0Var.equals(a0Var2);
        if (!this.f1282b.f1382c || zEquals) {
            return !z0Var.e().isEmpty() || z0Var.i() || a0Var.equals(a0Var2);
        }
        AbstractC0612b.d(z0Var.k(), "Waiting for sync, but snapshot is not from cache", new Object[0]);
        return false;
    }
}
