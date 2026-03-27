package c7;

import a7.x;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements b7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f13610a;

    public s(x xVar) {
        this.f13610a = xVar;
    }

    @Override // b7.e
    public Object emit(Object obj, InterfaceC2707e interfaceC2707e) {
        Object objN = this.f13610a.n(obj, interfaceC2707e);
        return objN == AbstractC2751c.f() ? objN : C2470H.f21956a;
    }
}
