package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzoy {
    public static final /* synthetic */ int zza = 0;
    private static final zzpl zzb;

    static {
        int i10 = zzos.zza;
        zzb = new zzpn();
    }

    public static void zzA(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzA(i10, list, z10);
    }

    public static void zzB(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzC(i10, list, z10);
    }

    public static void zzC(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzE(i10, list, z10);
    }

    public static void zzD(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzJ(i10, list, z10);
    }

    public static void zzE(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzL(i10, list, z10);
    }

    public static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzB = 0;
            while (i10 < size) {
                iZzB += zzln.zzB(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iZzB;
        }
        zzne zzneVar = (zzne) list;
        int iZzB2 = 0;
        while (i10 < size) {
            iZzB2 += zzln.zzB(zzneVar.zze(i10));
            i10++;
        }
        return iZzB2;
    }

    public static int zzb(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzln.zzA(i10 << 3) + 4);
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzln.zzA(i10 << 3) + 8);
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzB = 0;
            while (i10 < size) {
                iZzB += zzln.zzB(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iZzB;
        }
        zzne zzneVar = (zzne) list;
        int iZzB2 = 0;
        while (i10 < size) {
            iZzB2 += zzln.zzB(zzneVar.zze(i10));
            i10++;
        }
        return iZzB2;
    }

    public static int zzg(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zznx)) {
            int iZzB = 0;
            while (i10 < size) {
                iZzB += zzln.zzB(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iZzB;
        }
        zznx zznxVar = (zznx) list;
        int iZzB2 = 0;
        while (i10 < size) {
            iZzB2 += zzln.zzB(zznxVar.zze(i10));
            i10++;
        }
        return iZzB2;
    }

    public static int zzh(int i10, Object obj, zzow zzowVar) {
        int i11 = i10 << 3;
        if (!(obj instanceof zznt)) {
            return zzln.zzA(i11) + zzln.zzy((zzoi) obj, zzowVar);
        }
        int iZzA = zzln.zzA(i11);
        int iZza = ((zznt) obj).zza();
        return iZzA + zzln.zzA(iZza) + iZza;
    }

    public static int zzi(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzA = 0;
            while (i10 < size) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                iZzA += zzln.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i10++;
            }
            return iZzA;
        }
        zzne zzneVar = (zzne) list;
        int iZzA2 = 0;
        while (i10 < size) {
            int iZze = zzneVar.zze(i10);
            iZzA2 += zzln.zzA((iZze >> 31) ^ (iZze + iZze));
            i10++;
        }
        return iZzA2;
    }

    public static int zzj(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zznx)) {
            int iZzB = 0;
            while (i10 < size) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                iZzB += zzln.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i10++;
            }
            return iZzB;
        }
        zznx zznxVar = (zznx) list;
        int iZzB2 = 0;
        while (i10 < size) {
            long jZze = zznxVar.zze(i10);
            iZzB2 += zzln.zzB((jZze >> 63) ^ (jZze + jZze));
            i10++;
        }
        return iZzB2;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzA = 0;
            while (i10 < size) {
                iZzA += zzln.zzA(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iZzA;
        }
        zzne zzneVar = (zzne) list;
        int iZzA2 = 0;
        while (i10 < size) {
            iZzA2 += zzln.zzA(zzneVar.zze(i10));
            i10++;
        }
        return iZzA2;
    }

    public static int zzl(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zznx)) {
            int iZzB = 0;
            while (i10 < size) {
                iZzB += zzln.zzB(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iZzB;
        }
        zznx zznxVar = (zznx) list;
        int iZzB2 = 0;
        while (i10 < size) {
            iZzB2 += zzln.zzB(zznxVar.zze(i10));
            i10++;
        }
        return iZzB2;
    }

    public static zzpl zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i10, List list, zznh zznhVar, Object obj2, zzpl zzplVar) {
        if (zznhVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zznhVar.zza(iIntValue)) {
                    obj2 = zzo(obj, i10, iIntValue, obj2, zzplVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Integer num = (Integer) list.get(i12);
            int iIntValue2 = num.intValue();
            if (zznhVar.zza(iIntValue2)) {
                if (i12 != i11) {
                    list.set(i11, num);
                }
                i11++;
            } else {
                obj2 = zzo(obj, i10, iIntValue2, obj2, zzplVar);
            }
        }
        if (i11 != size) {
            list.subList(i11, size).clear();
        }
        return obj2;
    }

    public static Object zzo(Object obj, int i10, int i11, Object obj2, zzpl zzplVar) {
        if (obj2 == null) {
            obj2 = zzplVar.zza(obj);
        }
        zzplVar.zzh(obj2, i10, i11);
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

    public static void zzr(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzc(i10, list, z10);
    }

    public static void zzs(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzg(i10, list, z10);
    }

    public static void zzt(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzj(i10, list, z10);
    }

    public static void zzu(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzl(i10, list, z10);
    }

    public static void zzv(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzn(i10, list, z10);
    }

    public static void zzw(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzp(i10, list, z10);
    }

    public static void zzx(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzs(i10, list, z10);
    }

    public static void zzy(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzu(i10, list, z10);
    }

    public static void zzz(int i10, List list, zzpy zzpyVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzy(i10, list, z10);
    }
}
