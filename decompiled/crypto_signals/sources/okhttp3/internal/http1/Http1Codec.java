package okhttp3.internal.http1;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import k0.a;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import u5.C;
import u5.C1250g;
import u5.E;
import u5.G;

/* JADX INFO: loaded from: classes.dex */
public final class Http1Codec implements HttpCodec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8837a;

    public abstract class AbstractSource implements E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8839b;

        @Override // u5.E
        public long a(long j4, C1250g c1250g) {
            throw null;
        }

        @Override // u5.E
        public final G b() {
            return null;
        }

        public final void d(boolean z6, IOException iOException) {
            throw null;
        }
    }

    public final class ChunkedSink implements C {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8840a;

        @Override // u5.C
        public final void c(long j4, C1250g c1250g) {
            if (this.f8840a) {
                throw new IllegalStateException("closed");
            }
            if (j4 != 0) {
                throw null;
            }
        }

        @Override // u5.C, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            if (!this.f8840a) {
                this.f8840a = true;
                throw null;
            }
        }

        @Override // u5.C, java.io.Flushable
        public final synchronized void flush() {
            if (!this.f8840a) {
                throw null;
            }
        }
    }

    public class ChunkedSource extends AbstractSource {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8842d;

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, u5.E
        public final long a(long j4, C1250g c1250g) throws ProtocolException {
            if (j4 < 0) {
                throw new IllegalArgumentException(a.f("byteCount < 0: ", j4));
            }
            if (this.f8838a) {
                throw new IllegalStateException("closed");
            }
            if (!this.f8842d) {
                return -1L;
            }
            long j6 = this.f8841c;
            if (j6 == 0 || j6 == -1) {
                if (j6 != -1) {
                    throw null;
                }
                throw null;
            }
            long jA = super.a(Math.min(j4, this.f8841c), c1250g);
            if (jA != -1) {
                this.f8841c -= jA;
                return jA;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            d(false, protocolException);
            throw protocolException;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean zF;
            if (this.f8838a) {
                return;
            }
            if (this.f8842d) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                try {
                    zF = Util.f(this, 100);
                } catch (IOException unused) {
                    zF = false;
                }
                if (!zF) {
                    d(false, null);
                }
            }
            this.f8838a = true;
        }
    }

    public final class FixedLengthSink implements C {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8844b;

        @Override // u5.C
        public final void c(long j4, C1250g c1250g) throws ProtocolException {
            if (this.f8843a) {
                throw new IllegalStateException("closed");
            }
            long j6 = c1250g.f10526b;
            byte[] bArr = Util.f8827a;
            if (j4 < 0 || 0 > j6 || j6 < j4) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (j4 <= this.f8844b) {
                throw null;
            }
            throw new ProtocolException("expected " + this.f8844b + " bytes but received " + j4);
        }

        @Override // u5.C, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws ProtocolException {
            if (this.f8843a) {
                return;
            }
            this.f8843a = true;
            if (this.f8844b > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            throw null;
        }

        @Override // u5.C, java.io.Flushable
        public final void flush() {
            if (!this.f8843a) {
                throw null;
            }
        }
    }

    public class FixedLengthSource extends AbstractSource {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8845c;

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, u5.E
        public final long a(long j4, C1250g c1250g) throws ProtocolException {
            if (j4 < 0) {
                throw new IllegalArgumentException(a.f("byteCount < 0: ", j4));
            }
            if (this.f8838a) {
                throw new IllegalStateException("closed");
            }
            long j6 = this.f8845c;
            if (j6 == 0) {
                return -1L;
            }
            long jA = super.a(Math.min(j6, j4), c1250g);
            if (jA == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                d(false, protocolException);
                throw protocolException;
            }
            long j7 = this.f8845c - jA;
            this.f8845c = j7;
            if (j7 == 0) {
                d(true, null);
            }
            return jA;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean zF;
            if (this.f8838a) {
                return;
            }
            if (this.f8845c != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                try {
                    zF = Util.f(this, 100);
                } catch (IOException unused) {
                    zF = false;
                }
                if (!zF) {
                    d(false, null);
                }
            }
            this.f8838a = true;
        }
    }

    public class UnknownLengthSource extends AbstractSource {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8846c;

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, u5.E
        public final long a(long j4, C1250g c1250g) {
            if (j4 < 0) {
                throw new IllegalArgumentException(a.f("byteCount < 0: ", j4));
            }
            if (this.f8838a) {
                throw new IllegalStateException("closed");
            }
            if (this.f8846c) {
                return -1L;
            }
            long jA = super.a(j4, c1250g);
            if (jA != -1) {
                return jA;
            }
            this.f8846c = true;
            d(true, null);
            return -1L;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f8838a) {
                return;
            }
            if (!this.f8846c) {
                d(false, null);
            }
            this.f8838a = true;
        }
    }
}
