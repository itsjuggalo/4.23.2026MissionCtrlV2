package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import u5.C1250g;

/* JADX INFO: loaded from: classes.dex */
final class Http2Writer implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f8934c = Logger.getLogger(Http2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8936b;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f8936b = true;
        throw null;
    }

    public final synchronized void d(Settings settings) {
        try {
            if (this.f8936b) {
                throw new IOException("closed");
            }
            int i = this.f8935a;
            int i6 = settings.f8944a;
            if ((i6 & 32) != 0) {
                i = settings.f8945b[5];
            }
            this.f8935a = i;
            if (((i6 & 2) != 0 ? settings.f8945b[1] : -1) != -1) {
                Math.min((i6 & 2) != 0 ? settings.f8945b[1] : -1, 16384);
                throw null;
            }
            g(0, 0, (byte) 4, (byte) 1);
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void f(boolean z6, int i, C1250g c1250g, int i6) {
        if (this.f8936b) {
            throw new IOException("closed");
        }
        g(i, i6, (byte) 0, z6 ? (byte) 1 : (byte) 0);
        if (i6 > 0) {
            throw null;
        }
    }

    public final synchronized void flush() {
        try {
            if (!this.f8936b) {
                throw null;
            }
            throw new IOException("closed");
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void g(int i, int i6, byte b3, byte b6) {
        Level level = Level.FINE;
        Logger logger = f8934c;
        if (logger.isLoggable(level)) {
            logger.fine(Http2.a(false, i, i6, b3, b6));
        }
        int i7 = this.f8935a;
        if (i6 > i7) {
            Http2.b("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i7), Integer.valueOf(i6));
            throw null;
        }
        if ((Integer.MIN_VALUE & i) == 0) {
            throw null;
        }
        Http2.b("reserved bit set: %s", Integer.valueOf(i));
        throw null;
    }

    public final synchronized void h(int i, ErrorCode errorCode, byte[] bArr) {
        try {
            if (this.f8936b) {
                throw new IOException("closed");
            }
            if (errorCode.f8853a != -1) {
                g(0, bArr.length + 8, (byte) 7, (byte) 0);
                throw null;
            }
            Http2.b("errorCode.httpCode == -1", new Object[0]);
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void i(int i, int i6, boolean z6) {
        try {
            if (this.f8936b) {
                throw new IOException("closed");
            }
            g(0, 8, (byte) 6, z6 ? (byte) 1 : (byte) 0);
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void j(int i, ErrorCode errorCode) {
        try {
            if (this.f8936b) {
                throw new IOException("closed");
            }
            if (errorCode.f8853a == -1) {
                throw new IllegalArgumentException();
            }
            g(i, 4, (byte) 3, (byte) 0);
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void k(int i, long j4) {
        try {
            if (this.f8936b) {
                throw new IOException("closed");
            }
            if (j4 == 0 || j4 > 2147483647L) {
                Http2.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j4));
                throw null;
            }
            g(i, 4, (byte) 8, (byte) 0);
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
