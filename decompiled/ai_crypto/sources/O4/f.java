package O4;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import q5.AbstractC2562a;
import q5.AbstractC2563b;
import q5.C2566e;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4221a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f4222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public O4.b f4224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FlutterJNI f4225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExecutorService f4226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Future f4227g;

    public class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4228a;

        public a(Context context) {
            this.f4228a = context;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b call() {
            String str;
            String str2;
            String[] strArr;
            C2566e c2566eK = C2566e.K("FlutterLoader initTask");
            try {
                f.c(f.this, this.f4228a);
                try {
                    f.this.f4225e.loadLibrary(this.f4228a);
                    f.this.f4225e.updateRefreshRate();
                    f.this.f4226f.execute(new Runnable() { // from class: O4.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f4220a.c();
                        }
                    });
                    b bVar = new b(AbstractC2563b.d(this.f4228a), AbstractC2563b.a(this.f4228a), AbstractC2563b.c(this.f4228a), null);
                    if (c2566eK != null) {
                        c2566eK.close();
                    }
                    return bVar;
                } catch (UnsatisfiedLinkError e7) {
                    if (!e7.toString().contains("couldn't find \"libflutter.so\"") && !e7.toString().contains("dlopen failed: library \"libflutter.so\" not found")) {
                        throw e7;
                    }
                    String property = System.getProperty("os.arch");
                    File file = new File(f.this.f4224d.f4208f);
                    String[] list = file.list();
                    ArrayList arrayList = new ArrayList();
                    String[] strArr2 = Build.SUPPORTED_ABIS;
                    int length = strArr2.length;
                    int i7 = 0;
                    while (i7 < length) {
                        String str3 = strArr2[i7];
                        StringBuilder sb = new StringBuilder();
                        sb.append("!");
                        String str4 = File.separator;
                        sb.append(str4);
                        sb.append("lib");
                        sb.append(str4);
                        sb.append(str3);
                        String string = sb.toString();
                        String[] strArr3 = this.f4228a.getApplicationInfo().splitSourceDirs;
                        ArrayList arrayList2 = new ArrayList();
                        if (strArr3 != null) {
                            int length2 = strArr3.length;
                            int i8 = 0;
                            while (i8 < length2) {
                                arrayList2.add(strArr3[i8] + string);
                                i8++;
                                strArr2 = strArr2;
                            }
                            strArr = strArr2;
                            arrayList.addAll(arrayList2);
                        } else {
                            strArr = strArr2;
                        }
                        String str5 = this.f4228a.getApplicationInfo().sourceDir;
                        if (str5 != null && !str5.isEmpty()) {
                            arrayList.add(str5 + string);
                        }
                        i7++;
                        strArr2 = strArr;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Could not load libflutter.so this is possibly because the application is running on an architecture that Flutter Android does not support (e.g. x86) see https://docs.flutter.dev/deployment/android#what-are-the-supported-target-architectures for more detail.\nApp is using cpu architecture: ");
                    sb2.append(property);
                    sb2.append(", and the native libraries directory (with path ");
                    sb2.append(file.getAbsolutePath());
                    sb2.append(") ");
                    if (file.exists()) {
                        str = "contains the following files: " + Arrays.toString(list);
                    } else {
                        str = "does not exist";
                    }
                    sb2.append(str);
                    if (arrayList.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = ", and the split and source libraries directory (with path(s) " + arrayList + ")";
                    }
                    sb2.append(str2);
                    sb2.append(".");
                    throw new UnsupportedOperationException(sb2.toString(), e7);
                }
            } finally {
            }
        }

        public final /* synthetic */ void c() {
            f.this.f4225e.prefetchDefaultFontManager();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f4232c;

        public /* synthetic */ b(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }

        public b(String str, String str2, String str3) {
            this.f4230a = str;
            this.f4231b = str2;
            this.f4232c = str3;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4233a;

        public String a() {
            return this.f4233a;
        }
    }

    public f(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.f4225e = flutterJNI;
        this.f4226f = executorService;
    }

    public static /* synthetic */ g c(f fVar, Context context) {
        fVar.m(context);
        return null;
    }

    public static boolean o(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean("io.flutter.embedding.android.LeakVM", true);
    }

    public boolean g() {
        return this.f4224d.f4209g;
    }

    public void h(Context context, String[] strArr) {
        if (this.f4221a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f4222b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            C2566e c2566eK = C2566e.K("FlutterLoader#ensureInitializationComplete");
            try {
                b bVar = (b) this.f4227g.get();
                ArrayList arrayList = new ArrayList();
                arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                StringBuilder sb = new StringBuilder();
                sb.append("--icu-native-lib-path=");
                sb.append(this.f4224d.f4208f);
                String str = File.separator;
                sb.append(str);
                sb.append("libflutter.so");
                arrayList.add(sb.toString());
                if (strArr != null) {
                    Collections.addAll(arrayList, strArr);
                }
                arrayList.add("--aot-shared-library-name=" + this.f4224d.f4203a);
                arrayList.add("--aot-shared-library-name=" + this.f4224d.f4208f + str + this.f4224d.f4203a);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("--cache-dir-path=");
                sb2.append(bVar.f4231b);
                arrayList.add(sb2.toString());
                if (this.f4224d.f4207e != null) {
                    arrayList.add("--domain-network-policy=" + this.f4224d.f4207e);
                }
                if (this.f4222b.a() != null) {
                    arrayList.add("--log-tag=" + this.f4222b.a());
                }
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                int i7 = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
                if (i7 == 0) {
                    ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                    i7 = (int) ((r8.totalMem / 1000000.0d) / 2.0d);
                }
                arrayList.add("--old-gen-heap-size=" + i7);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 48));
                arrayList.add("--prefetched-default-font-manager");
                if (bundle != null) {
                    if (bundle.containsKey("io.flutter.embedding.android.EnableImpeller")) {
                        if (bundle.getBoolean("io.flutter.embedding.android.EnableImpeller")) {
                            arrayList.add("--enable-impeller=true");
                        } else {
                            arrayList.add("--enable-impeller=false");
                        }
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanValidation", false)) {
                        arrayList.add("--enable-vulkan-validation");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableOpenGLGPUTracing", false)) {
                        arrayList.add("--enable-opengl-gpu-tracing");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanGPUTracing", false)) {
                        arrayList.add("--enable-vulkan-gpu-tracing");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.DisableMergedPlatformUIThread", false)) {
                        arrayList.add("--merged-platform-ui-thread=disabled");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableFlutterGPU", false)) {
                        arrayList.add("--enable-flutter-gpu");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableSurfaceControl", false)) {
                        arrayList.add("--enable-surface-control");
                    }
                    String string = bundle.getString("io.flutter.embedding.android.ImpellerBackend");
                    if (string != null) {
                        arrayList.add("--impeller-backend=" + string);
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.ImpellerLazyShaderInitialization")) {
                        arrayList.add("--impeller-lazy-shader-mode");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.ImpellerAntialiasLines")) {
                        arrayList.add("--impeller-antialias-lines");
                    }
                }
                arrayList.add("--leak-vm=" + (o(bundle) ? com.amazon.a.a.o.b.af : com.amazon.a.a.o.b.ag));
                this.f4225e.init(context, (String[]) arrayList.toArray(new String[0]), null, bVar.f4230a, bVar.f4231b, SystemClock.uptimeMillis() - this.f4223c, Build.VERSION.SDK_INT);
                this.f4221a = true;
                if (c2566eK != null) {
                    c2566eK.close();
                }
            } finally {
            }
        } catch (Exception e7) {
            J4.b.c("FlutterLoader", "Flutter initialization failed.", e7);
            throw new RuntimeException(e7);
        }
    }

    public void i(final Context context, final String[] strArr, final Handler handler, final Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f4222b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        if (this.f4221a) {
            handler.post(runnable);
        } else {
            this.f4226f.execute(new Runnable() { // from class: O4.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4210a.q(context, strArr, handler, runnable);
                }
            });
        }
    }

    public String j() {
        return this.f4224d.f4206d;
    }

    public final String k(String str) {
        return this.f4224d.f4206d + File.separator + str;
    }

    public String l(String str) {
        return k(str);
    }

    public final g m(Context context) {
        return null;
    }

    public boolean n() {
        return this.f4221a;
    }

    public final /* synthetic */ void p(Context context, String[] strArr, Handler handler, Runnable runnable) {
        h(context.getApplicationContext(), strArr);
        handler.post(runnable);
    }

    public final /* synthetic */ void q(final Context context, final String[] strArr, final Handler handler, final Runnable runnable) {
        try {
            AbstractC2562a.a(Looper.getMainLooper()).post(new Runnable() { // from class: O4.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4215a.p(context, strArr, handler, runnable);
                }
            });
        } catch (Exception e7) {
            J4.b.c("FlutterLoader", "Flutter initialization failed.", e7);
            throw new RuntimeException(e7);
        }
    }

    public void r(Context context) {
        s(context, new c());
    }

    public void s(Context context, c cVar) {
        if (this.f4222b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        C2566e c2566eK = C2566e.K("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.f4222b = cVar;
            this.f4223c = SystemClock.uptimeMillis();
            this.f4224d = O4.a.e(applicationContext);
            i.f((DisplayManager) applicationContext.getSystemService("display"), this.f4225e).g();
            this.f4227g = this.f4226f.submit(new a(applicationContext));
            if (c2566eK != null) {
                c2566eK.close();
            }
        } catch (Throwable th) {
            if (c2566eK != null) {
                try {
                    c2566eK.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
