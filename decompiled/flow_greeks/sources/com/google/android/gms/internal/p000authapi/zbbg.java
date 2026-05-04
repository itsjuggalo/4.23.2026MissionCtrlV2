package com.google.android.gms.internal.p000authapi;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zbbg extends zbbe {
    private final zbbi zba;

    public zbbg(zbbi zbbiVar, int i10) {
        super(zbbiVar.size(), i10);
        this.zba = zbbiVar;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbe
    public final Object zba(int i10) {
        return this.zba.get(i10);
    }
}
