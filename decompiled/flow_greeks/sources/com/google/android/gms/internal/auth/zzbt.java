package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.s;
import e5.a;
import e5.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbt implements a {
    public final h getSpatulaHeader(g gVar) {
        s.k(gVar);
        return gVar.b(new zzbs(this, gVar));
    }

    public final h performProxyRequest(g gVar, b bVar) {
        s.k(gVar);
        s.k(bVar);
        return gVar.b(new zzbq(this, gVar, bVar));
    }
}
