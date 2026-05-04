package j3;

import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue f13837a = c4.l.f(20);

    public abstract m a();

    public m b() {
        m mVar = (m) this.f13837a.poll();
        return mVar == null ? a() : mVar;
    }

    public void c(m mVar) {
        if (this.f13837a.size() < 20) {
            this.f13837a.offer(mVar);
        }
    }
}
