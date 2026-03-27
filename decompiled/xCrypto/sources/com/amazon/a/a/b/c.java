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
import com.google.firebase.sessions.settings.RemoteSettings;
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
    private static final String f8395A = "deviceDisplay";

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final String f8396B = "deviceBrand";

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final String f8397C = "deviceBoard";

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final String f8398D = "androidVersion";

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final String f8399E = "deviceModel";

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final String f8400F = "packageFilePath";

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final String f8401G = "packageName";

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final String f8402H = "packageVersionName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f8403a = new com.amazon.a.a.o.c("CrashReport");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f8404b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8405c = "([a-zA-Z0-9_.]+(Exception|Error))|(at\\s.*\\(.*\\))";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8406d = "SHA1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8407e = "crashTime";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8408f = "UTF-8";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8409g = "crashId";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f8410h = "threadDump";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f8411i = "stackTrace";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f8412j = "threadAllocSize";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f8413k = "threadAllocCount";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f8414l = "nativeHeapFreeSize";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f8415m = "nativeHeapSize";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f8416n = "memLowThreshold";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f8417o = "memLowFlag";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f8418p = "availableInternalMemorySize";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f8419q = "totalInternalMemorySize";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f8420r = "deviceUser";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f8421s = "deviceType";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f8422t = "deviceTime";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f8423u = "deviceTags";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f8424v = "deviceProduct";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f8425w = "deviceManufacturer";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f8426x = "deviceId";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f8427y = "deviceHost";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f8428z = "deviceFingerPrint";

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final HashMap<String, String> f8429I = new LinkedHashMap();

    public c(Application application, Throwable th) {
        try {
            a(application, th);
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.f8810b) {
                f8403a.b("Error collection crash report details", th2);
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
        this.f8429I.put(f8407e, new Date().toString());
    }

    private void c(Application application) {
        this.f8429I.put(f8399E, Build.MODEL);
        this.f8429I.put(f8398D, Build.VERSION.RELEASE);
        this.f8429I.put(f8397C, Build.BOARD);
        this.f8429I.put(f8396B, Build.BRAND);
        this.f8429I.put(f8395A, Build.DISPLAY);
        this.f8429I.put(f8428z, Build.FINGERPRINT);
        this.f8429I.put(f8427y, Build.HOST);
        this.f8429I.put(f8426x, Build.ID);
        this.f8429I.put(f8425w, Build.MANUFACTURER);
        this.f8429I.put(f8424v, Build.PRODUCT);
        this.f8429I.put(f8423u, Build.TAGS);
        this.f8429I.put(f8422t, Long.toString(Build.TIME));
        this.f8429I.put(f8421s, Build.TYPE);
        this.f8429I.put(f8420r, Build.USER);
        this.f8429I.put(f8419q, Long.toString(d()));
        this.f8429I.put(f8418p, Long.toString(c()));
        ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            this.f8429I.put(f8417o, Boolean.toString(memoryInfo.lowMemory));
            this.f8429I.put(f8416n, Long.toString(memoryInfo.threshold));
        }
        this.f8429I.put(f8415m, Long.toString(Debug.getNativeHeapSize()));
        this.f8429I.put(f8414l, Long.toString(Debug.getNativeHeapAllocatedSize()));
        this.f8429I.put(f8413k, Long.toString(Debug.getThreadAllocCount()));
        this.f8429I.put(f8412j, Long.toString(Debug.getThreadAllocSize()));
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
                sb.append(RemoteSettings.FORWARD_SLASH_STRING + key.getName());
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
        this.f8429I.put(f8410h, sb.toString());
    }

    private void f() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8429I.get(f8401G));
            sb.append(this.f8429I.get(f8402H));
            sb.append(this.f8429I.get(f8398D));
            String str = this.f8429I.get(f8411i);
            if (str != null) {
                Matcher matcher = Pattern.compile(f8405c).matcher(str);
                while (matcher.find()) {
                    sb.append(matcher.group());
                }
            }
            this.f8429I.put(f8409g, new BigInteger(MessageDigest.getInstance(f8406d).digest(sb.toString().getBytes(f8408f))).abs().toString(16));
        } catch (Exception e4) {
            if (com.amazon.a.a.o.c.f8810b) {
                f8403a.b("Error capturing crash id", e4);
            }
        }
    }

    private PackageInfo b(Application application) {
        try {
            return application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e4) {
            if (!com.amazon.a.a.o.c.f8810b) {
                return null;
            }
            f8403a.b("Unable to fetch package info", e4);
            return null;
        }
    }

    private void a(Application application) {
        PackageInfo packageInfoB = b(application);
        if (packageInfoB == null) {
            return;
        }
        this.f8429I.put(f8402H, packageInfoB.versionName);
        this.f8429I.put(f8401G, packageInfoB.packageName);
        this.f8429I.put(f8400F, application.getFilesDir().getAbsolutePath());
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
        this.f8429I.put(f8411i, sb.toString());
    }

    public Map<String, String> a() {
        return this.f8429I;
    }

    private long c() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
