package sg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f20394a = new d0("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f20395b = new d0("REUSABLE_CLAIMED");

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[Catch: all -> 0x0067, DONT_GENERATE, TryCatch #0 {all -> 0x0067, blocks: (B:11:0x003e, B:13:0x004c, B:15:0x0052, B:28:0x0091, B:18:0x0069, B:20:0x0079, B:25:0x0088, B:27:0x008e, B:33:0x009e, B:36:0x00a7, B:35:0x00a4, B:23:0x007f), top: B:45:0x003e, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(gd.e r6, java.lang.Object r7) {
        /*
            boolean r0 = r6 instanceof sg.h
            if (r0 == 0) goto Lb2
            sg.h r6 = (sg.h) r6
            java.lang.Object r0 = ng.e0.b(r7)
            ng.k0 r1 = r6.f20390d
            gd.i r2 = r6.getContext()
            boolean r1 = r1.a0(r2)
            r2 = 1
            if (r1 == 0) goto L26
            r6.f20392f = r0
            r6.f17199c = r2
            ng.k0 r7 = r6.f20390d
            gd.i r0 = r6.getContext()
            r7.Z(r0, r6)
            goto Lac
        L26:
            ng.v2 r1 = ng.v2.f17190a
            ng.i1 r1 = r1.b()
            boolean r3 = r1.l0()
            if (r3 == 0) goto L3b
            r6.f20392f = r0
            r6.f17199c = r2
            r1.h0(r6)
            goto Lac
        L3b:
            r1.j0(r2)
            gd.i r3 = r6.getContext()     // Catch: java.lang.Throwable -> L67
            ng.y1$b r4 = ng.y1.N     // Catch: java.lang.Throwable -> L67
            gd.i$b r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L67
            ng.y1 r3 = (ng.y1) r3     // Catch: java.lang.Throwable -> L67
            if (r3 == 0) goto L69
            boolean r4 = r3.isActive()     // Catch: java.lang.Throwable -> L67
            if (r4 != 0) goto L69
            java.util.concurrent.CancellationException r7 = r3.getCancellationException()     // Catch: java.lang.Throwable -> L67
            r6.a(r0, r7)     // Catch: java.lang.Throwable -> L67
            cd.r$a r0 = cd.r.f3870b     // Catch: java.lang.Throwable -> L67
            java.lang.Object r7 = cd.s.a(r7)     // Catch: java.lang.Throwable -> L67
            java.lang.Object r7 = cd.r.b(r7)     // Catch: java.lang.Throwable -> L67
            r6.resumeWith(r7)     // Catch: java.lang.Throwable -> L67
            goto L91
        L67:
            r7 = move-exception
            goto La8
        L69:
            gd.e r0 = r6.f20391e     // Catch: java.lang.Throwable -> L67
            java.lang.Object r3 = r6.f20393g     // Catch: java.lang.Throwable -> L67
            gd.i r4 = r0.getContext()     // Catch: java.lang.Throwable -> L67
            java.lang.Object r3 = sg.k0.i(r4, r3)     // Catch: java.lang.Throwable -> L67
            sg.d0 r5 = sg.k0.f20405a     // Catch: java.lang.Throwable -> L67
            if (r3 == r5) goto L7e
            ng.a3 r0 = ng.i0.m(r0, r4, r3)     // Catch: java.lang.Throwable -> L67
            goto L7f
        L7e:
            r0 = 0
        L7f:
            gd.e r5 = r6.f20391e     // Catch: java.lang.Throwable -> L9b
            r5.resumeWith(r7)     // Catch: java.lang.Throwable -> L9b
            cd.h0 r7 = cd.h0.f3852a     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto L8e
            boolean r7 = r0.O0()     // Catch: java.lang.Throwable -> L67
            if (r7 == 0) goto L91
        L8e:
            sg.k0.f(r4, r3)     // Catch: java.lang.Throwable -> L67
        L91:
            boolean r7 = r1.o0()     // Catch: java.lang.Throwable -> L67
            if (r7 != 0) goto L91
        L97:
            r1.e0(r2)
            goto Lac
        L9b:
            r7 = move-exception
            if (r0 == 0) goto La4
            boolean r0 = r0.O0()     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto La7
        La4:
            sg.k0.f(r4, r3)     // Catch: java.lang.Throwable -> L67
        La7:
            throw r7     // Catch: java.lang.Throwable -> L67
        La8:
            r6.i(r7)     // Catch: java.lang.Throwable -> Lad
            goto L97
        Lac:
            return
        Lad:
            r6 = move-exception
            r1.e0(r2)
            throw r6
        Lb2:
            r6.resumeWith(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.i.b(gd.e, java.lang.Object):void");
    }
}
