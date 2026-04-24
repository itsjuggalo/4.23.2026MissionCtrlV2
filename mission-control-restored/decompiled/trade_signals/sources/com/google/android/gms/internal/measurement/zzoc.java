package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzoc implements Iterator {
    final /* synthetic */ zzoe zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzoc(zzoe zzoeVar, byte[] bArr) {
        Objects.requireNonNull(zzoeVar);
        this.zza = zzoeVar;
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
        int i8 = this.zzb + 1;
        zzoe zzoeVar = this.zza;
        if (i8 >= zzoeVar.zzj()) {
            return !zzoeVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i8 = this.zzb + 1;
        this.zzb = i8;
        zzoe zzoeVar = this.zza;
        return i8 < zzoeVar.zzj() ? (zzob) zzoeVar.zzi()[i8] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzoe zzoeVar = this.zza;
        zzoeVar.zzh();
        int i8 = this.zzb;
        if (i8 >= zzoeVar.zzj()) {
            zza().remove();
        } else {
            this.zzb = i8 - 1;
            zzoeVar.zzg(i8);
        }
    }
}
