package okhttp3.internal.connection;

import okhttp3.Connection;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8835a;

    /* JADX INFO: renamed from: okhttp3.internal.connection.RealConnection$1, reason: invalid class name */
    class AnonymousClass1 extends RealWebSocket.Streams {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw null;
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final void a(Http2Connection http2Connection) {
        throw null;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final void b(Http2Stream http2Stream) {
        http2Stream.c(ErrorCode.REFUSED_STREAM);
    }

    public final String toString() {
        throw null;
    }
}
