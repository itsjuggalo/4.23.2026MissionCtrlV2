package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zziz {
    public static final /* synthetic */ int zza = 0;
    private static final zzjj zzb;

    static {
        int i4 = zziu.zza;
        zzb = new zzjl();
    }

    public static void zzA(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzC(i4, list, z4);
    }

    public static void zzB(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzE(i4, list, z4);
    }

    public static void zzC(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzJ(i4, list, z4);
    }

    public static void zzD(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzL(i4, list, z4);
    }

    public static boolean zzE(Object obj, Object obj2) {
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
        if (!(list instanceof zzhl)) {
            int iZzA = 0;
            while (i4 < size) {
                iZzA += zzgr.zzA(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iZzA;
        }
        zzhl zzhlVar = (zzhl) list;
        int iZzA2 = 0;
        while (i4 < size) {
            iZzA2 += zzgr.zzA(zzhlVar.zze(i4));
            i4++;
        }
        return iZzA2;
    }

    public static int zzb(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgr.zzz(i4 << 3) + 4);
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgr.zzz(i4 << 3) + 8);
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
        if (!(list instanceof zzhl)) {
            int iZzA = 0;
            while (i4 < size) {
                iZzA += zzgr.zzA(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iZzA;
        }
        zzhl zzhlVar = (zzhl) list;
        int iZzA2 = 0;
        while (i4 < size) {
            iZzA2 += zzgr.zzA(zzhlVar.zze(i4));
            i4++;
        }
        return iZzA2;
    }

    public static int zzg(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzib)) {
            int iZzA = 0;
            while (i4 < size) {
                iZzA += zzgr.zzA(((Long) list.get(i4)).longValue());
                i4++;
            }
            return iZzA;
        }
        zzib zzibVar = (zzib) list;
        int iZzA2 = 0;
        while (i4 < size) {
            iZzA2 += zzgr.zzA(zzibVar.zze(i4));
            i4++;
        }
        return iZzA2;
    }

    public static int zzh(int i4, Object obj, zzix zzixVar) {
        int i5 = i4 << 3;
        if (!(obj instanceof zzhx)) {
            return zzgr.zzz(i5) + zzgr.zzx((zzim) obj, zzixVar);
        }
        int iZzz = zzgr.zzz(i5);
        int iZza = ((zzhx) obj).zza();
        return iZzz + zzgr.zzz(iZza) + iZza;
    }

    public static int zzi(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhl)) {
            int iZzz = 0;
            while (i4 < size) {
                int iIntValue = ((Integer) list.get(i4)).intValue();
                iZzz += zzgr.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i4++;
            }
            return iZzz;
        }
        zzhl zzhlVar = (zzhl) list;
        int iZzz2 = 0;
        while (i4 < size) {
            int iZze = zzhlVar.zze(i4);
            iZzz2 += zzgr.zzz((iZze >> 31) ^ (iZze + iZze));
            i4++;
        }
        return iZzz2;
    }

    public static int zzj(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzib)) {
            int iZzA = 0;
            while (i4 < size) {
                long jLongValue = ((Long) list.get(i4)).longValue();
                iZzA += zzgr.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i4++;
            }
            return iZzA;
        }
        zzib zzibVar = (zzib) list;
        int iZzA2 = 0;
        while (i4 < size) {
            long jZze = zzibVar.zze(i4);
            iZzA2 += zzgr.zzA((jZze >> 63) ^ (jZze + jZze));
            i4++;
        }
        return iZzA2;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhl)) {
            int iZzz = 0;
            while (i4 < size) {
                iZzz += zzgr.zzz(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iZzz;
        }
        zzhl zzhlVar = (zzhl) list;
        int iZzz2 = 0;
        while (i4 < size) {
            iZzz2 += zzgr.zzz(zzhlVar.zze(i4));
            i4++;
        }
        return iZzz2;
    }

    public static int zzl(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzib)) {
            int iZzA = 0;
            while (i4 < size) {
                iZzA += zzgr.zzA(((Long) list.get(i4)).longValue());
                i4++;
            }
            return iZzA;
        }
        zzib zzibVar = (zzib) list;
        int iZzA2 = 0;
        while (i4 < size) {
            iZzA2 += zzgr.zzA(zzibVar.zze(i4));
            i4++;
        }
        return iZzA2;
    }

    public static zzjj zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i4, int i5, Object obj2, zzjj zzjjVar) {
        Object obj3 = obj2;
        if (obj2 == null) {
            zzhk zzhkVar = (zzhk) obj;
            zzjk zzjkVar = zzhkVar.zzc;
            obj3 = zzjkVar;
            if (zzjkVar == zzjk.zzc()) {
                zzjk zzjkVarZzf = zzjk.zzf();
                zzhkVar.zzc = zzjkVarZzf;
                obj3 = zzjkVarZzf;
            }
        }
        ((zzjk) obj3).zzj(i4 << 3, Long.valueOf(i5));
        return obj3;
    }

    public static void zzo(zzgx zzgxVar, Object obj, Object obj2) {
        if (((zzhh) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    public static void zzp(zzjj zzjjVar, Object obj, Object obj2) {
        zzhk zzhkVar = (zzhk) obj;
        zzjk zzjkVarZze = zzhkVar.zzc;
        zzjk zzjkVar = ((zzhk) obj2).zzc;
        if (!zzjk.zzc().equals(zzjkVar)) {
            if (zzjk.zzc().equals(zzjkVarZze)) {
                zzjkVarZze = zzjk.zze(zzjkVarZze, zzjkVar);
            } else {
                zzjkVarZze.zzd(zzjkVar);
            }
        }
        zzhkVar.zzc = zzjkVarZze;
    }

    public static void zzq(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzc(i4, list, z4);
    }

    public static void zzr(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzg(i4, list, z4);
    }

    public static void zzs(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzj(i4, list, z4);
    }

    public static void zzt(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzl(i4, list, z4);
    }

    public static void zzu(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzn(i4, list, z4);
    }

    public static void zzv(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzp(i4, list, z4);
    }

    public static void zzw(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzs(i4, list, z4);
    }

    public static void zzx(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzu(i4, list, z4);
    }

    public static void zzy(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzy(i4, list, z4);
    }

    public static void zzz(int i4, List list, zzjw zzjwVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzA(i4, list, z4);
    }
}
