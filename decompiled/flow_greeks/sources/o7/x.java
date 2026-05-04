package o7;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class x implements fa.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set f17600b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set f17599a = Collections.newSetFromMap(new ConcurrentHashMap());

    public x(Collection collection) {
        this.f17599a.addAll(collection);
    }

    public static x b(Collection collection) {
        return new x((Set) collection);
    }

    public synchronized void a(fa.b bVar) {
        try {
            if (this.f17600b == null) {
                this.f17599a.add(bVar);
            } else {
                this.f17600b.add(bVar.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // fa.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set get() {
        if (this.f17600b == null) {
            synchronized (this) {
                try {
                    if (this.f17600b == null) {
                        this.f17600b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f17600b);
    }

    public final synchronized void d() {
        try {
            Iterator it = this.f17599a.iterator();
            while (it.hasNext()) {
                this.f17600b.add(((fa.b) it.next()).get());
            }
            this.f17599a = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
