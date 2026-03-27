package U3;

import L3.j;
import O1.C0641c;
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

/* JADX INFO: loaded from: classes.dex */
public class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.g f4795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J f4796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0641c f4797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final N3.b f4798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final N3.b f4799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final O3.h f4800f;

    public F(Q2.g gVar, J j7, N3.b bVar, N3.b bVar2, O3.h hVar) {
        this(gVar, j7, new C0641c(gVar.m()), bVar, bVar2, hVar);
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
        return d(m(J.c(this.f4795a), "*", bundle));
    }

    public final Task d(Task task) {
        return task.continueWith(new B0.k(), new Continuation() { // from class: U3.E
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.f4794a.j(task2);
            }
        });
    }

    public final String e() {
        try {
            return b(MessageDigest.getInstance("SHA-1").digest(this.f4795a.q().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    public Task f() {
        return this.f4797c.a();
    }

    public Task g() {
        return d(m(J.c(this.f4795a), "*", new Bundle()));
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

    public final /* synthetic */ String j(Task task) {
        return h((Bundle) task.getResult(IOException.class));
    }

    public final void k(String str, String str2, Bundle bundle) {
        j.a aVarB;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("gmp_app_id", this.f4795a.r().c());
        bundle.putString("gmsv", Integer.toString(this.f4796b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f4796b.a());
        bundle.putString("app_ver_name", this.f4796b.b());
        bundle.putString("firebase-app-name-hash", e());
        try {
            String strB = ((O3.m) Tasks.await(this.f4800f.a(false))).b();
            if (TextUtils.isEmpty(strB)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strB);
            }
        } catch (InterruptedException e7) {
            e = e7;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        } catch (ExecutionException e8) {
            e = e8;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        }
        bundle.putString("appid", (String) Tasks.await(this.f4800f.getId()));
        bundle.putString("cliv", "fcm-24.1.2");
        L3.j jVar = (L3.j) this.f4799e.get();
        X3.i iVar = (X3.i) this.f4798d.get();
        if (jVar == null || iVar == null || (aVarB = jVar.b("fire-iid")) == j.a.NONE) {
            return;
        }
        bundle.putString("Firebase-Client-Log-Type", Integer.toString(aVarB.b()));
        bundle.putString("Firebase-Client", iVar.a());
    }

    public Task l(boolean z7) {
        return this.f4797c.d(z7);
    }

    public final Task m(String str, String str2, Bundle bundle) {
        try {
            k(str, str2, bundle);
            return this.f4797c.c(bundle);
        } catch (InterruptedException | ExecutionException e7) {
            return Tasks.forException(e7);
        }
    }

    public Task n(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return d(m(str, "/topics/" + str2, bundle));
    }

    public Task o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return d(m(str, "/topics/" + str2, bundle));
    }

    public F(Q2.g gVar, J j7, C0641c c0641c, N3.b bVar, N3.b bVar2, O3.h hVar) {
        this.f4795a = gVar;
        this.f4796b = j7;
        this.f4797c = c0641c;
        this.f4798d = bVar;
        this.f4799e = bVar2;
        this.f4800f = hVar;
    }
}
