package R2;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f2791c = new m(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.n f2792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f2793b;

    public m(Q2.n nVar, Boolean bool) {
        D1.b.w("Precondition can specify \"exists\" or \"updateTime\" but not both", nVar == null || bool == null, new Object[0]);
        this.f2792a = nVar;
        this.f2793b = bool;
    }

    public static m a(boolean z6) {
        return new m(null, Boolean.valueOf(z6));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(Q2.k r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            Q2.n r2 = r4.f2792a
            if (r2 == 0) goto L15
            boolean r3 = r5.d()
            if (r3 == 0) goto L24
            Q2.n r5 = r5.f2681c
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L24
            goto L23
        L15:
            java.lang.Boolean r3 = r4.f2793b
            if (r3 == 0) goto L25
            boolean r2 = r3.booleanValue()
            boolean r5 = r5.d()
            if (r2 != r5) goto L24
        L23:
            return r1
        L24:
            return r0
        L25:
            if (r2 != 0) goto L2b
            if (r3 != 0) goto L2b
            r5 = r1
            goto L2c
        L2b:
            r5 = r0
        L2c:
            java.lang.String r2 = "Precondition should be empty"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            D1.b.w(r2, r5, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.m.b(Q2.k):boolean");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            Q2.n nVar = mVar.f2792a;
            Q2.n nVar2 = this.f2792a;
            if (nVar2 == null ? nVar != null : !nVar2.equals(nVar)) {
                return false;
            }
            Boolean bool = mVar.f2793b;
            Boolean bool2 = this.f2793b;
            if (bool2 != null) {
                return bool2.equals(bool);
            }
            if (bool == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Q2.n nVar = this.f2792a;
        int iHashCode = (nVar != null ? nVar.f2688a.hashCode() : 0) * 31;
        Boolean bool = this.f2793b;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        Boolean bool = this.f2793b;
        Q2.n nVar = this.f2792a;
        if (nVar == null && bool == null) {
            return "Precondition{<none>}";
        }
        if (nVar != null) {
            return "Precondition{updateTime=" + nVar + "}";
        }
        if (bool == null) {
            D1.b.n("Invalid Precondition", new Object[0]);
            throw null;
        }
        return "Precondition{exists=" + bool + "}";
    }
}
