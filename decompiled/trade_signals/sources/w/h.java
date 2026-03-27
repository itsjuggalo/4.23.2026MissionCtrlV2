package w;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final x.b lock;
    private final x.c map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public h(int i8) {
        this.maxSize = i8;
        if (i8 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        this.map = new x.c(0, 0.75f);
        this.lock = new x.b();
    }

    public final int a(Object obj, Object obj2) {
        int iSizeOf = sizeOf(obj, obj2);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    public Object create(Object key) {
        AbstractC2304t.f(key, "key");
        return null;
    }

    public final int createCount() {
        int i8;
        synchronized (this.lock) {
            i8 = this.createCount;
        }
        return i8;
    }

    public void entryRemoved(boolean z7, Object key, Object oldValue, Object obj) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(oldValue, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i8;
        synchronized (this.lock) {
            i8 = this.evictionCount;
        }
        return i8;
    }

    public final Object get(Object key) {
        Object objD;
        AbstractC2304t.f(key, "key");
        synchronized (this.lock) {
            Object objA = this.map.a(key);
            if (objA != null) {
                this.hitCount++;
                return objA;
            }
            this.missCount++;
            Object objCreate = create(key);
            if (objCreate == null) {
                return null;
            }
            synchronized (this.lock) {
                try {
                    this.createCount++;
                    objD = this.map.d(key, objCreate);
                    if (objD != null) {
                        this.map.d(key, objD);
                    } else {
                        this.size += a(key, objCreate);
                        C2470H c2470h = C2470H.f21956a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objD != null) {
                entryRemoved(false, key, objCreate, objD);
                return objD;
            }
            trimToSize(this.maxSize);
            return objCreate;
        }
    }

    public final int hitCount() {
        int i8;
        synchronized (this.lock) {
            i8 = this.hitCount;
        }
        return i8;
    }

    public final int maxSize() {
        int i8;
        synchronized (this.lock) {
            i8 = this.maxSize;
        }
        return i8;
    }

    public final int missCount() {
        int i8;
        synchronized (this.lock) {
            i8 = this.missCount;
        }
        return i8;
    }

    public final Object put(Object key, Object value) {
        Object objD;
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(value, "value");
        synchronized (this.lock) {
            try {
                this.putCount++;
                this.size += a(key, value);
                objD = this.map.d(key, value);
                if (objD != null) {
                    this.size -= a(key, objD);
                }
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objD != null) {
            entryRemoved(false, key, objD, value);
        }
        trimToSize(this.maxSize);
        return objD;
    }

    public final int putCount() {
        int i8;
        synchronized (this.lock) {
            i8 = this.putCount;
        }
        return i8;
    }

    public final Object remove(Object key) {
        Object objE;
        AbstractC2304t.f(key, "key");
        synchronized (this.lock) {
            try {
                objE = this.map.e(key);
                if (objE != null) {
                    this.size -= a(key, objE);
                }
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objE != null) {
            entryRemoved(false, key, objE, null);
        }
        return objE;
    }

    public void resize(int i8) {
        if (i8 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        synchronized (this.lock) {
            this.maxSize = i8;
            C2470H c2470h = C2470H.f21956a;
        }
        trimToSize(i8);
    }

    public final int size() {
        int i8;
        synchronized (this.lock) {
            i8 = this.size;
        }
        return i8;
    }

    public int sizeOf(Object key, Object value) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(value, "value");
        return 1;
    }

    public final Map<Object, Object> snapshot() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.lock) {
            try {
                for (Map.Entry entry : this.map.b()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        synchronized (this.lock) {
            try {
                int i8 = this.hitCount;
                int i9 = this.missCount + i8;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i9 != 0 ? (i8 * 100) / i9 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!".toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void trimToSize(int r6) {
        /*
            r5 = this;
        L0:
            x.b r0 = r5.lock
            monitor-enter(r0)
            int r1 = r5.size     // Catch: java.lang.Throwable -> L14
            if (r1 < 0) goto L57
            x.c r1 = r5.map     // Catch: java.lang.Throwable -> L14
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L16
            int r1 = r5.size     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L57
            goto L16
        L14:
            r6 = move-exception
            goto L63
        L16:
            int r1 = r5.size     // Catch: java.lang.Throwable -> L14
            if (r1 <= r6) goto L55
            x.c r1 = r5.map     // Catch: java.lang.Throwable -> L14
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L23
            goto L55
        L23:
            x.c r1 = r5.map     // Catch: java.lang.Throwable -> L14
            java.util.Set r1 = r1.b()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r1 = p5.z.Z(r1)     // Catch: java.lang.Throwable -> L14
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L33
            monitor-exit(r0)
            return
        L33:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L14
            x.c r3 = r5.map     // Catch: java.lang.Throwable -> L14
            r3.e(r2)     // Catch: java.lang.Throwable -> L14
            int r3 = r5.size     // Catch: java.lang.Throwable -> L14
            int r4 = r5.a(r2, r1)     // Catch: java.lang.Throwable -> L14
            int r3 = r3 - r4
            r5.size = r3     // Catch: java.lang.Throwable -> L14
            int r3 = r5.evictionCount     // Catch: java.lang.Throwable -> L14
            r4 = 1
            int r3 = r3 + r4
            r5.evictionCount = r3     // Catch: java.lang.Throwable -> L14
            monitor-exit(r0)
            r0 = 0
            r5.entryRemoved(r4, r2, r1, r0)
            goto L0
        L55:
            monitor-exit(r0)
            return
        L57:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L14
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L14
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L14
            throw r1     // Catch: java.lang.Throwable -> L14
        L63:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: w.h.trimToSize(int):void");
    }
}
