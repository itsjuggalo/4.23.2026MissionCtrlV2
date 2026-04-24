package okhttp3.internal.http2;

import com.google.android.gms.common.api.a;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import w6.C2792e;
import w6.InterfaceC2793f;

/* JADX INFO: loaded from: classes2.dex */
final class Http2Writer implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f21039g = Logger.getLogger(Http2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2793f f21040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2792e f21042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Hpack.Writer f21045f;

    public Http2Writer(InterfaceC2793f interfaceC2793f, boolean z7) {
        this.f21040a = interfaceC2793f;
        this.f21041b = z7;
        C2792e c2792e = new C2792e();
        this.f21042c = c2792e;
        this.f21045f = new Hpack.Writer(c2792e);
        this.f21043d = 16384;
    }

    public static void X(InterfaceC2793f interfaceC2793f, int i7) {
        interfaceC2793f.v((i7 >>> 16) & 255);
        interfaceC2793f.v((i7 >>> 8) & 255);
        interfaceC2793f.v(i7 & 255);
    }

    public void A(int i7, int i8, byte b7, byte b8) {
        Logger logger = f21039g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.b(false, i7, i8, b7, b8));
        }
        int i9 = this.f21043d;
        if (i8 > i9) {
            throw Http2.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i9), Integer.valueOf(i8));
        }
        if ((Integer.MIN_VALUE & i7) != 0) {
            throw Http2.c("reserved bit set: %s", Integer.valueOf(i7));
        }
        X(this.f21040a, i8);
        this.f21040a.v(b7 & 255);
        this.f21040a.v(b8 & 255);
        this.f21040a.r(i7 & a.e.API_PRIORITY_OTHER);
    }

    public synchronized void G(int i7, ErrorCode errorCode, byte[] bArr) {
        try {
            if (this.f21044e) {
                throw new IOException("closed");
            }
            if (errorCode.f20891a == -1) {
                throw Http2.c("errorCode.httpCode == -1", new Object[0]);
            }
            A(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f21040a.r(i7);
            this.f21040a.r(errorCode.f20891a);
            if (bArr.length > 0) {
                this.f21040a.a0(bArr);
            }
            this.f21040a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void H(boolean z7, int i7, List list) throws IOException {
        if (this.f21044e) {
            throw new IOException("closed");
        }
        this.f21045f.g(list);
        long jE0 = this.f21042c.E0();
        int iMin = (int) Math.min(this.f21043d, jE0);
        long j7 = iMin;
        byte b7 = jE0 == j7 ? (byte) 4 : (byte) 0;
        if (z7) {
            b7 = (byte) (b7 | 1);
        }
        A(i7, iMin, (byte) 1, b7);
        this.f21040a.L(this.f21042c, j7);
        if (jE0 > j7) {
            V(i7, jE0 - j7);
        }
    }

    public synchronized void K(int i7, int i8, List list) {
        if (this.f21044e) {
            throw new IOException("closed");
        }
        this.f21045f.g(list);
        long jE0 = this.f21042c.E0();
        int iMin = (int) Math.min(this.f21043d - 4, jE0);
        long j7 = iMin;
        A(i7, iMin + 4, (byte) 5, jE0 == j7 ? (byte) 4 : (byte) 0);
        this.f21040a.r(i8 & a.e.API_PRIORITY_OTHER);
        this.f21040a.L(this.f21042c, j7);
        if (jE0 > j7) {
            V(i7, jE0 - j7);
        }
    }

    public synchronized void M(int i7, ErrorCode errorCode) {
        if (this.f21044e) {
            throw new IOException("closed");
        }
        if (errorCode.f20891a == -1) {
            throw new IllegalArgumentException();
        }
        A(i7, 4, (byte) 3, (byte) 0);
        this.f21040a.r(errorCode.f20891a);
        this.f21040a.flush();
    }

    public synchronized void O(Settings settings) {
        try {
            if (this.f21044e) {
                throw new IOException("closed");
            }
            int i7 = 0;
            A(0, settings.j() * 6, (byte) 4, (byte) 0);
            while (i7 < 10) {
                if (settings.g(i7)) {
                    this.f21040a.q(i7 == 4 ? 3 : i7 == 7 ? 4 : i7);
                    this.f21040a.r(settings.b(i7));
                }
                i7++;
            }
            this.f21040a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void T(boolean z7, int i7, int i8, List list) {
        if (this.f21044e) {
            throw new IOException("closed");
        }
        H(z7, i7, list);
    }

    public final void V(int i7, long j7) {
        while (j7 > 0) {
            int iMin = (int) Math.min(this.f21043d, j7);
            long j8 = iMin;
            j7 -= j8;
            A(i7, iMin, (byte) 9, j7 == 0 ? (byte) 4 : (byte) 0);
            this.f21040a.L(this.f21042c, j8);
        }
    }

    public synchronized void a(int i7, long j7) {
        if (this.f21044e) {
            throw new IOException("closed");
        }
        if (j7 == 0 || j7 > 2147483647L) {
            throw Http2.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j7));
        }
        A(i7, 4, (byte) 8, (byte) 0);
        this.f21040a.r((int) j7);
        this.f21040a.flush();
    }

    public synchronized void b(boolean z7, int i7, int i8) {
        if (this.f21044e) {
            throw new IOException("closed");
        }
        A(0, 8, (byte) 6, z7 ? (byte) 1 : (byte) 0);
        this.f21040a.r(i7);
        this.f21040a.r(i8);
        this.f21040a.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f21044e = true;
        this.f21040a.close();
    }

    public synchronized void flush() {
        if (this.f21044e) {
            throw new IOException("closed");
        }
        this.f21040a.flush();
    }

    public synchronized void h(Settings settings) {
        try {
            if (this.f21044e) {
                throw new IOException("closed");
            }
            this.f21043d = settings.f(this.f21043d);
            if (settings.c() != -1) {
                this.f21045f.e(settings.c());
            }
            A(0, 0, (byte) 4, (byte) 1);
            this.f21040a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void i(int i7, byte b7, C2792e c2792e, int i8) {
        A(i7, i8, (byte) 0, b7);
        if (i8 > 0) {
            this.f21040a.L(c2792e, i8);
        }
    }

    public synchronized void k0(boolean z7, int i7, C2792e c2792e, int i8) {
        if (this.f21044e) {
            throw new IOException("closed");
        }
        i(i7, z7 ? (byte) 1 : (byte) 0, c2792e, i8);
    }

    public int m0() {
        return this.f21043d;
    }

    public synchronized void w() {
        try {
            if (this.f21044e) {
                throw new IOException("closed");
            }
            if (this.f21041b) {
                Logger logger = f21039g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util.q(">> CONNECTION %s", Http2.f20921a.q()));
                }
                this.f21040a.a0(Http2.f20921a.M());
                this.f21040a.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
