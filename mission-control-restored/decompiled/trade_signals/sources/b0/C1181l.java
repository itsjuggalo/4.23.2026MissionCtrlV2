package b0;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: b0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1181l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.o f12768a;

    public C1181l() {
        M m8 = M.f12588b;
        AbstractC2304t.d(m8, "null cannot be cast to non-null type androidx.datastore.core.State<T of androidx.datastore.core.DataStoreInMemoryCache>");
        this.f12768a = b7.u.a(m8);
    }

    public final I a() {
        return (I) this.f12768a.getValue();
    }

    public final b7.d b() {
        return this.f12768a;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b0.I c(b0.I r6) {
        /*
            r5 = this;
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.AbstractC2304t.f(r6, r0)
            b7.o r0 = r5.f12768a
        L7:
            java.lang.Object r1 = r0.getValue()
            r2 = r1
            b0.I r2 = (b0.I) r2
            boolean r3 = r2 instanceof b0.C1168B
            if (r3 == 0) goto L14
            r3 = 1
            goto L1a
        L14:
            b0.M r3 = b0.M.f12588b
            boolean r3 = kotlin.jvm.internal.AbstractC2304t.b(r2, r3)
        L1a:
            if (r3 == 0) goto L1d
            goto L2b
        L1d:
            boolean r3 = r2 instanceof b0.C1175f
            if (r3 == 0) goto L2d
            int r3 = r6.a()
            int r4 = r2.a()
            if (r3 <= r4) goto L31
        L2b:
            r2 = r6
            goto L31
        L2d:
            boolean r3 = r2 instanceof b0.r
            if (r3 == 0) goto L38
        L31:
            boolean r1 = r0.b(r1, r2)
            if (r1 == 0) goto L7
            return r2
        L38:
            o5.o r6 = new o5.o
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.C1181l.c(b0.I):b0.I");
    }
}
