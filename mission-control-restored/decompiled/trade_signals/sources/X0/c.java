package X0;

import java.util.Queue;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue f9324a = AbstractC2629l.f(20);

    public abstract m a();

    public m b() {
        m mVar = (m) this.f9324a.poll();
        return mVar == null ? a() : mVar;
    }

    public void c(m mVar) {
        if (this.f9324a.size() < 20) {
            this.f9324a.offer(mVar);
        }
    }
}
