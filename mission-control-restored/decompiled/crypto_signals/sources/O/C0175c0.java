package O;

/* JADX INFO: renamed from: O.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0175c0 extends U implements H0 {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // O.H0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r7, K4.c r8) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.reflect.InvocationTargetException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof O.C0173b0
            if (r0 == 0) goto L13
            r0 = r8
            O.b0 r0 = (O.C0173b0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            O.b0 r0 = new O.b0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f2188c
            J4.a r1 = J4.a.f791a
            int r2 = r0.e
            G4.l r3 = G4.l.f540a
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.io.FileOutputStream r7 = r0.f2187b
            java.io.FileOutputStream r0 = r0.f2186a
            a.AbstractC0284a.E(r8)     // Catch: java.lang.Throwable -> L2d
            goto L5e
        L2d:
            r7 = move-exception
            goto L6e
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            a.AbstractC0284a.E(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r6.f2161c
            boolean r8 = r8.get()
            if (r8 != 0) goto L74
            java.io.FileOutputStream r8 = new java.io.FileOutputStream
            java.io.File r2 = r6.f2159a
            r8.<init>(r2)
            O.u0 r2 = r6.f2160b     // Catch: java.lang.Throwable -> L6c
            O.E0 r5 = new O.E0     // Catch: java.lang.Throwable -> L6c
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L6c
            r0.f2186a = r8     // Catch: java.lang.Throwable -> L6c
            r0.f2187b = r8     // Catch: java.lang.Throwable -> L6c
            r0.e = r4     // Catch: java.lang.Throwable -> L6c
            r2.b(r7, r5)     // Catch: java.lang.Throwable -> L6c
            if (r3 != r1) goto L5c
            return r1
        L5c:
            r7 = r8
            r0 = r7
        L5e:
            java.io.FileDescriptor r7 = r7.getFD()     // Catch: java.lang.Throwable -> L2d
            r7.sync()     // Catch: java.lang.Throwable -> L2d
            r7 = 0
            F1.h.g(r0, r7)
            return r3
        L6a:
            r0 = r8
            goto L6e
        L6c:
            r7 = move-exception
            goto L6a
        L6e:
            throw r7     // Catch: java.lang.Throwable -> L6f
        L6f:
            r8 = move-exception
            F1.h.g(r0, r7)
            throw r8
        L74:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "This scope has already been closed."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: O.C0175c0.a(java.lang.Object, K4.c):java.lang.Object");
    }
}
