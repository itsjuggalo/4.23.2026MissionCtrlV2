package h1;

import i1.InterfaceC1297d;
import j1.InterfaceC1562b;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f12157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1297d f12158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f12159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC1562b f12160d;

    public v(Executor executor, InterfaceC1297d interfaceC1297d, x xVar, InterfaceC1562b interfaceC1562b) {
        this.f12157a = executor;
        this.f12158b = interfaceC1297d;
        this.f12159c = xVar;
        this.f12160d = interfaceC1562b;
    }

    public static /* synthetic */ Object a(v vVar) {
        Iterator it = vVar.f12158b.u().iterator();
        while (it.hasNext()) {
            vVar.f12159c.b((a1.p) it.next(), 1);
        }
        return null;
    }

    public void c() {
        this.f12157a.execute(new Runnable() { // from class: h1.t
            @Override // java.lang.Runnable
            public final void run() {
                v vVar = this.f12155a;
                vVar.f12160d.f(new InterfaceC1562b.a() { // from class: h1.u
                    @Override // j1.InterfaceC1562b.a
                    public final Object a() {
                        return v.a(vVar);
                    }
                });
            }
        });
    }
}
