package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzha implements Iterator {
    final /* synthetic */ zzhd zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzha(zzhd zzhdVar, zzhc zzhcVar) {
        Objects.requireNonNull(zzhdVar);
        this.zza = zzhdVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10 = this.zzb + 1;
        zzhd zzhdVar = this.zza;
        if (i10 >= zzhdVar.zzb) {
            return !zzhdVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i10 = this.zzb + 1;
        this.zzb = i10;
        zzhd zzhdVar = this.zza;
        return i10 < zzhdVar.zzb ? (zzgz) zzhdVar.zza[i10] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzhd zzhdVar = this.zza;
        zzhdVar.zzo();
        int i10 = this.zzb;
        if (i10 >= zzhdVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i10 - 1;
            zzhdVar.zzm(i10);
        }
    }
}
