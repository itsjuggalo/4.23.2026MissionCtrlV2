package p3;

import h3.C1875k;
import java.util.Collections;
import java.util.Iterator;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: p3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2553g extends C2549c implements InterfaceC2560n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2553g f22289e = new C2553g();

    public static C2553g M() {
        return f22289e;
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public InterfaceC2560n A(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        return (interfaceC2560n.isEmpty() || c2548b.t()) ? this : new C2549c().A(c2548b, interfaceC2560n);
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public Object D(boolean z7) {
        return null;
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public Iterator E() {
        return Collections.emptyList().iterator();
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public String G() {
        return "";
    }

    @Override // p3.C2549c
    public boolean equals(Object obj) {
        if (obj instanceof C2553g) {
            return true;
        }
        if (obj instanceof InterfaceC2560n) {
            InterfaceC2560n interfaceC2560n = (InterfaceC2560n) obj;
            if (interfaceC2560n.isEmpty() && o().equals(interfaceC2560n.o())) {
                return true;
            }
        }
        return false;
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public Object getValue() {
        return null;
    }

    @Override // p3.C2549c
    public int hashCode() {
        return 0;
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public boolean isEmpty() {
        return true;
    }

    @Override // p3.C2549c, java.lang.Iterable
    public Iterator iterator() {
        return Collections.emptyList().iterator();
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public int j() {
        return 0;
    }

    @Override // p3.C2549c, java.lang.Comparable
    /* JADX INFO: renamed from: n */
    public int compareTo(InterfaceC2560n interfaceC2560n) {
        return interfaceC2560n.isEmpty() ? 0 : -1;
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public C2548b p(C2548b c2548b) {
        return null;
    }

    @Override // p3.C2549c
    public String toString() {
        return "<Empty Node>";
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public boolean u(C2548b c2548b) {
        return false;
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public String v(InterfaceC2560n.b bVar) {
        return "";
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public boolean x() {
        return false;
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public InterfaceC2560n y(C1875k c1875k, InterfaceC2560n interfaceC2560n) {
        if (c1875k.isEmpty()) {
            return interfaceC2560n;
        }
        C2548b c2548bP = c1875k.P();
        return A(c2548bP, z(c2548bP).y(c1875k.S(), interfaceC2560n));
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public InterfaceC2560n o() {
        return this;
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public C2553g c(InterfaceC2560n interfaceC2560n) {
        return this;
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public InterfaceC2560n s(C1875k c1875k) {
        return this;
    }

    @Override // p3.C2549c, p3.InterfaceC2560n
    public InterfaceC2560n z(C2548b c2548b) {
        return this;
    }
}
