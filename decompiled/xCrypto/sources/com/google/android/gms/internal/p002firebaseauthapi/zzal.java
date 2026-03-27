package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzal<E> extends zzad<E> {
    private final zzaj<E> zza;

    public zzal(zzaj<E> zzajVar, int i4) {
        super(zzajVar.size(), i4);
        this.zza = zzajVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzad
    public final E zza(int i4) {
        return this.zza.get(i4);
    }
}
