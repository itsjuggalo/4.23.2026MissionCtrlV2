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

/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final String f13691A = "deviceDisplay";

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final String f13692B = "deviceBrand";

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final String f13693C = "deviceBoard";

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final String f13694D = "androidVersion";

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final String f13695E = "deviceModel";

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final String f13696F = "packageFilePath";

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final String f13697G = "packageName";

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final String f13698H = "packageVersionName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13699a = new com.amazon.a.a.o.c("CrashReport");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f13700b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13701c = "([a-zA-Z0-9_.]+(Exception|Error))|(at\\s.*\\(.*\\))";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f13702d = "SHA1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f13703e = "crashTime";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f13704f = "UTF-8";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f13705g = "crashId";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f13706h = "threadDump";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f13707i = "stackTrace";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f13708j = "threadAllocSize";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f13709k = "threadAllocCount";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f13710l = "nativeHeapFreeSize";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f13711m = "nativeHeapSize";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f13712n = "memLowThreshold";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f13713o = "memLowFlag";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f13714p = "availableInternalMemorySize";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f13715q = "totalInternalMemorySize";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f13716r = "deviceUser";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f13717s = "deviceType";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f13718t = "deviceTime";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f13719u = "deviceTags";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f13720v = "deviceProduct";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f13721w = "deviceManufacturer";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f13722x = "deviceId";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f13723y = "deviceHost";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f13724z = "deviceFingerPrint";

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final HashMap<String, String> f13725I = new LinkedHashMap();

    public c(Application application, Throwable th) {
        try {
            a(application, th);
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.f14106b) {
                f13699a.b("Error collection crash report details", th2);
            }
        }
    }

    private PackageInfo b(Application application) {
        try {
            return application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e8) {
            if (!com.amazon.a.a.o.c.f14106b) {
                return null;
            }
            f13699a.b("Unable to fetch package info", e8);
            return null;
        }
    }

    private long c() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    private long d() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    private void e() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            sb.append("Thread : " + key.getId());
            if (!e.a(key.getName())) {
                sb.append("/" + key.getName());
            }
            sb.append("\n");
            sb.append("isAlive : " + key.isAlive() + "\n");
            sb.append("isInterrupted : " + key.isInterrupted() + "\n");
            sb.append("isDaemon : " + key.isDaemon() + "\n");
            for (StackTraceElement stackTraceElement : value) {
                sb.append("\tat " + stackTraceElement + "\n");
            }
            sb.append("\n\n");
        }
        this.f13725I.put(f13706h, sb.toString());
    }

    private void f() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f13725I.get(f13697G));
            sb.append(this.f13725I.get(f13698H));
            sb.append(this.f13725I.get(f13694D));
            String str = this.f13725I.get(f13707i);
            if (str != null) {
                Matcher matcher = Pattern.compile(f13701c).matcher(str);
                while (matcher.find()) {
                    sb.append(matcher.group());
                }
            }
            this.f13725I.put(f13705g, new BigInteger(MessageDigest.getInstance(f13702d).digest(sb.toString().getBytes(f13704f))).abs().toString(16));
        } catch (Exception e8) {
            if (com.amazon.a.a.o.c.f14106b) {
                f13699a.b("Error capturing crash id", e8);
            }
        }
    }

    public Map<String, String> a() {
        return this.f13725I;
    }

    private void a(Application application) {
        PackageInfo packageInfoB = b(application);
        if (packageInfoB == null) {
            return;
        }
        this.f13725I.put(f13698H, packageInfoB.versionName);
        this.f13725I.put(f13697G, packageInfoB.packageName);
        this.f13725I.put(f13696F, application.getFilesDir().getAbsolutePath());
    }

    private void b() {
        this.f13725I.put(f13703e, new Date().toString());
    }

    private void c(Application application) {
        this.f13725I.put(f13695E, Build.MODEL);
        this.f13725I.put(f13694D, Build.VERSION.RELEASE);
        this.f13725I.put(f13693C, Build.BOARD);
        this.f13725I.put(f13692B, Build.BRAND);
        this.f13725I.put(f13691A, Build.DISPLAY);
        this.f13725I.put(f13724z, Build.FINGERPRINT);
        this.f13725I.put(f13723y, Build.HOST);
        this.f13725I.put(f13722x, Build.ID);
        this.f13725I.put(f13721w, Build.MANUFACTURER);
        this.f13725I.put(f13720v, Build.PRODUCT);
        this.f13725I.put(f13719u, Build.TAGS);
        this.f13725I.put(f13718t, Long.toString(Build.TIME));
        this.f13725I.put(f13717s, Build.TYPE);
        this.f13725I.put(f13716r, Build.USER);
        this.f13725I.put(f13715q, Long.toString(d()));
        this.f13725I.put(f13714p, Long.toString(c()));
        ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            this.f13725I.put(f13713o, Boolean.toString(memoryInfo.lowMemory));
            this.f13725I.put(f13712n, Long.toString(memoryInfo.threshold));
        }
        this.f13725I.put(f13711m, Long.toString(Debug.getNativeHeapSize()));
        this.f13725I.put(f13710l, Long.toString(Debug.getNativeHeapAllocatedSize()));
        this.f13725I.put(f13709k, Long.toString(Debug.getThreadAllocCount()));
        this.f13725I.put(f13708j, Long.toString(Debug.getThreadAllocSize()));
    }

    private void a(Application application, Throwable th) {
        b();
        a(application);
        c(application);
        a(th);
        e();
        f();
    }

    private void a(Throwable th) {
        StringBuilder sb = new StringBuilder();
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        sb.append(stringWriter.toString());
        sb.append("\n");
        Throwable cause = th.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            sb.append(stringWriter.toString());
            cause = cause.getCause();
            sb.append("\n\n");
        }
        printWriter.close();
        this.f13725I.put(f13707i, sb.toString());
    }
}
