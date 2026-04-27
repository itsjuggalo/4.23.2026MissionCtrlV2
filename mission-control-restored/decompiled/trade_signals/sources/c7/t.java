package c7;

import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import u5.InterfaceC2778e;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements InterfaceC2707e, InterfaceC2778e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2707e f13611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2711i f13612b;

    public t(InterfaceC2707e interfaceC2707e, InterfaceC2711i interfaceC2711i) {
        this.f13611a = interfaceC2707e;
        this.f13612b = interfaceC2711i;
    }

    @Override // u5.InterfaceC2778e
    public InterfaceC2778e getCallerFrame() {
        InterfaceC2707e interfaceC2707e = this.f13611a;
        if (interfaceC2707e instanceof InterfaceC2778e) {
            return (InterfaceC2778e) interfaceC2707e;
        }
        return null;
    }

    @Override // s5.InterfaceC2707e
    public InterfaceC2711i getContext() {
        return this.f13612b;
    }

    @Override // s5.InterfaceC2707e
    public void resumeWith(Object obj) {
        this.f13611a.resumeWith(obj);
    }
}
