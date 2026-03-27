package com.google.firebase.auth.internal;

import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzam extends MultiFactorSession {
    public static final Parcelable.Creator<zzam> CREATOR = new zzap();
    private String zza;
    private String zzb;
    private List<PhoneMultiFactorInfo> zzc;
    private List<TotpMultiFactorInfo> zzd;
    private zzaf zze;

    private zzam() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 1, this.zza, false);
        c.E(parcel, 2, this.zzb, false);
        c.I(parcel, 3, this.zzc, false);
        c.I(parcel, 4, this.zzd, false);
        c.C(parcel, 5, this.zze, i4, false);
        c.b(parcel, iA);
    }

    public final zzaf zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zza != null;
    }

    public zzam(String str, String str2, List<PhoneMultiFactorInfo> list, List<TotpMultiFactorInfo> list2, zzaf zzafVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
        this.zzd = list2;
        this.zze = zzafVar;
    }

    public static zzam zza(String str, zzaf zzafVar) {
        AbstractC0940s.e(str);
        zzam zzamVar = new zzam();
        zzamVar.zza = str;
        zzamVar.zze = zzafVar;
        return zzamVar;
    }

    public static zzam zza(List<MultiFactorInfo> list, String str) {
        AbstractC0940s.k(list);
        AbstractC0940s.e(str);
        zzam zzamVar = new zzam();
        zzamVar.zzc = new ArrayList();
        zzamVar.zzd = new ArrayList();
        for (MultiFactorInfo multiFactorInfo : list) {
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzamVar.zzc.add((PhoneMultiFactorInfo) multiFactorInfo);
            } else if (multiFactorInfo instanceof TotpMultiFactorInfo) {
                zzamVar.zzd.add((TotpMultiFactorInfo) multiFactorInfo);
            } else {
                throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: " + multiFactorInfo.getFactorId());
            }
        }
        zzamVar.zzb = str;
        return zzamVar;
    }
}
