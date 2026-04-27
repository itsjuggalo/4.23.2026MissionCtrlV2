package S1;

/* JADX INFO: renamed from: S1.e2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0561e2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f4471g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q f4473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4475d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f4476e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f4477f = null;

    public /* synthetic */ C0561e2(String str, Object obj, Object obj2, Q q4, byte[] bArr) {
        this.f4472a = str;
        this.f4474c = obj;
        this.f4473b = q4;
    }

    public final String a() {
        return this.f4472a;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f4475d
            monitor-enter(r0)
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            if (r4 == 0) goto L7
            return r4
        L7:
            S1.f r4 = S1.Z1.f4313a
            if (r4 != 0) goto Le
            java.lang.Object r4 = r3.f4474c
            return r4
        Le:
            java.lang.Object r4 = S1.C0561e2.f4471g
            monitor-enter(r4)
            boolean r0 = S1.C0566f.a()     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L24
            java.lang.Object r0 = r3.f4477f     // Catch: java.lang.Throwable -> L1e
            if (r0 != 0) goto L20
            java.lang.Object r0 = r3.f4474c     // Catch: java.lang.Throwable -> L1e
            goto L22
        L1e:
            r0 = move-exception
            goto L66
        L20:
            java.lang.Object r0 = r3.f4477f     // Catch: java.lang.Throwable -> L1e
        L22:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            return r0
        L24:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            java.util.List r4 = S1.AbstractC0569f2.b()     // Catch: java.lang.SecurityException -> L5a
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.SecurityException -> L5a
        L2d:
            boolean r0 = r4.hasNext()     // Catch: java.lang.SecurityException -> L5a
            if (r0 == 0) goto L5a
            java.lang.Object r0 = r4.next()     // Catch: java.lang.SecurityException -> L5a
            S1.e2 r0 = (S1.C0561e2) r0     // Catch: java.lang.SecurityException -> L5a
            boolean r1 = S1.C0566f.a()     // Catch: java.lang.SecurityException -> L5a
            if (r1 != 0) goto L52
            r1 = 0
            S1.Q r2 = r0.f4473b     // Catch: java.lang.IllegalStateException -> L48 java.lang.SecurityException -> L5a
            if (r2 == 0) goto L48
            java.lang.Object r1 = r2.zza()     // Catch: java.lang.IllegalStateException -> L48 java.lang.SecurityException -> L5a
        L48:
            java.lang.Object r2 = S1.C0561e2.f4471g     // Catch: java.lang.SecurityException -> L5a
            monitor-enter(r2)     // Catch: java.lang.SecurityException -> L5a
            r0.f4477f = r1     // Catch: java.lang.Throwable -> L4f
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
            S1.Q r4 = r3.f4473b
            if (r4 != 0) goto L61
        L5e:
            java.lang.Object r4 = r3.f4474c
            goto L65
        L61:
            java.lang.Object r4 = r4.zza()     // Catch: java.lang.Throwable -> L5e
        L65:
            return r4
        L66:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            throw r0
        L68:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0561e2.b(java.lang.Object):java.lang.Object");
    }
}
