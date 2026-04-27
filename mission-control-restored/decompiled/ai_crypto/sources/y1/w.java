package y1;

import java.util.concurrent.Executor;
import t1.InterfaceC2651b;
import z1.InterfaceC2859d;

/* JADX INFO: loaded from: classes.dex */
public final class w implements InterfaceC2651b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f25525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f25526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final D5.a f25527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D5.a f25528d;

    public w(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4) {
        this.f25525a = aVar;
        this.f25526b = aVar2;
        this.f25527c = aVar3;
        this.f25528d = aVar4;
    }

    public static w a(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4) {
        return new w(aVar, aVar2, aVar3, aVar4);
    }

    public static v c(Executor executor, InterfaceC2859d interfaceC2859d, x xVar, A1.b bVar) {
        return new v(executor, interfaceC2859d, xVar, bVar);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v get() {
        return c((Executor) this.f25525a.get(), (InterfaceC2859d) this.f25526b.get(), (x) this.f25527c.get(), (A1.b) this.f25528d.get());
    }
}
