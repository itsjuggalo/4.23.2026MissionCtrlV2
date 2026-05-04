package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzand {
    private static final zzanu<?, ?> zza = new zzanw();

    @Deprecated
    public static int zza(int i10, zzamm zzammVar, zzanb zzanbVar) {
        return (zzakn.zzh(i10) << 1) + ((zzajm) zzammVar).zza(zzanbVar);
    }

    public static int zzb(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzakn.zzh(i10));
    }

    public static int zzc(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakn.zzb(i10, 0);
    }

    public static int zzd(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakn.zza(i10, 0L);
    }

    public static int zze(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzakn.zzh(i10));
    }

    public static int zzf(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzakn.zzh(i10));
    }

    public static int zzg(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzakn.zzh(i10));
    }

    public static int zzh(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzakn.zzh(i10));
    }

    public static int zzi(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzakn.zzh(i10));
    }

    public static int zzj(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzakn.zzh(i10));
    }

    public static void zzk(int i10, List<Integer> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzk(i10, list, z10);
    }

    public static void zzl(int i10, List<Long> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzl(i10, list, z10);
    }

    public static void zzm(int i10, List<Integer> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzm(i10, list, z10);
    }

    public static void zzn(int i10, List<Long> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzn(i10, list, z10);
    }

    private static int zza(zzajm zzajmVar, zzanb zzanbVar) {
        return zzakn.zzd(zzajmVar.zza(zzanbVar));
    }

    public static int zzc(List<?> list) {
        return list.size() << 2;
    }

    public static int zzd(List<?> list) {
        return list.size() << 3;
    }

    public static int zzb(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzali)) {
            int iZza = 0;
            while (i10 < size) {
                iZza += zzakn.zza(list.get(i10).intValue());
                i10++;
            }
            return iZza;
        }
        zzali zzaliVar = (zzali) list;
        int iZza2 = 0;
        while (i10 < size) {
            iZza2 += zzakn.zza(zzaliVar.zzb(i10));
            i10++;
        }
        return iZza2;
    }

    public static void zzc(int i10, List<Integer> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzc(i10, list, z10);
    }

    public static void zzd(int i10, List<Integer> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzd(i10, list, z10);
    }

    public static int zze(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzali)) {
            int iZzc = 0;
            while (i10 < size) {
                iZzc += zzakn.zzc(list.get(i10).intValue());
                i10++;
            }
            return iZzc;
        }
        zzali zzaliVar = (zzali) list;
        int iZzc2 = 0;
        while (i10 < size) {
            iZzc2 += zzakn.zzc(zzaliVar.zzb(i10));
            i10++;
        }
        return iZzc2;
    }

    public static int zzf(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalx)) {
            int iZzb = 0;
            while (i10 < size) {
                iZzb += zzakn.zzb(list.get(i10).longValue());
                i10++;
            }
            return iZzb;
        }
        zzalx zzalxVar = (zzalx) list;
        int iZzb2 = 0;
        while (i10 < size) {
            iZzb2 += zzakn.zzb(zzalxVar.zzb(i10));
            i10++;
        }
        return iZzb2;
    }

    public static int zzg(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzali)) {
            int iZzg = 0;
            while (i10 < size) {
                iZzg += zzakn.zzg(list.get(i10).intValue());
                i10++;
            }
            return iZzg;
        }
        zzali zzaliVar = (zzali) list;
        int iZzg2 = 0;
        while (i10 < size) {
            iZzg2 += zzakn.zzg(zzaliVar.zzb(i10));
            i10++;
        }
        return iZzg2;
    }

    public static int zzh(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalx)) {
            int iZzd = 0;
            while (i10 < size) {
                iZzd += zzakn.zzd(list.get(i10).longValue());
                i10++;
            }
            return iZzd;
        }
        zzalx zzalxVar = (zzalx) list;
        int iZzd2 = 0;
        while (i10 < size) {
            iZzd2 += zzakn.zzd(zzalxVar.zzb(i10));
            i10++;
        }
        return iZzd2;
    }

    public static int zzi(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzali)) {
            int iZzi = 0;
            while (i10 < size) {
                iZzi += zzakn.zzi(list.get(i10).intValue());
                i10++;
            }
            return iZzi;
        }
        zzali zzaliVar = (zzali) list;
        int iZzi2 = 0;
        while (i10 < size) {
            iZzi2 += zzakn.zzi(zzaliVar.zzb(i10));
            i10++;
        }
        return iZzi2;
    }

    public static int zzj(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalx)) {
            int iZze = 0;
            while (i10 < size) {
                iZze += zzakn.zze(list.get(i10).longValue());
                i10++;
            }
            return iZze;
        }
        zzalx zzalxVar = (zzalx) list;
        int iZze2 = 0;
        while (i10 < size) {
            iZze2 += zzakn.zze(zzalxVar.zzb(i10));
            i10++;
        }
        return iZze2;
    }

    public static int zza(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakn.zza(i10, true);
    }

    public static int zza(List<?> list) {
        return list.size();
    }

    public static int zza(int i10, List<zzajv> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzh = size * zzakn.zzh(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            iZzh += zzakn.zza(list.get(i11));
        }
        return iZzh;
    }

    public static int zzb(int i10, List<?> list, zzanb<?> zzanbVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzh = zzakn.zzh(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof zzalu) {
                iZza = zzakn.zza((zzalu) obj);
            } else {
                iZza = zza((zzajm) obj, (zzanb) zzanbVar);
            }
            iZzh += iZza;
        }
        return iZzh;
    }

    public static void zze(int i10, List<Long> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zze(i10, list, z10);
    }

    public static void zzf(int i10, List<Float> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzf(i10, list, z10);
    }

    public static void zzg(int i10, List<Integer> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzg(i10, list, z10);
    }

    public static void zzh(int i10, List<Long> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzh(i10, list, z10);
    }

    public static void zzi(int i10, List<Integer> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzi(i10, list, z10);
    }

    public static void zzj(int i10, List<Long> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzj(i10, list, z10);
    }

    public static int zza(int i10, List<zzamm> list, zzanb<?> zzanbVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZza = 0;
        for (int i11 = 0; i11 < size; i11++) {
            iZza += zza(i10, list.get(i11), (zzanb) zzanbVar);
        }
        return iZza;
    }

    public static int zza(int i10, Object obj, zzanb<?> zzanbVar) {
        if (obj instanceof zzalu) {
            return zzakn.zzb(i10, (zzalu) obj);
        }
        return zzakn.zzh(i10) + zza((zzajm) obj, (zzanb) zzanbVar);
    }

    public static int zzb(int i10, List<?> list) {
        int iZza;
        int iZza2;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzh = zzakn.zzh(i10) * size;
        if (!(list instanceof zzalt)) {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof zzajv) {
                    iZza = zzakn.zza((zzajv) obj);
                } else {
                    iZza = zzakn.zza((String) obj);
                }
                iZzh += iZza;
                i11++;
            }
            return iZzh;
        }
        zzalt zzaltVar = (zzalt) list;
        while (i11 < size) {
            Object objZza = zzaltVar.zza(i11);
            if (objZza instanceof zzajv) {
                iZza2 = zzakn.zza((zzajv) objZza);
            } else {
                iZza2 = zzakn.zza((String) objZza);
            }
            iZzh += iZza2;
            i11++;
        }
        return iZzh;
    }

    public static zzanu<?, ?> zza() {
        return zza;
    }

    public static <UT, UB> UB zza(Object obj, int i10, List<Integer> list, zzalj zzaljVar, UB ub2, zzanu<UT, UB> zzanuVar) {
        if (zzaljVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Integer num = list.get(i12);
                int iIntValue = num.intValue();
                if (zzaljVar.zza(iIntValue)) {
                    if (i12 != i11) {
                        list.set(i11, num);
                    }
                    i11++;
                } else {
                    ub2 = (UB) zza(obj, i10, iIntValue, ub2, zzanuVar);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
            return ub2;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (!zzaljVar.zza(iIntValue2)) {
                ub2 = (UB) zza(obj, i10, iIntValue2, ub2, zzanuVar);
                it.remove();
            }
        }
        return ub2;
    }

    public static void zzb(int i10, List<Double> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzb(i10, list, z10);
    }

    public static void zzb(int i10, List<?> list, zzaol zzaolVar, zzanb<?> zzanbVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzb(i10, list, (zzanb) zzanbVar);
    }

    public static <UT, UB> UB zza(Object obj, int i10, int i11, UB ub2, zzanu<UT, UB> zzanuVar) {
        if (ub2 == null) {
            ub2 = zzanuVar.zzc(obj);
        }
        zzanuVar.zzb(ub2, i10, i11);
        return ub2;
    }

    public static void zzb(int i10, List<String> list, zzaol zzaolVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzb(i10, list);
    }

    public static <T, FT extends zzakz<FT>> void zza(zzakw<FT> zzakwVar, T t10, T t11) {
        zzakx<T> zzakxVarZza = zzakwVar.zza(t11);
        if (zzakxVarZza.zza.isEmpty()) {
            return;
        }
        zzakwVar.zzb(t10).zza((zzakx) zzakxVarZza);
    }

    public static <T> void zza(zzamf zzamfVar, T t10, T t11, long j10) {
        zzanz.zza(t10, j10, zzamfVar.zza(zzanz.zze(t10, j10), zzanz.zze(t11, j10)));
    }

    public static <T, UT, UB> void zza(zzanu<UT, UB> zzanuVar, T t10, T t11) {
        zzanuVar.zzc(t10, zzanuVar.zza(zzanuVar.zzd(t10), zzanuVar.zzd(t11)));
    }

    public static void zza(Class<?> cls) {
        zzalf.class.isAssignableFrom(cls);
    }

    public static void zza(int i10, List<Boolean> list, zzaol zzaolVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zza(i10, list, z10);
    }

    public static void zza(int i10, List<zzajv> list, zzaol zzaolVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zza(i10, list);
    }

    public static void zza(int i10, List<?> list, zzaol zzaolVar, zzanb<?> zzanbVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zza(i10, list, (zzanb) zzanbVar);
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
