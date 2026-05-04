package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import o9.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f6331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f6332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l5.c f6333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fa.b f6334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final fa.b f6335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ga.h f6336f;

    public g0(a7.g gVar, l0 l0Var, fa.b bVar, fa.b bVar2, ga.h hVar) {
        this(gVar, l0Var, new l5.c(gVar.m()), bVar, bVar2, hVar);
    }

    public static /* synthetic */ String a(g0 g0Var, Task task) {
        g0Var.getClass();
        return g0Var.h((Bundle) task.getResult(IOException.class));
    }

    public static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static boolean i(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    public Task c() {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return d(l(l0.c(this.f6331a), "*", bundle));
    }

    public final Task d(Task task) {
        return task.continueWith(new h2.g(), new Continuation() { // from class: com.google.firebase.messaging.f0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return g0.a(this.f6319a, task2);
            }
        });
    }

    public final String e() {
        try {
            return b(MessageDigest.getInstance("SHA-1").digest(this.f6331a.q().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    public Task f() {
        return this.f6333c.a();
    }

    public Task g() {
        return d(l(l0.c(this.f6331a), "*", new Bundle()));
    }

    public final String h(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public final void j(String str, String str2, Bundle bundle) {
        j.a aVarB;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("gmp_app_id", this.f6331a.r().c());
        bundle.putString("gmsv", Integer.toString(this.f6332b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f6332b.a());
        bundle.putString("app_ver_name", this.f6332b.b());
        bundle.putString("firebase-app-name-hash", e());
        try {
            String strB = ((ga.m) Tasks.await(this.f6336f.a(false))).b();
            if (TextUtils.isEmpty(strB)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strB);
            }
        } catch (InterruptedException e10) {
            e = e10;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        } catch (ExecutionException e11) {
            e = e11;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        }
        bundle.putString("appid", (String) Tasks.await(this.f6336f.getId()));
        bundle.putString("cliv", "fcm-25.0.1");
        o9.j jVar = (o9.j) this.f6335e.get();
        oa.i iVar = (oa.i) this.f6334d.get();
        if (jVar == null || iVar == null || (aVarB = jVar.b("fire-iid")) == j.a.NONE) {
            return;
        }
        bundle.putString("Firebase-Client-Log-Type", Integer.toString(aVarB.b()));
        bundle.putString("Firebase-Client", iVar.a());
    }

    public Task k(boolean z10) {
        return this.f6333c.d(z10);
    }

    public final Task l(String str, String str2, Bundle bundle) {
        try {
            j(str, str2, bundle);
            return this.f6333c.c(bundle);
        } catch (InterruptedException | ExecutionException e10) {
            return Tasks.forException(e10);
        }
    }

    public Task m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return d(l(str, "/topics/" + str2, bundle));
    }

    public Task n(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return d(l(str, "/topics/" + str2, bundle));
    }

    public g0(a7.g gVar, l0 l0Var, l5.c cVar, fa.b bVar, fa.b bVar2, ga.h hVar) {
        this.f6331a = gVar;
        this.f6332b = l0Var;
        this.f6333c = cVar;
        this.f6334d = bVar;
        this.f6335e = bVar2;
        this.f6336f = hVar;
    }
}
