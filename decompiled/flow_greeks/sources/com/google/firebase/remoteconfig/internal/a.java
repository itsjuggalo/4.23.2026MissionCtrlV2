package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import pa.p;
import pa.q;
import pa.t;
import t5.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f6468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpURLConnection f6469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f6470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final qa.e f6471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final pa.c f6472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f6473f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f6476i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Random f6474g = new Random();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6477j = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t5.e f6475h = h.d();

    /* JADX INFO: renamed from: com.google.firebase.remoteconfig.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class RunnableC0103a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f6479b;

        public RunnableC0103a(int i10, long j10) {
            this.f6478a = i10;
            this.f6479b = j10;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a.this.d(this.f6478a, this.f6479b);
        }
    }

    public a(HttpURLConnection httpURLConnection, c cVar, qa.e eVar, Set set, pa.c cVar2, ScheduledExecutorService scheduledExecutorService, e eVar2) {
        this.f6469b = httpURLConnection;
        this.f6470c = cVar;
        this.f6471d = eVar;
        this.f6468a = set;
        this.f6472e = cVar2;
        this.f6473f = scheduledExecutorService;
        this.f6476i = eVar2;
    }

    public static /* synthetic */ Task a(a aVar, Task task, Task task2, long j10, int i10, Task task3) throws JSONException {
        aVar.getClass();
        if (!task.isSuccessful()) {
            return Tasks.forException(new p("Failed to auto-fetch config update.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new p("Failed to get activated config for auto-fetch", task2.getException()));
        }
        c.a aVar2 = (c.a) task.getResult();
        b bVarA = (b) task2.getResult();
        if (!e(aVar2, j10).booleanValue()) {
            Log.d("FirebaseRemoteConfig", "Fetched template version is the same as SDK's current version. Retrying fetch.");
            aVar.b(i10, j10);
            return Tasks.forResult(null);
        }
        if (aVar2.d() == null) {
            Log.d("FirebaseRemoteConfig", "The fetch succeeded, but the backend had no updates.");
            return Tasks.forResult(null);
        }
        if (bVarA == null) {
            bVarA = b.l().a();
        }
        Set setF = bVarA.f(aVar2.d());
        if (setF.isEmpty()) {
            Log.d("FirebaseRemoteConfig", "Config was fetched, but no params changed.");
            return Tasks.forResult(null);
        }
        aVar.c(pa.b.a(setF));
        return Tasks.forResult(null);
    }

    public static Boolean e(c.a aVar, long j10) {
        if (aVar.d() != null) {
            return Boolean.valueOf(aVar.d().k() >= j10);
        }
        return Boolean.valueOf(aVar.f() == 1);
    }

    public final void b(int i10, long j10) {
        if (i10 == 0) {
            j(new t("Unable to fetch the latest version of the template.", q.a.CONFIG_UPDATE_NOT_FETCHED));
        } else {
            this.f6473f.schedule(new RunnableC0103a(i10, j10), this.f6474g.nextInt(4), TimeUnit.SECONDS);
        }
    }

    public final synchronized void c(pa.b bVar) {
        Iterator it = this.f6468a.iterator();
        while (it.hasNext()) {
            ((pa.c) it.next()).onUpdate(bVar);
        }
    }

    public synchronized Task d(int i10, final long j10) throws Throwable {
        final int i11 = i10 - 1;
        try {
            try {
                final Task taskN = this.f6470c.n(c.b.REALTIME, 3 - i11);
                final Task taskE = this.f6471d.e();
                return Tasks.whenAllComplete((Task<?>[]) new Task[]{taskN, taskE}).continueWithTask(this.f6473f, new Continuation() { // from class: qa.a
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        return com.google.firebase.remoteconfig.internal.a.a(this.f18964a, taskN, taskE, j10, i11, task);
                    }
                });
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
    
        r5 = new org.json.JSONObject(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
    
        if (r5.has("featureDisabled") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        if (r5.getBoolean("featureDisabled") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
    
        r10.f6472e.onError(new pa.t("The server is temporarily unavailable. Try again in a few minutes.", pa.q.a.CONFIG_UPDATE_UNAVAILABLE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        if (g() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if (r5.has("latestTemplateVersionNumber") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        r6 = r10.f6470c.r();
        r8 = r5.getLong("latestTemplateVersionNumber");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        if (r8 <= r6) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        b(3, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        if (r5.has("retryIntervalSeconds") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
    
        l(r5.getInt("retryIntervalSeconds"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.io.InputStream r11) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "retryIntervalSeconds"
            java.lang.String r1 = "latestTemplateVersionNumber"
            java.lang.String r2 = "featureDisabled"
            java.io.BufferedReader r3 = new java.io.BufferedReader
            java.io.InputStreamReader r4 = new java.io.InputStreamReader
            java.lang.String r5 = "utf-8"
            r4.<init>(r11, r5)
            r3.<init>(r4)
            java.lang.String r11 = ""
        L14:
            r4 = r11
        L15:
            java.lang.String r5 = r3.readLine()
            if (r5 == 0) goto La5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = "}"
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L15
            java.lang.String r4 = r10.i(r4)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L3d
            goto L15
        L3d:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L5d
            r5.<init>(r4)     // Catch: org.json.JSONException -> L5d
            boolean r4 = r5.has(r2)     // Catch: org.json.JSONException -> L5d
            if (r4 == 0) goto L5f
            boolean r4 = r5.getBoolean(r2)     // Catch: org.json.JSONException -> L5d
            if (r4 == 0) goto L5f
            pa.c r4 = r10.f6472e     // Catch: org.json.JSONException -> L5d
            pa.t r5 = new pa.t     // Catch: org.json.JSONException -> L5d
            java.lang.String r6 = "The server is temporarily unavailable. Try again in a few minutes."
            pa.q$a r7 = pa.q.a.CONFIG_UPDATE_UNAVAILABLE     // Catch: org.json.JSONException -> L5d
            r5.<init>(r6, r7)     // Catch: org.json.JSONException -> L5d
            r4.onError(r5)     // Catch: org.json.JSONException -> L5d
            goto La5
        L5d:
            r4 = move-exception
            goto L8c
        L5f:
            boolean r4 = r10.g()     // Catch: org.json.JSONException -> L5d
            if (r4 == 0) goto L66
            goto La5
        L66:
            boolean r4 = r5.has(r1)     // Catch: org.json.JSONException -> L5d
            if (r4 == 0) goto L7e
            com.google.firebase.remoteconfig.internal.c r4 = r10.f6470c     // Catch: org.json.JSONException -> L5d
            long r6 = r4.r()     // Catch: org.json.JSONException -> L5d
            long r8 = r5.getLong(r1)     // Catch: org.json.JSONException -> L5d
            int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r4 <= 0) goto L7e
            r4 = 3
            r10.b(r4, r8)     // Catch: org.json.JSONException -> L5d
        L7e:
            boolean r4 = r5.has(r0)     // Catch: org.json.JSONException -> L5d
            if (r4 == 0) goto L14
            int r4 = r5.getInt(r0)     // Catch: org.json.JSONException -> L5d
            r10.l(r4)     // Catch: org.json.JSONException -> L5d
            goto L14
        L8c:
            pa.p r5 = new pa.p
            java.lang.Throwable r6 = r4.getCause()
            pa.q$a r7 = pa.q.a.CONFIG_UPDATE_MESSAGE_INVALID
            java.lang.String r8 = "Unable to parse config update message."
            r5.<init>(r8, r6, r7)
            r10.j(r5)
            java.lang.String r5 = "FirebaseRemoteConfig"
            java.lang.String r6 = "Unable to parse latest config update message."
            android.util.Log.e(r5, r6, r4)
            goto L14
        La5:
            r3.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.a.f(java.io.InputStream):void");
    }

    public final synchronized boolean g() {
        return this.f6468a.isEmpty();
    }

    public void h() {
        HttpURLConnection httpURLConnection = this.f6469b;
        if (httpURLConnection == null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = httpURLConnection.getInputStream();
                    f(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e10) {
                    Log.d("FirebaseRemoteConfig", "Exception thrown when closing connection stream. Retrying connection...", e10);
                }
            } catch (IOException e11) {
                if (!this.f6477j) {
                    Log.d("FirebaseRemoteConfig", "Real-time connection was closed due to an exception.", e11);
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e12) {
                    Log.d("FirebaseRemoteConfig", "Exception thrown when closing connection stream. Retrying connection...", e12);
                }
            }
            throw th;
        }
    }

    public final String i(String str) {
        int iIndexOf = str.indexOf(123);
        int iLastIndexOf = str.lastIndexOf(125);
        return (iIndexOf < 0 || iLastIndexOf < 0 || iIndexOf >= iLastIndexOf) ? "" : str.substring(iIndexOf, iLastIndexOf + 1);
    }

    public final synchronized void j(q qVar) {
        Iterator it = this.f6468a.iterator();
        while (it.hasNext()) {
            ((pa.c) it.next()).onError(qVar);
        }
    }

    public void k(boolean z10) {
        this.f6477j = z10;
    }

    public final synchronized void l(int i10) {
        this.f6476i.q(new Date(new Date(this.f6475h.a()).getTime() + (((long) i10) * 1000)));
    }
}
