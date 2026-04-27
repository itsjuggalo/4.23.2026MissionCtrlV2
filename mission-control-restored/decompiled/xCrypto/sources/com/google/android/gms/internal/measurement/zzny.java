package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzny {
    public static final /* synthetic */ int zza = 0;
    private static final zzoh zzb;

    static {
        int i4 = zznt.zza;
        zzb = new zzoj();
    }

    public static zzoh zzA() {
        return zzb;
    }

    public static boolean zzB(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzC(zzlr zzlrVar, Object obj, Object obj2) {
        if (((zzmb) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    public static void zzD(zzoh zzohVar, Object obj, Object obj2) {
        zzme zzmeVar = (zzme) obj;
        zzoi zzoiVarZzc = zzmeVar.zzc;
        zzoi zzoiVar = ((zzme) obj2).zzc;
        if (!zzoi.zza().equals(zzoiVar)) {
            if (zzoi.zza().equals(zzoiVarZzc)) {
                zzoiVarZzc = zzoi.zzc(zzoiVarZzc, zzoiVar);
            } else {
                zzoiVarZzc.zzl(zzoiVar);
            }
        }
        zzmeVar.zzc = zzoiVarZzc;
    }

    public static Object zzE(Object obj, int i4, int i5, Object obj2, zzoh zzohVar) {
        if (obj2 == null) {
            obj2 = zzohVar.zza(obj);
        }
        ((zzoi) obj2).zzk(i4 << 3, Long.valueOf(i5));
        return obj2;
    }

    public static void zza(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzC(i4, list, z4);
    }

    public static void zzb(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzB(i4, list, z4);
    }

    public static void zzc(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzy(i4, list, z4);
    }

    public static void zzd(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzz(i4, list, z4);
    }

    public static void zze(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzL(i4, list, z4);
    }

    public static void zzf(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzA(i4, list, z4);
    }

    public static void zzg(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzJ(i4, list, z4);
    }

    public static void zzh(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzw(i4, list, z4);
    }

    public static void zzi(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzH(i4, list, z4);
    }

    public static void zzj(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzK(i4, list, z4);
    }

    public static void zzk(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzx(i4, list, z4);
    }

    public static void zzl(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzI(i4, list, z4);
    }

    public static void zzm(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzD(i4, list, z4);
    }

    public static void zzn(int i4, List list, zzou zzouVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzE(i4, list, z4);
    }

    public static int zzo(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmz)) {
            int iZzA = 0;
            while (i4 < size) {
                iZzA += zzll.zzA(((Long) list.get(i4)).longValue());
                i4++;
            }
            return iZzA;
        }
        zzmz zzmzVar = (zzmz) list;
        int iZzA2 = 0;
        while (i4 < size) {
            iZzA2 += zzll.zzA(zzmzVar.zzc(i4));
            i4++;
        }
        return iZzA2;
    }

    public static int zzp(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmz)) {
            int iZzA = 0;
            while (i4 < size) {
                iZzA += zzll.zzA(((Long) list.get(i4)).longValue());
                i4++;
            }
            return iZzA;
        }
        zzmz zzmzVar = (zzmz) list;
        int iZzA2 = 0;
        while (i4 < size) {
            iZzA2 += zzll.zzA(zzmzVar.zzc(i4));
            i4++;
        }
        return iZzA2;
    }

    public static int zzq(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmz)) {
            int iZzA = 0;
            while (i4 < size) {
                long jLongValue = ((Long) list.get(i4)).longValue();
                iZzA += zzll.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i4++;
            }
            return iZzA;
        }
        zzmz zzmzVar = (zzmz) list;
        int iZzA2 = 0;
        while (i4 < size) {
            long jZzc = zzmzVar.zzc(i4);
            iZzA2 += zzll.zzA((jZzc >> 63) ^ (jZzc + jZzc));
            i4++;
        }
        return iZzA2;
    }

    public static int zzr(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmf)) {
            int iZzA = 0;
            while (i4 < size) {
                iZzA += zzll.zzA(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iZzA;
        }
        zzmf zzmfVar = (zzmf) list;
        int iZzA2 = 0;
        while (i4 < size) {
            iZzA2 += zzll.zzA(zzmfVar.zzf(i4));
            i4++;
        }
        return iZzA2;
    }

    public static int zzs(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmf)) {
            int iZzA = 0;
            while (i4 < size) {
                iZzA += zzll.zzA(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iZzA;
        }
        zzmf zzmfVar = (zzmf) list;
        int iZzA2 = 0;
        while (i4 < size) {
            iZzA2 += zzll.zzA(zzmfVar.zzf(i4));
            i4++;
        }
        return iZzA2;
    }

    public static int zzt(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmf)) {
            int iZzz = 0;
            while (i4 < size) {
                iZzz += zzll.zzz(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return iZzz;
        }
        zzmf zzmfVar = (zzmf) list;
        int iZzz2 = 0;
        while (i4 < size) {
            iZzz2 += zzll.zzz(zzmfVar.zzf(i4));
            i4++;
        }
        return iZzz2;
    }

    public static int zzu(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmf)) {
            int iZzz = 0;
            while (i4 < size) {
                int iIntValue = ((Integer) list.get(i4)).intValue();
                iZzz += zzll.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i4++;
            }
            return iZzz;
        }
        zzmf zzmfVar = (zzmf) list;
        int iZzz2 = 0;
        while (i4 < size) {
            int iZzf = zzmfVar.zzf(i4);
            iZzz2 += zzll.zzz((iZzf >> 31) ^ (iZzf + iZzf));
            i4++;
        }
        return iZzz2;
    }

    public static int zzv(List list) {
        return list.size() * 4;
    }

    public static int zzw(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzll.zzz(i4 << 3) + 4);
    }

    public static int zzx(List list) {
        return list.size() * 8;
    }

    public static int zzy(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzll.zzz(i4 << 3) + 8);
    }

    public static int zzz(int i4, Object obj, zznw zznwVar) {
        int i5 = i4 << 3;
        if (!(obj instanceof zzmv)) {
            return zzll.zzz(i5) + zzll.zzD((zznl) obj, zznwVar);
        }
        int iZzz = zzll.zzz(i5);
        int iZzb = ((zzmv) obj).zzb();
        return iZzz + zzll.zzz(iZzb) + iZzb;
    }
}
