package com.google.android.play.core.integrity;

/* JADX INFO: loaded from: classes.dex */
final class ao extends IntegrityTokenRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f5353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f5354c = null;

    public /* synthetic */ ao(String str, Long l6, Object obj, an anVar) {
        this.f5352a = str;
        this.f5353b = l6;
    }

    private static boolean a() {
        return true;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final Long cloudProjectNumber() {
        return this.f5353b;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof com.google.android.play.core.integrity.IntegrityTokenRequest
            r2 = 0
            if (r1 == 0) goto L24
            r1 = r6
            com.google.android.play.core.integrity.IntegrityTokenRequest r1 = (com.google.android.play.core.integrity.IntegrityTokenRequest) r1
            java.lang.String r3 = r5.f5352a
            java.lang.String r4 = r1.nonce()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L24
            java.lang.Long r3 = r5.f5353b
            if (r3 != 0) goto L26
            java.lang.Long r1 = r1.cloudProjectNumber()
            if (r1 != 0) goto L24
        L22:
            r1 = r0
            goto L31
        L24:
            r1 = r2
            goto L31
        L26:
            java.lang.Long r1 = r1.cloudProjectNumber()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L24
            goto L22
        L31:
            boolean r3 = r6 instanceof com.google.android.play.core.integrity.ao
            if (r3 == 0) goto L43
            boolean r3 = a()
            if (r3 == 0) goto L43
            com.google.android.play.core.integrity.ao r6 = (com.google.android.play.core.integrity.ao) r6
            if (r1 == 0) goto L42
            java.lang.Object r6 = r6.f5354c
            return r0
        L42:
            return r2
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.integrity.ao.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iHashCode = this.f5352a.hashCode() ^ 1000003;
        Long l6 = this.f5353b;
        int iHashCode2 = (iHashCode * 1000003) ^ (l6 == null ? 0 : l6.hashCode());
        return a() ? iHashCode2 * 1000003 : iHashCode2;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final String nonce() {
        return this.f5352a;
    }

    public final String toString() {
        String strConcat = "IntegrityTokenRequest{nonce=" + this.f5352a + ", cloudProjectNumber=" + this.f5353b;
        if (a()) {
            strConcat = strConcat.concat(", network=null");
        }
        return strConcat.concat("}");
    }
}
