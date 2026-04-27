package com.google.firebase.messaging;

import B3.j;
import P1.C0759c;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.InterfaceC2319c;
import w0.ExecutorC2893k;

/* JADX INFO: loaded from: classes.dex */
public class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G2.f f15612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final L f15613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0759c f15614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final S3.b f15615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final S3.b f15616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final T3.h f15617f;

    public G(G2.f fVar, L l8, C0759c c0759c, S3.b bVar, S3.b bVar2, T3.h hVar) {
        this.f15612a = fVar;
        this.f15613b = l8;
        this.f15614c = c0759c;
        this.f15615d = bVar;
        this.f15616e = bVar2;
        this.f15617f = hVar;
    }

    public static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static boolean i(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    public AbstractC2328l c() {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return d(m(L.c(this.f15612a), "*", bundle));
    }

    public final AbstractC2328l d(AbstractC2328l abstractC2328l) {
        return abstractC2328l.h(new ExecutorC2893k(), new InterfaceC2319c() { // from class: com.google.firebase.messaging.F
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l2) {
                return this.f15591a.j(abstractC2328l2);
            }
        });
    }

    public final String e() {
        try {
            return b(MessageDigest.getInstance("SHA-1").digest(this.f15612a.q().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    public AbstractC2328l f() {
        return this.f15614c.a();
    }

    public AbstractC2328l g() {
        return d(m(L.c(this.f15612a), "*", new Bundle()));
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

    public final /* synthetic */ String j(AbstractC2328l abstractC2328l) {
        return h((Bundle) abstractC2328l.l(IOException.class));
    }

    public final void k(String str, String str2, Bundle bundle) {
        j.a aVarB;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("gmp_app_id", this.f15612a.r().c());
        bundle.putString("gmsv", Integer.toString(this.f15613b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f15613b.a());
        bundle.putString("app_ver_name", this.f15613b.b());
        bundle.putString("firebase-app-name-hash", e());
        try {
            String strB = ((T3.m) AbstractC2331o.a(this.f15617f.a(false))).b();
            if (TextUtils.isEmpty(strB)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strB);
            }
        } catch (InterruptedException e8) {
            e = e8;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        } catch (ExecutionException e9) {
            e = e9;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        }
        bundle.putString("appid", (String) AbstractC2331o.a(this.f15617f.getId()));
        bundle.putString("cliv", "fcm-25.0.0");
        B3.j jVar = (B3.j) this.f15616e.get();
        a4.i iVar = (a4.i) this.f15615d.get();
        if (jVar == null || iVar == null || (aVarB = jVar.b("fire-iid")) == j.a.NONE) {
            return;
        }
        bundle.putString("Firebase-Client-Log-Type", Integer.toString(aVarB.b()));
        bundle.putString("Firebase-Client", iVar.a());
    }

    public AbstractC2328l l(boolean z7) {
        return this.f15614c.d(z7);
    }

    public final AbstractC2328l m(String str, String str2, Bundle bundle) {
        try {
            k(str, str2, bundle);
            return this.f15614c.c(bundle);
        } catch (InterruptedException | ExecutionException e8) {
            return AbstractC2331o.d(e8);
        }
    }

    public AbstractC2328l n(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return d(m(str, "/topics/" + str2, bundle));
    }

    public AbstractC2328l o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return d(m(str, "/topics/" + str2, bundle));
    }

    public G(G2.f fVar, L l8, S3.b bVar, S3.b bVar2, T3.h hVar) {
        this(fVar, l8, new C0759c(fVar.m()), bVar, bVar2, hVar);
    }
}
