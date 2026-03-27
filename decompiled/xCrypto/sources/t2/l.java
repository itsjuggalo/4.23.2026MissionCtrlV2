package t2;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q2.q;
import q2.s;
import q2.w;
import q2.x;
import r2.InterfaceC1752b;
import s2.D;
import s2.E;
import s2.G;
import s2.InterfaceC1769B;
import s2.u;
import s2.v;
import v2.AbstractC1896a;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: loaded from: classes.dex */
public final class l implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f14796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q2.c f14797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f14798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1788e f14799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f14800e;

    public class a extends w {
        public a() {
        }

        @Override // q2.w
        public Object c(C1946a c1946a) throws IOException {
            c1946a.B0();
            return null;
        }

        @Override // q2.w
        public void e(y2.c cVar, Object obj) throws IOException {
            cVar.e0();
        }

        public String toString() {
            return "AnonymousOrNonStaticLocalClassAdapter";
        }
    }

    public class b extends d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f14802d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Method f14803e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ w f14804f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ w f14805g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f14806h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f14807i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Field field, boolean z4, Method method, w wVar, w wVar2, boolean z5, boolean z6) {
            super(str, field);
            this.f14802d = z4;
            this.f14803e = method;
            this.f14804f = wVar;
            this.f14805g = wVar2;
            this.f14806h = z5;
            this.f14807i = z6;
        }

        @Override // t2.l.d
        public void a(C1946a c1946a, int i4, Object[] objArr) {
            Object objC = this.f14805g.c(c1946a);
            if (objC != null || !this.f14806h) {
                objArr[i4] = objC;
                return;
            }
            throw new q2.n("null is not allowed as value for record component '" + this.f14812c + "' of primitive type; at path " + c1946a.K());
        }

        @Override // t2.l.d
        public void b(C1946a c1946a, Object obj) throws IllegalAccessException {
            Object objC = this.f14805g.c(c1946a);
            if (objC == null && this.f14806h) {
                return;
            }
            if (this.f14802d) {
                l.b(obj, this.f14811b);
            } else if (this.f14807i) {
                throw new q2.k("Cannot set value of 'static final' " + AbstractC1896a.g(this.f14811b, false));
            }
            this.f14811b.set(obj, objC);
        }

        @Override // t2.l.d
        public void c(y2.c cVar, Object obj) throws IllegalAccessException {
            Object objInvoke;
            if (this.f14802d) {
                Method method = this.f14803e;
                if (method == null) {
                    l.b(obj, this.f14811b);
                } else {
                    l.b(obj, method);
                }
            }
            Method method2 = this.f14803e;
            if (method2 != null) {
                try {
                    objInvoke = method2.invoke(obj, new Object[0]);
                } catch (InvocationTargetException e4) {
                    throw new q2.k("Accessor " + AbstractC1896a.g(this.f14803e, false) + " threw exception", e4.getCause());
                }
            } else {
                objInvoke = this.f14811b.get(obj);
            }
            if (objInvoke == obj) {
                return;
            }
            cVar.a0(this.f14810a);
            this.f14804f.e(cVar, objInvoke);
        }
    }

    public static abstract class c extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f14809a;

        public c(f fVar) {
            this.f14809a = fVar;
        }

        @Override // q2.w
        public Object c(C1946a c1946a) throws IOException {
            if (c1946a.r0() == y2.b.NULL) {
                c1946a.n0();
                return null;
            }
            Object objF = f();
            Map map = this.f14809a.f14815a;
            try {
                c1946a.g();
                while (c1946a.d0()) {
                    d dVar = (d) map.get(c1946a.l0());
                    if (dVar == null) {
                        c1946a.B0();
                    } else {
                        h(objF, c1946a, dVar);
                    }
                }
                c1946a.G();
                return g(objF);
            } catch (IllegalAccessException e4) {
                throw AbstractC1896a.e(e4);
            } catch (IllegalStateException e5) {
                throw new q(e5);
            }
        }

        @Override // q2.w
        public void e(y2.c cVar, Object obj) throws IOException {
            if (obj == null) {
                cVar.e0();
                return;
            }
            cVar.x();
            try {
                Iterator it = this.f14809a.f14816b.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).c(cVar, obj);
                }
                cVar.G();
            } catch (IllegalAccessException e4) {
                throw AbstractC1896a.e(e4);
            }
        }

        public abstract Object f();

        public abstract Object g(Object obj);

        public abstract void h(Object obj, C1946a c1946a, d dVar);
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Field f14811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f14812c;

        public d(String str, Field field) {
            this.f14810a = str;
            this.f14811b = field;
            this.f14812c = field.getName();
        }

        public abstract void a(C1946a c1946a, int i4, Object[] objArr);

        public abstract void b(C1946a c1946a, Object obj);

        public abstract void c(y2.c cVar, Object obj);
    }

    public static class f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f14814c = new f(Collections.EMPTY_MAP, Collections.EMPTY_LIST);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f14815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f14816b;

        public f(Map map, List list) {
            this.f14815a = map;
            this.f14816b = list;
        }
    }

    public static final class g extends c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Map f14817e = k();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Constructor f14818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[] f14819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map f14820d;

        public g(Class cls, f fVar, boolean z4) {
            super(fVar);
            this.f14820d = new HashMap();
            Constructor constructorI = AbstractC1896a.i(cls);
            this.f14818b = constructorI;
            if (z4) {
                l.b(null, constructorI);
            } else {
                AbstractC1896a.o(constructorI);
            }
            String[] strArrK = AbstractC1896a.k(cls);
            for (int i4 = 0; i4 < strArrK.length; i4++) {
                this.f14820d.put(strArrK[i4], Integer.valueOf(i4));
            }
            Class<?>[] parameterTypes = this.f14818b.getParameterTypes();
            this.f14819c = new Object[parameterTypes.length];
            for (int i5 = 0; i5 < parameterTypes.length; i5++) {
                this.f14819c[i5] = f14817e.get(parameterTypes[i5]);
            }
        }

        public static Map k() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        @Override // t2.l.c
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object[] f() {
            return (Object[]) this.f14819c.clone();
        }

        @Override // t2.l.c
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Object g(Object[] objArr) {
            try {
                return this.f14818b.newInstance(objArr);
            } catch (IllegalAccessException e4) {
                throw AbstractC1896a.e(e4);
            } catch (IllegalArgumentException e5) {
                e = e5;
                throw new RuntimeException("Failed to invoke constructor '" + AbstractC1896a.c(this.f14818b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e6) {
                e = e6;
                throw new RuntimeException("Failed to invoke constructor '" + AbstractC1896a.c(this.f14818b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Failed to invoke constructor '" + AbstractC1896a.c(this.f14818b) + "' with args " + Arrays.toString(objArr), e7.getCause());
            }
        }

        @Override // t2.l.c
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void h(Object[] objArr, C1946a c1946a, d dVar) {
            Integer num = (Integer) this.f14820d.get(dVar.f14812c);
            if (num != null) {
                dVar.a(c1946a, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + AbstractC1896a.c(this.f14818b) + "' for field with name '" + dVar.f14812c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public l(u uVar, q2.c cVar, v vVar, C1788e c1788e, List list) {
        this.f14796a = uVar;
        this.f14797b = cVar;
        this.f14798c = vVar;
        this.f14799d = c1788e;
        this.f14800e = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (E.a(accessibleObject, obj)) {
            return;
        }
        throw new q2.k(AbstractC1896a.g(accessibleObject, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    public static IllegalArgumentException d(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + AbstractC1896a.f(field) + " and " + AbstractC1896a.f(field2) + "\nSee " + G.a("duplicate-fields"));
    }

    public final d c(q2.e eVar, Field field, Method method, String str, C1925a c1925a, boolean z4, boolean z5) {
        boolean z6;
        w oVar;
        boolean zA = D.a(c1925a.c());
        int modifiers = field.getModifiers();
        boolean z7 = false;
        if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
            z6 = false;
            z7 = true;
        } else {
            z6 = false;
        }
        InterfaceC1752b interfaceC1752b = (InterfaceC1752b) field.getAnnotation(InterfaceC1752b.class);
        w wVarC = interfaceC1752b != null ? this.f14799d.c(this.f14796a, eVar, c1925a, interfaceC1752b, false) : null;
        boolean z8 = wVarC == null ? z6 : true;
        if (wVarC == null) {
            wVarC = eVar.l(c1925a);
        }
        w wVar = wVarC;
        if (z4) {
            oVar = z8 ? wVar : new o(eVar, wVar, c1925a.d());
        } else {
            oVar = wVar;
        }
        return new b(str, field, z5, method, oVar, wVar, zA, z7);
    }

    @Override // q2.x
    public w create(q2.e eVar, C1925a c1925a) {
        Class clsC = c1925a.c();
        if (!Object.class.isAssignableFrom(clsC)) {
            return null;
        }
        if (AbstractC1896a.l(clsC)) {
            return new a();
        }
        s sVarB = E.b(this.f14800e, clsC);
        if (sVarB != s.BLOCK_ALL) {
            boolean z4 = sVarB == s.BLOCK_INACCESSIBLE;
            return AbstractC1896a.m(clsC) ? new g(clsC, e(eVar, c1925a, clsC, z4, true), z4) : new e(this.f14796a.t(c1925a), e(eVar, c1925a, clsC, z4, false));
        }
        throw new q2.k("ReflectionAccessFilter does not permit using reflection for " + clsC + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t2.l.f e(q2.e r20, x2.C1925a r21, java.lang.Class r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.l.e(q2.e, x2.a, java.lang.Class, boolean, boolean):t2.l$f");
    }

    public final List f(Field field) {
        r2.c cVar = (r2.c) field.getAnnotation(r2.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f14797b.a(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    public final boolean g(Field field, boolean z4) {
        return !this.f14798c.c(field, z4);
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC1769B f14813b;

        public e(InterfaceC1769B interfaceC1769B, f fVar) {
            super(fVar);
            this.f14813b = interfaceC1769B;
        }

        @Override // t2.l.c
        public Object f() {
            return this.f14813b.a();
        }

        @Override // t2.l.c
        public void h(Object obj, C1946a c1946a, d dVar) {
            dVar.b(c1946a, obj);
        }

        @Override // t2.l.c
        public Object g(Object obj) {
            return obj;
        }
    }
}
