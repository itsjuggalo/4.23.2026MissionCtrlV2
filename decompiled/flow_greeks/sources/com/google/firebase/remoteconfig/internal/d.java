package com.google.firebase.remoteconfig.internal;

import a7.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import ga.h;
import ga.m;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import pa.p;
import pa.q;
import t5.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f6514t = {2, 4, 8, 16, 32, 64, 128, 256};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f6515u = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f6516a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6518c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HttpURLConnection f6521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.google.firebase.remoteconfig.internal.a f6522g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ScheduledExecutorService f6524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f6525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f6526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h f6527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public qa.e f6528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f6529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f6530o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final e f6533r;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6523h = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6517b = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Random f6531p = new Random();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final t5.e f6532q = t5.h.d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6519d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6520e = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Object f6534s = new Object();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.e();
        }
    }

    public d(g gVar, h hVar, c cVar, qa.e eVar, Context context, String str, Set set, e eVar2, ScheduledExecutorService scheduledExecutorService) {
        this.f6516a = set;
        this.f6524i = scheduledExecutorService;
        this.f6518c = Math.max(8 - eVar2.i().b(), 1);
        this.f6526k = gVar;
        this.f6525j = cVar;
        this.f6527l = hVar;
        this.f6528m = eVar;
        this.f6529n = context;
        this.f6530o = str;
        this.f6533r = eVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:9:0x0030, B:47:0x00bd, B:49:0x00c1, B:50:0x00c5), top: B:88:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c5 A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #1 {all -> 0x0044, blocks: (B:9:0x0030, B:47:0x00bd, B:49:0x00c1, B:50:0x00c5), top: B:88:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ com.google.android.gms.tasks.Task a(com.google.firebase.remoteconfig.internal.d r10, com.google.android.gms.tasks.Task r11, com.google.android.gms.tasks.Task r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.d.a(com.google.firebase.remoteconfig.internal.d, com.google.android.gms.tasks.Task, com.google.android.gms.tasks.Task):com.google.android.gms.tasks.Task");
    }

    public static /* synthetic */ Task b(d dVar, Task task, Task task2, Task task3) {
        dVar.getClass();
        if (!task.isSuccessful()) {
            return Tasks.forException(new p("Firebase Installations failed to get installation auth token for config update listener connection.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new p("Firebase Installations failed to get installation ID for config update listener connection.", task2.getException()));
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) dVar.q().openConnection();
            dVar.A(httpURLConnection, (String) task2.getResult(), ((m) task.getResult()).b());
            return Tasks.forResult(httpURLConnection);
        } catch (IOException e10) {
            return Tasks.forException(new p("Failed to open HTTP stream connection", e10));
        }
    }

    public static String m(String str) {
        Matcher matcher = f6515u.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    public void A(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        x(httpURLConnection, str2);
        byte[] bytes = k(str).toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public synchronized com.google.firebase.remoteconfig.internal.a B(HttpURLConnection httpURLConnection) {
        return new com.google.firebase.remoteconfig.internal.a(httpURLConnection, this.f6525j, this.f6528m, this.f6516a, new b(), this.f6524i, this.f6533r);
    }

    public void C() {
        s(0L);
    }

    public final void D(Date date) {
        int iB = this.f6533r.i().b() + 1;
        this.f6533r.r(iB, new Date(date.getTime() + o(iB)));
    }

    public void e() {
        if (g()) {
            if (new Date(this.f6532q.a()).before(this.f6533r.i().a())) {
                w();
            } else {
                final Task taskJ = j();
                Tasks.whenAllComplete((Task<?>[]) new Task[]{taskJ}).continueWith(this.f6524i, new Continuation() { // from class: qa.n
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        return com.google.firebase.remoteconfig.internal.d.a(this.f19016a, taskJ, task);
                    }
                });
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean f() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Set r0 = r1.f6516a     // Catch: java.lang.Throwable -> L17
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f6517b     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f6519d     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            boolean r0 = r1.f6520e     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L19
            r0 = 1
            goto L1a
        L17:
            r0 = move-exception
            goto L1c
        L19:
            r0 = 0
        L1a:
            monitor-exit(r1)
            return r0
        L1c:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.d.f():boolean");
    }

    public final synchronized boolean g() {
        boolean zF;
        zF = f();
        if (zF) {
            y(true);
        }
        return zF;
    }

    public final void h(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                Log.d("FirebaseRemoteConfig", "Error closing connection stream.", e10);
            }
        }
    }

    public void i(InputStream inputStream, InputStream inputStream2) {
        HttpURLConnection httpURLConnection = this.f6521f;
        if (httpURLConnection != null && !this.f6520e) {
            httpURLConnection.disconnect();
        }
        h(inputStream);
        h(inputStream2);
    }

    public Task j() {
        final Task taskA = this.f6527l.a(false);
        final Task id2 = this.f6527l.getId();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{taskA, id2}).continueWithTask(this.f6524i, new Continuation() { // from class: qa.o
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return com.google.firebase.remoteconfig.internal.d.b(this.f19018a, taskA, id2, task);
            }
        });
    }

    public final JSONObject k(String str) {
        HashMap map = new HashMap();
        map.put("project", m(this.f6526k.r().c()));
        map.put("namespace", this.f6530o);
        map.put("lastKnownVersionNumber", Long.toString(this.f6525j.r()));
        map.put("appId", this.f6526k.r().c());
        map.put(com.amazon.a.a.o.b.I, "23.0.1");
        map.put("appInstanceId", str);
        return new JSONObject(map);
    }

    public final synchronized void l() {
        this.f6519d = true;
    }

    public final String n() {
        try {
            Context context = this.f6529n;
            byte[] bArrA = t5.a.a(context, context.getPackageName());
            if (bArrA != null) {
                return j.c(bArrA, false);
            }
            Log.e("FirebaseRemoteConfig", "Could not get fingerprint hash for package: " + this.f6529n.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i("FirebaseRemoteConfig", "No such package: " + this.f6529n.getPackageName());
            return null;
        }
    }

    public final long o(int i10) {
        int length = f6514t.length;
        if (i10 >= length) {
            i10 = length;
        }
        long millis = TimeUnit.MINUTES.toMillis(r0[i10 - 1]);
        return (millis / 2) + ((long) this.f6531p.nextInt((int) millis));
    }

    public final String p(String str) {
        return String.format("https://firebaseremoteconfigrealtime.googleapis.com/v1/projects/%s/namespaces/%s:streamFetchInvalidations", m(this.f6526k.r().c()), str);
    }

    public final URL q() {
        try {
            return new URL(p(this.f6530o));
        } catch (MalformedURLException unused) {
            Log.e("FirebaseRemoteConfig", "URL is malformed");
            return null;
        }
    }

    public final boolean r(int i10) {
        return i10 == 408 || i10 == 429 || i10 == 502 || i10 == 503 || i10 == 504;
    }

    public final synchronized void s(long j10) {
        try {
            if (f()) {
                int i10 = this.f6518c;
                if (i10 > 0) {
                    this.f6518c = i10 - 1;
                    this.f6524i.schedule(new a(), j10, TimeUnit.MILLISECONDS);
                } else if (!this.f6520e) {
                    u(new p("Unable to connect to the server. Check your connection and try again.", q.a.CONFIG_UPDATE_STREAM_ERROR));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String t(InputStream inputStream) {
        StringBuilder sb2 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb2.append(line);
            }
        } catch (IOException unused) {
            if (sb2.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb2.toString();
    }

    public final synchronized void u(q qVar) {
        Iterator it = this.f6516a.iterator();
        while (it.hasNext()) {
            ((pa.c) it.next()).onError(qVar);
        }
    }

    public final synchronized void v() {
        this.f6518c = 8;
    }

    public synchronized void w() {
        s(Math.max(0L, this.f6533r.i().a().getTime() - new Date(this.f6532q.a()).getTime()));
    }

    public final void x(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty("X-Goog-Firebase-Installations-Auth", str);
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.f6526k.r().b());
        httpURLConnection.setRequestProperty("X-Android-Package", this.f6529n.getPackageName());
        httpURLConnection.setRequestProperty("X-Android-Cert", n());
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection.setRequestProperty("X-Accept-Response-Streaming", com.amazon.a.a.o.b.f4545af);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
    }

    public final synchronized void y(boolean z10) {
        this.f6517b = z10;
    }

    public void z(boolean z10) {
        HttpURLConnection httpURLConnection;
        synchronized (this.f6534s) {
            try {
                this.f6520e = z10;
                com.google.firebase.remoteconfig.internal.a aVar = this.f6522g;
                if (aVar != null) {
                    aVar.k(z10);
                }
                if (Build.VERSION.SDK_INT >= 26 && z10 && (httpURLConnection = this.f6521f) != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements pa.c {
        public b() {
        }

        @Override // pa.c
        public void onError(q qVar) {
            d.this.l();
            d.this.u(qVar);
        }

        @Override // pa.c
        public void onUpdate(pa.b bVar) {
        }
    }
}
