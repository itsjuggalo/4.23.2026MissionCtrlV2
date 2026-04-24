package T3;

import N1.C0149z;
import N1.CallableC0141w0;
import N1.X;
import P2.C0217o;
import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.internal.measurement.zzdd;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import t4.AbstractC1183a;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f3043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f3044d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f3045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f3046g;

    public d(Context context, zzdd zzddVar, Long l6) {
        this.f3042b = true;
        I.g(context);
        Context applicationContext = context.getApplicationContext();
        I.g(applicationContext);
        this.f3043c = applicationContext;
        this.f3045f = l6;
        if (zzddVar != null) {
            this.e = zzddVar;
            this.f3042b = zzddVar.zzc;
            this.f3041a = zzddVar.zzb;
            this.f3046g = zzddVar.zze;
            Bundle bundle = zzddVar.zzd;
            if (bundle != null) {
                this.f3044d = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }

    public void a(Context context, String[] strArr) {
        Context context2;
        if (this.f3042b) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (((C0149z) this.f3043c) == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            AbstractC1183a.f("FlutterLoader#ensureInitializationComplete");
            try {
                c cVar = (c) ((Future) this.f3046g).get();
                ArrayList arrayList = new ArrayList();
                arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                StringBuilder sb = new StringBuilder("--icu-native-lib-path=");
                sb.append((String) ((C0217o) this.f3044d).e);
                String str = File.separator;
                sb.append(str);
                sb.append("libflutter.so");
                arrayList.add(sb.toString());
                if (strArr != null) {
                    Collections.addAll(arrayList, strArr);
                }
                arrayList.add("--aot-shared-library-name=".concat((String) ((C0217o) this.f3044d).f2473b));
                arrayList.add("--aot-shared-library-name=" + ((String) ((C0217o) this.f3044d).e) + str + ((String) ((C0217o) this.f3044d).f2473b));
                StringBuilder sb2 = new StringBuilder("--cache-dir-path=");
                sb2.append(cVar.f3040b);
                arrayList.add(sb2.toString());
                arrayList.add("--domain-network-policy=".concat((String) ((C0217o) this.f3044d).f2475d));
                ((C0149z) this.f3043c).getClass();
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                int i = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
                if (i == 0) {
                    context2 = context;
                    ((ActivityManager) context2.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                    i = (int) ((r9.totalMem / 1000000.0d) / 2.0d);
                } else {
                    context2 = context;
                }
                arrayList.add("--old-gen-heap-size=" + i);
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
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
                        arrayList.add("--impeller-backend=".concat(string));
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.ImpellerLazyShaderInitialization")) {
                        arrayList.add("--impeller-lazy-shader-mode");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.ImpellerAntialiasLines")) {
                        arrayList.add("--impeller-antialias-lines");
                    }
                }
                arrayList.add("--leak-vm=".concat(bundle == null ? true : bundle.getBoolean("io.flutter.embedding.android.LeakVM", true) ? "true" : "false"));
                ((FlutterJNI) this.e).init(context2, (String[]) arrayList.toArray(new String[0]), null, cVar.f3039a, cVar.f3040b, SystemClock.uptimeMillis() - this.f3041a, Build.VERSION.SDK_INT);
                this.f3042b = true;
                Trace.endSection();
            } finally {
            }
        } catch (Exception e) {
            Log.e("FlutterLoader", "Flutter initialization failed.", e);
            throw new RuntimeException(e);
        }
    }

    public void b(Context context) {
        C0149z c0149z = new C0149z(14);
        if (((C0149z) this.f3043c) != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        AbstractC1183a.f("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.f3043c = c0149z;
            this.f3041a = SystemClock.uptimeMillis();
            this.f3044d = a.a(applicationContext);
            X xA = X.a((DisplayManager) applicationContext.getSystemService("display"), (FlutterJNI) this.e);
            ((FlutterJNI) xA.f1434c).setAsyncWaitForVsyncDelegate((io.flutter.view.a) xA.e);
            this.f3046g = ((ExecutorService) this.f3045f).submit(new CallableC0141w0(3, this, applicationContext));
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
