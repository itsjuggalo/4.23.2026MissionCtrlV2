package l2;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20560a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue f20561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20562c;

    public final void a(K k8) {
        synchronized (this.f20560a) {
            try {
                if (this.f20561b == null) {
                    this.f20561b = new ArrayDeque();
                }
                this.f20561b.add(k8);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(AbstractC2328l abstractC2328l) {
        K k8;
        synchronized (this.f20560a) {
            if (this.f20561b != null && !this.f20562c) {
                this.f20562c = true;
                while (true) {
                    synchronized (this.f20560a) {
                        try {
                            k8 = (K) this.f20561b.poll();
                            if (k8 == null) {
                                this.f20562c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    k8.b(abstractC2328l);
                }
            }
        }
    }
}
