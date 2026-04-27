package L5;

import G6.InterfaceC0581s;
import G6.InterfaceC0582t;
import L5.a1;
import R5.InterfaceC0845b;
import R5.InterfaceC0848e;
import R5.InterfaceC0856m;
import j6.C2254r;
import j6.InterfaceC2260x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import o5.C2487o;

/* JADX INFO: loaded from: classes2.dex */
public final class W0 implements I5.r, Y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f5109d = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(W0.class, "upperBounds", "getUpperBounds()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R5.m0 f5110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1.a f5111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X0 f5112c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5113a;

        static {
            int[] iArr = new int[I6.N0.values().length];
            try {
                iArr[I6.N0.f4370e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[I6.N0.f4371f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[I6.N0.f4372g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5113a = iArr;
        }
    }

    public W0(X0 x02, R5.m0 descriptor) {
        X xD;
        Object objN;
        AbstractC2304t.f(descriptor, "descriptor");
        this.f5110a = descriptor;
        this.f5111b = a1.c(new V0(this));
        if (x02 == null) {
            InterfaceC0856m interfaceC0856mB = getDescriptor().b();
            AbstractC2304t.e(interfaceC0856mB, "getContainingDeclaration(...)");
            if (interfaceC0856mB instanceof InterfaceC0848e) {
                objN = d((InterfaceC0848e) interfaceC0856mB);
            } else {
                if (!(interfaceC0856mB instanceof InterfaceC0845b)) {
                    throw new Y0("Unknown type parameter container: " + interfaceC0856mB);
                }
                InterfaceC0856m interfaceC0856mB2 = ((InterfaceC0845b) interfaceC0856mB).b();
                AbstractC2304t.e(interfaceC0856mB2, "getContainingDeclaration(...)");
                if (interfaceC0856mB2 instanceof InterfaceC0848e) {
                    xD = d((InterfaceC0848e) interfaceC0856mB2);
                } else {
                    InterfaceC0582t interfaceC0582t = interfaceC0856mB instanceof InterfaceC0582t ? (InterfaceC0582t) interfaceC0856mB : null;
                    if (interfaceC0582t == null) {
                        throw new Y0("Non-class callable descriptor must be deserialized: " + interfaceC0856mB);
                    }
                    I5.d dVarE = A5.a.e(b(interfaceC0582t));
                    AbstractC2304t.d(dVarE, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    xD = (X) dVarE;
                }
                objN = interfaceC0856mB.N(new C0665j(xD), C2470H.f21956a);
            }
            x02 = (X0) objN;
        }
        this.f5112c = x02;
    }

    public static final List e(W0 w02) {
        List upperBounds = w02.getDescriptor().getUpperBounds();
        AbstractC2304t.e(upperBounds, "getUpperBounds(...)");
        ArrayList arrayList = new ArrayList(p5.r.s(upperBounds, 10));
        Iterator it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(new U0((I6.S) it.next(), null, 2, null));
        }
        return arrayList;
    }

    public final Class b(InterfaceC0582t interfaceC0582t) {
        Class clsF;
        InterfaceC0581s interfaceC0581sD0 = interfaceC0582t.d0();
        C2254r c2254r = interfaceC0581sD0 instanceof C2254r ? (C2254r) interfaceC0581sD0 : null;
        InterfaceC2260x interfaceC2260xG = c2254r != null ? c2254r.g() : null;
        W5.f fVar = interfaceC2260xG instanceof W5.f ? (W5.f) interfaceC2260xG : null;
        if (fVar != null && (clsF = fVar.f()) != null) {
            return clsF;
        }
        throw new Y0("Container of deserialized member is not resolved: " + interfaceC0582t);
    }

    @Override // L5.Y
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public R5.m0 getDescriptor() {
        return this.f5110a;
    }

    public final X d(InterfaceC0848e interfaceC0848e) {
        Class clsQ = j1.q(interfaceC0848e);
        X x8 = (X) (clsQ != null ? A5.a.e(clsQ) : null);
        if (x8 != null) {
            return x8;
        }
        throw new Y0("Type parameter container is not resolved: " + interfaceC0848e.b());
    }

    public boolean equals(Object obj) {
        if (obj instanceof W0) {
            W0 w02 = (W0) obj;
            if (AbstractC2304t.b(this.f5112c, w02.f5112c) && AbstractC2304t.b(getName(), w02.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // I5.r
    public String getName() {
        String strB = getDescriptor().getName().b();
        AbstractC2304t.e(strB, "asString(...)");
        return strB;
    }

    @Override // I5.r
    public List getUpperBounds() {
        Object objB = this.f5111b.b(this, f5109d[0]);
        AbstractC2304t.e(objB, "getValue(...)");
        return (List) objB;
    }

    public int hashCode() {
        return (this.f5112c.hashCode() * 31) + getName().hashCode();
    }

    @Override // I5.r
    public I5.t p() {
        int i8 = a.f5113a[getDescriptor().p().ordinal()];
        if (i8 == 1) {
            return I5.t.f4301a;
        }
        if (i8 == 2) {
            return I5.t.f4302b;
        }
        if (i8 == 3) {
            return I5.t.f4303c;
        }
        throw new C2487o();
    }

    public String toString() {
        return kotlin.jvm.internal.W.f20475a.a(this);
    }
}
