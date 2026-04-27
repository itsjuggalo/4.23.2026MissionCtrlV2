package N1;

/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f1125f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0137v f1127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f1129d = new Object();
    public volatile Object e = null;

    public /* synthetic */ D(String str, Object obj, InterfaceC0137v interfaceC0137v) {
        this.f1126a = str;
        this.f1128c = obj;
        this.f1127b = interfaceC0137v;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1129d
            monitor-enter(r0)
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L66
            if (r4 == 0) goto L7
            return r4
        L7:
            E4.c r4 = N1.K0.f1281k
            if (r4 != 0) goto Le
            java.lang.Object r4 = r3.f1128c
            return r4
        Le:
            java.lang.Object r4 = N1.D.f1125f
            monitor-enter(r4)
            boolean r0 = E4.c.a()     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L24
            java.lang.Object r0 = r3.e     // Catch: java.lang.Throwable -> L1e
            if (r0 != 0) goto L20
            java.lang.Object r0 = r3.f1128c     // Catch: java.lang.Throwable -> L1e
            goto L22
        L1e:
            r0 = move-exception
            goto L64
        L20:
            java.lang.Object r0 = r3.e     // Catch: java.lang.Throwable -> L1e
        L22:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            return r0
        L24:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            java.util.List r4 = N1.E.f1180a     // Catch: java.lang.SecurityException -> L58
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.SecurityException -> L58
        L2b:
            boolean r0 = r4.hasNext()     // Catch: java.lang.SecurityException -> L58
            if (r0 == 0) goto L58
            java.lang.Object r0 = r4.next()     // Catch: java.lang.SecurityException -> L58
            N1.D r0 = (N1.D) r0     // Catch: java.lang.SecurityException -> L58
            boolean r1 = E4.c.a()     // Catch: java.lang.SecurityException -> L58
            if (r1 != 0) goto L50
            r1 = 0
            N1.v r2 = r0.f1127b     // Catch: java.lang.IllegalStateException -> L46 java.lang.SecurityException -> L58
            if (r2 == 0) goto L46
            java.lang.Object r1 = r2.zza()     // Catch: java.lang.IllegalStateException -> L46 java.lang.SecurityException -> L58
        L46:
            java.lang.Object r2 = N1.D.f1125f     // Catch: java.lang.SecurityException -> L58
            monitor-enter(r2)     // Catch: java.lang.SecurityException -> L58
            r0.e = r1     // Catch: java.lang.Throwable -> L4d
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4d
            goto L2b
        L4d:
            r4 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4d
            throw r4     // Catch: java.lang.SecurityException -> L58
        L50:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.SecurityException -> L58
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch: java.lang.SecurityException -> L58
            throw r4     // Catch: java.lang.SecurityException -> L58
        L58:
            N1.v r4 = r3.f1127b
            if (r4 != 0) goto L5f
        L5c:
            java.lang.Object r4 = r3.f1128c
            goto L63
        L5f:
            java.lang.Object r4 = r4.zza()     // Catch: java.lang.Throwable -> L5c
        L63:
            return r4
        L64:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            throw r0
        L66:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L66
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: N1.D.a(java.lang.Object):java.lang.Object");
    }
}
