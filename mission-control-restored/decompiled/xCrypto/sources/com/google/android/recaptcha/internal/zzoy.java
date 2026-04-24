package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzoy {
    public static final /* synthetic */ int zza = 0;
    private static final zzpl zzb;

    static {
        int i4 = zzos.zza;
        zzb = new zzpn();
    }

    public static void zzA(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzA(i4, list, z4);
    }

    public static void zzB(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzC(i4, list, z4);
    }

    public static void zzC(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzE(i4, list, z4);
    }

    public static void zzD(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzJ(i4, list, z4);
    }

    public static void zzE(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzL(i4, list, z4);
    }

    public static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzB = 0;
            while (i4 < size) {
                iZzB += zzln.zzB(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iZzB;
        }
        zzne zzneVar = (zzne) list;
        int iZzB2 = 0;
        while (i4 < size) {
            iZzB2 += zzln.zzB(zzneVar.zze(i4));
            i4++;
        }
        return iZzB2;
    }

    public static int zzb(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzln.zzA(i4 << 3) + 4);
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzln.zzA(i4 << 3) + 8);
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzB = 0;
            while (i4 < size) {
                iZzB += zzln.zzB(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iZzB;
        }
        zzne zzneVar = (zzne) list;
        int iZzB2 = 0;
        while (i4 < size) {
            iZzB2 += zzln.zzB(zzneVar.zze(i4));
            i4++;
        }
        return iZzB2;
    }

    public static int zzg(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zznx)) {
            int iZzB = 0;
            while (i4 < size) {
                iZzB += zzln.zzB(((Long) list.get(i4)).longValue());
                i4++;
            }
            return iZzB;
        }
        zznx zznxVar = (zznx) list;
        int iZzB2 = 0;
        while (i4 < size) {
            iZzB2 += zzln.zzB(zznxVar.zze(i4));
            i4++;
        }
        return iZzB2;
    }

    public static int zzh(int i4, Object obj, zzow zzowVar) {
        int i5 = i4 << 3;
        if (!(obj instanceof zznt)) {
            return zzln.zzA(i5) + zzln.zzy((zzoi) obj, zzowVar);
        }
        int iZzA = zzln.zzA(i5);
        int iZza = ((zznt) obj).zza();
        return iZzA + zzln.zzA(iZza) + iZza;
    }

    public static int zzi(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzA = 0;
            while (i4 < size) {
                int iIntValue = ((Integer) list.get(i4)).intValue();
                iZzA += zzln.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i4++;
            }
            return iZzA;
        }
        zzne zzneVar = (zzne) list;
        int iZzA2 = 0;
        while (i4 < size) {
            int iZze = zzneVar.zze(i4);
            iZzA2 += zzln.zzA((iZze >> 31) ^ (iZze + iZze));
            i4++;
        }
        return iZzA2;
    }

    public static int zzj(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zznx)) {
            int iZzB = 0;
            while (i4 < size) {
                long jLongValue = ((Long) list.get(i4)).longValue();
                iZzB += zzln.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i4++;
            }
            return iZzB;
        }
        zznx zznxVar = (zznx) list;
        int iZzB2 = 0;
        while (i4 < size) {
            long jZze = zznxVar.zze(i4);
            iZzB2 += zzln.zzB((jZze >> 63) ^ (jZze + jZze));
            i4++;
        }
        return iZzB2;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzA = 0;
            while (i4 < size) {
                iZzA += zzln.zzA(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iZzA;
        }
        zzne zzneVar = (zzne) list;
        int iZzA2 = 0;
        while (i4 < size) {
            iZzA2 += zzln.zzA(zzneVar.zze(i4));
            i4++;
        }
        return iZzA2;
    }

    public static int zzl(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zznx)) {
            int iZzB = 0;
            while (i4 < size) {
                iZzB += zzln.zzB(((Long) list.get(i4)).longValue());
                i4++;
            }
            return iZzB;
        }
        zznx zznxVar = (zznx) list;
        int iZzB2 = 0;
        while (i4 < size) {
            iZzB2 += zzln.zzB(zznxVar.zze(i4));
            i4++;
        }
        return iZzB2;
    }

    public static zzpl zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i4, List list, zznh zznhVar, Object obj2, zzpl zzplVar) {
        if (zznhVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zznhVar.zza(iIntValue)) {
                    obj2 = zzo(obj, i4, iIntValue, obj2, zzplVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Integer num = (Integer) list.get(i6);
            int iIntValue2 = num.intValue();
            if (zznhVar.zza(iIntValue2)) {
                if (i6 != i5) {
                    list.set(i5, num);
                }
                i5++;
            } else {
                obj2 = zzo(obj, i4, iIntValue2, obj2, zzplVar);
            }
        }
        if (i5 != size) {
            list.subList(i5, size).clear();
        }
        return obj2;
    }

    public static Object zzo(Object obj, int i4, int i5, Object obj2, zzpl zzplVar) {
        if (obj2 == null) {
            obj2 = zzplVar.zza(obj);
        }
        zzplVar.zzh(obj2, i4, i5);
        return obj2;
    }

    public static void zzp(zzmp zzmpVar, Object obj, Object obj2) {
        zzmt zzmtVar = ((zzna) obj2).zzb;
        if (zzmtVar.zza.isEmpty()) {
            return;
        }
        ((zzna) obj).zzi().zzh(zzmtVar);
    }

    public static void zzq(zzpl zzplVar, Object obj, Object obj2) {
        zznd zzndVar = (zznd) obj;
        zzpm zzpmVarZze = zzndVar.zzc;
        zzpm zzpmVar = ((zznd) obj2).zzc;
        if (!zzpm.zzc().equals(zzpmVar)) {
            if (zzpm.zzc().equals(zzpmVarZze)) {
                zzpmVarZze = zzpm.zze(zzpmVarZze, zzpmVar);
            } else {
                zzpmVarZze.zzd(zzpmVar);
            }
        }
        zzndVar.zzc = zzpmVarZze;
    }

    public static void zzr(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzc(i4, list, z4);
    }

    public static void zzs(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzg(i4, list, z4);
    }

    public static void zzt(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzj(i4, list, z4);
    }

    public static void zzu(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzl(i4, list, z4);
    }

    public static void zzv(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzn(i4, list, z4);
    }

    public static void zzw(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzp(i4, list, z4);
    }

    public static void zzx(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzs(i4, list, z4);
    }

    public static void zzy(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzu(i4, list, z4);
    }

    public static void zzz(int i4, List list, zzpy zzpyVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzy(i4, list, z4);
    }
}
