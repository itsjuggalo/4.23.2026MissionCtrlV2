package d5;

import O.C0195s;

/* JADX INFO: loaded from: classes.dex */
public final class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E.l f5979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0195s f5980b;

    public j(E.l lVar, C0195s c0195s) {
        this.f5979a = lVar;
        this.f5980b = c0195s;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // d5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(d5.f r9, I4.d r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof d5.i
            if (r0 == 0) goto L13
            r0 = r10
            d5.i r0 = (d5.i) r0
            int r1 = r0.f5976b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5976b = r1
            goto L18
        L13:
            d5.i r0 = new d5.i
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f5975a
            J4.a r1 = J4.a.f791a
            int r2 = r0.f5976b
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L50
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r9 = r0.f5978d
            e5.i r9 = (e5.i) r9
            a.AbstractC0284a.E(r10)     // Catch: java.lang.Throwable -> L32
            goto L7c
        L32:
            r10 = move-exception
            goto L86
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.Object r9 = r0.f5978d
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            a.AbstractC0284a.E(r10)
            goto La0
        L44:
            d5.f r9 = r0.e
            java.lang.Object r2 = r0.f5978d
            d5.j r2 = (d5.j) r2
            a.AbstractC0284a.E(r10)     // Catch: java.lang.Throwable -> L4e
            goto L63
        L4e:
            r9 = move-exception
            goto L8c
        L50:
            a.AbstractC0284a.E(r10)
            E.l r10 = r8.f5979a     // Catch: java.lang.Throwable -> L8a
            r0.f5978d = r8     // Catch: java.lang.Throwable -> L8a
            r0.e = r9     // Catch: java.lang.Throwable -> L8a
            r0.f5976b = r5     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r10 = r10.e(r9, r0)     // Catch: java.lang.Throwable -> L8a
            if (r10 != r1) goto L62
            goto L9f
        L62:
            r2 = r8
        L63:
            e5.i r10 = new e5.i
            I4.i r4 = r0.getContext()
            r10.<init>(r9, r4)
            O.s r9 = r2.f5980b     // Catch: java.lang.Throwable -> L82
            r0.f5978d = r10     // Catch: java.lang.Throwable -> L82
            r0.e = r6     // Catch: java.lang.Throwable -> L82
            r0.f5976b = r3     // Catch: java.lang.Throwable -> L82
            java.lang.Object r9 = r9.b(r10, r6, r0)     // Catch: java.lang.Throwable -> L82
            if (r9 != r1) goto L7b
            goto L9f
        L7b:
            r9 = r10
        L7c:
            r9.releaseIntercepted()
            G4.l r9 = G4.l.f540a
            return r9
        L82:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L86:
            r9.releaseIntercepted()
            throw r10
        L8a:
            r9 = move-exception
            r2 = r8
        L8c:
            d5.B r10 = new d5.B
            r10.<init>(r9)
            O.s r2 = r2.f5980b
            r0.f5978d = r9
            r0.e = r6
            r0.f5976b = r4
            java.lang.Object r10 = d5.z.a(r10, r2, r9, r0)
            if (r10 != r1) goto La0
        L9f:
            return r1
        La0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.j.e(d5.f, I4.d):java.lang.Object");
    }
}
