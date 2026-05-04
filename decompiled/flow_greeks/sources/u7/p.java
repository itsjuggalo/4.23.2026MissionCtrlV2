package u7;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.flutter.plugins.firebase.auth.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import u7.a0;
import x7.f0;
import x7.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final FilenameFilter f22313t = new FilenameFilter() { // from class: u7.o
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith(".ae");
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Charset f22314u = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f22316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f22317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w7.o f22318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v7.i f22319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f22320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a8.g f22321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u7.a f22322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final w7.f f22323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r7.a f22324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s7.a f22325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final m f22326l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r0 f22327m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a0 f22328n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c8.j f22329o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TaskCompletionSource f22330p = new TaskCompletionSource();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TaskCompletionSource f22331q = new TaskCompletionSource();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TaskCompletionSource f22332r = new TaskCompletionSource();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f22333s = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements a0.a {
        public a() {
        }

        @Override // u7.a0.a
        public void a(c8.j jVar, Thread thread, Throwable th) throws Throwable {
            p.this.G(jVar, thread, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f22335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f22336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Thread f22337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c8.j f22338d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f22339e;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements SuccessContinuation {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f22341a;

            public a(String str) {
                this.f22341a = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task then(c8.d dVar) {
                if (dVar != null) {
                    return Tasks.whenAll((Task<?>[]) new Task[]{p.this.L(), p.this.f22327m.y(p.this.f22319e.f23152a, b.this.f22339e ? this.f22341a : null)});
                }
                r7.g.f().k("Received null app settings, cannot send reports at crash time.");
                return Tasks.forResult(null);
            }
        }

        public b(long j10, Throwable th, Thread thread, c8.j jVar, boolean z10) {
            this.f22335a = j10;
            this.f22336b = th;
            this.f22337c = thread;
            this.f22338d = jVar;
            this.f22339e = z10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task call() {
            long jE = p.E(this.f22335a);
            String strA = p.this.A();
            if (strA == null) {
                r7.g.f().d("Tried to write a fatal exception while no session was open.");
                return Tasks.forResult(null);
            }
            p.this.f22317c.a();
            p.this.f22327m.u(this.f22336b, this.f22337c, strA, jE);
            p.this.v(this.f22335a);
            p.this.s(this.f22338d);
            p.this.u(new h().c(), Boolean.valueOf(this.f22339e));
            return !p.this.f22316b.d() ? Tasks.forResult(null) : this.f22338d.a().onSuccessTask(p.this.f22319e.f23152a, new a(strA));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements SuccessContinuation {
        public c() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task then(Void r12) {
            return Tasks.forResult(Boolean.TRUE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements SuccessContinuation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f22344a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements SuccessContinuation {
            public a() {
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task then(c8.d dVar) {
                if (dVar == null) {
                    r7.g.f().k("Received null app settings at app startup. Cannot send cached reports");
                    return Tasks.forResult(null);
                }
                p.this.L();
                p.this.f22327m.x(p.this.f22319e.f23152a);
                p.this.f22332r.trySetResult(null);
                return Tasks.forResult(null);
            }
        }

        public d(Task task) {
            this.f22344a = task;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task then(Boolean bool) {
            if (bool.booleanValue()) {
                r7.g.f().b("Sending cached crash reports...");
                p.this.f22316b.c(bool.booleanValue());
                return this.f22344a.onSuccessTask(p.this.f22319e.f23152a, new a());
            }
            r7.g.f().i("Deleting cached crash reports...");
            p.q(p.this.J());
            p.this.f22327m.w();
            p.this.f22332r.trySetResult(null);
            return Tasks.forResult(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f22347a;

        public e(long j10) {
            this.f22347a = j10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong(DiagnosticsEntry.TIMESTAMP_KEY, this.f22347a);
            p.this.f22325k.a("_ae", bundle);
            return null;
        }
    }

    public p(Context context, h0 h0Var, c0 c0Var, a8.g gVar, x xVar, u7.a aVar, w7.o oVar, w7.f fVar, r0 r0Var, r7.a aVar2, s7.a aVar3, m mVar, v7.i iVar) {
        this.f22315a = context;
        this.f22320f = h0Var;
        this.f22316b = c0Var;
        this.f22321g = gVar;
        this.f22317c = xVar;
        this.f22322h = aVar;
        this.f22318d = oVar;
        this.f22323i = fVar;
        this.f22324j = aVar2;
        this.f22325k = aVar3;
        this.f22326l = mVar;
        this.f22327m = r0Var;
        this.f22319e = iVar;
    }

    public static long B() {
        return E(System.currentTimeMillis());
    }

    public static List C(r7.h hVar, String str, a8.g gVar, byte[] bArr) {
        File fileQ = gVar.q(str, "user-data");
        File fileQ2 = gVar.q(str, "keys");
        File fileQ3 = gVar.q(str, "rollouts-state");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g("logs_file", "logs", bArr));
        arrayList.add(new f0("crash_meta_file", "metadata", hVar.g()));
        arrayList.add(new f0("session_meta_file", "session", hVar.f()));
        arrayList.add(new f0("app_meta_file", "app", hVar.a()));
        arrayList.add(new f0("device_meta_file", "device", hVar.c()));
        arrayList.add(new f0("os_meta_file", "os", hVar.b()));
        arrayList.add(N(hVar));
        arrayList.add(new f0("user_meta_file", Constants.USER, fileQ));
        arrayList.add(new f0("keys_file", "keys", fileQ2));
        arrayList.add(new f0("rollouts_file", "rollouts", fileQ3));
        return arrayList;
    }

    public static long E(long j10) {
        return j10 / 1000;
    }

    public static boolean M(String str, File file, f0.a aVar) {
        if (file == null || !file.exists()) {
            r7.g.f().k("No minidump data found for session " + str);
        }
        if (aVar == null) {
            r7.g.f().g("No Tombstones data found for session " + str);
        }
        return (file == null || !file.exists()) && aVar == null;
    }

    public static k0 N(r7.h hVar) {
        File fileE = hVar.e();
        return (fileE == null || !fileE.exists()) ? new g("minidump_file", "minidump", new byte[]{0}) : new f0("minidump_file", "minidump", fileE);
    }

    public static byte[] P(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static g0.a n(h0 h0Var, u7.a aVar) {
        return g0.a.b(h0Var.f(), aVar.f22224f, aVar.f22225g, h0Var.a().c(), d0.b(aVar.f22222d).c(), aVar.f22226h);
    }

    public static g0.b o(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return g0.b.c(i.k(), Build.MODEL, Runtime.getRuntime().availableProcessors(), i.b(context), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), i.x(), i.l(), Build.MANUFACTURER, Build.PRODUCT);
    }

    public static g0.c p() {
        return g0.c.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, i.y());
    }

    public static void q(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public static boolean z() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final String A() {
        SortedSet sortedSetQ = this.f22327m.q();
        if (sortedSetQ.isEmpty()) {
            return null;
        }
        return (String) sortedSetQ.first();
    }

    public final InputStream D(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader != null) {
            return classLoader.getResourceAsStream(str);
        }
        r7.g.f().k("Couldn't get Class Loader");
        return null;
    }

    public String F() throws IOException {
        String strR = i.r(this.f22315a);
        if (strR != null) {
            r7.g.f().b("Read version control info from string resource");
            return Base64.encodeToString(strR.getBytes(f22314u), 0);
        }
        InputStream inputStreamD = D("META-INF/version-control-info.textproto");
        if (inputStreamD == null) {
            if (inputStreamD != null) {
                inputStreamD.close();
            }
            r7.g.f().g("No version control information found");
            return null;
        }
        try {
            r7.g.f().b("Read version control info from file");
            String strEncodeToString = Base64.encodeToString(P(inputStreamD), 0);
            inputStreamD.close();
            return strEncodeToString;
        } catch (Throwable th) {
            try {
                inputStreamD.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void G(c8.j jVar, Thread thread, Throwable th) throws Throwable {
        H(jVar, thread, th, false);
    }

    public synchronized void H(c8.j jVar, Thread thread, Throwable th, boolean z10) throws Throwable {
        Throwable th2;
        try {
            try {
                r7.g.f().b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
                if (!z10) {
                    try {
                        va.a.b();
                    } catch (Throwable th3) {
                        th2 = th3;
                        throw th2;
                    }
                }
                Task taskF = this.f22319e.f23152a.f(new b(System.currentTimeMillis(), th, thread, jVar, z10));
                if (!z10) {
                    try {
                        u0.b(taskF);
                    } catch (TimeoutException unused) {
                        r7.g.f().d("Cannot send reports. Timed out while fetching settings.");
                    } catch (Exception e10) {
                        r7.g.f().e("Error handling uncaught exception", e10);
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                th2 = th;
                throw th2;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public boolean I() {
        a0 a0Var = this.f22328n;
        return a0Var != null && a0Var.a();
    }

    public List J() {
        return this.f22321g.h(f22313t);
    }

    public final Task K(long j10) {
        if (z()) {
            r7.g.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        r7.g.f().b("Logging app exception event to Firebase Analytics");
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new e(j10));
    }

    public final Task L() {
        ArrayList arrayList = new ArrayList();
        for (File file : J()) {
            try {
                arrayList.add(K(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                r7.g.f().k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    public void O(final String str) {
        this.f22319e.f23152a.e(new Runnable() { // from class: u7.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f22307a.u(str, Boolean.FALSE);
            }
        });
    }

    public void Q() {
        try {
            String strF = F();
            if (strF != null) {
                R("com.crashlytics.version-control-info", strF);
                r7.g.f().g("Saved version control info");
            }
        } catch (IOException e10) {
            r7.g.f().l("Unable to save version control info", e10);
        }
    }

    public void R(String str, String str2) {
        try {
            this.f22318d.l(str, str2);
        } catch (IllegalArgumentException e10) {
            Context context = this.f22315a;
            if (context != null && i.v(context)) {
                throw e10;
            }
            r7.g.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    public void S(Task task) {
        if (this.f22327m.p()) {
            r7.g.f().i("Crash reports are available to be sent.");
            T().onSuccessTask(this.f22319e.f23152a, new d(task));
        } else {
            r7.g.f().i("No crash reports are available to be sent.");
            this.f22330p.trySetResult(Boolean.FALSE);
        }
    }

    public final Task T() {
        if (this.f22316b.d()) {
            r7.g.f().b("Automatic data collection is enabled. Allowing upload.");
            this.f22330p.trySetResult(Boolean.FALSE);
            return Tasks.forResult(Boolean.TRUE);
        }
        r7.g.f().b("Automatic data collection is disabled.");
        r7.g.f().i("Notifying that unsent reports are available.");
        this.f22330p.trySetResult(Boolean.TRUE);
        Task taskOnSuccessTask = this.f22316b.h().onSuccessTask(new c());
        r7.g.f().b("Waiting for send/deleteUnsentReports to be called.");
        return v7.b.b(taskOnSuccessTask, this.f22331q.getTask());
    }

    public final void U(String str) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 30) {
            r7.g.f().i("ANR feature enabled, but device is API " + i10);
            return;
        }
        List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.f22315a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
        if (historicalProcessExitReasons.size() != 0) {
            this.f22327m.v(str, historicalProcessExitReasons, new w7.f(this.f22321g, str), w7.o.j(str, this.f22321g, this.f22319e));
        } else {
            r7.g.f().i("No ApplicationExitInfo available. Session: " + str);
        }
    }

    public void V(long j10, String str) {
        if (I()) {
            return;
        }
        this.f22323i.g(j10, str);
    }

    public boolean r() {
        v7.i.c();
        if (!this.f22317c.c()) {
            String strA = A();
            return strA != null && this.f22324j.d(strA);
        }
        r7.g.f().i("Found previous crash marker.");
        this.f22317c.d();
        return true;
    }

    public void s(c8.j jVar) {
        t(false, jVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(boolean z10, c8.j jVar, boolean z11) {
        String str;
        v7.i.c();
        ArrayList arrayList = new ArrayList(this.f22327m.q());
        if (arrayList.size() <= z10) {
            r7.g.f().i("No open sessions to be closed.");
            return;
        }
        String str2 = (String) arrayList.get(z10 ? 1 : 0);
        if (z11 && jVar.b().f3712b.f3720b) {
            U(str2);
        } else {
            r7.g.f().i("ANR feature disabled.");
        }
        if (z11 && this.f22324j.d(str2)) {
            x(str2);
        }
        if (z10 != 0) {
            str = (String) arrayList.get(0);
        } else {
            this.f22326l.e(null);
            str = null;
        }
        this.f22327m.m(B(), str);
    }

    public final void u(String str, Boolean bool) {
        long jB = B();
        r7.g.f().b("Opening a new session with ID " + str);
        this.f22324j.b(str, String.format(Locale.US, "Crashlytics Android SDK/%s", w.k()), jB, x7.g0.b(n(this.f22320f, this.f22322h), p(), o(this.f22315a)));
        if (bool.booleanValue() && str != null) {
            this.f22318d.m(str);
        }
        this.f22323i.e(str);
        this.f22326l.e(str);
        this.f22327m.r(str, jB);
    }

    public final void v(long j10) {
        try {
            if (this.f22321g.g(".ae" + j10).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e10) {
            r7.g.f().l("Could not create app exception marker file.", e10);
        }
    }

    public void w(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, c8.j jVar) {
        this.f22329o = jVar;
        O(str);
        a0 a0Var = new a0(new a(), jVar, uncaughtExceptionHandler, this.f22324j);
        this.f22328n = a0Var;
        Thread.setDefaultUncaughtExceptionHandler(a0Var);
    }

    public final void x(String str) {
        r7.g.f().i("Finalizing native report for session " + str);
        r7.h hVarA = this.f22324j.a(str);
        File fileE = hVarA.e();
        f0.a aVarD = hVarA.d();
        if (M(str, fileE, aVarD)) {
            r7.g.f().k("No native core present");
            return;
        }
        long jLastModified = fileE.lastModified();
        w7.f fVar = new w7.f(this.f22321g, str);
        File fileK = this.f22321g.k(str);
        if (!fileK.isDirectory()) {
            r7.g.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        v(jLastModified);
        List listC = C(hVarA, str, this.f22321g, fVar.b());
        l0.b(fileK, listC);
        r7.g.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.f22327m.l(str, listC, aVarD);
        fVar.a();
    }

    public boolean y(c8.j jVar) {
        v7.i.c();
        if (I()) {
            r7.g.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        r7.g.f().i("Finalizing previously open sessions.");
        try {
            t(true, jVar, true);
            r7.g.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e10) {
            r7.g.f().e("Unable to finalize previously open sessions.", e10);
            return false;
        }
    }
}
