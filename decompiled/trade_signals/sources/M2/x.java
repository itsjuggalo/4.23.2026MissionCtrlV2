package M2;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class x implements S3.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set f5344b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set f5343a = Collections.newSetFromMap(new ConcurrentHashMap());

    public x(Collection collection) {
        this.f5343a.addAll(collection);
    }

    public static x b(Collection collection) {
        return new x((Set) collection);
    }

    public synchronized void a(S3.b bVar) {
        Set set;
        S3.b bVar2;
        try {
            if (this.f5344b == null) {
                set = this.f5343a;
                bVar2 = bVar;
            } else {
                set = this.f5344b;
                bVar2 = bVar.get();
            }
            set.add(bVar2);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // S3.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set get() {
        if (this.f5344b == null) {
            synchronized (this) {
                try {
                    if (this.f5344b == null) {
                        this.f5344b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f5344b);
    }

    public final synchronized void d() {
        try {
            Iterator it = this.f5343a.iterator();
            while (it.hasNext()) {
                this.f5344b.add(((S3.b) it.next()).get());
            }
            this.f5343a = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
