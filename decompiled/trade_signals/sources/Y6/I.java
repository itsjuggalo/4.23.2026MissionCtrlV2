package Y6;

import Y6.I;
import d7.AbstractC1651l;
import d7.C1647h;
import d7.C1650k;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import s5.AbstractC2703a;
import s5.AbstractC2704b;
import s5.InterfaceC2707e;
import s5.InterfaceC2708f;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class I extends AbstractC2703a implements InterfaceC2708f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9626b = new a(null);

    public static final class a extends AbstractC2704b {
        public a() {
            super(InterfaceC2708f.f23114O, new B5.k() { // from class: Y6.H
                @Override // B5.k
                public final Object invoke(Object obj) {
                    return I.a.d((InterfaceC2711i.b) obj);
                }
            });
        }

        public static final I d(InterfaceC2711i.b bVar) {
            if (bVar instanceof I) {
                return (I) bVar;
            }
            return null;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public I() {
        super(InterfaceC2708f.f23114O);
    }

    public static /* synthetic */ I y0(I i8, int i9, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return i8.x0(i9, str);
    }

    @Override // s5.InterfaceC2708f
    public final void D(InterfaceC2707e interfaceC2707e) {
        AbstractC2304t.d(interfaceC2707e, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C1647h) interfaceC2707e).t();
    }

    @Override // s5.InterfaceC2708f
    public final InterfaceC2707e R(InterfaceC2707e interfaceC2707e) {
        return new C1647h(this, interfaceC2707e);
    }

    @Override // s5.AbstractC2703a, s5.InterfaceC2711i.b, s5.InterfaceC2711i
    public InterfaceC2711i.b a(InterfaceC2711i.c cVar) {
        return InterfaceC2708f.a.a(this, cVar);
    }

    @Override // s5.AbstractC2703a, s5.InterfaceC2711i
    public InterfaceC2711i r0(InterfaceC2711i.c cVar) {
        return InterfaceC2708f.a.b(this, cVar);
    }

    public String toString() {
        return P.a(this) + '@' + P.b(this);
    }

    public abstract void v0(InterfaceC2711i interfaceC2711i, Runnable runnable);

    public boolean w0(InterfaceC2711i interfaceC2711i) {
        return true;
    }

    public I x0(int i8, String str) {
        AbstractC1651l.a(i8);
        return new C1650k(this, i8, str);
    }
}
