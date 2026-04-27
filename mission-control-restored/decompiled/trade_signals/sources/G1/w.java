package G1;

import H1.InterfaceC0586d;
import java.util.concurrent.Executor;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class w implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f2156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f2157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f2158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2426a f2159d;

    public w(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4) {
        this.f2156a = interfaceC2426a;
        this.f2157b = interfaceC2426a2;
        this.f2158c = interfaceC2426a3;
        this.f2159d = interfaceC2426a4;
    }

    public static w a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4) {
        return new w(interfaceC2426a, interfaceC2426a2, interfaceC2426a3, interfaceC2426a4);
    }

    public static v c(Executor executor, InterfaceC0586d interfaceC0586d, x xVar, I1.b bVar) {
        return new v(executor, interfaceC0586d, xVar, bVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v get() {
        return c((Executor) this.f2156a.get(), (InterfaceC0586d) this.f2157b.get(), (x) this.f2158c.get(), (I1.b) this.f2159d.get());
    }
}
