package y1;

import android.content.Context;
import java.util.concurrent.Executor;
import t1.InterfaceC2651b;
import z1.InterfaceC2858c;
import z1.InterfaceC2859d;

/* JADX INFO: loaded from: classes.dex */
public final class s implements InterfaceC2651b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f25510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f25511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final D5.a f25512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D5.a f25513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final D5.a f25514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final D5.a f25515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final D5.a f25516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final D5.a f25517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final D5.a f25518i;

    public s(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4, D5.a aVar5, D5.a aVar6, D5.a aVar7, D5.a aVar8, D5.a aVar9) {
        this.f25510a = aVar;
        this.f25511b = aVar2;
        this.f25512c = aVar3;
        this.f25513d = aVar4;
        this.f25514e = aVar5;
        this.f25515f = aVar6;
        this.f25516g = aVar7;
        this.f25517h = aVar8;
        this.f25518i = aVar9;
    }

    public static s a(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4, D5.a aVar5, D5.a aVar6, D5.a aVar7, D5.a aVar8, D5.a aVar9) {
        return new s(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static r c(Context context, s1.e eVar, InterfaceC2859d interfaceC2859d, x xVar, Executor executor, A1.b bVar, B1.a aVar, B1.a aVar2, InterfaceC2858c interfaceC2858c) {
        return new r(context, eVar, interfaceC2859d, xVar, executor, bVar, aVar, aVar2, interfaceC2858c);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r get() {
        return c((Context) this.f25510a.get(), (s1.e) this.f25511b.get(), (InterfaceC2859d) this.f25512c.get(), (x) this.f25513d.get(), (Executor) this.f25514e.get(), (A1.b) this.f25515f.get(), (B1.a) this.f25516g.get(), (B1.a) this.f25517h.get(), (InterfaceC2858c) this.f25518i.get());
    }
}
