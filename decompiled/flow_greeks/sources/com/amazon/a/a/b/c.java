package com.amazon.a.a.b;

import android.app.ActivityManager;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import com.amazon.a.a.o.e;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable {
    private static final String A = "deviceDisplay";
    private static final String B = "deviceBrand";
    private static final String C = "deviceBoard";
    private static final String D = "androidVersion";
    private static final String E = "deviceModel";
    private static final String F = "packageFilePath";
    private static final String G = "packageName";
    private static final String H = "packageVersionName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4216a = new com.amazon.a.a.o.c("CrashReport");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f4217b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4218c = "([a-zA-Z0-9_.]+(Exception|Error))|(at\\s.*\\(.*\\))";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f4219d = "SHA1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f4220e = "crashTime";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f4221f = "UTF-8";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f4222g = "crashId";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f4223h = "threadDump";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f4224i = "stackTrace";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f4225j = "threadAllocSize";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f4226k = "threadAllocCount";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f4227l = "nativeHeapFreeSize";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f4228m = "nativeHeapSize";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f4229n = "memLowThreshold";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f4230o = "memLowFlag";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f4231p = "availableInternalMemorySize";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f4232q = "totalInternalMemorySize";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f4233r = "deviceUser";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f4234s = "deviceType";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f4235t = "deviceTime";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f4236u = "deviceTags";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f4237v = "deviceProduct";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f4238w = "deviceManufacturer";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f4239x = "deviceId";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f4240y = "deviceHost";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f4241z = "deviceFingerPrint";
    private final HashMap<String, String> I = new LinkedHashMap();

    public c(Application application, Throwable th) {
        try {
            a(application, th);
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.f4604b) {
                f4216a.b("Error collection crash report details", th2);
            }
        }
    }

    private void a(Application application, Throwable th) {
        b();
        a(application);
        c(application);
        a(th);
        e();
        f();
    }

    private void b() {
        this.I.put(f4220e, new Date().toString());
    }

    private void c(Application application) {
        this.I.put(E, Build.MODEL);
        this.I.put(D, Build.VERSION.RELEASE);
        this.I.put(C, Build.BOARD);
        this.I.put(B, Build.BRAND);
        this.I.put(A, Build.DISPLAY);
        this.I.put(f4241z, Build.FINGERPRINT);
        this.I.put(f4240y, Build.HOST);
        this.I.put(f4239x, Build.ID);
        this.I.put(f4238w, Build.MANUFACTURER);
        this.I.put(f4237v, Build.PRODUCT);
        this.I.put(f4236u, Build.TAGS);
        this.I.put(f4235t, Long.toString(Build.TIME));
        this.I.put(f4234s, Build.TYPE);
        this.I.put(f4233r, Build.USER);
        this.I.put(f4232q, Long.toString(d()));
        this.I.put(f4231p, Long.toString(c()));
        ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            this.I.put(f4230o, Boolean.toString(memoryInfo.lowMemory));
            this.I.put(f4229n, Long.toString(memoryInfo.threshold));
        }
        this.I.put(f4228m, Long.toString(Debug.getNativeHeapSize()));
        this.I.put(f4227l, Long.toString(Debug.getNativeHeapAllocatedSize()));
        this.I.put(f4226k, Long.toString(Debug.getThreadAllocCount()));
        this.I.put(f4225j, Long.toString(Debug.getThreadAllocSize()));
    }

    private long d() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    private void e() {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            sb2.append("Thread : " + key.getId());
            if (!e.a(key.getName())) {
                sb2.append("/" + key.getName());
            }
            sb2.append("\n");
            sb2.append("isAlive : " + key.isAlive() + "\n");
            sb2.append("isInterrupted : " + key.isInterrupted() + "\n");
            sb2.append("isDaemon : " + key.isDaemon() + "\n");
            for (StackTraceElement stackTraceElement : value) {
                sb2.append("\tat " + stackTraceElement + "\n");
            }
            sb2.append("\n\n");
        }
        this.I.put(f4223h, sb2.toString());
    }

    private void f() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.I.get(G));
            sb2.append(this.I.get(H));
            sb2.append(this.I.get(D));
            String str = this.I.get(f4224i);
            if (str != null) {
                Matcher matcher = Pattern.compile(f4218c).matcher(str);
                while (matcher.find()) {
                    sb2.append(matcher.group());
                }
            }
            this.I.put(f4222g, new BigInteger(MessageDigest.getInstance(f4219d).digest(sb2.toString().getBytes(f4221f))).abs().toString(16));
        } catch (Exception e10) {
            if (com.amazon.a.a.o.c.f4604b) {
                f4216a.b("Error capturing crash id", e10);
            }
        }
    }

    private PackageInfo b(Application application) {
        try {
            return application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e10) {
            if (!com.amazon.a.a.o.c.f4604b) {
                return null;
            }
            f4216a.b("Unable to fetch package info", e10);
            return null;
        }
    }

    private void a(Application application) {
        PackageInfo packageInfoB = b(application);
        if (packageInfoB == null) {
            return;
        }
        this.I.put(H, packageInfoB.versionName);
        this.I.put(G, packageInfoB.packageName);
        this.I.put(F, application.getFilesDir().getAbsolutePath());
    }

    private void a(Throwable th) {
        StringBuilder sb2 = new StringBuilder();
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        sb2.append(stringWriter.toString());
        sb2.append("\n");
        Throwable cause = th.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            sb2.append(stringWriter.toString());
            cause = cause.getCause();
            sb2.append("\n\n");
        }
        printWriter.close();
        this.I.put(f4224i, sb2.toString());
    }

    public Map<String, String> a() {
        return this.I;
    }

    private long c() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
