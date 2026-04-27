package G1;

import H1.InterfaceC0585c;
import H1.InterfaceC0586d;
import android.content.Context;
import java.util.concurrent.Executor;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class s implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f2141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f2142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f2143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2426a f2144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2426a f2145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC2426a f2146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC2426a f2147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InterfaceC2426a f2148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InterfaceC2426a f2149i;

    public s(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4, InterfaceC2426a interfaceC2426a5, InterfaceC2426a interfaceC2426a6, InterfaceC2426a interfaceC2426a7, InterfaceC2426a interfaceC2426a8, InterfaceC2426a interfaceC2426a9) {
        this.f2141a = interfaceC2426a;
        this.f2142b = interfaceC2426a2;
        this.f2143c = interfaceC2426a3;
        this.f2144d = interfaceC2426a4;
        this.f2145e = interfaceC2426a5;
        this.f2146f = interfaceC2426a6;
        this.f2147g = interfaceC2426a7;
        this.f2148h = interfaceC2426a8;
        this.f2149i = interfaceC2426a9;
    }

    public static s a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4, InterfaceC2426a interfaceC2426a5, InterfaceC2426a interfaceC2426a6, InterfaceC2426a interfaceC2426a7, InterfaceC2426a interfaceC2426a8, InterfaceC2426a interfaceC2426a9) {
        return new s(interfaceC2426a, interfaceC2426a2, interfaceC2426a3, interfaceC2426a4, interfaceC2426a5, interfaceC2426a6, interfaceC2426a7, interfaceC2426a8, interfaceC2426a9);
    }

    public static r c(Context context, A1.e eVar, InterfaceC0586d interfaceC0586d, x xVar, Executor executor, I1.b bVar, J1.a aVar, J1.a aVar2, InterfaceC0585c interfaceC0585c) {
        return new r(context, eVar, interfaceC0586d, xVar, executor, bVar, aVar, aVar2, interfaceC0585c);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r get() {
        return c((Context) this.f2141a.get(), (A1.e) this.f2142b.get(), (InterfaceC0586d) this.f2143c.get(), (x) this.f2144d.get(), (Executor) this.f2145e.get(), (I1.b) this.f2146f.get(), (J1.a) this.f2147g.get(), (J1.a) this.f2148h.get(), (InterfaceC0585c) this.f2149i.get());
    }
}
