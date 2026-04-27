package i2;

import android.net.Uri;
import com.google.android.gms.internal.p002firebaseauthapi.zzal;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: renamed from: i2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0657c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzal f6784d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6787c;

    static {
        HashMap map = new HashMap();
        map.put("recoverEmail", 2);
        map.put("resetPassword", 0);
        map.put("signIn", 4);
        map.put("verifyEmail", 1);
        map.put("verifyBeforeChangeEmail", 5);
        map.put("revertSecondFactorAddition", 6);
        f6784d = zzal.zza(map);
    }

    public C0657c(String str) {
        String strA = a(str, "apiKey");
        String strA2 = a(str, "oobCode");
        String strA3 = a(str, "mode");
        if (strA == null || strA2 == null || strA3 == null) {
            throw new IllegalArgumentException("apiKey, oobCode and mode are required in a valid action code URL");
        }
        com.google.android.gms.common.internal.I.d(strA);
        com.google.android.gms.common.internal.I.d(strA2);
        this.f6785a = strA2;
        com.google.android.gms.common.internal.I.d(strA3);
        this.f6786b = strA3;
        a(str, "continueUrl");
        a(str, "lang");
        this.f6787c = a(str, "tenantId");
    }

    public static String a(String str, String str2) {
        Uri uri = Uri.parse(str);
        try {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return uri.getQueryParameter(str2);
            }
            if (!queryParameterNames.contains("link")) {
                return null;
            }
            String queryParameter = uri.getQueryParameter("link");
            com.google.android.gms.common.internal.I.d(queryParameter);
            return Uri.parse(queryParameter).getQueryParameter(str2);
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }
}
