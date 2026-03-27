package Z2;

import android.net.Uri;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzan;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: renamed from: Z2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0755f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzan f5782g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5788f;

    static {
        HashMap map = new HashMap();
        map.put("recoverEmail", 2);
        map.put("resetPassword", 0);
        map.put("signIn", 4);
        map.put("verifyEmail", 1);
        map.put("verifyBeforeChangeEmail", 5);
        map.put("revertSecondFactorAddition", 6);
        f5782g = zzan.zza(map);
    }

    public C0755f(String str) {
        String strE = e(str, "apiKey");
        String strE2 = e(str, "oobCode");
        String strE3 = e(str, "mode");
        if (strE == null || strE2 == null || strE3 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
        }
        this.f5783a = AbstractC1207s.e(strE);
        this.f5784b = AbstractC1207s.e(strE2);
        this.f5785c = AbstractC1207s.e(strE3);
        this.f5786d = e(str, "continueUrl");
        this.f5787e = e(str, "lang");
        this.f5788f = e(str, "tenantId");
    }

    public static C0755f c(String str) {
        AbstractC1207s.e(str);
        try {
            return new C0755f(str);
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
                return Uri.parse(AbstractC1207s.e(uri.getQueryParameter("link"))).getQueryParameter(str2);
            }
            return null;
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }

    public String a() {
        return this.f5784b;
    }

    public int b() {
        zzan zzanVar = f5782g;
        if (zzanVar.containsKey(this.f5785c)) {
            return ((Integer) zzanVar.get(this.f5785c)).intValue();
        }
        return 3;
    }

    public final String d() {
        return this.f5788f;
    }
}
