package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ActionCodeUrl {
    private static final com.google.android.gms.internal.p002firebaseauthapi.zzan<String, Integer> zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    static {
        HashMap map = new HashMap();
        map.put("recoverEmail", 2);
        map.put("resetPassword", 0);
        map.put("signIn", 4);
        map.put("verifyEmail", 1);
        map.put("verifyBeforeChangeEmail", 5);
        map.put("revertSecondFactorAddition", 6);
        zza = com.google.android.gms.internal.p002firebaseauthapi.zzan.zza(map);
    }

    private ActionCodeUrl(String str) {
        String strZza = zza(str, "apiKey");
        String strZza2 = zza(str, "oobCode");
        String strZza3 = zza(str, "mode");
        if (strZza == null || strZza2 == null || strZza3 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
        }
        this.zzb = AbstractC0940s.e(strZza);
        this.zzc = AbstractC0940s.e(strZza2);
        this.zzd = AbstractC0940s.e(strZza3);
        this.zze = zza(str, "continueUrl");
        this.zzf = zza(str, "lang");
        this.zzg = zza(str, "tenantId");
    }

    public static ActionCodeUrl parseLink(String str) {
        AbstractC0940s.e(str);
        try {
            return new ActionCodeUrl(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String getApiKey() {
        return this.zzb;
    }

    public String getCode() {
        return this.zzc;
    }

    public String getContinueUrl() {
        return this.zze;
    }

    public String getLanguageCode() {
        return this.zzf;
    }

    public int getOperation() {
        com.google.android.gms.internal.p002firebaseauthapi.zzan<String, Integer> zzanVar = zza;
        if (zzanVar.containsKey(this.zzd)) {
            return zzanVar.get(this.zzd).intValue();
        }
        return 3;
    }

    public final String zza() {
        return this.zzg;
    }

    private static String zza(String str, String str2) {
        Uri uri = Uri.parse(str);
        try {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return uri.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(AbstractC0940s.e(uri.getQueryParameter("link"))).getQueryParameter(str2);
            }
            return null;
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }
}
