package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzco extends zzcj implements List, RandomAccess {
    private static final zzdx zza = new zzcl(zzdk.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    public static zzco zzj(Object[] objArr, int i4) {
        return i4 == 0 ? zzdk.zza : new zzdk(objArr, i4);
    }

    public static zzco zzk(Collection collection) {
        if (!(collection instanceof zzcj)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzdd.zzb(array, length);
            return zzj(array, length);
        }
        zzco zzcoVarZzd = ((zzcj) collection).zzd();
        if (!zzcoVarZzd.zzf()) {
            return zzcoVarZzd;
        }
        Object[] array2 = zzcoVarZzd.toArray();
        return zzj(array2, array2.length);
    }

    public static zzco zzl() {
        return zzdk.zza;
    }

    public static zzco zzm(Object obj) {
        Object[] objArr = {obj};
        zzdd.zzb(objArr, 1);
        return zzj(objArr, 1);
    }

    public static Collector zzo() {
        return zzbv.zza();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i4, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i4, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            for (int i4 = 0; i4 < size; i4++) {
                if (!zzbd.zza(get(i4), list.get(i4))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !zzbd.zza(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i4 = 0; i4 < size; i4++) {
            iHashCode = (iHashCode * 31) + get(i4).hashCode();
        }
        return iHashCode;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (obj.equals(get(i4))) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i4, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    public int zza(Object[] objArr, int i4) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            objArr[i5] = get(i5);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    @Deprecated
    public final zzco zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcj
    /* JADX INFO: renamed from: zze */
    public final zzdw iterator() {
        return listIterator(0);
    }

    public zzco zzh() {
        return size() <= 1 ? this : new zzcm(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public zzco subList(int i4, int i5) {
        zzbe.zze(i4, i5, size());
        int i6 = i5 - i4;
        return i6 == size() ? this : i6 == 0 ? zzdk.zza : new zzcn(this, i4, i6);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final zzdx listIterator(int i4) {
        zzbe.zzb(i4, size(), FirebaseAnalytics.Param.INDEX);
        return isEmpty() ? zza : new zzcl(this, i4);
    }
}
