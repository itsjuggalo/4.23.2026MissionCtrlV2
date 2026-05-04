package m7;

import android.net.Uri;
import com.google.android.gms.internal.p002firebaseauthapi.zzal;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzal f16006g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f16012f;

    static {
        HashMap map = new HashMap();
        map.put("recoverEmail", 2);
        map.put("resetPassword", 0);
        map.put("signIn", 4);
        map.put("verifyEmail", 1);
        map.put("verifyBeforeChangeEmail", 5);
        map.put("revertSecondFactorAddition", 6);
        f16006g = zzal.zza(map);
    }

    public f(String str) {
        String strE = e(str, "apiKey");
        String strE2 = e(str, "oobCode");
        String strE3 = e(str, "mode");
        if (strE == null || strE2 == null || strE3 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
        }
        this.f16007a = com.google.android.gms.common.internal.s.e(strE);
        this.f16008b = com.google.android.gms.common.internal.s.e(strE2);
        this.f16009c = com.google.android.gms.common.internal.s.e(strE3);
        this.f16010d = e(str, "continueUrl");
        this.f16011e = e(str, "lang");
        this.f16012f = e(str, "tenantId");
    }

    public static f c(String str) {
        com.google.android.gms.common.internal.s.e(str);
        try {
            return new f(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String e(String str, String str2) {
        Uri uri = Uri.parse(str);
        try {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return uri.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(com.google.android.gms.common.internal.s.e(uri.getQueryParameter("link"))).getQueryParameter(str2);
            }
            return null;
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }

    public String a() {
        return this.f16008b;
    }

    public int b() {
        zzal zzalVar = f16006g;
        if (zzalVar.containsKey(this.f16009c)) {
            return ((Integer) zzalVar.get(this.f16009c)).intValue();
        }
        return 3;
    }

    public final String d() {
        return this.f16012f;
    }
}
