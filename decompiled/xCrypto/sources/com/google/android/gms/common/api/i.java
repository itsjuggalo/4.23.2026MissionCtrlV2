package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.C0913q;
import com.google.android.gms.common.api.internal.C0919x;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static h a(k kVar, f fVar) {
        AbstractC0940s.l(kVar, "Result must not be null");
        AbstractC0940s.b(!kVar.getStatus().o(), "Status code must not be SUCCESS");
        r rVar = new r(fVar, kVar);
        rVar.setResult(kVar);
        return rVar;
    }

    public static g b(k kVar, f fVar) {
        AbstractC0940s.l(kVar, "Result must not be null");
        s sVar = new s(fVar);
        sVar.setResult(kVar);
        return new C0913q(sVar);
    }

    public static h c(Status status, f fVar) {
        AbstractC0940s.l(status, "Result must not be null");
        C0919x c0919x = new C0919x(fVar);
        c0919x.setResult(status);
        return c0919x;
    }
}
