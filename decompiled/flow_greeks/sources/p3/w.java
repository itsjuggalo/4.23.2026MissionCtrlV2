package p3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f18281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f18282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final File f18283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile w f18284h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18287c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f18288d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18285a = 20000;

    static {
        int i10 = Build.VERSION.SDK_INT;
        f18281e = i10 < 29;
        f18282f = i10 >= 28;
        f18283g = new File("/proc/self/fd");
    }

    public static w b() {
        if (f18284h == null) {
            synchronized (w.class) {
                try {
                    if (f18284h == null) {
                        f18284h = new w();
                    }
                } finally {
                }
            }
        }
        return f18284h;
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
        return f18281e && !this.f18288d.get();
    }

    public final int c() {
        if (e()) {
            return 500;
        }
        return this.f18285a;
    }

    public final synchronized boolean d() {
        try {
            boolean z10 = true;
            int i10 = this.f18286b + 1;
            this.f18286b = i10;
            if (i10 >= 50) {
                this.f18286b = 0;
                int length = f18283g.list().length;
                long jC = c();
                if (length >= jC) {
                    z10 = false;
                }
                this.f18287c = z10;
                if (!z10 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jC);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f18287c;
    }

    public boolean f(int i10, int i11, boolean z10, boolean z11) {
        if (!z10) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!f18282f) {
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
        if (z11) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i10 < 0 || i11 < 0) {
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

    public boolean g(int i10, int i11, BitmapFactory.Options options, boolean z10, boolean z11) {
        boolean zF = f(i10, i11, z10, z11);
        if (zF) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zF;
    }

    public void h() {
        c4.l.a();
        this.f18288d.set(true);
    }
}
