package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzad implements Iterator {
    final /* synthetic */ zzae zza;
    private int zzb;

    public zzad(zzae zzaeVar) {
        Objects.requireNonNull(zzaeVar);
        this.zza = zzaeVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza.zzh();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        zzae zzaeVar = this.zza;
        if (this.zzb < zzaeVar.zzh()) {
            int i4 = this.zzb;
            this.zzb = i4 + 1;
            return zzaeVar.zzl(i4);
        }
        int i5 = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i5);
        throw new NoSuchElementException(sb.toString());
    }
}
