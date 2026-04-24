package L5;

import I5.l;
import L5.a1;
import R5.AbstractC0863u;
import R5.InterfaceC0845b;
import c6.InterfaceC1257a;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import p5.AbstractC2592n;
import p5.AbstractC2595q;
import r5.AbstractC2678a;
import s5.InterfaceC2707e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A implements I5.c, X0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1.a f5028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1.a f5029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a1.a f5030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a1.a f5031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a1.a f5032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC2483k f5033f;

    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC2678a.a(((I5.l) obj).getName(), ((I5.l) obj2).getName());
        }
    }

    public A() {
        a1.a aVarC = a1.c(new C0679q(this));
        AbstractC2304t.e(aVarC, "lazySoft(...)");
        this.f5028a = aVarC;
        a1.a aVarC2 = a1.c(new r(this));
        AbstractC2304t.e(aVarC2, "lazySoft(...)");
        this.f5029b = aVarC2;
        a1.a aVarC3 = a1.c(new C0682s(this));
        AbstractC2304t.e(aVarC3, "lazySoft(...)");
        this.f5030c = aVarC3;
        a1.a aVarC4 = a1.c(new C0684t(this));
        AbstractC2304t.e(aVarC4, "lazySoft(...)");
        this.f5031d = aVarC4;
        a1.a aVarC5 = a1.c(new C0686u(this));
        AbstractC2304t.e(aVarC5, "lazySoft(...)");
        this.f5032e = aVarC5;
        this.f5033f = AbstractC2484l.b(EnumC2486n.f21975b, new C0688v(this));
    }

    public static final boolean W(A a8) {
        List parameters = a8.getParameters();
        if ((parameters instanceof Collection) && parameters.isEmpty()) {
            return false;
        }
        Iterator it = parameters.iterator();
        while (it.hasNext()) {
            if (j1.k(((I5.l) it.next()).getType())) {
                return true;
            }
        }
        return false;
    }

    public static final Object[] n(A a8) {
        int iT;
        List<I5.l> parameters = a8.getParameters();
        int size = parameters.size() + (a8.isSuspend() ? 1 : 0);
        if (((Boolean) a8.f5033f.getValue()).booleanValue()) {
            iT = 0;
            for (I5.l lVar : parameters) {
                iT += lVar.i() == l.a.f4293c ? a8.T(lVar) : 0;
            }
        } else if (parameters.isEmpty()) {
            iT = 0;
        } else {
            Iterator it = parameters.iterator();
            iT = 0;
            while (it.hasNext()) {
                if (((I5.l) it.next()).i() == l.a.f4293c && (iT = iT + 1) < 0) {
                    AbstractC2595q.q();
                }
            }
        }
        int i8 = (iT + 31) / 32;
        Object[] objArr = new Object[size + i8 + 1];
        for (I5.l lVar2 : parameters) {
            if (lVar2.k() && !j1.l(lVar2.getType())) {
                objArr[lVar2.g()] = j1.g(K5.c.f(lVar2.getType()));
            } else if (lVar2.j()) {
                objArr[lVar2.g()] = a8.M(lVar2.getType());
            }
        }
        for (int i9 = 0; i9 < i8; i9++) {
            objArr[size + i9] = 0;
        }
        return objArr;
    }

    public static final List p(A a8) {
        return j1.e(a8.X());
    }

    public static final ArrayList t(A a8) {
        int i8;
        InterfaceC0845b interfaceC0845bS = a8.X();
        ArrayList arrayList = new ArrayList();
        int i9 = 0;
        if (a8.V()) {
            i8 = 0;
        } else {
            R5.c0 c0VarI = j1.i(interfaceC0845bS);
            if (c0VarI != null) {
                arrayList.add(new C0695y0(a8, 0, l.a.f4291a, new C0690w(c0VarI)));
                i8 = 1;
            } else {
                i8 = 0;
            }
            R5.c0 c0VarL0 = interfaceC0845bS.l0();
            if (c0VarL0 != null) {
                arrayList.add(new C0695y0(a8, i8, l.a.f4292b, new C0692x(c0VarL0)));
                i8++;
            }
        }
        int size = interfaceC0845bS.k().size();
        while (i9 < size) {
            arrayList.add(new C0695y0(a8, i8, l.a.f4293c, new C0694y(interfaceC0845bS, i9)));
            i9++;
            i8++;
        }
        if (a8.U() && (interfaceC0845bS instanceof InterfaceC1257a) && arrayList.size() > 1) {
            p5.u.w(arrayList, new a());
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final R5.W w(InterfaceC0845b interfaceC0845b, int i8) {
        Object obj = interfaceC0845b.k().get(i8);
        AbstractC2304t.e(obj, "get(...)");
        return (R5.W) obj;
    }

    public static final U0 x(A a8) {
        I6.S returnType = a8.X().getReturnType();
        AbstractC2304t.c(returnType);
        return new U0(returnType, new C0696z(a8));
    }

    public static final Type y(A a8) {
        Type typeN = a8.N();
        return typeN == null ? a8.P().getReturnType() : typeN;
    }

    public static final List z(A a8) {
        List<R5.m0> typeParameters = a8.X().getTypeParameters();
        AbstractC2304t.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(p5.r.s(typeParameters, 10));
        for (R5.m0 m0Var : typeParameters) {
            AbstractC2304t.c(m0Var);
            arrayList.add(new W0(a8, m0Var));
        }
        return arrayList;
    }

    public final Object K(Map map) throws J5.a {
        Object objM;
        List<I5.l> parameters = getParameters();
        ArrayList arrayList = new ArrayList(p5.r.s(parameters, 10));
        for (I5.l lVar : parameters) {
            if (map.containsKey(lVar)) {
                objM = map.get(lVar);
                if (objM == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + lVar + ')');
                }
            } else if (lVar.k()) {
                objM = null;
            } else {
                if (!lVar.j()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + lVar);
                }
                objM = M(lVar.getType());
            }
            arrayList.add(objM);
        }
        M5.h hVarR = R();
        if (hVarR != null) {
            try {
                return hVarR.call(arrayList.toArray(new Object[0]));
            } catch (IllegalAccessException e8) {
                throw new J5.a(e8);
            }
        }
        throw new Y0("This callable does not support a default call: " + X());
    }

    public final Object L(Map args, InterfaceC2707e interfaceC2707e) throws J5.a {
        AbstractC2304t.f(args, "args");
        List<I5.l> parameters = getParameters();
        boolean z7 = false;
        if (parameters.isEmpty()) {
            try {
                return P().call(isSuspend() ? new InterfaceC2707e[]{interfaceC2707e} : new InterfaceC2707e[0]);
            } catch (IllegalAccessException e8) {
                throw new J5.a(e8);
            }
        }
        int size = parameters.size() + (isSuspend() ? 1 : 0);
        Object[] objArrO = O();
        if (isSuspend()) {
            objArrO[parameters.size()] = interfaceC2707e;
        }
        boolean zBooleanValue = ((Boolean) this.f5033f.getValue()).booleanValue();
        int i8 = 0;
        for (I5.l lVar : parameters) {
            int iT = zBooleanValue ? T(lVar) : 1;
            if (args.containsKey(lVar)) {
                objArrO[lVar.g()] = args.get(lVar);
            } else if (lVar.k()) {
                if (zBooleanValue) {
                    int i9 = i8 + iT;
                    for (int i10 = i8; i10 < i9; i10++) {
                        int i11 = (i10 / 32) + size;
                        Object obj = objArrO[i11];
                        AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.Int");
                        objArrO[i11] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i10 % 32)));
                    }
                } else {
                    int i12 = (i8 / 32) + size;
                    Object obj2 = objArrO[i12];
                    AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.Int");
                    objArrO[i12] = Integer.valueOf(((Integer) obj2).intValue() | (1 << (i8 % 32)));
                }
                z7 = true;
            } else if (!lVar.j()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + lVar);
            }
            if (lVar.i() == l.a.f4293c) {
                i8 += iT;
            }
        }
        if (!z7) {
            try {
                M5.h hVarP = P();
                Object[] objArrCopyOf = Arrays.copyOf(objArrO, size);
                AbstractC2304t.e(objArrCopyOf, "copyOf(...)");
                return hVarP.call(objArrCopyOf);
            } catch (IllegalAccessException e9) {
                throw new J5.a(e9);
            }
        }
        M5.h hVarR = R();
        if (hVarR != null) {
            try {
                return hVarR.call(objArrO);
            } catch (IllegalAccessException e10) {
                throw new J5.a(e10);
            }
        }
        throw new Y0("This callable does not support a default call: " + X());
    }

    public final Object M(I5.q qVar) {
        Class clsB = A5.a.b(K5.b.b(qVar));
        if (clsB.isArray()) {
            Object objNewInstance = Array.newInstance(clsB.getComponentType(), 0);
            AbstractC2304t.e(objNewInstance, "run(...)");
            return objNewInstance;
        }
        throw new Y0("Cannot instantiate the default empty array of type " + clsB.getSimpleName() + ", because it is not an array type");
    }

    public final Type N() {
        Type[] lowerBounds;
        if (!isSuspend()) {
            return null;
        }
        Object objL0 = p5.z.l0(P().a());
        ParameterizedType parameterizedType = objL0 instanceof ParameterizedType ? (ParameterizedType) objL0 : null;
        if (!AbstractC2304t.b(parameterizedType != null ? parameterizedType.getRawType() : null, InterfaceC2707e.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        AbstractC2304t.e(actualTypeArguments, "getActualTypeArguments(...)");
        Object objY = AbstractC2592n.Y(actualTypeArguments);
        WildcardType wildcardType = objY instanceof WildcardType ? (WildcardType) objY : null;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) AbstractC2592n.C(lowerBounds);
    }

    public final Object[] O() {
        return (Object[]) ((Object[]) this.f5032e.invoke()).clone();
    }

    public abstract M5.h P();

    public abstract AbstractC0654d0 Q();

    public abstract M5.h R();

    /* JADX INFO: renamed from: S */
    public abstract InterfaceC0845b X();

    public final int T(I5.l lVar) {
        if (!((Boolean) this.f5033f.getValue()).booleanValue()) {
            throw new IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before".toString());
        }
        if (!j1.k(lVar.getType())) {
            return 1;
        }
        I5.q type = lVar.getType();
        AbstractC2304t.d(type, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        List listN = M5.o.n(I6.F0.a(((U0) type).y()));
        AbstractC2304t.c(listN);
        return listN.size();
    }

    public final boolean U() {
        return AbstractC2304t.b(getName(), "<init>") && Q().e().isAnnotation();
    }

    public abstract boolean V();

    @Override // I5.c
    public Object call(Object... args) throws J5.a {
        AbstractC2304t.f(args, "args");
        try {
            return P().call(args);
        } catch (IllegalAccessException e8) {
            throw new J5.a(e8);
        }
    }

    @Override // I5.c
    public Object callBy(Map args) {
        AbstractC2304t.f(args, "args");
        return U() ? K(args) : L(args, null);
    }

    @Override // I5.b
    public List getAnnotations() {
        Object objInvoke = this.f5028a.invoke();
        AbstractC2304t.e(objInvoke, "invoke(...)");
        return (List) objInvoke;
    }

    @Override // I5.c
    public List getParameters() {
        Object objInvoke = this.f5029b.invoke();
        AbstractC2304t.e(objInvoke, "invoke(...)");
        return (List) objInvoke;
    }

    @Override // I5.c
    public I5.q getReturnType() {
        Object objInvoke = this.f5030c.invoke();
        AbstractC2304t.e(objInvoke, "invoke(...)");
        return (I5.q) objInvoke;
    }

    @Override // I5.c
    public List getTypeParameters() {
        Object objInvoke = this.f5031d.invoke();
        AbstractC2304t.e(objInvoke, "invoke(...)");
        return (List) objInvoke;
    }

    @Override // I5.c
    public I5.u getVisibility() {
        AbstractC0863u visibility = X().getVisibility();
        AbstractC2304t.e(visibility, "getVisibility(...)");
        return j1.r(visibility);
    }

    @Override // I5.c
    public boolean isAbstract() {
        return X().m() == R5.E.f7200e;
    }

    @Override // I5.c
    public boolean isFinal() {
        return X().m() == R5.E.f7197b;
    }

    @Override // I5.c
    public boolean isOpen() {
        return X().m() == R5.E.f7199d;
    }

    public static final R5.W u(R5.c0 c0Var) {
        return c0Var;
    }

    public static final R5.W v(R5.c0 c0Var) {
        return c0Var;
    }
}
