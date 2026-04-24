package Y0;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f9494a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f9495b = new b();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lock f9496a = new ReentrantLock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9497b;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue f9498a = new ArrayDeque();

        public a a() {
            a aVar;
            synchronized (this.f9498a) {
                aVar = (a) this.f9498a.poll();
            }
            return aVar == null ? new a() : aVar;
        }

        public void b(a aVar) {
            synchronized (this.f9498a) {
                try {
                    if (this.f9498a.size() < 10) {
                        this.f9498a.offer(aVar);
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
                aVarA = (a) this.f9494a.get(str);
                if (aVarA == null) {
                    aVarA = this.f9495b.a();
                    this.f9494a.put(str, aVarA);
                }
                aVarA.f9497b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        aVarA.f9496a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = (a) AbstractC2628k.d(this.f9494a.get(str));
                int i8 = aVar.f9497b;
                if (i8 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f9497b);
                }
                int i9 = i8 - 1;
                aVar.f9497b = i9;
                if (i9 == 0) {
                    a aVar2 = (a) this.f9494a.remove(str);
                    if (!aVar2.equals(aVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVar2 + ", safeKey: " + str);
                    }
                    this.f9495b.b(aVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.f9496a.unlock();
    }
}
