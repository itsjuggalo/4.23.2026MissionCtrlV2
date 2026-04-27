package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.internal.H;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.internal.I;
import q1.C0920a;

/* JADX INFO: loaded from: classes.dex */
public final class zzbt {
    public final q getSpatulaHeader(o oVar) {
        I.g(oVar);
        return ((H) oVar).f5099b.doWrite(new zzbs(this, oVar));
    }

    public final q performProxyRequest(o oVar, C0920a c0920a) {
        I.g(oVar);
        I.g(c0920a);
        return ((H) oVar).f5099b.doWrite(new zzbq(this, oVar, c0920a));
    }
}
