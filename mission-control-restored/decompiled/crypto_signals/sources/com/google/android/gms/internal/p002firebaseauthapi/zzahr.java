package com.google.android.gms.internal.p002firebaseauthapi;

import B1.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzahr implements zzaez<zzahr> {
    private static final String zza = "zzahr";
    private String zzb;

    public zzahr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaez
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahr zza(String str) throws zzacn {
        try {
            this.zzb = e.a(new JSONObject(str).optString("producerProjectNumber"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajk.zza(e, zza, str);
        }
    }

    public zzahr(String str) {
        this.zzb = str;
    }

    public final String zza() {
        return this.zzb;
    }
}
