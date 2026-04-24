package c7;

import kotlin.jvm.internal.AbstractC2296k;
import o5.C2470H;
import s5.C2712j;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import t5.AbstractC2751c;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends g {
    public h(b7.d dVar, InterfaceC2711i interfaceC2711i, int i8, a7.a aVar) {
        super(dVar, interfaceC2711i, i8, aVar);
    }

    @Override // c7.e
    public e f(InterfaceC2711i interfaceC2711i, int i8, a7.a aVar) {
        return new h(this.f13591d, interfaceC2711i, i8, aVar);
    }

    @Override // c7.g
    public Object m(b7.e eVar, InterfaceC2707e interfaceC2707e) {
        Object objCollect = this.f13591d.collect(eVar, interfaceC2707e);
        return objCollect == AbstractC2751c.f() ? objCollect : C2470H.f21956a;
    }

    public /* synthetic */ h(b7.d dVar, InterfaceC2711i interfaceC2711i, int i8, a7.a aVar, int i9, AbstractC2296k abstractC2296k) {
        this(dVar, (i9 & 2) != 0 ? C2712j.f23116a : interfaceC2711i, (i9 & 4) != 0 ? -3 : i8, (i9 & 8) != 0 ? a7.a.f10173a : aVar);
    }
}
