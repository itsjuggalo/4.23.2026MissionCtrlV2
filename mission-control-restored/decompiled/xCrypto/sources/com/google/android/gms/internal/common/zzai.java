package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
final class zzai extends zzad {
    private final zzak zza;

    public zzai(zzak zzakVar, int i4) {
        super(zzakVar.size(), i4);
        this.zza = zzakVar;
    }

    @Override // com.google.android.gms.internal.common.zzad
    public final Object zza(int i4) {
        return this.zza.get(i4);
    }
}
