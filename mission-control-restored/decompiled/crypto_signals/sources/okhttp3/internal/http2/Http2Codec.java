package okhttp3.internal.http2;

import java.util.List;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import u5.C1250g;
import u5.p;

/* JADX INFO: loaded from: classes.dex */
public final class Http2Codec implements HttpCodec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f8874a = Util.e("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f8875b = Util.e("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    public class StreamFinishingSource extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8877b;

        @Override // u5.p, u5.E
        public final long a(long j4, C1250g c1250g) {
            throw null;
        }

        @Override // u5.p, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            super.close();
            if (this.f8876a) {
                return;
            }
            this.f8876a = true;
            throw null;
        }
    }
}
