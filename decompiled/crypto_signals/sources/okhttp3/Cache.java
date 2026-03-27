package okhttp3;

import java.io.Closeable;
import java.io.Flushable;
import java.util.Iterator;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.platform.Platform;
import u5.i;
import u5.o;
import u5.p;

/* JADX INFO: loaded from: classes.dex */
public final class Cache implements Closeable, Flushable {

    /* JADX INFO: renamed from: okhttp3.Cache$1, reason: invalid class name */
    public class AnonymousClass1 implements InternalCache {
    }

    /* JADX INFO: renamed from: okhttp3.Cache$2, reason: invalid class name */
    class AnonymousClass2 implements Iterator<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8729a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            this.f8729a = false;
            throw null;
        }

        @Override // java.util.Iterator
        public final String next() {
            this.f8729a = false;
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f8729a) {
                throw new IllegalStateException("remove() before next()");
            }
            throw null;
        }
    }

    public final class CacheRequestImpl implements CacheRequest {

        /* JADX INFO: renamed from: okhttp3.Cache$CacheRequestImpl$1, reason: invalid class name */
        class AnonymousClass1 extends o {
            @Override // u5.o, u5.C, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                throw null;
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public final void a() {
            throw null;
        }
    }

    public static class CacheResponseBody extends ResponseBody {

        /* JADX INFO: renamed from: okhttp3.Cache$CacheResponseBody$1, reason: invalid class name */
        class AnonymousClass1 extends p {
            @Override // u5.p, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                throw null;
            }
        }

        @Override // okhttp3.ResponseBody
        public final i f() {
            return null;
        }
    }

    public static final class Entry {
        static {
            Platform.f8950a.getClass();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // java.io.Flushable
    public final void flush() {
        throw null;
    }
}
