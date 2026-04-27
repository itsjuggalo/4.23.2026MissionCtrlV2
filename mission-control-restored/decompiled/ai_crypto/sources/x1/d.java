package x1;

import java.util.concurrent.Executor;
import t1.InterfaceC2651b;
import y1.x;
import z1.InterfaceC2859d;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InterfaceC2651b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f25283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f25284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final D5.a f25285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D5.a f25286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final D5.a f25287e;

    public d(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4, D5.a aVar5) {
        this.f25283a = aVar;
        this.f25284b = aVar2;
        this.f25285c = aVar3;
        this.f25286d = aVar4;
        this.f25287e = aVar5;
    }

    public static d a(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4, D5.a aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static C2818c c(Executor executor, s1.e eVar, x xVar, InterfaceC2859d interfaceC2859d, A1.b bVar) {
        return new C2818c(executor, eVar, xVar, interfaceC2859d, bVar);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2818c get() {
        return c((Executor) this.f25283a.get(), (s1.e) this.f25284b.get(), (x) this.f25285c.get(), (InterfaceC2859d) this.f25286d.get(), (A1.b) this.f25287e.get());
    }
}
