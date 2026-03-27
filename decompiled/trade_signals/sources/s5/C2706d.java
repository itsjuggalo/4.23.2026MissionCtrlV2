package s5;

import B5.o;
import java.io.Serializable;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: s5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2706d implements InterfaceC2711i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2711i f23112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2711i.b f23113b;

    public C2706d(InterfaceC2711i left, InterfaceC2711i.b element) {
        AbstractC2304t.f(left, "left");
        AbstractC2304t.f(element, "element");
        this.f23112a = left;
        this.f23113b = element;
    }

    public static final String i(String acc, InterfaceC2711i.b element) {
        AbstractC2304t.f(acc, "acc");
        AbstractC2304t.f(element, "element");
        if (acc.length() == 0) {
            return element.toString();
        }
        return acc + ", " + element;
    }

    @Override // s5.InterfaceC2711i
    public Object K(Object obj, o operation) {
        AbstractC2304t.f(operation, "operation");
        return operation.invoke(this.f23112a.K(obj, operation), this.f23113b);
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i.b a(InterfaceC2711i.c key) {
        AbstractC2304t.f(key, "key");
        C2706d c2706d = this;
        while (true) {
            InterfaceC2711i.b bVarA = c2706d.f23113b.a(key);
            if (bVarA != null) {
                return bVarA;
            }
            InterfaceC2711i interfaceC2711i = c2706d.f23112a;
            if (!(interfaceC2711i instanceof C2706d)) {
                return interfaceC2711i.a(key);
            }
            c2706d = (C2706d) interfaceC2711i;
        }
    }

    public final boolean d(InterfaceC2711i.b bVar) {
        return AbstractC2304t.b(a(bVar.getKey()), bVar);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C2706d) {
                C2706d c2706d = (C2706d) obj;
                if (c2706d.h() != h() || !c2706d.g(this)) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean g(C2706d c2706d) {
        while (d(c2706d.f23113b)) {
            InterfaceC2711i interfaceC2711i = c2706d.f23112a;
            if (!(interfaceC2711i instanceof C2706d)) {
                AbstractC2304t.d(interfaceC2711i, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return d((InterfaceC2711i.b) interfaceC2711i);
            }
            c2706d = (C2706d) interfaceC2711i;
        }
        return false;
    }

    public final int h() {
        int i8 = 2;
        C2706d c2706d = this;
        while (true) {
            InterfaceC2711i interfaceC2711i = c2706d.f23112a;
            c2706d = interfaceC2711i instanceof C2706d ? (C2706d) interfaceC2711i : null;
            if (c2706d == null) {
                return i8;
            }
            i8++;
        }
    }

    public int hashCode() {
        return this.f23112a.hashCode() + this.f23113b.hashCode();
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i m0(InterfaceC2711i interfaceC2711i) {
        return InterfaceC2711i.a.b(this, interfaceC2711i);
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i r0(InterfaceC2711i.c key) {
        AbstractC2304t.f(key, "key");
        if (this.f23113b.a(key) != null) {
            return this.f23112a;
        }
        InterfaceC2711i interfaceC2711iR0 = this.f23112a.r0(key);
        return interfaceC2711iR0 == this.f23112a ? this : interfaceC2711iR0 == C2712j.f23116a ? this.f23113b : new C2706d(interfaceC2711iR0, this.f23113b);
    }

    public String toString() {
        return '[' + ((String) K("", new o() { // from class: s5.c
            @Override // B5.o
            public final Object invoke(Object obj, Object obj2) {
                return C2706d.i((String) obj, (InterfaceC2711i.b) obj2);
            }
        })) + ']';
    }
}
