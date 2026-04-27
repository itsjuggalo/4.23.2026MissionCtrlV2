package d7;

import s5.InterfaceC2711i;

/* JADX INFO: renamed from: d7.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1643d implements Y6.L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2711i f17043a;

    public C1643d(InterfaceC2711i interfaceC2711i) {
        this.f17043a = interfaceC2711i;
    }

    @Override // Y6.L
    public InterfaceC2711i j() {
        return this.f17043a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + j() + ')';
    }
}
