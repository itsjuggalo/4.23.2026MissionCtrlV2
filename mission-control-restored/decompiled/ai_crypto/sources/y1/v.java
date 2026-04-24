package y1;

import A1.b;
import java.util.Iterator;
import java.util.concurrent.Executor;
import z1.InterfaceC2859d;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f25521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2859d f25522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f25523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final A1.b f25524d;

    public v(Executor executor, InterfaceC2859d interfaceC2859d, x xVar, A1.b bVar) {
        this.f25521a = executor;
        this.f25522b = interfaceC2859d;
        this.f25523c = xVar;
        this.f25524d = bVar;
    }

    public void c() {
        this.f25521a.execute(new Runnable() { // from class: y1.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f25519a.e();
            }
        });
    }

    public final /* synthetic */ Object d() {
        Iterator it = this.f25522b.y().iterator();
        while (it.hasNext()) {
            this.f25523c.b((r1.p) it.next(), 1);
        }
        return null;
    }

    public final /* synthetic */ void e() {
        this.f25524d.h(new b.a() { // from class: y1.u
            @Override // A1.b.a
            public final Object a() {
                return this.f25520a.d();
            }
        });
    }
}
