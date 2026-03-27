package F1;

import G1.x;
import H1.InterfaceC0586d;
import java.util.concurrent.Executor;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class d implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f1513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f1514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f1515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2426a f1516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2426a f1517e;

    public d(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4, InterfaceC2426a interfaceC2426a5) {
        this.f1513a = interfaceC2426a;
        this.f1514b = interfaceC2426a2;
        this.f1515c = interfaceC2426a3;
        this.f1516d = interfaceC2426a4;
        this.f1517e = interfaceC2426a5;
    }

    public static d a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4, InterfaceC2426a interfaceC2426a5) {
        return new d(interfaceC2426a, interfaceC2426a2, interfaceC2426a3, interfaceC2426a4, interfaceC2426a5);
    }

    public static c c(Executor executor, A1.e eVar, x xVar, InterfaceC0586d interfaceC0586d, I1.b bVar) {
        return new c(executor, eVar, xVar, interfaceC0586d, bVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c((Executor) this.f1513a.get(), (A1.e) this.f1514b.get(), (x) this.f1515c.get(), (InterfaceC0586d) this.f1516d.get(), (I1.b) this.f1517e.get());
    }
}
