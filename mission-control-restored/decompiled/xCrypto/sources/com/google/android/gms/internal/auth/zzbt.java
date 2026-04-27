package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.AbstractC0940s;
import t1.InterfaceC1783a;
import t1.b;

/* JADX INFO: loaded from: classes.dex */
public final class zzbt implements InterfaceC1783a {
    public final h getSpatulaHeader(f fVar) {
        AbstractC0940s.k(fVar);
        return fVar.b(new zzbs(this, fVar));
    }

    public final h performProxyRequest(f fVar, b bVar) {
        AbstractC0940s.k(fVar);
        AbstractC0940s.k(bVar);
        return fVar.b(new zzbq(this, fVar, bVar));
    }
}
