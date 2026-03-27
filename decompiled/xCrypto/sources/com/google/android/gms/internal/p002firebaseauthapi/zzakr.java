package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakt;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
final class zzakr<T extends zzakt<T>> {
    private static final zzakr<?> zzb = new zzakr<>(true);
    final zzamw<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    private zzakr() {
        this.zza = new zzamz();
    }

    public static int zza(zzanw zzanwVar, int i4, Object obj) {
        int iZzi = zzakg.zzi(i4);
        if (zzanwVar == zzanw.zzj) {
            zzalb.zza((zzamc) obj);
            iZzi <<= 1;
        }
        return iZzi + zza(zzanwVar, obj);
    }

    public static <T extends zzakt<T>> zzakr<T> zzb() {
        return (zzakr<T>) zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() {
        zzakr zzakrVar = new zzakr();
        int iZza = this.zza.zza();
        for (int i4 = 0; i4 < iZza; i4++) {
            Map.Entry<K, Object> entryZza = this.zza.zza(i4);
            zzakrVar.zzb((zzakt) entryZza.getKey(), entryZza.getValue());
        }
        Iterator it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzakrVar.zzb((zzakt) entry.getKey(), entry.getValue());
        }
        zzakrVar.zzd = this.zzd;
        return zzakrVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzakr) {
            return this.zza.equals(((zzakr) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzc() {
        return this.zza.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzali(this.zza.zzc().iterator()) : this.zza.zzc().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        return this.zza.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzali(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        int iZza = this.zza.zza();
        for (int i4 = 0; i4 < iZza; i4++) {
            Object value = this.zza.zza(i4).getValue();
            if (value instanceof zzaky) {
                ((zzaky) value).zzs();
            }
        }
        Iterator it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzaky) {
                ((zzaky) value2).zzs();
            }
        }
        this.zza.zzd();
        this.zzc = true;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        int iZza = this.zza.zza();
        for (int i4 = 0; i4 < iZza; i4++) {
            if (!zzc(this.zza.zza(i4))) {
                return false;
            }
        }
        Iterator it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            if (!zzc((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z4 = value instanceof zzalg;
        if (key.zze()) {
            if (z4) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objZza = zza((zzakt) key);
            List list = (List) value;
            int size = list.size();
            if (objZza == null) {
                objZza = new ArrayList(size);
            }
            List list2 = (List) objZza;
            for (int i4 = 0; i4 < size; i4++) {
                list2.add(zza(list.get(i4)));
            }
            this.zza.put(key, objZza);
            return;
        }
        if (key.zzc() != zzaod.MESSAGE) {
            if (z4) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(key, zza(value));
            return;
        }
        Object objZza2 = zza((zzakt) key);
        if (objZza2 != null) {
            if (z4) {
                throw new NoSuchMethodError();
            }
            this.zza.put(key, objZza2 instanceof zzaml ? key.zza((zzaml) objZza2, (zzaml) value) : key.zza(((zzamc) objZza2).zzr(), (zzamc) value).zze());
        } else {
            this.zza.put(key, zza(value));
            if (z4) {
                this.zzd = true;
            }
        }
    }

    private zzakr(zzamw<T, Object> zzamwVar) {
        this.zza = zzamwVar;
        zze();
    }

    private static int zza(zzanw zzanwVar, Object obj) {
        switch (zzakq.zzb[zzanwVar.ordinal()]) {
            case 1:
                return zzakg.zza(((Double) obj).doubleValue());
            case 2:
                return zzakg.zza(((Float) obj).floatValue());
            case 3:
                return zzakg.zzd(((Long) obj).longValue());
            case 4:
                return zzakg.zzg(((Long) obj).longValue());
            case 5:
                return zzakg.zze(((Integer) obj).intValue());
            case 6:
                return zzakg.zzc(((Long) obj).longValue());
            case 7:
                return zzakg.zzd(((Integer) obj).intValue());
            case 8:
                return zzakg.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzakg.zza((zzamc) obj);
            case 10:
                if (obj instanceof zzalg) {
                    return zzakg.zza((zzalg) obj);
                }
                return zzakg.zzb((zzamc) obj);
            case 11:
                if (obj instanceof zzajp) {
                    return zzakg.zza((zzajp) obj);
                }
                return zzakg.zza((String) obj);
            case 12:
                if (obj instanceof zzajp) {
                    return zzakg.zza((zzajp) obj);
                }
                return zzakg.zza((byte[]) obj);
            case 13:
                return zzakg.zzj(((Integer) obj).intValue());
            case 14:
                return zzakg.zzg(((Integer) obj).intValue());
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                return zzakg.zze(((Long) obj).longValue());
            case 16:
                return zzakg.zzh(((Integer) obj).intValue());
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return zzakg.zzf(((Long) obj).longValue());
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                if (obj instanceof zzala) {
                    return zzakg.zzc(((zzala) obj).zza());
                }
                return zzakg.zzc(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static void zzc(T t4, Object obj) {
        zzanw zzanwVarZzb = t4.zzb();
        zzalb.zza(obj);
        boolean z4 = true;
        switch (zzakq.zza[zzanwVarZzb.zzb().ordinal()]) {
            case 1:
                z4 = obj instanceof Integer;
                break;
            case 2:
                z4 = obj instanceof Long;
                break;
            case 3:
                z4 = obj instanceof Float;
                break;
            case 4:
                z4 = obj instanceof Double;
                break;
            case 5:
                z4 = obj instanceof Boolean;
                break;
            case 6:
                z4 = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzajp) && !(obj instanceof byte[])) {
                    z4 = false;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzala)) {
                    z4 = false;
                }
                break;
            case 9:
                if (!(obj instanceof zzamc) && !(obj instanceof zzalg)) {
                    z4 = false;
                }
                break;
            default:
                z4 = false;
                break;
        }
        if (!z4) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t4.zza()), t4.zzb().zzb(), obj.getClass().getName()));
        }
    }

    private zzakr(boolean z4) {
        this(new zzamz());
        zze();
    }

    private static <T extends zzakt<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() != zzaod.MESSAGE) {
            return true;
        }
        if (key.zze()) {
            List list = (List) entry.getValue();
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!zzb(list.get(i4))) {
                    return false;
                }
            }
            return true;
        }
        return zzb(entry.getValue());
    }

    private final void zzb(T t4, Object obj) {
        if (t4.zze()) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i4 = 0; i4 < size; i4++) {
                    Object obj2 = list.get(i4);
                    zzc(t4, obj2);
                    arrayList.add(obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzc(t4, obj);
        }
        if (obj instanceof zzalg) {
            this.zzd = true;
        }
        this.zza.put(t4, obj);
    }

    public static int zza(zzakt<?> zzaktVar, Object obj) {
        zzanw zzanwVarZzb = zzaktVar.zzb();
        int iZza = zzaktVar.zza();
        if (zzaktVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            int i4 = 0;
            if (!zzaktVar.zzd()) {
                int iZza2 = 0;
                while (i4 < size) {
                    iZza2 += zza(zzanwVarZzb, iZza, list.get(i4));
                    i4++;
                }
                return iZza2;
            }
            if (list.isEmpty()) {
                return 0;
            }
            int iZza3 = 0;
            while (i4 < size) {
                iZza3 += zza(zzanwVarZzb, list.get(i4));
                i4++;
            }
            return zzakg.zzi(iZza) + iZza3 + zzakg.zzj(iZza3);
        }
        return zza(zzanwVarZzb, iZza, obj);
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzame) {
            return ((zzame) obj).zzj();
        }
        if (obj instanceof zzalg) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public final int zza() {
        int iZza = this.zza.zza();
        int iZza2 = 0;
        for (int i4 = 0; i4 < iZza; i4++) {
            iZza2 += zza((Map.Entry) this.zza.zza(i4));
        }
        Iterator it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            iZza2 += zza((Map.Entry) it.next());
        }
        return iZza2;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzaod.MESSAGE && !key.zze() && !key.zzd()) {
            if (value instanceof zzalg) {
                return zzakg.zza(entry.getKey().zza(), (zzalg) value);
            }
            return zzakg.zza(entry.getKey().zza(), (zzamc) value);
        }
        return zza((zzakt<?>) key, value);
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzaml) {
            return ((zzaml) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final Object zza(T t4) {
        Object obj = this.zza.get(t4);
        if (obj instanceof zzalg) {
            throw new NoSuchMethodError();
        }
        return obj;
    }

    public final void zza(zzakr<T> zzakrVar) {
        int iZza = zzakrVar.zza.zza();
        for (int i4 = 0; i4 < iZza; i4++) {
            zzb((Map.Entry) zzakrVar.zza.zza(i4));
        }
        Iterator it = zzakrVar.zza.zzb().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    public static void zza(zzakg zzakgVar, zzanw zzanwVar, int i4, Object obj) {
        if (zzanwVar == zzanw.zzj) {
            zzamc zzamcVar = (zzamc) obj;
            zzalb.zza(zzamcVar);
            zzakgVar.zzk(i4, 3);
            zzamcVar.zza(zzakgVar);
            zzakgVar.zzk(i4, 4);
        }
        zzakgVar.zzk(i4, zzanwVar.zza());
        switch (zzakq.zzb[zzanwVar.ordinal()]) {
            case 1:
                zzakgVar.zzb(((Double) obj).doubleValue());
                break;
            case 2:
                zzakgVar.zzb(((Float) obj).floatValue());
                break;
            case 3:
                zzakgVar.zzj(((Long) obj).longValue());
                break;
            case 4:
                zzakgVar.zzj(((Long) obj).longValue());
                break;
            case 5:
                zzakgVar.zzl(((Integer) obj).intValue());
                break;
            case 6:
                zzakgVar.zzh(((Long) obj).longValue());
                break;
            case 7:
                zzakgVar.zzk(((Integer) obj).intValue());
                break;
            case 8:
                zzakgVar.zzb(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzamc) obj).zza(zzakgVar);
                break;
            case 10:
                zzakgVar.zzc((zzamc) obj);
                break;
            case 11:
                if (obj instanceof zzajp) {
                    zzakgVar.zzb((zzajp) obj);
                } else {
                    zzakgVar.zzb((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzajp) {
                    zzakgVar.zzb((zzajp) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzakgVar.zzb(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzakgVar.zzn(((Integer) obj).intValue());
                break;
            case 14:
                zzakgVar.zzk(((Integer) obj).intValue());
                break;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                zzakgVar.zzh(((Long) obj).longValue());
                break;
            case 16:
                zzakgVar.zzm(((Integer) obj).intValue());
                break;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                zzakgVar.zzi(((Long) obj).longValue());
                break;
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                if (obj instanceof zzala) {
                    zzakgVar.zzl(((zzala) obj).zza());
                } else {
                    zzakgVar.zzl(((Integer) obj).intValue());
                }
                break;
        }
    }
}
