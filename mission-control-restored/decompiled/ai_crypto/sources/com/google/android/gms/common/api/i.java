package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.C1179p;
import com.google.android.gms.common.api.internal.C1185w;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static h a(k kVar, f fVar) {
        AbstractC1207s.l(kVar, "Result must not be null");
        AbstractC1207s.b(!kVar.getStatus().F(), "Status code must not be SUCCESS");
        r rVar = new r(fVar, kVar);
        rVar.setResult(kVar);
        return rVar;
    }

    public static g b(k kVar, f fVar) {
        AbstractC1207s.l(kVar, "Result must not be null");
        s sVar = new s(fVar);
        sVar.setResult(kVar);
        return new C1179p(sVar);
    }

    public static h c(Status status, f fVar) {
        AbstractC1207s.l(status, "Result must not be null");
        C1185w c1185w = new C1185w(fVar);
        c1185w.setResult(status);
        return c1185w;
    }
}
