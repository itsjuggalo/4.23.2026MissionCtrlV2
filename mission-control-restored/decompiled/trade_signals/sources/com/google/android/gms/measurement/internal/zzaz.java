package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.revenuecat.purchases.common.Constants;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzaz {
    public static final zzaz zza = new zzaz((Boolean) null, 100, (Boolean) null, (String) null);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap zzf;

    public zzaz(Boolean bool, int i8, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        this.zzf = enumMap;
        enumMap.put(zzjk.AD_USER_DATA, zzjl.zzh(bool));
        this.zzb = i8;
        this.zzc = zzl();
        this.zzd = bool2;
        this.zze = str;
    }

    public static zzaz zza(zzji zzjiVar, int i8) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        enumMap.put(zzjk.AD_USER_DATA, zzjiVar);
        return new zzaz(enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzaz zzg(String str) {
        if (str == null || str.length() <= 0) {
            return zza;
        }
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        int i8 = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(zzjk.class);
        zzjk[] zzjkVarArrZza = zzjj.DMA.zza();
        int length = zzjkVarArrZza.length;
        int i9 = 1;
        int i10 = 0;
        while (i10 < length) {
            enumMap.put(zzjkVarArrZza[i10], zzjl.zzj(strArrSplit[i9].charAt(0)));
            i10++;
            i9++;
        }
        return new zzaz(enumMap, i8, (Boolean) null, (String) null);
    }

    public static zzaz zzh(Bundle bundle, int i8) {
        if (bundle == null) {
            return new zzaz((Boolean) null, i8, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(zzjk.class);
        for (zzjk zzjkVar : zzjj.DMA.zza()) {
            enumMap.put(zzjkVar, zzjl.zzg(bundle.getString(zzjkVar.zze)));
        }
        return new zzaz(enumMap, i8, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static Boolean zzi(Bundle bundle) {
        zzji zzjiVarZzg;
        if (bundle == null || (zzjiVarZzg = zzjl.zzg(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int iOrdinal = zzjiVarZzg.ordinal();
        if (iOrdinal == 2) {
            return Boolean.FALSE;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return Boolean.TRUE;
    }

    private final String zzl() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzjk zzjkVar : zzjj.DMA.zza()) {
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(zzjl.zzm((zzji) this.zzf.get(zzjkVar)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaz)) {
            return false;
        }
        zzaz zzazVar = (zzaz) obj;
        if (this.zzc.equalsIgnoreCase(zzazVar.zzc) && Objects.equals(this.zzd, zzazVar.zzd)) {
            return Objects.equals(this.zze, zzazVar.zze);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.zzd;
        int i8 = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.zze;
        return this.zzc.hashCode() + (i8 * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final String toString() {
        int iOrdinal;
        String str;
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzjl.zzd(this.zzb));
        for (zzjk zzjkVar : zzjj.DMA.zza()) {
            sb.append(com.amazon.a.a.o.b.f.f14100a);
            sb.append(zzjkVar.zze);
            sb.append(com.amazon.a.a.o.b.f.f14101b);
            zzji zzjiVar = (zzji) this.zzf.get(zzjkVar);
            if (zzjiVar == null || (iOrdinal = zzjiVar.ordinal()) == 0) {
                sb.append("uninitialized");
            } else {
                if (iOrdinal == 1) {
                    str = "eu_consent_policy";
                } else if (iOrdinal == 2) {
                    str = "denied";
                } else if (iOrdinal == 3) {
                    str = "granted";
                }
                sb.append(str);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str2 = this.zze;
        if (str2 != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str2);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzji zzc() {
        zzji zzjiVar = (zzji) this.zzf.get(zzjk.AD_USER_DATA);
        return zzjiVar == null ? zzji.UNINITIALIZED : zzjiVar;
    }

    public final boolean zzd() {
        Iterator it = this.zzf.values().iterator();
        while (it.hasNext()) {
            if (((zzji) it.next()) != zzji.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String zze() {
        return this.zzc;
    }

    public final Bundle zzf() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzf.entrySet()) {
            String strZzi = zzjl.zzi((zzji) entry.getValue());
            if (strZzi != null) {
                bundle.putString(((zzjk) entry.getKey()).zze, strZzi);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final Boolean zzj() {
        return this.zzd;
    }

    public final String zzk() {
        return this.zze;
    }

    private zzaz(EnumMap enumMap, int i8, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(zzjk.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i8;
        this.zzc = zzl();
        this.zzd = bool;
        this.zze = str;
    }
}
