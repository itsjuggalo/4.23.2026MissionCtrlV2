package com.google.android.gms.internal.p002firebaseauthapi;

import W1.q;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzaiz implements zzaer<zzaiz> {
    private static final String zza = "zzaiz";
    private String zzb;
    private String zzc;
    private long zzd;
    private List<zzahq> zze;
    private String zzf;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaiz zza(String str) throws zzaci {
        try {
            JSONObject jSONObject = new JSONObject(str);
            q.a(jSONObject.optString("localId", null));
            q.a(jSONObject.optString("email", null));
            q.a(jSONObject.optString("displayName", null));
            this.zzb = q.a(jSONObject.optString("idToken", null));
            q.a(jSONObject.optString("photoUrl", null));
            this.zzc = q.a(jSONObject.optString("refreshToken", null));
            this.zzd = jSONObject.optLong("expiresIn", 0L);
            this.zze = zzahq.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzf = jSONObject.optString("mfaPendingCredential", null);
            return this;
        } catch (NullPointerException | JSONException e7) {
            throw zzajc.zza(e7, zza, str);
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final List<zzahq> zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return !TextUtils.isEmpty(this.zzf);
    }

    public final String zzb() {
        return this.zzb;
    }
}
