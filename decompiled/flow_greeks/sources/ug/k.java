package ug;

import ng.k0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends k0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f23034c = new k();

    @Override // ng.k0
    public void Z(gd.i iVar, Runnable runnable) {
        c.f23018i.g0(runnable, true, false);
    }

    @Override // ng.k0
    public k0 c0(int i10, String str) {
        sg.l.a(i10);
        return i10 >= j.f23031d ? sg.l.b(this, str) : super.c0(i10, str);
    }

    @Override // ng.k0
    public String toString() {
        return "Dispatchers.IO";
    }
}
