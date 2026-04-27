package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import com.google.android.gms.common.internal.I;
import i2.C0657c;
import i2.C0659e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzagx implements zzafa {
    private static final String zza = "zzagx";
    private final String zzb;
    private final String zzc;
    private final C0659e zzd;
    private final String zze;
    private final String zzf;

    static {
        String[] strArr = new String[0];
        if (strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str);
            }
            sb.append("] ");
        }
        for (int i = 2; i <= 7 && !Log.isLoggable(zza, i); i++) {
        }
    }

    public zzagx(C0659e c0659e, String str, String str2) {
        I.g(c0659e);
        this.zzd = c0659e;
        String str3 = c0659e.f6788a;
        I.d(str3);
        this.zzb = str3;
        String str4 = c0659e.f6790c;
        I.d(str4);
        this.zzc = str4;
        this.zze = str;
        this.zzf = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        C0657c c0657c;
        String str = this.zzc;
        zzal zzalVar = C0657c.f6784d;
        I.d(str);
        try {
            c0657c = new C0657c(str);
        } catch (IllegalArgumentException unused) {
            c0657c = null;
        }
        String str2 = c0657c != null ? c0657c.f6785a : null;
        String str3 = c0657c != null ? c0657c.f6787c : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zzb);
        if (str2 != null) {
            jSONObject.put("oobCode", str2);
        }
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        String str4 = this.zze;
        if (str4 != null) {
            jSONObject.put("idToken", str4);
        }
        String str5 = this.zzf;
        if (str5 != null) {
            zzajk.zza(jSONObject, "captchaResp", str5);
        } else {
            zzajk.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public final C0659e zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzf;
    }
}
