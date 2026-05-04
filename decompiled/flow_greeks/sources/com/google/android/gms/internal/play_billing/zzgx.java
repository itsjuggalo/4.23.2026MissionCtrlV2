package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzgx {
    public static final /* synthetic */ int zza = 0;
    private static final zzhh zzb;

    static {
        int i10 = zzgs.zza;
        zzb = new zzhj();
    }

    public static void zzA(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzC(i10, list, z10);
    }

    public static void zzB(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzE(i10, list, z10);
    }

    public static void zzC(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzJ(i10, list, z10);
    }

    public static void zzD(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzL(i10, list, z10);
    }

    public static boolean zzE(Object obj, Object obj2) {
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
        if (!(list instanceof zzfj)) {
            int iZzD = 0;
            while (i10 < size) {
                iZzD += zzep.zzD(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iZzD;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZzD2 = 0;
        while (i10 < size) {
            iZzD2 += zzep.zzD(zzfjVar.zze(i10));
            i10++;
        }
        return iZzD2;
    }

    public static int zzb(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzep.zzC(i10 << 3) + 4);
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzep.zzC(i10 << 3) + 8);
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
        if (!(list instanceof zzfj)) {
            int iZzD = 0;
            while (i10 < size) {
                iZzD += zzep.zzD(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iZzD;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZzD2 = 0;
        while (i10 < size) {
            iZzD2 += zzep.zzD(zzfjVar.zze(i10));
            i10++;
        }
        return iZzD2;
    }

    public static int zzg(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzga)) {
            int iZzD = 0;
            while (i10 < size) {
                iZzD += zzep.zzD(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iZzD;
        }
        zzga zzgaVar = (zzga) list;
        int iZzD2 = 0;
        while (i10 < size) {
            iZzD2 += zzep.zzD(zzgaVar.zze(i10));
            i10++;
        }
        return iZzD2;
    }

    public static int zzh(int i10, Object obj, zzgv zzgvVar) {
        int i11 = i10 << 3;
        if (!(obj instanceof zzfw)) {
            return zzep.zzC(i11) + zzep.zzA((zzgl) obj, zzgvVar);
        }
        int iZzC = zzep.zzC(i11);
        int iZza = ((zzfw) obj).zza();
        return iZzC + zzep.zzC(iZza) + iZza;
    }

    public static int zzi(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfj)) {
            int iZzC = 0;
            while (i10 < size) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                iZzC += zzep.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i10++;
            }
            return iZzC;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZzC2 = 0;
        while (i10 < size) {
            int iZze = zzfjVar.zze(i10);
            iZzC2 += zzep.zzC((iZze >> 31) ^ (iZze + iZze));
            i10++;
        }
        return iZzC2;
    }

    public static int zzj(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzga)) {
            int iZzD = 0;
            while (i10 < size) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                iZzD += zzep.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i10++;
            }
            return iZzD;
        }
        zzga zzgaVar = (zzga) list;
        int iZzD2 = 0;
        while (i10 < size) {
            long jZze = zzgaVar.zze(i10);
            iZzD2 += zzep.zzD((jZze >> 63) ^ (jZze + jZze));
            i10++;
        }
        return iZzD2;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfj)) {
            int iZzC = 0;
            while (i10 < size) {
                iZzC += zzep.zzC(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iZzC;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZzC2 = 0;
        while (i10 < size) {
            iZzC2 += zzep.zzC(zzfjVar.zze(i10));
            i10++;
        }
        return iZzC2;
    }

    public static int zzl(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzga)) {
            int iZzD = 0;
            while (i10 < size) {
                iZzD += zzep.zzD(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iZzD;
        }
        zzga zzgaVar = (zzga) list;
        int iZzD2 = 0;
        while (i10 < size) {
            iZzD2 += zzep.zzD(zzgaVar.zze(i10));
            i10++;
        }
        return iZzD2;
    }

    public static zzhh zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i10, int i11, Object obj2, zzhh zzhhVar) {
        if (obj2 == null) {
            obj2 = zzhhVar.zza(obj);
        }
        ((zzhi) obj2).zzj(i10 << 3, Long.valueOf(i11));
        return obj2;
    }

    public static void zzo(zzev zzevVar, Object obj, Object obj2) {
        if (((zzff) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    public static void zzp(zzhh zzhhVar, Object obj, Object obj2) {
        zzfi zzfiVar = (zzfi) obj;
        zzhi zzhiVarZze = zzfiVar.zzc;
        zzhi zzhiVar = ((zzfi) obj2).zzc;
        if (!zzhi.zzc().equals(zzhiVar)) {
            if (zzhi.zzc().equals(zzhiVarZze)) {
                zzhiVarZze = zzhi.zze(zzhiVarZze, zzhiVar);
            } else {
                zzhiVarZze.zzd(zzhiVar);
            }
        }
        zzfiVar.zzc = zzhiVarZze;
    }

    public static void zzq(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzc(i10, list, z10);
    }

    public static void zzr(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzg(i10, list, z10);
    }

    public static void zzs(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzj(i10, list, z10);
    }

    public static void zzt(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzl(i10, list, z10);
    }

    public static void zzu(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzn(i10, list, z10);
    }

    public static void zzv(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzp(i10, list, z10);
    }

    public static void zzw(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzs(i10, list, z10);
    }

    public static void zzx(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzu(i10, list, z10);
    }

    public static void zzy(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzy(i10, list, z10);
    }

    public static void zzz(int i10, List list, zzhu zzhuVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzA(i10, list, z10);
    }
}
