package com.google.android.gms.internal.auth;

import K1.a;
import K1.b;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class zzbt implements a {
    public final h getSpatulaHeader(f fVar) {
        AbstractC1207s.k(fVar);
        return fVar.b(new zzbs(this, fVar));
    }

    public final h performProxyRequest(f fVar, b bVar) {
        AbstractC1207s.k(fVar);
        AbstractC1207s.k(bVar);
        return fVar.b(new zzbq(this, fVar, bVar));
    }
}
