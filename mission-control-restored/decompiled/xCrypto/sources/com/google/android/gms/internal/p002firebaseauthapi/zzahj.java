package com.google.android.gms.internal.p002firebaseauthapi;

import G1.q;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzahj implements zzaer<zzahj> {
    private static final String zza = "zzahj";
    private String zzb;

    public zzahj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahj zza(String str) throws zzaci {
        try {
            this.zzb = q.a(new JSONObject(str).optString("producerProjectNumber"));
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzajc.zza(e4, zza, str);
        }
    }

    public zzahj(String str) {
        this.zzb = str;
    }

    public final String zza() {
        return this.zzb;
    }
}
