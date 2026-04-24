package h1;

import android.content.Context;
import b1.InterfaceC0861e;
import i1.InterfaceC1296c;
import i1.InterfaceC1297d;
import j1.InterfaceC1562b;
import java.util.concurrent.Executor;
import k1.InterfaceC1567a;

/* JADX INFO: loaded from: classes.dex */
public final class s implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f12146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V2.a f12147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V2.a f12148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V2.a f12149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final V2.a f12150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final V2.a f12151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final V2.a f12152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final V2.a f12153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final V2.a f12154i;

    public s(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4, V2.a aVar5, V2.a aVar6, V2.a aVar7, V2.a aVar8, V2.a aVar9) {
        this.f12146a = aVar;
        this.f12147b = aVar2;
        this.f12148c = aVar3;
        this.f12149d = aVar4;
        this.f12150e = aVar5;
        this.f12151f = aVar6;
        this.f12152g = aVar7;
        this.f12153h = aVar8;
        this.f12154i = aVar9;
    }

    public static s a(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4, V2.a aVar5, V2.a aVar6, V2.a aVar7, V2.a aVar8, V2.a aVar9) {
        return new s(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static r c(Context context, InterfaceC0861e interfaceC0861e, InterfaceC1297d interfaceC1297d, x xVar, Executor executor, InterfaceC1562b interfaceC1562b, InterfaceC1567a interfaceC1567a, InterfaceC1567a interfaceC1567a2, InterfaceC1296c interfaceC1296c) {
        return new r(context, interfaceC0861e, interfaceC1297d, xVar, executor, interfaceC1562b, interfaceC1567a, interfaceC1567a2, interfaceC1296c);
    }

    @Override // V2.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r get() {
        return c((Context) this.f12146a.get(), (InterfaceC0861e) this.f12147b.get(), (InterfaceC1297d) this.f12148c.get(), (x) this.f12149d.get(), (Executor) this.f12150e.get(), (InterfaceC1562b) this.f12151f.get(), (InterfaceC1567a) this.f12152g.get(), (InterfaceC1567a) this.f12153h.get(), (InterfaceC1296c) this.f12154i.get());
    }
}
