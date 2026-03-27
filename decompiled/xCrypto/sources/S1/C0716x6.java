package S1;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: S1.x6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0716x6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5049a;

    public C0716x6(Map map) {
        HashMap map2 = new HashMap();
        this.f5049a = map2;
        map2.putAll(map);
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        a2.k kVar = AbstractC0732z6.f5091a;
        int size = kVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            String str = (String) kVar.get(i4);
            Map map = this.f5049a;
            if (map.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append(com.amazon.a.a.o.b.f.f8805b);
                sb.append((String) map.get(str));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle b() {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0716x6.b():android.os.Bundle");
    }

    public final String c() {
        String str = (String) this.f5049a.get("PurposeDiagnostics");
        return TextUtils.isEmpty(str) ? "200000" : str;
    }

    public final String d(C0716x6 c0716x6) {
        Map map = c0716x6.f5049a;
        String str = (map.isEmpty() || ((String) map.get("Version")) != null) ? "0" : "1";
        Bundle bundleB = b();
        Bundle bundleB2 = c0716x6.b();
        return str.concat((bundleB.size() == bundleB2.size() && Objects.equals(bundleB.getString("ad_storage"), bundleB2.getString("ad_storage")) && Objects.equals(bundleB.getString("ad_personalization"), bundleB2.getString("ad_personalization")) && Objects.equals(bundleB.getString("ad_user_data"), bundleB2.getString("ad_user_data"))) ? "0" : "1");
    }

    public final String e() {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        int i4 = -1;
        try {
            String str = (String) this.f5049a.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                i4 = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        if (i4 < 0 || i4 > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4 >> 6));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4 & 63));
        }
        int iG = g();
        if (iG < 0 || iG > 63) {
            sb.append("0");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(iG));
        }
        AbstractC0940s.a(true);
        Map map = this.f5049a;
        int i5 = true != "1".equals(map.get("gdprApplies")) ? 0 : 2;
        boolean zEquals = "1".equals(map.get("EnableAdvertiserConsentMode"));
        int i6 = i5 | 4;
        if (zEquals) {
            i6 = i5 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i6));
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0716x6) {
            return a().equalsIgnoreCase(((C0716x6) obj).a());
        }
        return false;
    }

    public final Bundle f() {
        int iG;
        Map map = this.f5049a;
        if ("1".equals(map.get("GoogleConsent")) && (iG = g()) >= 0) {
            String str = (String) map.get("PurposeConsents");
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                String str2 = "denied";
                if (str.length() > 0) {
                    bundle.putString(Z3.AD_STORAGE.f4321a, str.charAt(0) == '1' ? "granted" : "denied");
                }
                if (str.length() > 3) {
                    bundle.putString(Z3.AD_PERSONALIZATION.f4321a, (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
                }
                if (str.length() > 6 && iG >= 4) {
                    String str3 = Z3.AD_USER_DATA.f4321a;
                    if (str.charAt(0) == '1' && str.charAt(6) == '1') {
                        str2 = "granted";
                    }
                    bundle.putString(str3, str2);
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    public final int g() {
        try {
            String str = (String) this.f5049a.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a();
    }
}
