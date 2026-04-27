package kotlin.jvm.internal;

import R4.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public final class e implements W4.c, d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f7924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f7925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap f7926d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f7927a;

    static {
        List listC0 = H4.g.c0(new Class[]{R4.a.class, R4.l.class, R4.p.class, R4.q.class, R4.r.class, R4.s.class, R4.t.class, R4.u.class, R4.v.class, w.class, R4.b.class, R4.c.class, R4.d.class, R4.e.class, R4.f.class, R4.g.class, R4.h.class, R4.i.class, R4.j.class, R4.k.class, R4.m.class, R4.n.class, R4.o.class});
        ArrayList arrayList = new ArrayList(H4.j.d0(listC0, 10));
        int i = 0;
        for (Object obj : listC0) {
            int i6 = i + 1;
            if (i < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new G4.f((Class) obj, Integer.valueOf(i)));
            i = i6;
        }
        f7924b = H4.t.U(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        j.d(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            j.b(str);
            sb.append(Y4.d.d0(str, str));
            sb.append("CompanionObject");
            map3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f7924b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        f7925c = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(H4.t.P(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            j.b(str2);
            linkedHashMap.put(key, Y4.d.d0(str2, str2));
        }
        f7926d = linkedHashMap;
    }

    public e(Class jClass) {
        j.e(jClass, "jClass");
        this.f7927a = jClass;
    }

    @Override // kotlin.jvm.internal.d
    public final Class a() {
        return this.f7927a;
    }

    public final String b() {
        String str;
        Class jClass = this.f7927a;
        j.e(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass()) {
            return null;
        }
        if (!jClass.isLocalClass()) {
            boolean zIsArray = jClass.isArray();
            LinkedHashMap linkedHashMap = f7926d;
            if (!zIsArray) {
                String str2 = (String) linkedHashMap.get(jClass.getName());
                return str2 == null ? jClass.getSimpleName() : str2;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                strConcat = str.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = jClass.getSimpleName();
        Method enclosingMethod = jClass.getEnclosingMethod();
        if (enclosingMethod != null) {
            return Y4.d.c0(simpleName, enclosingMethod.getName() + '$', simpleName);
        }
        Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
        if (enclosingConstructor != null) {
            return Y4.d.c0(simpleName, enclosingConstructor.getName() + '$', simpleName);
        }
        int iX = Y4.d.X(simpleName, '$', 0, 6);
        if (iX == -1) {
            return simpleName;
        }
        String strSubstring = simpleName.substring(iX + 1, simpleName.length());
        j.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && u0.q(this).equals(u0.q((W4.c) obj));
    }

    public final int hashCode() {
        return u0.q(this).hashCode();
    }

    public final String toString() {
        return this.f7927a + " (Kotlin reflection is not available)";
    }
}
