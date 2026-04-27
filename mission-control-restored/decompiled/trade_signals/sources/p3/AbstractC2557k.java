package p3;

import com.revenuecat.purchases.common.Constants;
import h3.C1875k;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import k3.AbstractC2279m;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: p3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2557k implements InterfaceC2560n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2560n f22295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22296b;

    /* JADX INFO: renamed from: p3.k$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22297a;

        static {
            int[] iArr = new int[InterfaceC2560n.b.values().length];
            f22297a = iArr;
            try {
                iArr[InterfaceC2560n.b.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22297a[InterfaceC2560n.b.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: p3.k$b */
    public enum b {
        DeferredValue,
        Boolean,
        Number,
        String
    }

    public AbstractC2557k(InterfaceC2560n interfaceC2560n) {
        this.f22295a = interfaceC2560n;
    }

    public static int n(C2558l c2558l, C2552f c2552f) {
        return Double.valueOf(((Long) c2558l.getValue()).longValue()).compareTo((Double) c2552f.getValue());
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n A(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        return c2548b.t() ? c(interfaceC2560n) : interfaceC2560n.isEmpty() ? this : C2553g.M().A(c2548b, interfaceC2560n).c(this.f22295a);
    }

    @Override // p3.InterfaceC2560n
    public Object D(boolean z7) {
        if (!z7 || this.f22295a.isEmpty()) {
            return getValue();
        }
        HashMap map = new HashMap();
        map.put(".value", getValue());
        map.put(".priority", this.f22295a.getValue());
        return map;
    }

    @Override // p3.InterfaceC2560n
    public Iterator E() {
        return Collections.emptyList().iterator();
    }

    @Override // p3.InterfaceC2560n
    public String G() {
        if (this.f22296b == null) {
            this.f22296b = AbstractC2279m.i(v(InterfaceC2560n.b.V1));
        }
        return this.f22296b;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public int compareTo(InterfaceC2560n interfaceC2560n) {
        if (interfaceC2560n.isEmpty()) {
            return 1;
        }
        if (interfaceC2560n instanceof C2549c) {
            return -1;
        }
        AbstractC2279m.g(interfaceC2560n.x(), "Node is not leaf node!");
        return ((this instanceof C2558l) && (interfaceC2560n instanceof C2552f)) ? n((C2558l) this, (C2552f) interfaceC2560n) : ((this instanceof C2552f) && (interfaceC2560n instanceof C2558l)) ? n((C2558l) interfaceC2560n, (C2552f) this) * (-1) : K((AbstractC2557k) interfaceC2560n);
    }

    public abstract b I();

    public String J(InterfaceC2560n.b bVar) {
        int i8 = a.f22297a[bVar.ordinal()];
        if (i8 != 1 && i8 != 2) {
            throw new IllegalArgumentException("Unknown hash version: " + bVar);
        }
        if (this.f22295a.isEmpty()) {
            return "";
        }
        return "priority:" + this.f22295a.v(bVar) + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
    }

    public int K(AbstractC2557k abstractC2557k) {
        b bVarI = I();
        b bVarI2 = abstractC2557k.I();
        return bVarI.equals(bVarI2) ? a(abstractC2557k) : bVarI.compareTo(bVarI2);
    }

    public abstract int a(AbstractC2557k abstractC2557k);

    @Override // p3.InterfaceC2560n
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return Collections.emptyList().iterator();
    }

    @Override // p3.InterfaceC2560n
    public int j() {
        return 0;
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n o() {
        return this.f22295a;
    }

    @Override // p3.InterfaceC2560n
    public C2548b p(C2548b c2548b) {
        return null;
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n s(C1875k c1875k) {
        return c1875k.isEmpty() ? this : c1875k.P().t() ? this.f22295a : C2553g.M();
    }

    public String toString() {
        String string = D(true).toString();
        if (string.length() <= 100) {
            return string;
        }
        return string.substring(0, 100) + "...";
    }

    @Override // p3.InterfaceC2560n
    public boolean u(C2548b c2548b) {
        return false;
    }

    @Override // p3.InterfaceC2560n
    public boolean x() {
        return true;
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n y(C1875k c1875k, InterfaceC2560n interfaceC2560n) {
        C2548b c2548bP = c1875k.P();
        if (c2548bP == null) {
            return interfaceC2560n;
        }
        if (interfaceC2560n.isEmpty() && !c2548bP.t()) {
            return this;
        }
        boolean z7 = true;
        if (c1875k.P().t() && c1875k.size() != 1) {
            z7 = false;
        }
        AbstractC2279m.f(z7);
        return A(c2548bP, C2553g.M().y(c1875k.S(), interfaceC2560n));
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n z(C2548b c2548b) {
        return c2548b.t() ? this.f22295a : C2553g.M();
    }
}
