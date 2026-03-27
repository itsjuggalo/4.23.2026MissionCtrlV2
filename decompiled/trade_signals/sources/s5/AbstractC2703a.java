package s5;

import B5.o;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: s5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2703a implements InterfaceC2711i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2711i.c f23109a;

    public AbstractC2703a(InterfaceC2711i.c key) {
        AbstractC2304t.f(key, "key");
        this.f23109a = key;
    }

    @Override // s5.InterfaceC2711i
    public Object K(Object obj, o oVar) {
        return InterfaceC2711i.b.a.a(this, obj, oVar);
    }

    @Override // s5.InterfaceC2711i.b, s5.InterfaceC2711i
    public InterfaceC2711i.b a(InterfaceC2711i.c cVar) {
        return InterfaceC2711i.b.a.b(this, cVar);
    }

    @Override // s5.InterfaceC2711i.b
    public InterfaceC2711i.c getKey() {
        return this.f23109a;
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i m0(InterfaceC2711i interfaceC2711i) {
        return InterfaceC2711i.b.a.d(this, interfaceC2711i);
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i r0(InterfaceC2711i.c cVar) {
        return InterfaceC2711i.b.a.c(this, cVar);
    }
}
