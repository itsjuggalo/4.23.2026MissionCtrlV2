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
    private static final String f9580A = "deviceDisplay";

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final String f9581B = "deviceBrand";

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final String f9582C = "deviceBoard";

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final String f9583D = "androidVersion";

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final String f9584E = "deviceModel";

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final String f9585F = "packageFilePath";

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final String f9586G = "packageName";

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final String f9587H = "packageVersionName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f9588a = new com.amazon.a.a.o.c("CrashReport");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f9589b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9590c = "([a-zA-Z0-9_.]+(Exception|Error))|(at\\s.*\\(.*\\))";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9591d = "SHA1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9592e = "crashTime";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9593f = "UTF-8";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f9594g = "crashId";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f9595h = "threadDump";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f9596i = "stackTrace";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f9597j = "threadAllocSize";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f9598k = "threadAllocCount";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f9599l = "nativeHeapFreeSize";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f9600m = "nativeHeapSize";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f9601n = "memLowThreshold";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f9602o = "memLowFlag";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f9603p = "availableInternalMemorySize";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f9604q = "totalInternalMemorySize";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f9605r = "deviceUser";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f9606s = "deviceType";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f9607t = "deviceTime";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f9608u = "deviceTags";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f9609v = "deviceProduct";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f9610w = "deviceManufacturer";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f9611x = "deviceId";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f9612y = "deviceHost";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f9613z = "deviceFingerPrint";

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final HashMap<String, String> f9614I = new LinkedHashMap();

    public c(Application application, Throwable th) {
        try {
            a(application, th);
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.f9995b) {
                f9588a.b("Error collection crash report details", th2);
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
        this.f9614I.put(f9592e, new Date().toString());
    }

    private void c(Application application) {
        this.f9614I.put(f9584E, Build.MODEL);
        this.f9614I.put(f9583D, Build.VERSION.RELEASE);
        this.f9614I.put(f9582C, Build.BOARD);
        this.f9614I.put(f9581B, Build.BRAND);
        this.f9614I.put(f9580A, Build.DISPLAY);
        this.f9614I.put(f9613z, Build.FINGERPRINT);
        this.f9614I.put(f9612y, Build.HOST);
        this.f9614I.put(f9611x, Build.ID);
        this.f9614I.put(f9610w, Build.MANUFACTURER);
        this.f9614I.put(f9609v, Build.PRODUCT);
        this.f9614I.put(f9608u, Build.TAGS);
        this.f9614I.put(f9607t, Long.toString(Build.TIME));
        this.f9614I.put(f9606s, Build.TYPE);
        this.f9614I.put(f9605r, Build.USER);
        this.f9614I.put(f9604q, Long.toString(d()));
        this.f9614I.put(f9603p, Long.toString(c()));
        ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            this.f9614I.put(f9602o, Boolean.toString(memoryInfo.lowMemory));
            this.f9614I.put(f9601n, Long.toString(memoryInfo.threshold));
        }
        this.f9614I.put(f9600m, Long.toString(Debug.getNativeHeapSize()));
        this.f9614I.put(f9599l, Long.toString(Debug.getNativeHeapAllocatedSize()));
        this.f9614I.put(f9598k, Long.toString(Debug.getThreadAllocCount()));
        this.f9614I.put(f9597j, Long.toString(Debug.getThreadAllocSize()));
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
        this.f9614I.put(f9595h, sb.toString());
    }

    private void f() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f9614I.get(f9586G));
            sb.append(this.f9614I.get(f9587H));
            sb.append(this.f9614I.get(f9583D));
            String str = this.f9614I.get(f9596i);
            if (str != null) {
                Matcher matcher = Pattern.compile(f9590c).matcher(str);
                while (matcher.find()) {
                    sb.append(matcher.group());
                }
            }
            this.f9614I.put(f9594g, new BigInteger(MessageDigest.getInstance(f9591d).digest(sb.toString().getBytes(f9593f))).abs().toString(16));
        } catch (Exception e7) {
            if (com.amazon.a.a.o.c.f9995b) {
                f9588a.b("Error capturing crash id", e7);
            }
        }
    }

    private PackageInfo b(Application application) {
        try {
            return application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e7) {
            if (!com.amazon.a.a.o.c.f9995b) {
                return null;
            }
            f9588a.b("Unable to fetch package info", e7);
            return null;
        }
    }

    private void a(Application application) {
        PackageInfo packageInfoB = b(application);
        if (packageInfoB == null) {
            return;
        }
        this.f9614I.put(f9587H, packageInfoB.versionName);
        this.f9614I.put(f9586G, packageInfoB.packageName);
        this.f9614I.put(f9585F, application.getFilesDir().getAbsolutePath());
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
        this.f9614I.put(f9596i, sb.toString());
    }

    public Map<String, String> a() {
        return this.f9614I;
    }

    private long c() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
