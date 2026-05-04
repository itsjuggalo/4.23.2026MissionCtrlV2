package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2427a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f2428b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f2429c = false;

    public static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final void a() {
        this.f2429c = true;
        Map map = this.f2427a;
        if (map != null) {
            synchronized (map) {
                try {
                    Iterator it = this.f2427a.values().iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                } finally {
                }
            }
        }
        Set set = this.f2428b;
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator it2 = this.f2428b.iterator();
                    while (it2.hasNext()) {
                        b((Closeable) it2.next());
                    }
                } finally {
                }
            }
            this.f2428b.clear();
        }
        d();
    }

    public Object c(String str) {
        Object obj;
        Map map = this.f2427a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f2427a.get(str);
        }
        return obj;
    }

    public Object e(String str, Object obj) {
        Object obj2;
        synchronized (this.f2427a) {
            try {
                obj2 = this.f2427a.get(str);
                if (obj2 == null) {
                    this.f2427a.put(str, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj2 != null) {
            obj = obj2;
        }
        if (this.f2429c) {
            b(obj);
        }
        return obj;
    }

    public void d() {
    }
}
