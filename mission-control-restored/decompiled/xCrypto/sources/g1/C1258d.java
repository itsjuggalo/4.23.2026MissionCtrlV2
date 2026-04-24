package g1;

import b1.InterfaceC0861e;
import h1.x;
import i1.InterfaceC1297d;
import j1.InterfaceC1562b;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: g1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1258d implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f11911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V2.a f11912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V2.a f11913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V2.a f11914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final V2.a f11915e;

    public C1258d(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4, V2.a aVar5) {
        this.f11911a = aVar;
        this.f11912b = aVar2;
        this.f11913c = aVar3;
        this.f11914d = aVar4;
        this.f11915e = aVar5;
    }

    public static C1258d a(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4, V2.a aVar5) {
        return new C1258d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static C1257c c(Executor executor, InterfaceC0861e interfaceC0861e, x xVar, InterfaceC1297d interfaceC1297d, InterfaceC1562b interfaceC1562b) {
        return new C1257c(executor, interfaceC0861e, xVar, interfaceC1297d, interfaceC1562b);
    }

    @Override // V2.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1257c get() {
        return c((Executor) this.f11911a.get(), (InterfaceC0861e) this.f11912b.get(), (x) this.f11913c.get(), (InterfaceC1297d) this.f11914d.get(), (InterfaceC1562b) this.f11915e.get());
    }
}
