package p3;

import h3.C1875k;
import java.util.Comparator;

/* JADX INFO: renamed from: p3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2554h implements Comparator {
    public static AbstractC2554h b(String str) {
        if (str.equals(".value")) {
            return C2567u.j();
        }
        if (str.equals(".key")) {
            return C2556j.j();
        }
        if (str.equals(".priority")) {
            throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
        }
        return new C2562p(new C1875k(str));
    }

    public int a(C2559m c2559m, C2559m c2559m2, boolean z7) {
        return z7 ? compare(c2559m2, c2559m) : compare(c2559m, c2559m2);
    }

    public abstract String c();

    public boolean d(InterfaceC2560n interfaceC2560n, InterfaceC2560n interfaceC2560n2) {
        return compare(new C2559m(C2548b.m(), interfaceC2560n), new C2559m(C2548b.m(), interfaceC2560n2)) != 0;
    }

    public abstract boolean e(InterfaceC2560n interfaceC2560n);

    public abstract C2559m f(C2548b c2548b, InterfaceC2560n interfaceC2560n);

    public abstract C2559m g();

    public C2559m h() {
        return C2559m.b();
    }
}
