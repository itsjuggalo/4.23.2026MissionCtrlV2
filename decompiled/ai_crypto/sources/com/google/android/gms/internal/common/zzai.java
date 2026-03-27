package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
final class zzai extends zzad {
    private final zzak zza;

    public zzai(zzak zzakVar, int i7) {
        super(zzakVar.size(), i7);
        this.zza = zzakVar;
    }

    @Override // com.google.android.gms.internal.common.zzad
    public final Object zza(int i7) {
        return this.zza.get(i7);
    }
}
