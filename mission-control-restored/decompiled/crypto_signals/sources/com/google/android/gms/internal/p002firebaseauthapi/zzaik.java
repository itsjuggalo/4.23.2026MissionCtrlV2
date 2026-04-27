package com.google.android.gms.internal.p002firebaseauthapi;

import B1.e;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzaik implements zzaez<zzaik> {
    private static final String zza = "zzaik";
    private String zzb;
    private zzaia zzc;
    private String zzd;
    private String zze;
    private long zzf;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaez
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaik zza(String str) throws zzacn {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = e.a(jSONObject.optString("email"));
            e.a(jSONObject.optString("passwordHash"));
            jSONObject.optBoolean("emailVerified", false);
            e.a(jSONObject.optString("displayName"));
            e.a(jSONObject.optString("photoUrl"));
            this.zzc = zzaia.zza(jSONObject.optJSONArray("providerUserInfo"));
            this.zzd = e.a(jSONObject.optString("idToken"));
            this.zze = e.a(jSONObject.optString("refreshToken"));
            this.zzf = jSONObject.optLong("expiresIn", 0L);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajk.zza(e, zza, str);
        }
    }

    public final long zza() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zze;
    }

    public final List<zzaib> zze() {
        zzaia zzaiaVar = this.zzc;
        if (zzaiaVar != null) {
            return zzaiaVar.zza();
        }
        return null;
    }

    public final String zzb() {
        return this.zzb;
    }
}
