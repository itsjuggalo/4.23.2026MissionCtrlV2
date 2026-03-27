package y3;

/* JADX INFO: renamed from: y3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1957k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f15988a = new F("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F f15989b = new F("REUSABLE_CLAIMED");

    /* JADX WARN: Removed duplicated region for block: B:27:0x008f A[Catch: all -> 0x0068, DONT_GENERATE, TryCatch #0 {all -> 0x0068, blocks: (B:11:0x003f, B:13:0x004d, B:15:0x0053, B:28:0x0092, B:18:0x006a, B:20:0x007a, B:25:0x0089, B:27:0x008f, B:33:0x009f, B:36:0x00a8, B:35:0x00a5, B:23:0x0080), top: B:45:0x003f, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(Z2.e r6, java.lang.Object r7, i3.k r8) {
        /*
            boolean r0 = r6 instanceof y3.C1956j
            if (r0 == 0) goto Lb3
            y3.j r6 = (y3.C1956j) r6
            java.lang.Object r8 = t3.G.b(r7, r8)
            t3.I r0 = r6.f15984d
            Z2.i r1 = r6.getContext()
            boolean r0 = r0.e0(r1)
            r1 = 1
            if (r0 == 0) goto L26
            r6.f15986f = r8
            r6.f14971c = r1
            t3.I r7 = r6.f15984d
            Z2.i r8 = r6.getContext()
            r7.d0(r8, r6)
            goto Lad
        L26:
            t3.U0 r0 = t3.U0.f14966a
            t3.g0 r0 = r0.b()
            boolean r2 = r0.n0()
            if (r2 == 0) goto L3b
            r6.f15986f = r8
            r6.f14971c = r1
            r0.j0(r6)
            goto Lad
        L3b:
            r0.l0(r1)
            r2 = 0
            Z2.i r3 = r6.getContext()     // Catch: java.lang.Throwable -> L68
            t3.w0$b r4 = t3.InterfaceC1846w0.f15039M     // Catch: java.lang.Throwable -> L68
            Z2.i$b r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L68
            t3.w0 r3 = (t3.InterfaceC1846w0) r3     // Catch: java.lang.Throwable -> L68
            if (r3 == 0) goto L6a
            boolean r4 = r3.isActive()     // Catch: java.lang.Throwable -> L68
            if (r4 != 0) goto L6a
            java.util.concurrent.CancellationException r7 = r3.getCancellationException()     // Catch: java.lang.Throwable -> L68
            r6.a(r8, r7)     // Catch: java.lang.Throwable -> L68
            W2.p$a r8 = W2.p.f5487b     // Catch: java.lang.Throwable -> L68
            java.lang.Object r7 = W2.q.a(r7)     // Catch: java.lang.Throwable -> L68
            java.lang.Object r7 = W2.p.b(r7)     // Catch: java.lang.Throwable -> L68
            r6.resumeWith(r7)     // Catch: java.lang.Throwable -> L68
            goto L92
        L68:
            r7 = move-exception
            goto La9
        L6a:
            Z2.e r8 = r6.f15985e     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = r6.f15987g     // Catch: java.lang.Throwable -> L68
            Z2.i r4 = r8.getContext()     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = y3.J.c(r4, r3)     // Catch: java.lang.Throwable -> L68
            y3.F r5 = y3.J.f15961a     // Catch: java.lang.Throwable -> L68
            if (r3 == r5) goto L7f
            t3.Z0 r8 = t3.H.g(r8, r4, r3)     // Catch: java.lang.Throwable -> L68
            goto L80
        L7f:
            r8 = r2
        L80:
            Z2.e r5 = r6.f15985e     // Catch: java.lang.Throwable -> L9c
            r5.resumeWith(r7)     // Catch: java.lang.Throwable -> L9c
            W2.E r7 = W2.E.f5463a     // Catch: java.lang.Throwable -> L9c
            if (r8 == 0) goto L8f
            boolean r7 = r8.O0()     // Catch: java.lang.Throwable -> L68
            if (r7 == 0) goto L92
        L8f:
            y3.J.a(r4, r3)     // Catch: java.lang.Throwable -> L68
        L92:
            boolean r7 = r0.q0()     // Catch: java.lang.Throwable -> L68
            if (r7 != 0) goto L92
        L98:
            r0.g0(r1)
            goto Lad
        L9c:
            r7 = move-exception
            if (r8 == 0) goto La5
            boolean r8 = r8.O0()     // Catch: java.lang.Throwable -> L68
            if (r8 == 0) goto La8
        La5:
            y3.J.a(r4, r3)     // Catch: java.lang.Throwable -> L68
        La8:
            throw r7     // Catch: java.lang.Throwable -> L68
        La9:
            r6.f(r7, r2)     // Catch: java.lang.Throwable -> Lae
            goto L98
        Lad:
            return
        Lae:
            r6 = move-exception
            r0.g0(r1)
            throw r6
        Lb3:
            r6.resumeWith(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.AbstractC1957k.b(Z2.e, java.lang.Object, i3.k):void");
    }

    public static /* synthetic */ void c(Z2.e eVar, Object obj, i3.k kVar, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            kVar = null;
        }
        b(eVar, obj, kVar);
    }
}
