package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzob implements Iterator {
    final /* synthetic */ zzod zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzob(zzod zzodVar, byte[] bArr) {
        Objects.requireNonNull(zzodVar);
        this.zza = zzodVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i7 = this.zzb + 1;
        zzod zzodVar = this.zza;
        if (i7 >= zzodVar.zzj()) {
            return !zzodVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i7 = this.zzb + 1;
        this.zzb = i7;
        zzod zzodVar = this.zza;
        return i7 < zzodVar.zzj() ? (zzoa) zzodVar.zzi()[i7] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzod zzodVar = this.zza;
        zzodVar.zzh();
        int i7 = this.zzb;
        if (i7 >= zzodVar.zzj()) {
            zza().remove();
        } else {
            this.zzb = i7 - 1;
            zzodVar.zzg(i7);
        }
    }
}
