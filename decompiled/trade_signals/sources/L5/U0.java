package L5;

import L5.a1;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import X5.AbstractC0990f;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.InterfaceC2305u;
import o5.AbstractC2484l;
import o5.C2487o;
import o5.C2488p;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import p5.AbstractC2592n;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class U0 implements InterfaceC2305u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f5099e = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(U0.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(U0.class, "arguments", "getArguments()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I6.S f5100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1.a f5101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a1.a f5102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a1.a f5103d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5104a;

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
            f5104a = iArr;
        }
    }

    public U0(I6.S type, Function0 function0) {
        AbstractC2304t.f(type, "type");
        this.f5100a = type;
        a1.a aVarC = null;
        a1.a aVar = function0 instanceof a1.a ? (a1.a) function0 : null;
        if (aVar != null) {
            aVarC = aVar;
        } else if (function0 != null) {
            aVarC = a1.c(function0);
        }
        this.f5101b = aVarC;
        this.f5102c = a1.c(new Q0(this));
        this.f5103d = a1.c(new R0(this, function0));
    }

    public static final List p(U0 u02, Function0 function0) {
        I5.s sVarD;
        List listM0 = u02.f5100a.M0();
        if (listM0.isEmpty()) {
            return AbstractC2595q.i();
        }
        InterfaceC2483k interfaceC2483kB = AbstractC2484l.b(EnumC2486n.f21975b, new S0(u02));
        ArrayList arrayList = new ArrayList(p5.r.s(listM0, 10));
        int i8 = 0;
        for (Object obj : listM0) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                AbstractC2595q.r();
            }
            I6.B0 b02 = (I6.B0) obj;
            if (b02.c()) {
                sVarD = I5.s.f4296c.c();
            } else {
                I6.S type = b02.getType();
                AbstractC2304t.e(type, "getType(...)");
                U0 u03 = new U0(type, function0 == null ? null : new T0(u02, i8, interfaceC2483kB));
                int i10 = a.f5104a[b02.b().ordinal()];
                if (i10 == 1) {
                    sVarD = I5.s.f4296c.d(u03);
                } else if (i10 == 2) {
                    sVarD = I5.s.f4296c.a(u03);
                } else {
                    if (i10 != 3) {
                        throw new C2487o();
                    }
                    sVarD = I5.s.f4296c.b(u03);
                }
            }
            arrayList.add(sVarD);
            i8 = i9;
        }
        return arrayList;
    }

    public static final List t(U0 u02) {
        Type typeB = u02.b();
        AbstractC2304t.c(typeB);
        return AbstractC0990f.h(typeB);
    }

    public static final List u(InterfaceC2483k interfaceC2483k) {
        return (List) interfaceC2483k.getValue();
    }

    public static final Type v(U0 u02, int i8, InterfaceC2483k interfaceC2483k) {
        Class genericComponentType;
        Type typeB = u02.b();
        if (typeB instanceof Class) {
            Class cls = (Class) typeB;
            genericComponentType = cls.isArray() ? cls.getComponentType() : Object.class;
        } else {
            if (!(typeB instanceof GenericArrayType)) {
                if (!(typeB instanceof ParameterizedType)) {
                    throw new Y0("Non-generic type has been queried for arguments: " + u02);
                }
                genericComponentType = (Type) u(interfaceC2483k).get(i8);
                if (genericComponentType instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) genericComponentType;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    AbstractC2304t.e(lowerBounds, "getLowerBounds(...)");
                    Type type = (Type) AbstractC2592n.D(lowerBounds);
                    if (type == null) {
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        AbstractC2304t.e(upperBounds, "getUpperBounds(...)");
                        genericComponentType = (Type) AbstractC2592n.C(upperBounds);
                    } else {
                        genericComponentType = type;
                    }
                }
                return genericComponentType;
            }
            if (i8 != 0) {
                throw new Y0("Array type has been queried for a non-0th argument: " + u02);
            }
            genericComponentType = ((GenericArrayType) typeB).getGenericComponentType();
        }
        AbstractC2304t.c(genericComponentType);
        return genericComponentType;
    }

    public static final I5.f w(U0 u02) {
        return u02.x(u02.f5100a);
    }

    @Override // I5.q
    public List a() {
        Object objB = this.f5103d.b(this, f5099e[1]);
        AbstractC2304t.e(objB, "getValue(...)");
        return (List) objB;
    }

    @Override // kotlin.jvm.internal.InterfaceC2305u
    public Type b() {
        a1.a aVar = this.f5101b;
        if (aVar != null) {
            return (Type) aVar.invoke();
        }
        return null;
    }

    @Override // I5.q
    public I5.f c() {
        return (I5.f) this.f5102c.b(this, f5099e[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof U0) {
            U0 u02 = (U0) obj;
            if (AbstractC2304t.b(this.f5100a, u02.f5100a) && AbstractC2304t.b(c(), u02.c()) && AbstractC2304t.b(a(), u02.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f5100a.hashCode() * 31;
        I5.f fVarC = c();
        return ((iHashCode + (fVarC != null ? fVarC.hashCode() : 0)) * 31) + a().hashCode();
    }

    public String toString() {
        return e1.f5164a.l(this.f5100a);
    }

    public final I5.f x(I6.S s8) {
        I6.S type;
        InterfaceC0851h interfaceC0851hS = s8.O0().s();
        if (!(interfaceC0851hS instanceof InterfaceC0848e)) {
            if (interfaceC0851hS instanceof R5.m0) {
                return new W0(null, (R5.m0) interfaceC0851hS);
            }
            if (!(interfaceC0851hS instanceof R5.l0)) {
                return null;
            }
            throw new C2488p("An operation is not implemented: Type alias classifiers are not yet supported");
        }
        Class clsQ = j1.q((InterfaceC0848e) interfaceC0851hS);
        if (clsQ == null) {
            return null;
        }
        if (!clsQ.isArray()) {
            if (I6.J0.l(s8)) {
                return new X(clsQ);
            }
            Class clsI = AbstractC0990f.i(clsQ);
            if (clsI != null) {
                clsQ = clsI;
            }
            return new X(clsQ);
        }
        I6.B0 b02 = (I6.B0) p5.z.w0(s8.M0());
        if (b02 == null || (type = b02.getType()) == null) {
            return new X(clsQ);
        }
        I5.f fVarX = x(type);
        if (fVarX != null) {
            return new X(j1.f(A5.a.b(K5.b.a(fVarX))));
        }
        throw new Y0("Cannot determine classifier for array element type: " + this);
    }

    public final I6.S y() {
        return this.f5100a;
    }

    public /* synthetic */ U0(I6.S s8, Function0 function0, int i8, AbstractC2296k abstractC2296k) {
        this(s8, (i8 & 2) != 0 ? null : function0);
    }
}
