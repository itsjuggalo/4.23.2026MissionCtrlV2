package N1;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzkp;
import com.google.android.gms.internal.measurement.zzkq;

/* JADX INFO: loaded from: classes.dex */
public abstract class H1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V1.i f1258a;

    static {
        V1.c cVar = V1.e.f3200b;
        Object[] objArr = new Object[24];
        objArr[0] = "Version";
        objArr[1] = "GoogleConsent";
        objArr[2] = "VendorConsent";
        objArr[3] = "VendorLegitimateInterest";
        objArr[4] = "gdprApplies";
        objArr[5] = "EnableAdvertiserConsentMode";
        objArr[6] = "PolicyVersion";
        objArr[7] = "PurposeConsents";
        objArr[8] = "PurposeOneTreatment";
        objArr[9] = "Purpose1";
        objArr[10] = "Purpose3";
        objArr[11] = "Purpose4";
        System.arraycopy(new String[]{"Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics"}, 0, objArr, 12, 12);
        D1.b.d(24, objArr);
        f1258a = V1.e.l(24, objArr);
    }

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

    public static final boolean c(zzkp zzkpVar, V1.n nVar, V1.n nVar2, V1.r rVar, char[] cArr, int i, int i6, int i7, String str, String str2, String str3, boolean z6, boolean z7) {
        G1 g12;
        char c6;
        int iD = d(zzkpVar);
        if (iD > 0 && (i6 != 1 || i != 1)) {
            cArr[iD] = '2';
        }
        if (h(zzkpVar, nVar2) == zzkq.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            c6 = '3';
        } else {
            if (zzkpVar == zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE && i7 == 1 && rVar.f3234d.equals(str)) {
                if (iD > 0 && cArr[iD] != '2') {
                    cArr[iD] = '1';
                }
                return true;
            }
            if (nVar.containsKey(zzkpVar) && (g12 = (G1) nVar.get(zzkpVar)) != null) {
                int iOrdinal = g12.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            return h(zzkpVar, nVar2) == zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST ? g(zzkpVar, cArr, str3, z7) : f(zzkpVar, cArr, str2, z6);
                        }
                        if (iOrdinal == 3) {
                            return h(zzkpVar, nVar2) == zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT ? f(zzkpVar, cArr, str2, z6) : g(zzkpVar, cArr, str3, z7);
                        }
                        c6 = '0';
                    } else if (h(zzkpVar, nVar2) != zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                        return g(zzkpVar, cArr, str3, z7);
                    }
                } else if (h(zzkpVar, nVar2) != zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                    return f(zzkpVar, cArr, str2, z6);
                }
                c6 = '8';
            } else {
                c6 = '0';
            }
        }
        if (iD <= 0 || cArr[iD] == '2') {
            return false;
        }
        cArr[iD] = c6;
        return false;
    }

    public static final int d(zzkp zzkpVar) {
        if (zzkpVar == zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzkpVar == zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzkpVar == zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzkpVar == zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    public static final String e(zzkp zzkpVar, String str, String str2) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(str) || str.length() < zzkpVar.zza()) ? "0" : String.valueOf(str.charAt(zzkpVar.zza() - 1));
        if (!TextUtils.isEmpty(str2) && str2.length() >= zzkpVar.zza()) {
            strValueOf = String.valueOf(str2.charAt(zzkpVar.zza() - 1));
        }
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    public static final boolean f(zzkp zzkpVar, char[] cArr, String str, boolean z6) {
        char c6;
        int iD = d(zzkpVar);
        if (!z6) {
            c6 = '4';
        } else {
            if (str.length() >= zzkpVar.zza()) {
                char cCharAt = str.charAt(zzkpVar.zza() - 1);
                boolean z7 = cCharAt == '1';
                if (iD > 0 && cArr[iD] != '2') {
                    cArr[iD] = cCharAt != '1' ? '6' : '1';
                }
                return z7;
            }
            c6 = '0';
        }
        if (iD > 0 && cArr[iD] != '2') {
            cArr[iD] = c6;
        }
        return false;
    }

    public static final boolean g(zzkp zzkpVar, char[] cArr, String str, boolean z6) {
        char c6;
        int iD = d(zzkpVar);
        if (!z6) {
            c6 = '5';
        } else {
            if (str.length() >= zzkpVar.zza()) {
                char cCharAt = str.charAt(zzkpVar.zza() - 1);
                boolean z7 = cCharAt == '1';
                if (iD > 0 && cArr[iD] != '2') {
                    cArr[iD] = cCharAt != '1' ? '7' : '1';
                }
                return z7;
            }
            c6 = '0';
        }
        if (iD > 0 && cArr[iD] != '2') {
            cArr[iD] = c6;
        }
        return false;
    }

    public static final zzkq h(zzkp zzkpVar, V1.n nVar) {
        Object obj = zzkq.PURPOSE_RESTRICTION_UNDEFINED;
        Object obj2 = nVar.get(zzkpVar);
        if (obj2 != null) {
            obj = obj2;
        }
        return (zzkq) obj;
    }
}
