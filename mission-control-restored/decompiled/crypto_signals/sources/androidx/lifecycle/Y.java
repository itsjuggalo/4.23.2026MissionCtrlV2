package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f4668a = new LinkedHashMap();

    public final void a() {
        for (T t6 : this.f4668a.values()) {
            t6.f4662c = true;
            HashMap map = t6.f4660a;
            if (map != null) {
                synchronized (map) {
                    try {
                        Iterator it = t6.f4660a.values().iterator();
                        while (it.hasNext()) {
                            T.a(it.next());
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = t6.f4661b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = t6.f4661b.iterator();
                        while (it2.hasNext()) {
                            T.a((Closeable) it2.next());
                        }
                    } finally {
                    }
                }
                t6.f4661b.clear();
            }
            t6.b();
        }
        this.f4668a.clear();
    }
}
