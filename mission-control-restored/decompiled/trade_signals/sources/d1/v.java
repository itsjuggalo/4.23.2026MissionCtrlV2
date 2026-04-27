package d1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f16818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f16819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final File f16820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile v f16821h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16824c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f16825d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16822a = 20000;

    static {
        int i8 = Build.VERSION.SDK_INT;
        f16818e = i8 < 29;
        f16819f = i8 >= 28;
        f16820g = new File("/proc/self/fd");
    }

    public static v b() {
        if (f16821h == null) {
            synchronized (v.class) {
                try {
                    if (f16821h == null) {
                        f16821h = new v();
                    }
                } finally {
                }
            }
        }
        return f16821h;
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean a() {
        return f16818e && !this.f16825d.get();
    }

    public final int c() {
        if (e()) {
            return 500;
        }
        return this.f16822a;
    }

    public final synchronized boolean d() {
        try {
            boolean z7 = true;
            int i8 = this.f16823b + 1;
            this.f16823b = i8;
            if (i8 >= 50) {
                this.f16823b = 0;
                int length = f16820g.list().length;
                long jC = c();
                if (length >= jC) {
                    z7 = false;
                }
                this.f16824c = z7;
                if (!z7 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jC);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f16824c;
    }

    public boolean f(int i8, int i9, boolean z7, boolean z8) {
        if (!z7) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!f16819f) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z8) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i8 < 0 || i9 < 0) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
            }
            return false;
        }
        if (d()) {
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    public boolean g(int i8, int i9, BitmapFactory.Options options, boolean z7, boolean z8) {
        boolean zF = f(i8, i9, z7, z8);
        if (zF) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zF;
    }

    public void h() {
        AbstractC2629l.a();
        this.f16825d.set(true);
    }
}
