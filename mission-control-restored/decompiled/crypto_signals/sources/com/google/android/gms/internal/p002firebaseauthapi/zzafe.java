package com.google.android.gms.internal.p002firebaseauthapi;

import V2.e;
import V2.g;
import Z1.h;
import Z1.k;
import a3.d;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import f2.C0596b;
import f2.C0598d;
import h2.InterfaceC0620b;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;
import s3.AbstractC1024h;
import z.AbstractC1454l;

/* JADX INFO: loaded from: classes.dex */
public final class zzafe {
    private Context zza;
    private zzafx zzb;
    private String zzc;
    private final h zzd;
    private boolean zze;
    private String zzf;

    public zzafe(Context context, h hVar, String str) {
        this.zze = false;
        I.g(context);
        this.zza = context;
        I.g(hVar);
        this.zzd = hVar;
        this.zzc = AbstractC1024h.b("Android/Fallback/", str);
    }

    private static String zza(h hVar) {
        InterfaceC0620b interfaceC0620b = (InterfaceC0620b) FirebaseAuth.getInstance(hVar).f5468v.get();
        if (interfaceC0620b == null) {
            return null;
        }
        try {
            C0596b c0596b = (C0596b) Tasks.await(((C0598d) interfaceC0620b).b(false));
            k kVar = c0596b.f6424b;
            if (kVar != null) {
                Log.w("LocalRequestInterceptor", "Error getting App Check token; using placeholder token instead. Error: ".concat(String.valueOf(kVar)));
            }
            return c0596b.f6423a;
        } catch (InterruptedException e) {
            e = e;
            d.s("Unexpected error getting App Check token: ", e.getMessage(), "LocalRequestInterceptor");
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            d.s("Unexpected error getting App Check token: ", e.getMessage(), "LocalRequestInterceptor");
            return null;
        }
    }

    private static String zzb(h hVar) {
        Task taskCall;
        g gVar = (g) FirebaseAuth.getInstance(hVar).f5469w.get();
        if (gVar != null) {
            try {
                e eVar = (e) gVar;
                if (AbstractC1454l.a(eVar.f3245b)) {
                    taskCall = Tasks.call(eVar.e, new V2.d(eVar, 0));
                } else {
                    taskCall = Tasks.forResult("");
                }
                return (String) Tasks.await(taskCall);
            } catch (InterruptedException | ExecutionException e) {
                Log.w("LocalRequestInterceptor", "Unable to get heartbeats: " + e.getMessage());
            }
        }
        return null;
    }

    public final void zzb(String str) {
        this.zzf = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zzafe(h hVar, String str) {
        this(hVar.f3962a, hVar, str);
        hVar.a();
    }

    public final void zza(URLConnection uRLConnection) {
        String strJ;
        if (this.zze) {
            strJ = d.j(this.zzc, "/FirebaseUI-Android");
        } else {
            strJ = d.j(this.zzc, "/FirebaseCore-Android");
        }
        if (this.zzb == null) {
            this.zzb = new zzafx(this.zza);
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.zzb.zzb());
        uRLConnection.setRequestProperty("X-Android-Cert", this.zzb.zza());
        uRLConnection.setRequestProperty("Accept-Language", zzafd.zza());
        uRLConnection.setRequestProperty("X-Client-Version", strJ);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.zzf);
        h hVar = this.zzd;
        hVar.a();
        uRLConnection.setRequestProperty("X-Firebase-GMPID", hVar.f3964c.f3975b);
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
