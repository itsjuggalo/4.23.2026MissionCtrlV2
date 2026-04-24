package d5;

/* JADX INFO: loaded from: classes.dex */
public final class c extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final B0.k f5962f;

    public c(B0.k kVar, I4.i iVar, int i, c5.a aVar) {
        super(kVar, iVar, i, aVar);
        this.f5962f = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // d5.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(c5.s r5, I4.d r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof d5.C0525b
            if (r0 == 0) goto L13
            r0 = r6
            d5.b r0 = (d5.C0525b) r0
            int r1 = r0.f5961d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5961d = r1
            goto L1a
        L13:
            d5.b r0 = new d5.b
            K4.c r6 = (K4.c) r6
            r0.<init>(r4, r6)
        L1a:
            java.lang.Object r6 = r0.f5959b
            J4.a r1 = J4.a.f791a
            int r2 = r0.f5961d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            c5.s r5 = r0.f5958a
            a.AbstractC0284a.E(r6)
            goto L41
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            a.AbstractC0284a.E(r6)
            r0.f5958a = r5
            r0.f5961d = r3
            java.lang.Object r6 = super.b(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            c5.r r5 = (c5.r) r5
            c5.c r5 = r5.f4967d
            boolean r5 = r5.r()
            if (r5 == 0) goto L4e
            G4.l r5 = G4.l.f540a
            return r5
        L4e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.c.b(c5.s, I4.d):java.lang.Object");
    }

    @Override // d5.d
    public final d c(I4.i iVar, int i, c5.a aVar) {
        return new c(this.f5962f, iVar, i, aVar);
    }
}
