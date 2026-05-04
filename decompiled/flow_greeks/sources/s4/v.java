package s4;

import java.util.Iterator;
import java.util.concurrent.Executor;
import u4.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f20029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t4.d f20030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f20031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u4.b f20032d;

    public v(Executor executor, t4.d dVar, x xVar, u4.b bVar) {
        this.f20029a = executor;
        this.f20030b = dVar;
        this.f20031c = xVar;
        this.f20032d = bVar;
    }

    public static /* synthetic */ Object a(v vVar) {
        Iterator it = vVar.f20030b.s().iterator();
        while (it.hasNext()) {
            vVar.f20031c.b((l4.p) it.next(), 1);
        }
        return null;
    }

    public void c() {
        this.f20029a.execute(new Runnable() { // from class: s4.t
            @Override // java.lang.Runnable
            public final void run() {
                v vVar = this.f20027a;
                vVar.f20032d.e(new b.a() { // from class: s4.u
                    @Override // u4.b.a
                    public final Object a() {
                        return v.a(vVar);
                    }
                });
            }
        });
    }
}
