package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class zzod extends AbstractMap {
    private Object[] zza;
    private int zzb;
    private boolean zzd;
    private volatile zzoc zze;
    private Map zzc = Collections.emptyMap();
    private Map zzf = Collections.emptyMap();

    private zzod() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final Object zzg(int i7) {
        zzh();
        Object value = ((zzoa) this.zza[i7]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i7 + 1, objArr, i7, (this.zzb - i7) - 1);
        this.zzb--;
        if (!this.zzc.isEmpty()) {
            Iterator it = zzo().entrySet().iterator();
            Object[] objArr2 = this.zza;
            int i8 = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i8] = new zzoa(this, (Comparable) entry.getKey(), entry.getValue());
            this.zzb++;
            it.remove();
        }
        return value;
    }

    private final int zzm(Comparable comparable) {
        int i7 = this.zzb;
        int i8 = i7 - 1;
        int i9 = 0;
        if (i8 >= 0) {
            int iCompareTo = comparable.compareTo(((zzoa) this.zza[i8]).zza());
            if (iCompareTo > 0) {
                return -(i7 + 1);
            }
            if (iCompareTo == 0) {
                return i8;
            }
        }
        while (i9 <= i8) {
            int i10 = (i9 + i8) / 2;
            int iCompareTo2 = comparable.compareTo(((zzoa) this.zza[i10]).zza());
            if (iCompareTo2 < 0) {
                i8 = i10 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i10;
                }
                i9 = i10 + 1;
            }
        }
        return -(i9 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final void zzh() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap zzo() {
        zzh();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzh();
        if (this.zzb != 0) {
            this.zza = null;
            this.zzb = 0;
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzm(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzoc(this, null);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzod)) {
            return super.equals(obj);
        }
        zzod zzodVar = (zzod) obj;
        int size = size();
        if (size != zzodVar.size()) {
            return false;
        }
        int i7 = this.zzb;
        if (i7 != zzodVar.zzb) {
            return entrySet().equals(zzodVar.entrySet());
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!zzd(i8).equals(zzodVar.zzd(i8))) {
                return false;
            }
        }
        if (i7 != size) {
            return this.zzc.equals(zzodVar.zzc);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZzm = zzm(comparable);
        return iZzm >= 0 ? ((zzoa) this.zza[iZzm]).getValue() : this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i7 = this.zzb;
        int iHashCode = 0;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode += this.zza[i8].hashCode();
        }
        return this.zzc.size() > 0 ? iHashCode + this.zzc.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzh();
        Comparable comparable = (Comparable) obj;
        int iZzm = zzm(comparable);
        if (iZzm >= 0) {
            return zzg(iZzm);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb + this.zzc.size();
    }

    public void zza() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final Map.Entry zzd(int i7) {
        if (i7 < this.zzb) {
            return (zzoa) this.zza[i7];
        }
        throw new ArrayIndexOutOfBoundsException(i7);
    }

    public final Iterable zze() {
        return this.zzc.isEmpty() ? Collections.emptySet() : this.zzc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzh();
        int iZzm = zzm(comparable);
        if (iZzm >= 0) {
            return ((zzoa) this.zza[iZzm]).setValue(obj);
        }
        zzh();
        if (this.zza == null) {
            this.zza = new Object[16];
        }
        int i7 = -(iZzm + 1);
        if (i7 >= 16) {
            return zzo().put(comparable, obj);
        }
        if (this.zzb == 16) {
            zzoa zzoaVar = (zzoa) this.zza[15];
            this.zzb = 15;
            zzo().put(zzoaVar.zza(), zzoaVar.getValue());
        }
        Object[] objArr = this.zza;
        int length = objArr.length;
        System.arraycopy(objArr, i7, objArr, i7 + 1, 15 - i7);
        this.zza[i7] = new zzoa(this, comparable, obj);
        this.zzb++;
        return null;
    }

    public final /* synthetic */ Object[] zzi() {
        return this.zza;
    }

    public final /* synthetic */ int zzj() {
        return this.zzb;
    }

    public final /* synthetic */ Map zzk() {
        return this.zzc;
    }

    public /* synthetic */ zzod(byte[] bArr) {
    }
}
