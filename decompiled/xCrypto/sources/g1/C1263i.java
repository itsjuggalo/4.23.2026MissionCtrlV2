package g1;

import android.content.Context;
import h1.x;
import i1.InterfaceC1297d;
import k1.InterfaceC1567a;

/* JADX INFO: renamed from: g1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1263i implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f11917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V2.a f11918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V2.a f11919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V2.a f11920d;

    public C1263i(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4) {
        this.f11917a = aVar;
        this.f11918b = aVar2;
        this.f11919c = aVar3;
        this.f11920d = aVar4;
    }

    public static C1263i a(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4) {
        return new C1263i(aVar, aVar2, aVar3, aVar4);
    }

    public static x c(Context context, InterfaceC1297d interfaceC1297d, h1.f fVar, InterfaceC1567a interfaceC1567a) {
        return (x) c1.d.d(AbstractC1262h.a(context, interfaceC1297d, fVar, interfaceC1567a));
    }

    @Override // V2.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x get() {
        return c((Context) this.f11917a.get(), (InterfaceC1297d) this.f11918b.get(), (h1.f) this.f11919c.get(), (InterfaceC1567a) this.f11920d.get());
    }
}
