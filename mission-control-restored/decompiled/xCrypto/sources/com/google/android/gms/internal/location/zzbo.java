package com.google.android.gms.internal.location;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzbo<E> extends zzbv<E> {
    private final int zza;
    private int zzb;

    public zzbo(int i4, int i5) {
        zzbm.zzb(i5, i4, FirebaseAnalytics.Param.INDEX);
        this.zza = i4;
        this.zzb = i5;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i4 = this.zzb;
        this.zzb = i4 + 1;
        return zza(i4);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i4 = this.zzb - 1;
        this.zzb = i4;
        return zza(i4);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    public abstract E zza(int i4);
}
