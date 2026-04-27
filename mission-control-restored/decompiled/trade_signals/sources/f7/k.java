package f7;

import Y6.I;
import d7.AbstractC1651l;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends I {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f17644c = new k();

    @Override // Y6.I
    public String toString() {
        return "Dispatchers.IO";
    }

    @Override // Y6.I
    public void v0(InterfaceC2711i interfaceC2711i, Runnable runnable) {
        c.f17628i.A0(runnable, true, false);
    }

    @Override // Y6.I
    public I x0(int i8, String str) {
        AbstractC1651l.a(i8);
        return i8 >= j.f17641d ? AbstractC1651l.b(this, str) : super.x0(i8, str);
    }
}
