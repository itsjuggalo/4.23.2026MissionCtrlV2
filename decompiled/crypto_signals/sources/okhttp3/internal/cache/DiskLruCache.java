package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.Flushable;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache implements Closeable, Flushable {

    /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$2, reason: invalid class name */
    class AnonymousClass2 extends FaultHidingSink {
        @Override // okhttp3.internal.cache.FaultHidingSink
        public final void d() {
            throw null;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$3, reason: invalid class name */
    class AnonymousClass3 implements Iterator<Snapshot> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final Snapshot next() {
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new IllegalStateException("remove() before next()");
        }
    }

    public final class Editor {

        /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$Editor$1, reason: invalid class name */
        class AnonymousClass1 extends FaultHidingSink {
            @Override // okhttp3.internal.cache.FaultHidingSink
            public final void d() {
                throw null;
            }
        }
    }

    public final class Entry {
    }

    public final class Snapshot implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw null;
        }
    }

    static {
        Pattern.compile("[a-z0-9_-]{1,120}");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        throw null;
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
    }
}
