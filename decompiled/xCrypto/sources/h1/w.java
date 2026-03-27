package h1;

import i1.InterfaceC1297d;
import j1.InterfaceC1562b;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class w implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f12161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V2.a f12162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V2.a f12163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V2.a f12164d;

    public w(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4) {
        this.f12161a = aVar;
        this.f12162b = aVar2;
        this.f12163c = aVar3;
        this.f12164d = aVar4;
    }

    public static w a(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4) {
        return new w(aVar, aVar2, aVar3, aVar4);
    }

    public static v c(Executor executor, InterfaceC1297d interfaceC1297d, x xVar, InterfaceC1562b interfaceC1562b) {
        return new v(executor, interfaceC1297d, xVar, interfaceC1562b);
    }

    @Override // V2.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v get() {
        return c((Executor) this.f12161a.get(), (InterfaceC1297d) this.f12162b.get(), (x) this.f12163c.get(), (InterfaceC1562b) this.f12164d.get());
    }
}
