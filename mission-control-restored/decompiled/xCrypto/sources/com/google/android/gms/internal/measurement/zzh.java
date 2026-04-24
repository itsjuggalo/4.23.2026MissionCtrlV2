package com.google.android.gms.internal.measurement;

import io.flutter.embedding.android.KeyboardMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzh {
    public static void zza(String str, int i4, List list) {
        if (list.size() != i4) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", str, Integer.valueOf(i4), Integer.valueOf(list.size())));
        }
    }

    public static void zzb(String str, int i4, List list) {
        if (list.size() < i4) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", str, Integer.valueOf(i4), Integer.valueOf(list.size())));
        }
    }

    public static void zzc(String str, int i4, List list) {
        if (list.size() > i4) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", str, Integer.valueOf(i4), Integer.valueOf(list.size())));
        }
    }

    public static boolean zzd(zzao zzaoVar) {
        if (zzaoVar == null) {
            return false;
        }
        Double dZzd = zzaoVar.zzd();
        return !dZzd.isNaN() && dZzd.doubleValue() >= 0.0d && dZzd.equals(Double.valueOf(Math.floor(dZzd.doubleValue())));
    }

    public static zzbk zze(String str) {
        zzbk zzbkVarZza = null;
        if (str != null && !str.isEmpty()) {
            zzbkVarZza = zzbk.zza(Integer.parseInt(str));
        }
        if (zzbkVarZza != null) {
            return zzbkVarZza;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", str));
    }

    public static boolean zzf(zzao zzaoVar, zzao zzaoVar2) {
        if (!zzaoVar.getClass().equals(zzaoVar2.getClass())) {
            return false;
        }
        if ((zzaoVar instanceof zzat) || (zzaoVar instanceof zzam)) {
            return true;
        }
        if (!(zzaoVar instanceof zzah)) {
            return zzaoVar instanceof zzas ? zzaoVar.zzc().equals(zzaoVar2.zzc()) : zzaoVar instanceof zzaf ? zzaoVar.zze().equals(zzaoVar2.zze()) : zzaoVar == zzaoVar2;
        }
        if (Double.isNaN(zzaoVar.zzd().doubleValue()) || Double.isNaN(zzaoVar2.zzd().doubleValue())) {
            return false;
        }
        return zzaoVar.zzd().equals(zzaoVar2.zzd());
    }

    public static int zzg(double d4) {
        if (Double.isNaN(d4) || Double.isInfinite(d4) || d4 == 0.0d) {
            return 0;
        }
        return (int) ((((double) (d4 > 0.0d ? 1 : -1)) * Math.floor(Math.abs(d4))) % 4.294967296E9d);
    }

    public static long zzh(double d4) {
        return ((long) zzg(d4)) & KeyboardMap.kValueMask;
    }

    public static double zzi(double d4) {
        if (Double.isNaN(d4)) {
            return 0.0d;
        }
        if (Double.isInfinite(d4) || d4 == 0.0d || d4 == 0.0d) {
            return d4;
        }
        return ((double) (d4 > 0.0d ? 1 : -1)) * Math.floor(Math.abs(d4));
    }

    public static Object zzj(zzao zzaoVar) {
        if (zzao.zzg.equals(zzaoVar)) {
            return null;
        }
        if (zzao.zzf.equals(zzaoVar)) {
            return "";
        }
        if (zzaoVar instanceof zzal) {
            return zzk((zzal) zzaoVar);
        }
        if (!(zzaoVar instanceof zzae)) {
            return !zzaoVar.zzd().isNaN() ? zzaoVar.zzd() : zzaoVar.zzc();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((zzae) zzaoVar).iterator();
        while (it.hasNext()) {
            Object objZzj = zzj((zzao) it.next());
            if (objZzj != null) {
                arrayList.add(objZzj);
            }
        }
        return arrayList;
    }

    public static Map zzk(zzal zzalVar) {
        HashMap map = new HashMap();
        for (String str : zzalVar.zzb()) {
            Object objZzj = zzj(zzalVar.zzk(str));
            if (objZzj != null) {
                map.put(str, objZzj);
            }
        }
        return map;
    }

    public static int zzl(zzg zzgVar) {
        int iZzg = zzg(zzgVar.zzh("runtime.counter").zzd().doubleValue() + 1.0d);
        if (iZzg > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        zzgVar.zze("runtime.counter", new zzah(Double.valueOf(iZzg)));
        return iZzg;
    }
}
