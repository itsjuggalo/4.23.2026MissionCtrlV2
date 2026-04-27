package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11939a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f11940b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f11941c = false;

    public static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e8) {
                throw new RuntimeException(e8);
            }
        }
    }

    public final void a() {
        this.f11941c = true;
        Map map = this.f11939a;
        if (map != null) {
            synchronized (map) {
                try {
                    Iterator it = this.f11939a.values().iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                } finally {
                }
            }
        }
        Set set = this.f11940b;
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator it2 = this.f11940b.iterator();
                    while (it2.hasNext()) {
                        b((Closeable) it2.next());
                    }
                } finally {
                }
            }
            this.f11940b.clear();
        }
        d();
    }

    public Object c(String str) {
        Object obj;
        Map map = this.f11939a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f11939a.get(str);
        }
        return obj;
    }

    public void d() {
    }

    public Object e(String str, Object obj) {
        Object obj2;
        synchronized (this.f11939a) {
            try {
                obj2 = this.f11939a.get(str);
                if (obj2 == null) {
                    this.f11939a.put(str, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj2 != null) {
            obj = obj2;
        }
        if (this.f11941c) {
            b(obj);
        }
        return obj;
    }
}
