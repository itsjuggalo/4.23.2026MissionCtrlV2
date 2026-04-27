package i2;

/* JADX INFO: renamed from: i2.e2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1801e2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f15630g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1757Q f15632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f15633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f15634d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f15635e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f15636f = null;

    public /* synthetic */ C1801e2(String str, Object obj, Object obj2, InterfaceC1757Q interfaceC1757Q, byte[] bArr) {
        this.f15631a = str;
        this.f15633c = obj;
        this.f15632b = interfaceC1757Q;
    }

    public final String a() {
        return this.f15631a;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f15634d
            monitor-enter(r0)
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            if (r4 == 0) goto L7
            return r4
        L7:
            i2.f r4 = i2.Z1.f15472a
            if (r4 != 0) goto Le
            java.lang.Object r4 = r3.f15633c
            return r4
        Le:
            java.lang.Object r4 = i2.C1801e2.f15630g
            monitor-enter(r4)
            boolean r0 = i2.C1806f.a()     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L24
            java.lang.Object r0 = r3.f15636f     // Catch: java.lang.Throwable -> L1e
            if (r0 != 0) goto L20
            java.lang.Object r0 = r3.f15633c     // Catch: java.lang.Throwable -> L1e
            goto L22
        L1e:
            r0 = move-exception
            goto L66
        L20:
            java.lang.Object r0 = r3.f15636f     // Catch: java.lang.Throwable -> L1e
        L22:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            goto L65
        L24:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            java.util.List r4 = i2.AbstractC1809f2.b()     // Catch: java.lang.SecurityException -> L5a
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.SecurityException -> L5a
        L2d:
            boolean r0 = r4.hasNext()     // Catch: java.lang.SecurityException -> L5a
            if (r0 == 0) goto L5a
            java.lang.Object r0 = r4.next()     // Catch: java.lang.SecurityException -> L5a
            i2.e2 r0 = (i2.C1801e2) r0     // Catch: java.lang.SecurityException -> L5a
            boolean r1 = i2.C1806f.a()     // Catch: java.lang.SecurityException -> L5a
            if (r1 != 0) goto L52
            r1 = 0
            i2.Q r2 = r0.f15632b     // Catch: java.lang.IllegalStateException -> L48 java.lang.SecurityException -> L5a
            if (r2 == 0) goto L48
            java.lang.Object r1 = r2.zza()     // Catch: java.lang.IllegalStateException -> L48 java.lang.SecurityException -> L5a
        L48:
            java.lang.Object r2 = i2.C1801e2.f15630g     // Catch: java.lang.SecurityException -> L5a
            monitor-enter(r2)     // Catch: java.lang.SecurityException -> L5a
            r0.f15636f = r1     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4f
            goto L2d
        L4f:
            r4 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4f
            throw r4     // Catch: java.lang.SecurityException -> L5a
        L52:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.SecurityException -> L5a
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch: java.lang.SecurityException -> L5a
            throw r4     // Catch: java.lang.SecurityException -> L5a
        L5a:
            i2.Q r4 = r3.f15632b
            if (r4 != 0) goto L61
        L5e:
            java.lang.Object r0 = r3.f15633c
            goto L65
        L61:
            java.lang.Object r0 = r4.zza()     // Catch: java.lang.Throwable -> L5e
        L65:
            return r0
        L66:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            throw r0
        L68:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C1801e2.b(java.lang.Object):java.lang.Object");
    }
}
