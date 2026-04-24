package p3;

import h3.C1875k;
import java.util.Iterator;

/* JADX INFO: renamed from: p3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC2560n extends Comparable, Iterable {

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final C2549c f22308N = new a();

    /* JADX INFO: renamed from: p3.n$b */
    public enum b {
        V1,
        V2
    }

    InterfaceC2560n A(C2548b c2548b, InterfaceC2560n interfaceC2560n);

    Object D(boolean z7);

    Iterator E();

    String G();

    InterfaceC2560n c(InterfaceC2560n interfaceC2560n);

    Object getValue();

    boolean isEmpty();

    int j();

    InterfaceC2560n o();

    C2548b p(C2548b c2548b);

    InterfaceC2560n s(C1875k c1875k);

    boolean u(C2548b c2548b);

    String v(b bVar);

    boolean x();

    InterfaceC2560n y(C1875k c1875k, InterfaceC2560n interfaceC2560n);

    InterfaceC2560n z(C2548b c2548b);

    /* JADX INFO: renamed from: p3.n$a */
    public class a extends C2549c {
        @Override // p3.C2549c
        public boolean equals(Object obj) {
            return obj == this;
        }

        @Override // p3.C2549c, p3.InterfaceC2560n
        public boolean isEmpty() {
            return false;
        }

        @Override // p3.C2549c, java.lang.Comparable
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compareTo(InterfaceC2560n interfaceC2560n) {
            return interfaceC2560n == this ? 0 : 1;
        }

        @Override // p3.C2549c
        public String toString() {
            return "<Max Node>";
        }

        @Override // p3.C2549c, p3.InterfaceC2560n
        public boolean u(C2548b c2548b) {
            return false;
        }

        @Override // p3.C2549c, p3.InterfaceC2560n
        public InterfaceC2560n z(C2548b c2548b) {
            return c2548b.t() ? o() : C2553g.M();
        }

        @Override // p3.C2549c, p3.InterfaceC2560n
        public InterfaceC2560n o() {
            return this;
        }
    }
}
