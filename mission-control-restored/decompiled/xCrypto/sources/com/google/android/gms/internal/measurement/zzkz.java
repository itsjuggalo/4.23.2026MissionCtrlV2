package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzkz extends zzla {
    final /* synthetic */ zzlg zza;
    private int zzb;
    private final int zzc;

    public zzkz(zzlg zzlgVar) {
        Objects.requireNonNull(zzlgVar);
        this.zza = zzlgVar;
        this.zzb = 0;
        this.zzc = zzlgVar.zzc();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzlc
    public final byte zza() {
        int i4 = this.zzb;
        if (i4 >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i4 + 1;
        return this.zza.zzb(i4);
    }
}
