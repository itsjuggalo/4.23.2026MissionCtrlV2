package S1;

import a2.l;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzko;
import com.google.android.gms.internal.measurement.zzkp;
import java.util.Map;

/* JADX INFO: renamed from: S1.z6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0732z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2.k f5091a = a2.k.A("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");

    public static String a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static int b(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(com.google.android.gms.internal.measurement.zzko r19, a2.l r20, a2.l r21, a2.m r22, char[] r23, int r24, int r25, int r26, int r27, int r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, boolean r32, boolean r33, boolean r34) {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.AbstractC0732z6.c(com.google.android.gms.internal.measurement.zzko, a2.l, a2.l, a2.m, char[], int, int, int, int, int, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean):boolean");
    }

    public static final Map d(a2.l lVar, a2.l lVar2, a2.m mVar, char[] cArr, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        zzko zzkoVar;
        Object obj;
        zzko zzkoVar2;
        Object obj2;
        if (((Boolean) AbstractC0569f2.f4559b1.b(null)).booleanValue() && !z6) {
            return a2.l.k();
        }
        zzko zzkoVar3 = zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        zzkp zzkpVar = (zzkp) lVar2.get(zzkoVar3);
        zzko zzkoVar4 = zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        zzkp zzkpVar2 = (zzkp) lVar2.get(zzkoVar4);
        zzko zzkoVar5 = zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        zzkp zzkpVar3 = (zzkp) lVar2.get(zzkoVar5);
        zzko zzkoVar6 = zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        zzkp zzkpVar4 = (zzkp) lVar2.get(zzkoVar6);
        l.a aVarI = a2.l.a().f("Version", "2").f("VendorConsent", true != z4 ? "0" : "1").f("VendorLegitimateInterest", true != z5 ? "0" : "1").f("gdprApplies", i6 != 1 ? "0" : "1").f("EnableAdvertiserConsentMode", i5 != 1 ? "0" : "1").f("PolicyVersion", String.valueOf(i7)).f("CmpSdkID", String.valueOf(i4)).f("PurposeOneTreatment", i8 != 1 ? "0" : "1").f("PublisherCC", str).f("PublisherRestrictions1", String.valueOf(zzkpVar != null ? zzkpVar.zza() : zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza())).f("PublisherRestrictions3", String.valueOf(zzkpVar2 != null ? zzkpVar2.zza() : zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza())).f("PublisherRestrictions4", String.valueOf(zzkpVar3 != null ? zzkpVar3.zza() : zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza())).f("PublisherRestrictions7", String.valueOf(zzkpVar4 != null ? zzkpVar4.zza() : zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza())).i(a2.l.l("Purpose1", f(zzkoVar3, lVar, lVar2, mVar, cArr, i4, i5, i6, i7, i8, str, str2, str3, z4, z5, z6), "Purpose3", f(zzkoVar4, lVar, lVar2, mVar, cArr, i4, i5, i6, i7, i8, str, str2, str3, z4, z5, z6), "Purpose4", f(zzkoVar5, lVar, lVar2, mVar, cArr, i4, i5, i6, i7, i8, str, str2, str3, z4, z5, z6), "Purpose7", f(zzkoVar6, lVar, lVar2, mVar, cArr, i4, i5, i6, i7, i8, str, str2, str3, z4, z5, z6)));
        if (true != c(zzkoVar3, lVar, lVar2, mVar, cArr, i4, i5, i6, i7, i8, str, str2, str3, z4, z5, z6)) {
            zzkoVar = zzkoVar4;
            obj = "0";
        } else {
            zzkoVar = zzkoVar4;
            obj = "1";
        }
        if (true != c(zzkoVar, lVar, lVar2, mVar, cArr, i4, i5, i6, i7, i8, str, str2, str3, z4, z5, z6)) {
            zzkoVar2 = zzkoVar5;
            obj2 = "0";
        } else {
            zzkoVar2 = zzkoVar5;
            obj2 = "1";
        }
        return aVarI.i(a2.l.m("AuthorizePurpose1", obj, "AuthorizePurpose3", obj2, "AuthorizePurpose4", true != c(zzkoVar2, lVar, lVar2, mVar, cArr, i4, i5, i6, i7, i8, str, str2, str3, z4, z5, z6) ? "0" : "1", "AuthorizePurpose7", true != c(zzkoVar6, lVar, lVar2, mVar, cArr, i4, i5, i6, i7, i8, str, str2, str3, z4, z5, z6) ? "0" : "1", "PurposeDiagnostics", new String(cArr))).c();
    }

    public static final int e(zzko zzkoVar, a2.l lVar, a2.l lVar2, a2.m mVar, char[] cArr, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        if (zzkoVar == zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzkoVar == zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzkoVar == zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzkoVar == zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    public static final String f(zzko zzkoVar, a2.l lVar, a2.l lVar2, a2.m mVar, char[] cArr, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(str2) || str2.length() < zzkoVar.zza()) ? "0" : String.valueOf(str2.charAt(zzkoVar.zza() - 1));
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzkoVar.zza()) {
            strValueOf = String.valueOf(str3.charAt(zzkoVar.zza() - 1));
        }
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    public static final boolean g(zzko zzkoVar, a2.l lVar, a2.l lVar2, a2.m mVar, char[] cArr, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        char c4;
        int iE = e(zzkoVar, lVar, lVar2, mVar, cArr, i4, i5, i6, i7, i8, str, str2, str3, z4, z5, z6);
        if (!z4) {
            c4 = '4';
        } else {
            if (str2.length() >= zzkoVar.zza()) {
                char cCharAt = str2.charAt(zzkoVar.zza() - 1);
                boolean z7 = cCharAt == '1';
                if (iE > 0 && cArr[iE] != '2') {
                    cArr[iE] = cCharAt != '1' ? '6' : '1';
                }
                return z7;
            }
            c4 = '0';
        }
        if (iE > 0 && cArr[iE] != '2') {
            cArr[iE] = c4;
        }
        return false;
    }

    public static final boolean h(zzko zzkoVar, a2.l lVar, a2.l lVar2, a2.m mVar, char[] cArr, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        char c4;
        int iE = e(zzkoVar, lVar, lVar2, mVar, cArr, i4, i5, i6, i7, i8, str, str2, str3, z4, z5, z6);
        if (!z5) {
            c4 = '5';
        } else {
            if (str3.length() >= zzkoVar.zza()) {
                char cCharAt = str3.charAt(zzkoVar.zza() - 1);
                boolean z7 = cCharAt == '1';
                if (iE > 0 && cArr[iE] != '2') {
                    cArr[iE] = cCharAt != '1' ? '7' : '1';
                }
                return z7;
            }
            c4 = '0';
        }
        if (iE > 0 && cArr[iE] != '2') {
            cArr[iE] = c4;
        }
        return false;
    }

    public static final zzkp i(zzko zzkoVar, a2.l lVar, a2.l lVar2, a2.m mVar, char[] cArr, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        return (zzkp) lVar2.getOrDefault(zzkoVar, zzkp.PURPOSE_RESTRICTION_UNDEFINED);
    }
}
