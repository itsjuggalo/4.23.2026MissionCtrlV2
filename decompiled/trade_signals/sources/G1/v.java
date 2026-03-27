package G1;

import H1.InterfaceC0586d;
import I1.b;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f2152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0586d f2153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f2154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final I1.b f2155d;

    public v(Executor executor, InterfaceC0586d interfaceC0586d, x xVar, I1.b bVar) {
        this.f2152a = executor;
        this.f2153b = interfaceC0586d;
        this.f2154c = xVar;
        this.f2155d = bVar;
    }

    public void c() {
        this.f2152a.execute(new Runnable() { // from class: G1.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f2150a.e();
            }
        });
    }

    public final /* synthetic */ Object d() {
        Iterator it = this.f2153b.z().iterator();
        while (it.hasNext()) {
            this.f2154c.a((z1.p) it.next(), 1);
        }
        return null;
    }

    public final /* synthetic */ void e() {
        this.f2155d.c(new b.a() { // from class: G1.u
            @Override // I1.b.a
            public final Object a() {
                return this.f2151a.d();
            }
        });
    }
}
