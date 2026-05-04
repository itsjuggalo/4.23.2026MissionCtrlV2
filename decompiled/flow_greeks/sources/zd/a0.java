package zd;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import wd.l;
import zd.z2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 implements wd.c, w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z2.a f25672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z2.a f25673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z2.a f25674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z2.a f25675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z2.a f25676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final cd.k f25677f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return fd.a.a(((wd.l) obj).getName(), ((wd.l) obj2).getName());
        }
    }

    public a0() {
        z2.a aVarC = z2.c(new q(this));
        kotlin.jvm.internal.t.e(aVarC, "lazySoft(...)");
        this.f25672a = aVarC;
        z2.a aVarC2 = z2.c(new r(this));
        kotlin.jvm.internal.t.e(aVarC2, "lazySoft(...)");
        this.f25673b = aVarC2;
        z2.a aVarC3 = z2.c(new s(this));
        kotlin.jvm.internal.t.e(aVarC3, "lazySoft(...)");
        this.f25674c = aVarC3;
        z2.a aVarC4 = z2.c(new t(this));
        kotlin.jvm.internal.t.e(aVarC4, "lazySoft(...)");
        this.f25675d = aVarC4;
        z2.a aVarC5 = z2.c(new u(this));
        kotlin.jvm.internal.t.e(aVarC5, "lazySoft(...)");
        this.f25676e = aVarC5;
        this.f25677f = cd.l.a(cd.n.f3864b, new v(this));
    }

    public static final boolean V(a0 a0Var) {
        List parameters = a0Var.getParameters();
        if (parameters != null && parameters.isEmpty()) {
            return false;
        }
        Iterator it = parameters.iterator();
        while (it.hasNext()) {
            if (i3.k(((wd.l) it.next()).getType())) {
                return true;
            }
        }
        return false;
    }

    public static final Object[] q(a0 a0Var) {
        int iS;
        List<wd.l> parameters = a0Var.getParameters();
        int size = parameters.size() + (a0Var.isSuspend() ? 1 : 0);
        if (((Boolean) a0Var.f25677f.getValue()).booleanValue()) {
            iS = 0;
            for (wd.l lVar : parameters) {
                iS += lVar.h() == l.a.f23904c ? a0Var.S(lVar) : 0;
            }
        } else if (parameters.isEmpty()) {
            iS = 0;
        } else {
            Iterator it = parameters.iterator();
            iS = 0;
            while (it.hasNext()) {
                if (((wd.l) it.next()).h() == l.a.f23904c && (iS = iS + 1) < 0) {
                    dd.r.s();
                }
            }
        }
        int i10 = (iS + 31) / 32;
        Object[] objArr = new Object[size + i10 + 1];
        for (wd.l lVar2 : parameters) {
            if (lVar2.p() && !i3.l(lVar2.getType())) {
                objArr[lVar2.getIndex()] = i3.g(yd.c.f(lVar2.getType()));
            } else if (lVar2.a()) {
                objArr[lVar2.getIndex()] = a0Var.L(lVar2.getType());
            }
        }
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[size + i11] = 0;
        }
        return objArr;
    }

    public static final List r(a0 a0Var) {
        return i3.e(a0Var.W());
    }

    public static final ArrayList s(a0 a0Var) {
        int i10;
        fe.b bVarR = a0Var.W();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        if (a0Var.U()) {
            i10 = 0;
        } else {
            fe.b1 b1VarI = i3.i(bVarR);
            if (b1VarI != null) {
                arrayList.add(new x1(a0Var, 0, l.a.f23902a, new w(b1VarI)));
                i10 = 1;
            } else {
                i10 = 0;
            }
            fe.b1 b1VarK0 = bVarR.k0();
            if (b1VarK0 != null) {
                arrayList.add(new x1(a0Var, i10, l.a.f23903b, new x(b1VarK0)));
                i10++;
            }
        }
        int size = bVarR.i().size();
        while (i11 < size) {
            arrayList.add(new x1(a0Var, i10, l.a.f23904c, new y(bVarR, i11)));
            i11++;
            i10++;
        }
        if (a0Var.T() && (bVarR instanceof qe.a) && arrayList.size() > 1) {
            dd.v.y(arrayList, new a());
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final fe.v0 v(fe.b bVar, int i10) {
        Object obj = bVar.i().get(i10);
        kotlin.jvm.internal.t.e(obj, "get(...)");
        return (fe.v0) obj;
    }

    public static final t2 w(a0 a0Var) {
        xf.r0 returnType = a0Var.W().getReturnType();
        kotlin.jvm.internal.t.c(returnType);
        return new t2(returnType, new z(a0Var));
    }

    public static final Type x(a0 a0Var) {
        Type typeM = a0Var.M();
        return typeM == null ? a0Var.O().getReturnType() : typeM;
    }

    public static final List y(a0 a0Var) {
        List<fe.l1> typeParameters = a0Var.W().getTypeParameters();
        kotlin.jvm.internal.t.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(typeParameters, 10));
        for (fe.l1 l1Var : typeParameters) {
            kotlin.jvm.internal.t.c(l1Var);
            arrayList.add(new v2(a0Var, l1Var));
        }
        return arrayList;
    }

    public final Object J(Map map) throws xd.a {
        Object objL;
        List<wd.l> parameters = getParameters();
        ArrayList arrayList = new ArrayList(dd.s.u(parameters, 10));
        for (wd.l lVar : parameters) {
            if (map.containsKey(lVar)) {
                objL = map.get(lVar);
                if (objL == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + lVar + ')');
                }
            } else if (lVar.p()) {
                objL = null;
            } else {
                if (!lVar.a()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + lVar);
                }
                objL = L(lVar.getType());
            }
            arrayList.add(objL);
        }
        ae.h hVarQ = Q();
        if (hVarQ != null) {
            try {
                return hVarQ.call(arrayList.toArray(new Object[0]));
            } catch (IllegalAccessException e10) {
                throw new xd.a(e10);
            }
        }
        throw new x2("This callable does not support a default call: " + W());
    }

    public final Object K(Map args, gd.e eVar) throws xd.a {
        kotlin.jvm.internal.t.f(args, "args");
        List<wd.l> parameters = getParameters();
        boolean z10 = false;
        if (parameters.isEmpty()) {
            try {
                return O().call(isSuspend() ? new gd.e[]{eVar} : new gd.e[0]);
            } catch (IllegalAccessException e10) {
                throw new xd.a(e10);
            }
        }
        int size = parameters.size() + (isSuspend() ? 1 : 0);
        Object[] objArrN = N();
        if (isSuspend()) {
            objArrN[parameters.size()] = eVar;
        }
        boolean zBooleanValue = ((Boolean) this.f25677f.getValue()).booleanValue();
        int i10 = 0;
        for (wd.l lVar : parameters) {
            int iS = zBooleanValue ? S(lVar) : 1;
            if (args.containsKey(lVar)) {
                objArrN[lVar.getIndex()] = args.get(lVar);
            } else if (lVar.p()) {
                if (zBooleanValue) {
                    int i11 = i10 + iS;
                    for (int i12 = i10; i12 < i11; i12++) {
                        int i13 = (i12 / 32) + size;
                        Object obj = objArrN[i13];
                        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.Int");
                        objArrN[i13] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i12 % 32)));
                    }
                } else {
                    int i14 = (i10 / 32) + size;
                    Object obj2 = objArrN[i14];
                    kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type kotlin.Int");
                    objArrN[i14] = Integer.valueOf(((Integer) obj2).intValue() | (1 << (i10 % 32)));
                }
                z10 = true;
            } else if (!lVar.a()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + lVar);
            }
            if (lVar.h() == l.a.f23904c) {
                i10 += iS;
            }
        }
        if (!z10) {
            try {
                ae.h hVarO = O();
                Object[] objArrCopyOf = Arrays.copyOf(objArrN, size);
                kotlin.jvm.internal.t.e(objArrCopyOf, "copyOf(...)");
                return hVarO.call(objArrCopyOf);
            } catch (IllegalAccessException e11) {
                throw new xd.a(e11);
            }
        }
        ae.h hVarQ = Q();
        if (hVarQ != null) {
            try {
                return hVarQ.call(objArrN);
            } catch (IllegalAccessException e12) {
                throw new xd.a(e12);
            }
        }
        throw new x2("This callable does not support a default call: " + W());
    }

    public final Object L(wd.q qVar) {
        Class clsB = od.a.b(yd.b.b(qVar));
        if (clsB.isArray()) {
            Object objNewInstance = Array.newInstance(clsB.getComponentType(), 0);
            kotlin.jvm.internal.t.e(objNewInstance, "run(...)");
            return objNewInstance;
        }
        throw new x2("Cannot instantiate the default empty array of type " + clsB.getSimpleName() + ", because it is not an array type");
    }

    public final Type M() {
        Type[] lowerBounds;
        if (isSuspend()) {
            Object objM0 = dd.a0.m0(O().a());
            ParameterizedType parameterizedType = objM0 instanceof ParameterizedType ? (ParameterizedType) objM0 : null;
            if (kotlin.jvm.internal.t.b(parameterizedType != null ? parameterizedType.getRawType() : null, gd.e.class)) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                kotlin.jvm.internal.t.e(actualTypeArguments, "getActualTypeArguments(...)");
                Object objN0 = dd.n.n0(actualTypeArguments);
                WildcardType wildcardType = objN0 instanceof WildcardType ? (WildcardType) objN0 : null;
                if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                    return (Type) dd.n.C(lowerBounds);
                }
            }
        }
        return null;
    }

    public final Object[] N() {
        return (Object[]) ((Object[]) this.f25676e.invoke()).clone();
    }

    public abstract ae.h O();

    public abstract c1 P();

    public abstract ae.h Q();

    /* JADX INFO: renamed from: R */
    public abstract fe.b W();

    public final int S(wd.l lVar) {
        if (!((Boolean) this.f25677f.getValue()).booleanValue()) {
            throw new IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before");
        }
        if (!i3.k(lVar.getType())) {
            return 1;
        }
        wd.q type = lVar.getType();
        kotlin.jvm.internal.t.d(type, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        List listN = ae.o.n(xf.e2.a(((t2) type).x()));
        kotlin.jvm.internal.t.c(listN);
        return listN.size();
    }

    public final boolean T() {
        return kotlin.jvm.internal.t.b(getName(), "<init>") && P().e().isAnnotation();
    }

    public abstract boolean U();

    @Override // wd.c
    public Object call(Object... args) throws xd.a {
        kotlin.jvm.internal.t.f(args, "args");
        try {
            return O().call(args);
        } catch (IllegalAccessException e10) {
            throw new xd.a(e10);
        }
    }

    @Override // wd.c
    public Object callBy(Map args) {
        kotlin.jvm.internal.t.f(args, "args");
        return T() ? J(args) : K(args, null);
    }

    @Override // wd.b
    public List getAnnotations() {
        Object objInvoke = this.f25672a.invoke();
        kotlin.jvm.internal.t.e(objInvoke, "invoke(...)");
        return (List) objInvoke;
    }

    @Override // wd.c
    public List getParameters() {
        Object objInvoke = this.f25673b.invoke();
        kotlin.jvm.internal.t.e(objInvoke, "invoke(...)");
        return (List) objInvoke;
    }

    @Override // wd.c
    public wd.q getReturnType() {
        Object objInvoke = this.f25674c.invoke();
        kotlin.jvm.internal.t.e(objInvoke, "invoke(...)");
        return (wd.q) objInvoke;
    }

    @Override // wd.c
    public List getTypeParameters() {
        Object objInvoke = this.f25675d.invoke();
        kotlin.jvm.internal.t.e(objInvoke, "invoke(...)");
        return (List) objInvoke;
    }

    @Override // wd.c
    public wd.u getVisibility() {
        fe.u visibility = W().getVisibility();
        kotlin.jvm.internal.t.e(visibility, "getVisibility(...)");
        return i3.r(visibility);
    }

    @Override // wd.c
    public boolean isAbstract() {
        return W().l() == fe.e0.f9464e;
    }

    @Override // wd.c
    public boolean isFinal() {
        return W().l() == fe.e0.f9461b;
    }

    @Override // wd.c
    public boolean isOpen() {
        return W().l() == fe.e0.f9463d;
    }

    public static final fe.v0 t(fe.b1 b1Var) {
        return b1Var;
    }

    public static final fe.v0 u(fe.b1 b1Var) {
        return b1Var;
    }
}
