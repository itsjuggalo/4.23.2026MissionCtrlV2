package com.google.android.gms.internal.p002firebaseauthapi;

import L3.i;
import Q2.g;
import Y2.b;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzaew {
    private Context zza;
    private zzafp zzb;
    private String zzc;
    private final g zzd;
    private boolean zze;
    private String zzf;

    public zzaew(g gVar, String str) {
        this(gVar.m(), gVar, str);
    }

    private static String zza(g gVar) {
        b bVar = (b) FirebaseAuth.getInstance(gVar).u0().get();
        if (bVar == null) {
            return null;
        }
        try {
            V2.b bVar2 = (V2.b) Tasks.await(bVar.a(false));
            if (bVar2.a() != null) {
                Log.w("LocalRequestInterceptor", "Error getting App Check token; using placeholder token instead. Error: " + String.valueOf(bVar2.a()));
            }
            return bVar2.b();
        } catch (InterruptedException e7) {
            e = e7;
            Log.e("LocalRequestInterceptor", "Unexpected error getting App Check token: " + e.getMessage());
            return null;
        } catch (ExecutionException e8) {
            e = e8;
            Log.e("LocalRequestInterceptor", "Unexpected error getting App Check token: " + e.getMessage());
            return null;
        }
    }

    private static String zzb(g gVar) {
        i iVar = (i) FirebaseAuth.getInstance(gVar).y0().get();
        if (iVar != null) {
            try {
                return (String) Tasks.await(iVar.a());
            } catch (InterruptedException | ExecutionException e7) {
                Log.w("LocalRequestInterceptor", "Unable to get heartbeats: " + e7.getMessage());
            }
        }
        return null;
    }

    public zzaew(Context context, g gVar, String str) {
        this.zze = false;
        this.zza = (Context) AbstractC1207s.k(context);
        this.zzd = (g) AbstractC1207s.k(gVar);
        this.zzc = String.format("Android/%s/%s", "Fallback", str);
    }

    public final void zzb(String str) {
        this.zzf = str;
    }

    public final void zza(URLConnection uRLConnection) {
        String str;
        if (this.zze) {
            str = this.zzc + "/FirebaseUI-Android";
        } else {
            str = this.zzc + "/FirebaseCore-Android";
        }
        if (this.zzb == null) {
            this.zzb = new zzafp(this.zza);
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.zzb.zzb());
        uRLConnection.setRequestProperty("X-Android-Cert", this.zzb.zza());
        uRLConnection.setRequestProperty("Accept-Language", zzaev.zza());
        uRLConnection.setRequestProperty("X-Client-Version", str);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.zzf);
        uRLConnection.setRequestProperty("X-Firebase-GMPID", this.zzd.r().c());
        uRLConnection.setRequestProperty("X-Firebase-Client", zzb(this.zzd));
        String strZza = zza(this.zzd);
        if (!TextUtils.isEmpty(strZza)) {
            uRLConnection.setRequestProperty("X-Firebase-AppCheck", strZza);
        }
        this.zzf = null;
    }

    public final void zza(String str) {
        this.zze = !TextUtils.isEmpty(str);
    }
}
