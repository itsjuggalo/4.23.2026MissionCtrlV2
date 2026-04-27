package b7;

import kotlin.jvm.internal.AbstractC2296k;
import o5.C2470H;
import s5.C2712j;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import t5.AbstractC2751c;

/* JADX INFO: loaded from: classes2.dex */
public class c extends c7.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final B5.o f13229d;

    public c(B5.o oVar, InterfaceC2711i interfaceC2711i, int i8, a7.a aVar) {
        super(interfaceC2711i, i8, aVar);
        this.f13229d = oVar;
    }

    public static /* synthetic */ Object j(c cVar, a7.v vVar, InterfaceC2707e interfaceC2707e) {
        Object objInvoke = cVar.f13229d.invoke(vVar, interfaceC2707e);
        return objInvoke == AbstractC2751c.f() ? objInvoke : C2470H.f21956a;
    }

    @Override // c7.e
    public Object e(a7.v vVar, InterfaceC2707e interfaceC2707e) {
        return j(this, vVar, interfaceC2707e);
    }

    @Override // c7.e
    public c7.e f(InterfaceC2711i interfaceC2711i, int i8, a7.a aVar) {
        return new c(this.f13229d, interfaceC2711i, i8, aVar);
    }

    @Override // c7.e
    public String toString() {
        return "block[" + this.f13229d + "] -> " + super.toString();
    }

    public /* synthetic */ c(B5.o oVar, InterfaceC2711i interfaceC2711i, int i8, a7.a aVar, int i9, AbstractC2296k abstractC2296k) {
        this(oVar, (i9 & 2) != 0 ? C2712j.f23116a : interfaceC2711i, (i9 & 4) != 0 ? -2 : i8, (i9 & 8) != 0 ? a7.a.f10173a : aVar);
    }
}
