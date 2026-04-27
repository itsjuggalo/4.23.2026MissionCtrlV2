package M5;

import I6.F0;
import I6.S;
import L5.AbstractC0654d0;
import L5.j1;
import M5.h;
import M5.i;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0868z;
import R5.W;
import V6.C;
import X5.AbstractC0990f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import p5.AbstractC2592n;
import p5.AbstractC2594p;
import p5.AbstractC2595q;
import p5.r;
import p5.v;
import p5.z;
import t5.AbstractC2751c;
import u6.AbstractC2796k;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f5419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Member f5420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f5421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H5.d[] f5422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5423f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final H5.d f5424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List[] f5425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f5426c;

        public a(H5.d argumentRange, List[] unboxParameters, Method method) {
            AbstractC2304t.f(argumentRange, "argumentRange");
            AbstractC2304t.f(unboxParameters, "unboxParameters");
            this.f5424a = argumentRange;
            this.f5425b = unboxParameters;
            this.f5426c = method;
        }

        public final H5.d a() {
            return this.f5424a;
        }

        public final Method b() {
            return this.f5426c;
        }

        public final List[] c() {
            return this.f5425b;
        }
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f5427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f5428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f5429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f5430d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f5431e;

        public b(InterfaceC0868z descriptor, AbstractC0654d0 container, String constructorDesc, List originalParameters) {
            Collection collectionE;
            AbstractC2304t.f(descriptor, "descriptor");
            AbstractC2304t.f(container, "container");
            AbstractC2304t.f(constructorDesc, "constructorDesc");
            AbstractC2304t.f(originalParameters, "originalParameters");
            Method methodB = container.B("constructor-impl", constructorDesc);
            AbstractC2304t.c(methodB);
            this.f5427a = methodB;
            Method methodB2 = container.B("box-impl", C.p0(constructorDesc, "V") + AbstractC0990f.f(container.e()));
            AbstractC2304t.c(methodB2);
            this.f5428b = methodB2;
            ArrayList arrayList = new ArrayList(r.s(originalParameters, 10));
            Iterator it = originalParameters.iterator();
            while (it.hasNext()) {
                S type = ((W) it.next()).getType();
                AbstractC2304t.e(type, "getType(...)");
                arrayList.add(o.p(F0.a(type), descriptor));
            }
            this.f5429c = arrayList;
            ArrayList arrayList2 = new ArrayList(r.s(originalParameters, 10));
            int i8 = 0;
            for (Object obj : originalParameters) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    AbstractC2595q.r();
                }
                InterfaceC0851h interfaceC0851hS = ((W) obj).getType().O0().s();
                AbstractC2304t.d(interfaceC0851hS, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                InterfaceC0848e interfaceC0848e = (InterfaceC0848e) interfaceC0851hS;
                List list = (List) this.f5429c.get(i8);
                if (list != null) {
                    collectionE = new ArrayList(r.s(list, 10));
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        collectionE.add(((Method) it2.next()).getReturnType());
                    }
                } else {
                    Class clsQ = j1.q(interfaceC0848e);
                    AbstractC2304t.c(clsQ);
                    collectionE = AbstractC2594p.e(clsQ);
                }
                arrayList2.add(collectionE);
                i8 = i9;
            }
            this.f5430d = arrayList2;
            this.f5431e = r.u(arrayList2);
        }

        @Override // M5.h
        public List a() {
            return this.f5431e;
        }

        @Override // M5.h
        public /* bridge */ /* synthetic */ Member b() {
            return (Member) d();
        }

        @Override // M5.h
        public boolean c() {
            return h.a.b(this);
        }

        @Override // M5.h
        public Object call(Object[] args) throws IllegalAccessException, InvocationTargetException {
            Collection collectionE;
            AbstractC2304t.f(args, "args");
            List<C2489q> listZ0 = AbstractC2592n.z0(args, this.f5429c);
            ArrayList arrayList = new ArrayList();
            for (C2489q c2489q : listZ0) {
                Object objA = c2489q.a();
                List list = (List) c2489q.b();
                if (list != null) {
                    collectionE = new ArrayList(r.s(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        collectionE.add(((Method) it.next()).invoke(objA, null));
                    }
                } else {
                    collectionE = AbstractC2594p.e(objA);
                }
                v.x(arrayList, collectionE);
            }
            Object[] array = arrayList.toArray(new Object[0]);
            this.f5427a.invoke(null, Arrays.copyOf(array, array.length));
            return this.f5428b.invoke(null, Arrays.copyOf(array, array.length));
        }

        public Void d() {
            return null;
        }

        public final List e() {
            return this.f5430d;
        }

        @Override // M5.h
        public Type getReturnType() {
            Class<?> returnType = this.f5428b.getReturnType();
            AbstractC2304t.e(returnType, "getReturnType(...)");
            return returnType;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b A[LOOP:1: B:25:0x0075->B:27:0x007b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n(R5.InterfaceC0845b r11, M5.h r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M5.n.<init>(R5.b, M5.h, boolean):void");
    }

    public static final boolean e(InterfaceC0848e makeKotlinParameterTypes) {
        AbstractC2304t.f(makeKotlinParameterTypes, "$this$makeKotlinParameterTypes");
        return AbstractC2796k.g(makeKotlinParameterTypes);
    }

    @Override // M5.h
    public List a() {
        return this.f5419b.a();
    }

    @Override // M5.h
    public Member b() {
        return this.f5420c;
    }

    @Override // M5.h
    public boolean c() {
        return this.f5419b instanceof i.h.a;
    }

    @Override // M5.h
    public Object call(Object[] args) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        Object objG;
        Object objG2;
        AbstractC2304t.f(args, "args");
        H5.d dVarA = this.f5421d.a();
        List[] listArrC = this.f5421d.c();
        Method methodB = this.f5421d.b();
        if (!dVarA.isEmpty()) {
            if (this.f5423f) {
                List listD = AbstractC2594p.d(args.length);
                int iE = dVarA.e();
                for (int i8 = 0; i8 < iE; i8++) {
                    listD.add(args[i8]);
                }
                int iE2 = dVarA.e();
                int iF = dVarA.f();
                if (iE2 <= iF) {
                    while (true) {
                        List<Method> list = listArrC[iE2];
                        Object obj = args[iE2];
                        if (list != null) {
                            for (Method method : list) {
                                if (obj != null) {
                                    objG2 = method.invoke(obj, null);
                                } else {
                                    Class<?> returnType = method.getReturnType();
                                    AbstractC2304t.e(returnType, "getReturnType(...)");
                                    objG2 = j1.g(returnType);
                                }
                                listD.add(objG2);
                            }
                        } else {
                            listD.add(obj);
                        }
                        if (iE2 == iF) {
                            break;
                        }
                        iE2++;
                    }
                }
                int iF2 = dVarA.f() + 1;
                int iG = AbstractC2592n.G(args);
                if (iF2 <= iG) {
                    while (true) {
                        listD.add(args[iF2]);
                        if (iF2 == iG) {
                            break;
                        }
                        iF2++;
                    }
                }
                args = AbstractC2594p.a(listD).toArray(new Object[0]);
            } else {
                int length = args.length;
                Object[] objArr = new Object[length];
                for (int i9 = 0; i9 < length; i9++) {
                    int iE3 = dVarA.e();
                    if (i9 > dVarA.f() || iE3 > i9) {
                        objG = args[i9];
                    } else {
                        List list2 = listArrC[i9];
                        Method method2 = list2 != null ? (Method) z.u0(list2) : null;
                        objG = args[i9];
                        if (method2 != null) {
                            if (objG != null) {
                                objG = method2.invoke(objG, null);
                            } else {
                                Class<?> returnType2 = method2.getReturnType();
                                AbstractC2304t.e(returnType2, "getReturnType(...)");
                                objG = j1.g(returnType2);
                            }
                        }
                    }
                    objArr[i9] = objG;
                }
                args = objArr;
            }
        }
        Object objCall = this.f5419b.call(args);
        return (objCall == AbstractC2751c.f() || methodB == null || (objInvoke = methodB.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    public final H5.d f(int i8) {
        H5.d dVar;
        if (i8 >= 0) {
            H5.d[] dVarArr = this.f5422e;
            if (i8 < dVarArr.length) {
                return dVarArr[i8];
            }
        }
        H5.d[] dVarArr2 = this.f5422e;
        if (dVarArr2.length == 0) {
            dVar = new H5.d(i8, i8);
        } else {
            int length = (i8 - dVarArr2.length) + ((H5.d) AbstractC2592n.V(dVarArr2)).f() + 1;
            dVar = new H5.d(length, length);
        }
        return dVar;
    }

    @Override // M5.h
    public Type getReturnType() {
        return this.f5419b.getReturnType();
    }
}
