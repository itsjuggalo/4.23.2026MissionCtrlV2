package M5;

import L5.Y0;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;
import p5.AbstractC2592n;
import p5.r;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    public static final Object g(Class annotationClass, Map values, List methods) {
        AbstractC2304t.f(annotationClass, "annotationClass");
        AbstractC2304t.f(values, "values");
        AbstractC2304t.f(methods, "methods");
        InterfaceC2483k interfaceC2483kA = AbstractC2484l.a(new b(values));
        Object objNewProxyInstance = Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new d(annotationClass, values, AbstractC2484l.a(new c(annotationClass, values)), interfaceC2483kA, methods));
        AbstractC2304t.d(objNewProxyInstance, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return objNewProxyInstance;
    }

    public static /* synthetic */ Object h(Class cls, Map map, List list, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            Set setKeySet = map.keySet();
            ArrayList arrayList = new ArrayList(r.s(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), null));
            }
            list = arrayList;
        }
        return g(cls, map, list);
    }

    public static final boolean i(Class cls, List list, Map map, Object obj) throws IllegalAccessException, InvocationTargetException {
        boolean zB;
        boolean z7;
        I5.d dVarA;
        Annotation annotation = obj instanceof Annotation ? (Annotation) obj : null;
        if (!AbstractC2304t.b((annotation == null || (dVarA = A5.a.a(annotation)) == null) ? null : A5.a.b(dVarA), cls)) {
            return false;
        }
        if ((list instanceof Collection) && list.isEmpty()) {
            z7 = true;
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Method method = (Method) it.next();
                Object obj2 = map.get(method.getName());
                Object objInvoke = method.invoke(obj, null);
                if (obj2 instanceof boolean[]) {
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                    zB = Arrays.equals((boolean[]) obj2, (boolean[]) objInvoke);
                } else if (obj2 instanceof char[]) {
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.CharArray");
                    zB = Arrays.equals((char[]) obj2, (char[]) objInvoke);
                } else if (obj2 instanceof byte[]) {
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.ByteArray");
                    zB = Arrays.equals((byte[]) obj2, (byte[]) objInvoke);
                } else if (obj2 instanceof short[]) {
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.ShortArray");
                    zB = Arrays.equals((short[]) obj2, (short[]) objInvoke);
                } else if (obj2 instanceof int[]) {
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.IntArray");
                    zB = Arrays.equals((int[]) obj2, (int[]) objInvoke);
                } else if (obj2 instanceof float[]) {
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.FloatArray");
                    zB = Arrays.equals((float[]) obj2, (float[]) objInvoke);
                } else if (obj2 instanceof long[]) {
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.LongArray");
                    zB = Arrays.equals((long[]) obj2, (long[]) objInvoke);
                } else if (obj2 instanceof double[]) {
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                    zB = Arrays.equals((double[]) obj2, (double[]) objInvoke);
                } else if (obj2 instanceof Object[]) {
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
                    zB = Arrays.equals((Object[]) obj2, (Object[]) objInvoke);
                } else {
                    zB = AbstractC2304t.b(obj2, objInvoke);
                }
                if (!zB) {
                    z7 = false;
                    break;
                }
            }
            z7 = true;
        }
        return z7;
    }

    public static final int j(Map map) {
        int iHashCode = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            iHashCode += (value instanceof boolean[] ? Arrays.hashCode((boolean[]) value) : value instanceof char[] ? Arrays.hashCode((char[]) value) : value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value instanceof short[] ? Arrays.hashCode((short[]) value) : value instanceof int[] ? Arrays.hashCode((int[]) value) : value instanceof float[] ? Arrays.hashCode((float[]) value) : value instanceof long[] ? Arrays.hashCode((long[]) value) : value instanceof double[] ? Arrays.hashCode((double[]) value) : value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode()) ^ (str.hashCode() * 127);
        }
        return iHashCode;
    }

    public static final int k(InterfaceC2483k interfaceC2483k) {
        return ((Number) interfaceC2483k.getValue()).intValue();
    }

    public static final String l(Class cls, Map map) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        sb.append(cls.getCanonicalName());
        z.e0(map.entrySet(), sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : e.f5396a);
        return sb.toString();
    }

    public static final CharSequence m(Map.Entry entry) {
        String string;
        AbstractC2304t.f(entry, "entry");
        String str = (String) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            string = Arrays.toString((boolean[]) value);
        } else if (value instanceof char[]) {
            string = Arrays.toString((char[]) value);
        } else if (value instanceof byte[]) {
            string = Arrays.toString((byte[]) value);
        } else if (value instanceof short[]) {
            string = Arrays.toString((short[]) value);
        } else if (value instanceof int[]) {
            string = Arrays.toString((int[]) value);
        } else if (value instanceof float[]) {
            string = Arrays.toString((float[]) value);
        } else if (value instanceof long[]) {
            string = Arrays.toString((long[]) value);
        } else if (value instanceof double[]) {
            string = Arrays.toString((double[]) value);
        } else {
            if (!(value instanceof Object[])) {
                string = value.toString();
                return str + '=' + string;
            }
            string = Arrays.toString((Object[]) value);
        }
        AbstractC2304t.e(string, "toString(...)");
        return str + '=' + string;
    }

    public static final String n(InterfaceC2483k interfaceC2483k) {
        return (String) interfaceC2483k.getValue();
    }

    public static final Object o(Class cls, Map map, InterfaceC2483k interfaceC2483k, InterfaceC2483k interfaceC2483k2, List list, Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (name != null) {
            int iHashCode = name.hashCode();
            if (iHashCode != -1776922004) {
                if (iHashCode != 147696667) {
                    if (iHashCode == 1444986633 && name.equals("annotationType")) {
                        return cls;
                    }
                } else if (name.equals("hashCode")) {
                    return Integer.valueOf(k(interfaceC2483k2));
                }
            } else if (name.equals("toString")) {
                return n(interfaceC2483k);
            }
        }
        if (AbstractC2304t.b(name, "equals") && objArr != null && objArr.length == 1) {
            return Boolean.valueOf(i(cls, list, map, AbstractC2592n.Y(objArr)));
        }
        if (map.containsKey(name)) {
            return map.get(name);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method is not supported: ");
        sb.append(method);
        sb.append(" (args: ");
        if (objArr == null) {
            objArr = new Object[0];
        }
        sb.append(AbstractC2592n.k0(objArr));
        sb.append(')');
        throw new Y0(sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Void p(int r3, java.lang.String r4, java.lang.Class r5) {
        /*
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            boolean r1 = kotlin.jvm.internal.AbstractC2304t.b(r5, r0)
            if (r1 == 0) goto Lf
            java.lang.Class<I5.d> r5 = I5.d.class
        La:
            I5.d r5 = kotlin.jvm.internal.O.b(r5)
            goto L26
        Lf:
            boolean r1 = r5.isArray()
            if (r1 == 0) goto L22
            java.lang.Class r1 = r5.getComponentType()
            boolean r0 = kotlin.jvm.internal.AbstractC2304t.b(r1, r0)
            if (r0 == 0) goto L22
            java.lang.Class<I5.d[]> r5 = I5.d[].class
            goto La
        L22:
            I5.d r5 = A5.a.e(r5)
        L26:
            java.lang.String r0 = r5.q()
            java.lang.Class<java.lang.Object[]> r1 = java.lang.Object[].class
            I5.d r1 = kotlin.jvm.internal.O.b(r1)
            java.lang.String r1 = r1.q()
            boolean r0 = kotlin.jvm.internal.AbstractC2304t.b(r0, r1)
            if (r0 == 0) goto L6d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r5.q()
            r0.append(r1)
            r1 = 60
            r0.append(r1)
            java.lang.Class r5 = A5.a.b(r5)
            java.lang.Class r5 = r5.getComponentType()
            java.lang.String r1 = "getComponentType(...)"
            kotlin.jvm.internal.AbstractC2304t.e(r5, r1)
            I5.d r5 = A5.a.e(r5)
            java.lang.String r5 = r5.q()
            r0.append(r5)
            r5 = 62
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            goto L71
        L6d:
            java.lang.String r5 = r5.q()
        L71:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Argument #"
            r1.append(r2)
            r1.append(r3)
            r3 = 32
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = " is not of the required type "
            r1.append(r3)
            r1.append(r5)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: M5.f.p(int, java.lang.String, java.lang.Class):java.lang.Void");
    }

    public static final Object q(Object obj, Class cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof I5.d) {
            obj = A5.a.b((I5.d) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof I5.d[]) {
                AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                I5.d[] dVarArr = (I5.d[]) obj;
                ArrayList arrayList = new ArrayList(dVarArr.length);
                for (I5.d dVar : dVarArr) {
                    arrayList.add(A5.a.b(dVar));
                }
                obj = arrayList.toArray(new Class[0]);
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
