package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import w2.k;
import w2.l;
import w2.m;

/* JADX INFO: loaded from: classes.dex */
public final class zzof {
    static final k zza = k.S("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");
    public static final /* synthetic */ int zzb = 0;

    public static String zza(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static int zzb(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0202  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean zzc(com.google.android.gms.internal.measurement.zzkp r21, w2.l r22, w2.l r23, w2.m r24, char[] r25, int r26, int r27, int r28, int r29, int r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, boolean r34, boolean r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzof.zzc(com.google.android.gms.internal.measurement.zzkp, w2.l, w2.l, w2.m, char[], int, int, int, int, int, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean):boolean");
    }

    public static final Map zzd(l lVar, l lVar2, m mVar, char[] cArr, int i8, int i9, int i10, int i11, int i12, String str, String str2, String str3, boolean z7, boolean z8, boolean z9) {
        if (!z9) {
            return l.j();
        }
        com.google.android.gms.internal.measurement.zzkp zzkpVar = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar = (com.google.android.gms.internal.measurement.zzkq) lVar2.get(zzkpVar);
        com.google.android.gms.internal.measurement.zzkp zzkpVar2 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar2 = (com.google.android.gms.internal.measurement.zzkq) lVar2.get(zzkpVar2);
        com.google.android.gms.internal.measurement.zzkp zzkpVar3 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        com.google.android.gms.internal.measurement.zzkq zzkqVar3 = (com.google.android.gms.internal.measurement.zzkq) lVar2.get(zzkpVar3);
        com.google.android.gms.internal.measurement.zzkp zzkpVar4 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar4 = (com.google.android.gms.internal.measurement.zzkq) lVar2.get(zzkpVar4);
        l.a aVarF = l.a().f("Version", "2").f("VendorConsent", true != z7 ? "0" : "1").f("VendorLegitimateInterest", true != z8 ? "0" : "1").f("gdprApplies", i10 != 1 ? "0" : "1").f("EnableAdvertiserConsentMode", i9 != 1 ? "0" : "1").f("PolicyVersion", String.valueOf(i11)).f("CmpSdkID", String.valueOf(i8)).f("PurposeOneTreatment", i12 != 1 ? "0" : "1").f("PublisherCC", str);
        if (zzkqVar == null) {
            zzkqVar = com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED;
        }
        l.a aVarF2 = aVarF.f("PublisherRestrictions1", String.valueOf(zzkqVar.zza()));
        if (zzkqVar2 == null) {
            zzkqVar2 = com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED;
        }
        return aVarF2.f("PublisherRestrictions3", String.valueOf(zzkqVar2.zza())).f("PublisherRestrictions4", String.valueOf(zzkqVar3 != null ? zzkqVar3.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza())).f("PublisherRestrictions7", String.valueOf(zzkqVar4 != null ? zzkqVar4.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza())).i(l.k("Purpose1", zzf(zzkpVar, lVar, lVar2, mVar, cArr, i8, i9, i10, i11, i12, str, str2, str3, z7, z8, true), "Purpose3", zzf(zzkpVar2, lVar, lVar2, mVar, cArr, i8, i9, i10, i11, i12, str, str2, str3, z7, z8, true), "Purpose4", zzf(zzkpVar3, lVar, lVar2, mVar, cArr, i8, i9, i10, i11, i12, str, str2, str3, z7, z8, true), "Purpose7", zzf(zzkpVar4, lVar, lVar2, mVar, cArr, i8, i9, i10, i11, i12, str, str2, str3, z7, z8, true))).i(l.l("AuthorizePurpose1", true != zzc(zzkpVar, lVar, lVar2, mVar, cArr, i8, i9, i10, i11, i12, str, str2, str3, z7, z8, true) ? "0" : "1", "AuthorizePurpose3", true != zzc(zzkpVar2, lVar, lVar2, mVar, cArr, i8, i9, i10, i11, i12, str, str2, str3, z7, z8, true) ? "0" : "1", "AuthorizePurpose4", true != zzc(zzkpVar3, lVar, lVar2, mVar, cArr, i8, i9, i10, i11, i12, str, str2, str3, z7, z8, true) ? "0" : "1", "AuthorizePurpose7", true == zzc(zzkpVar4, lVar, lVar2, mVar, cArr, i8, i9, i10, i11, i12, str, str2, str3, z7, z8, true) ? "1" : "0", "PurposeDiagnostics", new String(cArr))).c();
    }

    private static final int zze(com.google.android.gms.internal.measurement.zzkp zzkpVar, l lVar, l lVar2, m mVar, char[] cArr, int i8, int i9, int i10, int i11, int i12, String str, String str2, String str3, boolean z7, boolean z8, boolean z9) {
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private static final String zzf(com.google.android.gms.internal.measurement.zzkp zzkpVar, l lVar, l lVar2, m mVar, char[] cArr, int i8, int i9, int i10, int i11, int i12, String str, String str2, String str3, boolean z7, boolean z8, boolean z9) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(str2) || str2.length() < zzkpVar.zza()) ? "0" : String.valueOf(str2.charAt(zzkpVar.zza() - 1));
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzkpVar.zza()) {
            strValueOf = String.valueOf(str3.charAt(zzkpVar.zza() - 1));
        }
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    private static final boolean zzg(com.google.android.gms.internal.measurement.zzkp zzkpVar, l lVar, l lVar2, m mVar, char[] cArr, int i8, int i9, int i10, int i11, int i12, String str, String str2, String str3, boolean z7, boolean z8, boolean z9) {
        char c8;
        int iZze = zze(zzkpVar, lVar, lVar2, mVar, cArr, i8, i9, i10, i11, i12, str, str2, str3, z7, z8, true);
        if (!z7) {
            c8 = '4';
        } else {
            if (str2.length() >= zzkpVar.zza()) {
                char cCharAt = str2.charAt(zzkpVar.zza() - 1);
                boolean z10 = cCharAt == '1';
                if (iZze > 0 && cArr[iZze] != '2') {
                    cArr[iZze] = cCharAt != '1' ? '6' : '1';
                }
                return z10;
            }
            c8 = '0';
        }
        if (iZze > 0 && cArr[iZze] != '2') {
            cArr[iZze] = c8;
        }
        return false;
    }

    private static final boolean zzh(com.google.android.gms.internal.measurement.zzkp zzkpVar, l lVar, l lVar2, m mVar, char[] cArr, int i8, int i9, int i10, int i11, int i12, String str, String str2, String str3, boolean z7, boolean z8, boolean z9) {
        char c8;
        int iZze = zze(zzkpVar, lVar, lVar2, mVar, cArr, i8, i9, i10, i11, i12, str, str2, str3, z7, z8, true);
        if (!z8) {
            c8 = '5';
        } else {
            if (str3.length() >= zzkpVar.zza()) {
                char cCharAt = str3.charAt(zzkpVar.zza() - 1);
                boolean z10 = cCharAt == '1';
                if (iZze > 0 && cArr[iZze] != '2') {
                    cArr[iZze] = cCharAt != '1' ? '7' : '1';
                }
                return z10;
            }
            c8 = '0';
        }
        if (iZze > 0 && cArr[iZze] != '2') {
            cArr[iZze] = c8;
        }
        return false;
    }

    private static final com.google.android.gms.internal.measurement.zzkq zzi(com.google.android.gms.internal.measurement.zzkp zzkpVar, l lVar, l lVar2, m mVar, char[] cArr, int i8, int i9, int i10, int i11, int i12, String str, String str2, String str3, boolean z7, boolean z8, boolean z9) {
        return (com.google.android.gms.internal.measurement.zzkq) lVar2.getOrDefault(zzkpVar, com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED);
    }
}
