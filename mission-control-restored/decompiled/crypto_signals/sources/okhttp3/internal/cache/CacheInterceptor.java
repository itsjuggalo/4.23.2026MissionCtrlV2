package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.internal.Util;
import u5.C1250g;
import u5.E;
import u5.G;

/* JADX INFO: loaded from: classes.dex */
public final class CacheInterceptor implements Interceptor {

    /* JADX INFO: renamed from: okhttp3.internal.cache.CacheInterceptor$1, reason: invalid class name */
    class AnonymousClass1 implements E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8833a;

        @Override // u5.E
        public final long a(long j4, C1250g c1250g) {
            throw null;
        }

        @Override // u5.E
        public final G b() {
            throw null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean zF;
            if (!this.f8833a) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                try {
                    zF = Util.f(this, 100);
                } catch (IOException unused) {
                    zF = false;
                }
                if (!zF) {
                    this.f8833a = true;
                    throw null;
                }
            }
            throw null;
        }
    }
}
