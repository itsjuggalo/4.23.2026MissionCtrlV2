package k3;

import c4.k;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f14490a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f14491b = new b();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lock f14492a = new ReentrantLock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14493b;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue f14494a = new ArrayDeque();

        public a a() {
            a aVar;
            synchronized (this.f14494a) {
                aVar = (a) this.f14494a.poll();
            }
            return aVar == null ? new a() : aVar;
        }

        public void b(a aVar) {
            synchronized (this.f14494a) {
                try {
                    if (this.f14494a.size() < 10) {
                        this.f14494a.offer(aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void a(String str) {
        a aVarA;
        synchronized (this) {
            try {
                aVarA = (a) this.f14490a.get(str);
                if (aVarA == null) {
                    aVarA = this.f14491b.a();
                    this.f14490a.put(str, aVarA);
                }
                aVarA.f14493b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        aVarA.f14492a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = (a) k.e((a) this.f14490a.get(str));
                int i10 = aVar.f14493b;
                if (i10 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f14493b);
                }
                int i11 = i10 - 1;
                aVar.f14493b = i11;
                if (i11 == 0) {
                    a aVar2 = (a) this.f14490a.remove(str);
                    if (!aVar2.equals(aVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVar2 + ", safeKey: " + str);
                    }
                    this.f14491b.b(aVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.f14492a.unlock();
    }
}
