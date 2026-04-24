package okhttp3.internal.cache2;

import u5.AbstractC1245b;
import u5.C1250g;
import u5.E;
import u5.G;
import u5.j;

/* JADX INFO: loaded from: classes.dex */
final class Relay {

    public class RelaySource implements E {
        @Override // u5.E
        public final long a(long j4, C1250g c1250g) {
            throw new IllegalStateException("closed");
        }

        @Override // u5.E
        public final G b() {
            return null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    }

    static {
        j jVar = j.f10527d;
        AbstractC1245b.e("OkHttp cache v1\n");
        AbstractC1245b.e("OkHttp DIRTY :(\n");
    }
}
