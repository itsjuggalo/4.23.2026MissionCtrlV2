package ae;

import ae.h;
import ae.i;
import dd.a0;
import dd.q;
import dd.r;
import dd.s;
import dd.w;
import fe.v0;
import fe.z;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kg.c0;
import kotlin.jvm.internal.t;
import xf.e2;
import xf.r0;
import zd.c1;
import zd.i3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Member f797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vd.g[] f799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f800f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vd.g f801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List[] f802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f803c;

        public a(vd.g argumentRange, List[] unboxParameters, Method method) {
            t.f(argumentRange, "argumentRange");
            t.f(unboxParameters, "unboxParameters");
            this.f801a = argumentRange;
            this.f802b = unboxParameters;
            this.f803c = method;
        }

        public final vd.g a() {
            return this.f801a;
        }

        public final Method b() {
            return this.f803c;
        }

        public final List[] c() {
            return this.f802b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f807d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f808e;

        public b(z descriptor, c1 container, String constructorDesc, List originalParameters) {
            Collection collectionE;
            t.f(descriptor, "descriptor");
            t.f(container, "container");
            t.f(constructorDesc, "constructorDesc");
            t.f(originalParameters, "originalParameters");
            Method methodA = container.A("constructor-impl", constructorDesc);
            t.c(methodA);
            this.f804a = methodA;
            Method methodA2 = container.A("box-impl", c0.z0(constructorDesc, "V") + le.f.f(container.e()));
            t.c(methodA2);
            this.f805b = methodA2;
            ArrayList arrayList = new ArrayList(s.u(originalParameters, 10));
            Iterator it = originalParameters.iterator();
            while (it.hasNext()) {
                r0 type = ((v0) it.next()).getType();
                t.e(type, "getType(...)");
                arrayList.add(o.p(e2.a(type), descriptor));
            }
            this.f806c = arrayList;
            ArrayList arrayList2 = new ArrayList(s.u(originalParameters, 10));
            int i10 = 0;
            for (Object obj : originalParameters) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    r.t();
                }
                fe.h hVarB = ((v0) obj).getType().N0().b();
                t.d(hVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                fe.e eVar = (fe.e) hVarB;
                List list = (List) this.f806c.get(i10);
                if (list != null) {
                    collectionE = new ArrayList(s.u(list, 10));
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        collectionE.add(((Method) it2.next()).getReturnType());
                    }
                } else {
                    Class clsQ = i3.q(eVar);
                    t.c(clsQ);
                    collectionE = q.e(clsQ);
                }
                arrayList2.add(collectionE);
                i10 = i11;
            }
            this.f807d = arrayList2;
            this.f808e = s.w(arrayList2);
        }

        @Override // ae.h
        public List a() {
            return this.f808e;
        }

        @Override // ae.h
        public /* bridge */ /* synthetic */ Member b() {
            return (Member) d();
        }

        @Override // ae.h
        public boolean c() {
            return h.a.b(this);
        }

        @Override // ae.h
        public Object call(Object[] args) throws IllegalAccessException, InvocationTargetException {
            Collection collectionE;
            t.f(args, "args");
            List<cd.q> listO0 = dd.n.O0(args, this.f806c);
            ArrayList arrayList = new ArrayList();
            for (cd.q qVar : listO0) {
                Object objA = qVar.a();
                List list = (List) qVar.b();
                if (list != null) {
                    collectionE = new ArrayList(s.u(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        collectionE.add(((Method) it.next()).invoke(objA, null));
                    }
                } else {
                    collectionE = q.e(objA);
                }
                w.z(arrayList, collectionE);
            }
            Object[] array = arrayList.toArray(new Object[0]);
            this.f804a.invoke(null, Arrays.copyOf(array, array.length));
            return this.f805b.invoke(null, Arrays.copyOf(array, array.length));
        }

        public Void d() {
            return null;
        }

        public final List e() {
            return this.f807d;
        }

        @Override // ae.h
        public Type getReturnType() {
            Class<?> returnType = this.f805b.getReturnType();
            t.e(returnType, "getReturnType(...)");
            return returnType;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0079 A[LOOP:1: B:25:0x0073->B:27:0x0079, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n(fe.b r11, ae.h r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ae.n.<init>(fe.b, ae.h, boolean):void");
    }

    public static final boolean e(fe.e makeKotlinParameterTypes) {
        t.f(makeKotlinParameterTypes, "$this$makeKotlinParameterTypes");
        return jf.k.g(makeKotlinParameterTypes);
    }

    @Override // ae.h
    public List a() {
        return this.f796b.a();
    }

    @Override // ae.h
    public Member b() {
        return this.f797c;
    }

    @Override // ae.h
    public boolean c() {
        return this.f796b instanceof i.h.a;
    }

    @Override // ae.h
    public Object call(Object[] args) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        Object objG;
        Object objG2;
        t.f(args, "args");
        vd.g gVarA = this.f798d.a();
        List[] listArrC = this.f798d.c();
        Method methodB = this.f798d.b();
        if (!gVarA.isEmpty()) {
            if (this.f800f) {
                List listD = q.d(args.length);
                int iE = gVarA.e();
                for (int i10 = 0; i10 < iE; i10++) {
                    listD.add(args[i10]);
                }
                int iE2 = gVarA.e();
                int iF = gVarA.f();
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
                                    t.e(returnType, "getReturnType(...)");
                                    objG2 = i3.g(returnType);
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
                int iF2 = gVarA.f() + 1;
                int iG = dd.n.G(args);
                if (iF2 <= iG) {
                    while (true) {
                        listD.add(args[iF2]);
                        if (iF2 == iG) {
                            break;
                        }
                        iF2++;
                    }
                }
                args = q.a(listD).toArray(new Object[0]);
            } else {
                int length = args.length;
                Object[] objArr = new Object[length];
                for (int i11 = 0; i11 < length; i11++) {
                    int iE3 = gVarA.e();
                    if (i11 > gVarA.f() || iE3 > i11) {
                        objG = args[i11];
                    } else {
                        List list2 = listArrC[i11];
                        Method method2 = list2 != null ? (Method) a0.v0(list2) : null;
                        objG = args[i11];
                        if (method2 != null) {
                            if (objG != null) {
                                objG = method2.invoke(objG, null);
                            } else {
                                Class<?> returnType2 = method2.getReturnType();
                                t.e(returnType2, "getReturnType(...)");
                                objG = i3.g(returnType2);
                            }
                        }
                    }
                    objArr[i11] = objG;
                }
                args = objArr;
            }
        }
        Object objCall = this.f796b.call(args);
        return (objCall == hd.c.f() || methodB == null || (objInvoke = methodB.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    public final vd.g f(int i10) {
        if (i10 >= 0) {
            vd.g[] gVarArr = this.f799e;
            if (i10 < gVarArr.length) {
                return gVarArr[i10];
            }
        }
        vd.g[] gVarArr2 = this.f799e;
        if (gVarArr2.length == 0) {
            return new vd.g(i10, i10);
        }
        int length = (i10 - gVarArr2.length) + ((vd.g) dd.n.k0(gVarArr2)).f() + 1;
        return new vd.g(length, length);
    }

    @Override // ae.h
    public Type getReturnType() {
        return this.f796b.getReturnType();
    }
}
