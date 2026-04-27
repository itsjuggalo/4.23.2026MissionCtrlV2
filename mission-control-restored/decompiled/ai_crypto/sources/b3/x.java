package b3;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class x implements N3.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set f8577b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set f8576a = Collections.newSetFromMap(new ConcurrentHashMap());

    public x(Collection collection) {
        this.f8576a.addAll(collection);
    }

    public static x b(Collection collection) {
        return new x((Set) collection);
    }

    public synchronized void a(N3.b bVar) {
        try {
            if (this.f8577b == null) {
                this.f8576a.add(bVar);
            } else {
                this.f8577b.add(bVar.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // N3.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set get() {
        if (this.f8577b == null) {
            synchronized (this) {
                try {
                    if (this.f8577b == null) {
                        this.f8577b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f8577b);
    }

    public final synchronized void d() {
        try {
            Iterator it = this.f8576a.iterator();
            while (it.hasNext()) {
                this.f8577b.add(((N3.b) it.next()).get());
            }
            this.f8576a = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
