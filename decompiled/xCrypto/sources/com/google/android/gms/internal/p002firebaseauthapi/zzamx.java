package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzamx {
    private static final zzano<?, ?> zza = new zzanq();

    public static int zza(int i4, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakg.zza(i4, true);
    }

    public static int zzb(int i4, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzakg.zzi(i4));
    }

    public static int zzc(int i4, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakg.zzc(i4, 0);
    }

    public static int zzd(int i4, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakg.zza(i4, 0L);
    }

    public static int zze(int i4, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzakg.zzi(i4));
    }

    public static int zzf(int i4, List<Long> list, boolean z4) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzakg.zzi(i4));
    }

    public static int zzg(int i4, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzakg.zzi(i4));
    }

    public static int zzh(int i4, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzakg.zzi(i4));
    }

    public static int zzi(int i4, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzakg.zzi(i4));
    }

    public static int zzj(int i4, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzakg.zzi(i4));
    }

    public static void zzk(int i4, List<Integer> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzk(i4, list, z4);
    }

    public static void zzl(int i4, List<Long> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzl(i4, list, z4);
    }

    public static void zzm(int i4, List<Integer> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzm(i4, list, z4);
    }

    public static void zzn(int i4, List<Long> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzn(i4, list, z4);
    }

    public static int zza(List<?> list) {
        return list.size();
    }

    public static int zzc(List<?> list) {
        return list.size() << 2;
    }

    public static int zzd(List<?> list) {
        return list.size() << 3;
    }

    public static int zza(int i4, List<zzajp> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzi = size * zzakg.zzi(i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            iZzi += zzakg.zza(list.get(i5));
        }
        return iZzi;
    }

    public static int zzb(List<Integer> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakz)) {
            int iZzc = 0;
            while (i4 < size) {
                iZzc += zzakg.zzc(list.get(i4).intValue());
                i4++;
            }
            return iZzc;
        }
        zzakz zzakzVar = (zzakz) list;
        int iZzc2 = 0;
        while (i4 < size) {
            iZzc2 += zzakg.zzc(zzakzVar.zzb(i4));
            i4++;
        }
        return iZzc2;
    }

    public static void zzc(int i4, List<Integer> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzc(i4, list, z4);
    }

    public static void zzd(int i4, List<Integer> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzd(i4, list, z4);
    }

    public static int zze(List<Integer> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakz)) {
            int iZze = 0;
            while (i4 < size) {
                iZze += zzakg.zze(list.get(i4).intValue());
                i4++;
            }
            return iZze;
        }
        zzakz zzakzVar = (zzakz) list;
        int iZze2 = 0;
        while (i4 < size) {
            iZze2 += zzakg.zze(zzakzVar.zzb(i4));
            i4++;
        }
        return iZze2;
    }

    public static int zzf(List<Long> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalr)) {
            int iZzd = 0;
            while (i4 < size) {
                iZzd += zzakg.zzd(list.get(i4).longValue());
                i4++;
            }
            return iZzd;
        }
        zzalr zzalrVar = (zzalr) list;
        int iZzd2 = 0;
        while (i4 < size) {
            iZzd2 += zzakg.zzd(zzalrVar.zzb(i4));
            i4++;
        }
        return iZzd2;
    }

    public static int zzg(List<Integer> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakz)) {
            int iZzh = 0;
            while (i4 < size) {
                iZzh += zzakg.zzh(list.get(i4).intValue());
                i4++;
            }
            return iZzh;
        }
        zzakz zzakzVar = (zzakz) list;
        int iZzh2 = 0;
        while (i4 < size) {
            iZzh2 += zzakg.zzh(zzakzVar.zzb(i4));
            i4++;
        }
        return iZzh2;
    }

    public static int zzh(List<Long> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalr)) {
            int iZzf = 0;
            while (i4 < size) {
                iZzf += zzakg.zzf(list.get(i4).longValue());
                i4++;
            }
            return iZzf;
        }
        zzalr zzalrVar = (zzalr) list;
        int iZzf2 = 0;
        while (i4 < size) {
            iZzf2 += zzakg.zzf(zzalrVar.zzb(i4));
            i4++;
        }
        return iZzf2;
    }

    public static int zzi(List<Integer> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakz)) {
            int iZzj = 0;
            while (i4 < size) {
                iZzj += zzakg.zzj(list.get(i4).intValue());
                i4++;
            }
            return iZzj;
        }
        zzakz zzakzVar = (zzakz) list;
        int iZzj2 = 0;
        while (i4 < size) {
            iZzj2 += zzakg.zzj(zzakzVar.zzb(i4));
            i4++;
        }
        return iZzj2;
    }

    public static int zzj(List<Long> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalr)) {
            int iZzg = 0;
            while (i4 < size) {
                iZzg += zzakg.zzg(list.get(i4).longValue());
                i4++;
            }
            return iZzg;
        }
        zzalr zzalrVar = (zzalr) list;
        int iZzg2 = 0;
        while (i4 < size) {
            iZzg2 += zzakg.zzg(zzalrVar.zzb(i4));
            i4++;
        }
        return iZzg2;
    }

    public static int zza(int i4, List<zzamc> list, zzamv<?> zzamvVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZza = 0;
        for (int i5 = 0; i5 < size; i5++) {
            iZza += zzakg.zza(i4, list.get(i5), zzamvVar);
        }
        return iZza;
    }

    public static int zzb(int i4, List<?> list, zzamv<?> zzamvVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzi = zzakg.zzi(i4) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof zzalk) {
                iZza = zzakg.zza((zzalk) obj);
            } else {
                iZza = zzakg.zza((zzamc) obj, zzamvVar);
            }
            iZzi += iZza;
        }
        return iZzi;
    }

    public static void zze(int i4, List<Long> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zze(i4, list, z4);
    }

    public static void zzf(int i4, List<Float> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzf(i4, list, z4);
    }

    public static void zzg(int i4, List<Integer> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzg(i4, list, z4);
    }

    public static void zzh(int i4, List<Long> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzh(i4, list, z4);
    }

    public static void zzi(int i4, List<Integer> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzi(i4, list, z4);
    }

    public static void zzj(int i4, List<Long> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzj(i4, list, z4);
    }

    public static int zza(int i4, Object obj, zzamv<?> zzamvVar) {
        if (obj instanceof zzalk) {
            return zzakg.zzb(i4, (zzalk) obj);
        }
        return zzakg.zzb(i4, (zzamc) obj, zzamvVar);
    }

    public static zzano<?, ?> zza() {
        return zza;
    }

    public static <UT, UB> UB zza(Object obj, int i4, List<Integer> list, zzald zzaldVar, UB ub, zzano<UT, UB> zzanoVar) {
        if (zzaldVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                Integer num = list.get(i6);
                int iIntValue = num.intValue();
                if (zzaldVar.zza(iIntValue)) {
                    if (i6 != i5) {
                        list.set(i5, num);
                    }
                    i5++;
                } else {
                    ub = (UB) zza(obj, i4, iIntValue, ub, zzanoVar);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (!zzaldVar.zza(iIntValue2)) {
                ub = (UB) zza(obj, i4, iIntValue2, ub, zzanoVar);
                it.remove();
            }
        }
        return ub;
    }

    public static int zzb(int i4, List<?> list) {
        int iZza;
        int iZza2;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzi = zzakg.zzi(i4) * size;
        if (!(list instanceof zzaln)) {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof zzajp) {
                    iZza = zzakg.zza((zzajp) obj);
                } else {
                    iZza = zzakg.zza((String) obj);
                }
                iZzi += iZza;
                i5++;
            }
            return iZzi;
        }
        zzaln zzalnVar = (zzaln) list;
        while (i5 < size) {
            Object objZza = zzalnVar.zza(i5);
            if (objZza instanceof zzajp) {
                iZza2 = zzakg.zza((zzajp) objZza);
            } else {
                iZza2 = zzakg.zza((String) objZza);
            }
            iZzi += iZza2;
            i5++;
        }
        return iZzi;
    }

    public static <UT, UB> UB zza(Object obj, int i4, int i5, UB ub, zzano<UT, UB> zzanoVar) {
        if (ub == null) {
            ub = zzanoVar.zzc(obj);
        }
        zzanoVar.zzb(ub, i4, i5);
        return ub;
    }

    public static void zzb(int i4, List<Double> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzb(i4, list, z4);
    }

    public static <T, FT extends zzakt<FT>> void zza(zzakm<FT> zzakmVar, T t4, T t5) {
        zzakr<T> zzakrVarZza = zzakmVar.zza(t5);
        if (zzakrVarZza.zza.isEmpty()) {
            return;
        }
        zzakmVar.zzb(t4).zza((zzakr) zzakrVarZza);
    }

    public static void zzb(int i4, List<?> list, zzaof zzaofVar, zzamv<?> zzamvVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzb(i4, list, (zzamv) zzamvVar);
    }

    public static void zzb(int i4, List<String> list, zzaof zzaofVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zzb(i4, list);
    }

    public static <T> void zza(zzalz zzalzVar, T t4, T t5, long j4) {
        zzanp.zza(t4, j4, zzalzVar.zza(zzanp.zze(t4, j4), zzanp.zze(t5, j4)));
    }

    public static <T, UT, UB> void zza(zzano<UT, UB> zzanoVar, T t4, T t5) {
        zzanoVar.zzc(t4, zzanoVar.zza(zzanoVar.zzd(t4), zzanoVar.zzd(t5)));
    }

    public static void zza(Class<?> cls) {
        zzaky.class.isAssignableFrom(cls);
    }

    public static void zza(int i4, List<Boolean> list, zzaof zzaofVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zza(i4, list, z4);
    }

    public static void zza(int i4, List<zzajp> list, zzaof zzaofVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zza(i4, list);
    }

    public static void zza(int i4, List<?> list, zzaof zzaofVar, zzamv<?> zzamvVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaofVar.zza(i4, list, (zzamv) zzamvVar);
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
