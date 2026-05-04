package com.google.android.gms.common.api;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static h a(k kVar, g gVar) {
        com.google.android.gms.common.internal.s.l(kVar, "Result must not be null");
        com.google.android.gms.common.internal.s.b(!kVar.getStatus().V(), "Status code must not be SUCCESS");
        p pVar = new p(gVar, kVar);
        pVar.setResult(kVar);
        return pVar;
    }

    public static h b(Status status, g gVar) {
        com.google.android.gms.common.internal.s.l(status, "Result must not be null");
        com.google.android.gms.common.api.internal.u uVar = new com.google.android.gms.common.api.internal.u(gVar);
        uVar.setResult(status);
        return uVar;
    }
}
