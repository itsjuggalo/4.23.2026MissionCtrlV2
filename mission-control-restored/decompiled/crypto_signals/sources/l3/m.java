package l3;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f8132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f8133b;

    public m(t localOverrideSettings, t remoteSettings) {
        kotlin.jvm.internal.j.e(localOverrideSettings, "localOverrideSettings");
        kotlin.jvm.internal.j.e(remoteSettings, "remoteSettings");
        this.f8132a = localOverrideSettings;
        this.f8133b = remoteSettings;
    }

    public final double a() {
        Double dB = this.f8132a.b();
        if (dB != null) {
            double dDoubleValue = dB.doubleValue();
            if (0.0d <= dDoubleValue && dDoubleValue <= 1.0d) {
                return dDoubleValue;
            }
        }
        Double dB2 = this.f8133b.b();
        if (dB2 != null) {
            double dDoubleValue2 = dB2.doubleValue();
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                return dDoubleValue2;
            }
        }
        return 1.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        if (r6.c(r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(K4.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof l3.l
            if (r0 == 0) goto L13
            r0 = r6
            l3.l r0 = (l3.l) r0
            int r1 = r0.f8131d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8131d = r1
            goto L18
        L13:
            l3.l r0 = new l3.l
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f8129b
            J4.a r1 = J4.a.f791a
            int r2 = r0.f8131d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            a.AbstractC0284a.E(r6)
            goto L57
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            l3.m r2 = r0.f8128a
            a.AbstractC0284a.E(r6)
            goto L49
        L38:
            a.AbstractC0284a.E(r6)
            r0.f8128a = r5
            r0.f8131d = r4
            l3.t r6 = r5.f8132a
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r1) goto L48
            goto L56
        L48:
            r2 = r5
        L49:
            l3.t r6 = r2.f8133b
            r2 = 0
            r0.f8128a = r2
            r0.f8131d = r3
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r1) goto L57
        L56:
            return r1
        L57:
            G4.l r6 = G4.l.f540a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.m.b(K4.c):java.lang.Object");
    }
}
