package g9;

import g9.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f10174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o.b f10175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d9.r f10176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10177d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z0 f10178e = z0.UNKNOWN;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y1 f10179f;

    public c1(b1 b1Var, o.b bVar, d9.r rVar) {
        this.f10174a = b1Var;
        this.f10176c = rVar;
        this.f10175b = bVar;
    }

    public b1 a() {
        return this.f10174a;
    }

    public boolean b() {
        if (this.f10175b != null) {
            return !r0.f10303d.equals(d9.s0.CACHE);
        }
        return true;
    }

    public void c(com.google.firebase.firestore.f fVar) {
        this.f10176c.a(null, fVar);
    }

    public boolean d(z0 z0Var) {
        this.f10178e = z0Var;
        y1 y1Var = this.f10179f;
        if (y1Var == null || this.f10177d || !h(y1Var, z0Var)) {
            return false;
        }
        f(this.f10179f);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(g9.y1 r14) {
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
            n9.b.d(r0, r3, r4)
            g9.o$b r0 = r13.f10175b
            boolean r0 = r0.f10300a
            if (r0 != 0) goto L6b
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r0 = r14.d()
            java.util.Iterator r0 = r0.iterator()
        L30:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L48
            java.lang.Object r3 = r0.next()
            g9.m r3 = (g9.m) r3
            g9.m$a r4 = r3.c()
            g9.m$a r5 = g9.m.a.METADATA
            if (r4 == r5) goto L30
            r7.add(r3)
            goto L30
        L48:
            g9.y1 r3 = new g9.y1
            g9.b1 r4 = r14.h()
            j9.m r5 = r14.e()
            j9.m r6 = r14.g()
            boolean r8 = r14.k()
            g8.e r9 = r14.f()
            boolean r10 = r14.a()
            r11 = 1
            boolean r12 = r14.i()
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r14 = r3
        L6b:
            boolean r0 = r13.f10177d
            if (r0 != 0) goto L7b
            g9.z0 r0 = r13.f10178e
            boolean r0 = r13.h(r14, r0)
            if (r0 == 0) goto L88
            r13.f(r14)
            goto L89
        L7b:
            boolean r0 = r13.g(r14)
            if (r0 == 0) goto L88
            d9.r r0 = r13.f10176c
            r2 = 0
            r0.a(r14, r2)
            goto L89
        L88:
            r1 = r2
        L89:
            r13.f10179f = r14
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.c1.e(g9.y1):boolean");
    }

    public final void f(y1 y1Var) {
        n9.b.d(!this.f10177d, "Trying to raise initial event for second time", new Object[0]);
        y1 y1VarC = y1.c(y1Var.h(), y1Var.e(), y1Var.f(), y1Var.k(), y1Var.b(), y1Var.i());
        this.f10177d = true;
        this.f10176c.a(y1VarC, null);
    }

    public final boolean g(y1 y1Var) {
        if (!y1Var.d().isEmpty()) {
            return true;
        }
        y1 y1Var2 = this.f10179f;
        boolean z10 = (y1Var2 == null || y1Var2.j() == y1Var.j()) ? false : true;
        if (y1Var.a() || z10) {
            return this.f10175b.f10301b;
        }
        return false;
    }

    public final boolean h(y1 y1Var, z0 z0Var) {
        n9.b.d(!this.f10177d, "Determining whether to raise first event but already had first event.", new Object[0]);
        if (!y1Var.k() || !b()) {
            return true;
        }
        z0 z0Var2 = z0.OFFLINE;
        boolean zEquals = z0Var.equals(z0Var2);
        if (!this.f10175b.f10302c || zEquals) {
            return !y1Var.e().isEmpty() || y1Var.i() || z0Var.equals(z0Var2);
        }
        n9.b.d(y1Var.k(), "Waiting for sync, but snapshot is not from cache", new Object[0]);
        return false;
    }
}
