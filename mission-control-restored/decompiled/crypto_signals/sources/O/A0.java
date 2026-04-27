package O;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class A0 implements InterfaceC0179e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j5.d f2073a = j5.e.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q3.h f2074b = new Q3.h(11);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Y3.j f2075c = new Y3.j(new z0(2, null));

    public A0(String str) {
    }

    @Override // O.InterfaceC0179e0
    public final Object a(Q q6) {
        return new Integer(((AtomicInteger) this.f2074b.f2742b).incrementAndGet());
    }

    @Override // O.InterfaceC0179e0
    public final Object b(K4.c cVar) {
        return new Integer(((AtomicInteger) this.f2074b.f2742b).get());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // O.InterfaceC0179e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(R4.l r8, K4.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof O.x0
            if (r0 == 0) goto L13
            r0 = r9
            O.x0 r0 = (O.x0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            O.x0 r0 = new O.x0
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f2311c
            J4.a r1 = J4.a.f791a
            int r2 = r0.e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L45
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.f2309a
            j5.a r8 = (j5.a) r8
            a.AbstractC0284a.E(r9)     // Catch: java.lang.Throwable -> L2f
            goto L67
        L2f:
            r9 = move-exception
            goto L71
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            j5.d r8 = r0.f2310b
            java.lang.Object r2 = r0.f2309a
            R4.l r2 = (R4.l) r2
            a.AbstractC0284a.E(r9)
            r9 = r8
            r8 = r2
            goto L57
        L45:
            a.AbstractC0284a.E(r9)
            r0.f2309a = r8
            j5.d r9 = r7.f2073a
            r0.f2310b = r9
            r0.e = r4
            java.lang.Object r2 = r9.d(r0)
            if (r2 != r1) goto L57
            goto L63
        L57:
            r0.f2309a = r9     // Catch: java.lang.Throwable -> L6d
            r0.f2310b = r5     // Catch: java.lang.Throwable -> L6d
            r0.e = r3     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L6d
            if (r8 != r1) goto L64
        L63:
            return r1
        L64:
            r6 = r9
            r9 = r8
            r8 = r6
        L67:
            j5.d r8 = (j5.d) r8
            r8.f(r5)
            return r9
        L6d:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L71:
            j5.d r8 = (j5.d) r8
            r8.f(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: O.A0.c(R4.l, K4.c):java.lang.Object");
    }

    @Override // O.InterfaceC0179e0
    public final d5.e d() {
        return this.f2075c;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // O.InterfaceC0179e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(R4.p r7, K4.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof O.y0
            if (r0 == 0) goto L13
            r0 = r8
            O.y0 r0 = (O.y0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            O.y0 r0 = new O.y0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f2320c
            J4.a r1 = J4.a.f791a
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            boolean r7 = r0.f2319b
            j5.d r0 = r0.f2318a
            a.AbstractC0284a.E(r8)     // Catch: java.lang.Throwable -> L2c
            goto L53
        L2c:
            r8 = move-exception
            goto L5d
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            a.AbstractC0284a.E(r8)
            j5.d r8 = r6.f2073a
            boolean r2 = r8.e()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L59
            r0.f2318a = r8     // Catch: java.lang.Throwable -> L59
            r0.f2319b = r2     // Catch: java.lang.Throwable -> L59
            r0.e = r3     // Catch: java.lang.Throwable -> L59
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L59
            if (r7 != r1) goto L50
            return r1
        L50:
            r0 = r8
            r8 = r7
            r7 = r2
        L53:
            if (r7 == 0) goto L58
            r0.f(r4)
        L58:
            return r8
        L59:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r2
        L5d:
            if (r7 == 0) goto L62
            r0.f(r4)
        L62:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: O.A0.e(R4.p, K4.c):java.lang.Object");
    }
}
