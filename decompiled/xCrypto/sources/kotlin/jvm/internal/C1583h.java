package kotlin.jvm.internal;

import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.L;
import h3.AbstractC1282a;
import i3.InterfaceC1318a;
import i3.InterfaceC1319b;
import i3.InterfaceC1320c;
import i3.InterfaceC1321d;
import i3.InterfaceC1322e;
import i3.InterfaceC1323f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p3.InterfaceC1716c;
import r3.AbstractC1753A;

/* JADX INFO: renamed from: kotlin.jvm.internal.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1583h implements InterfaceC1716c, InterfaceC1582g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13421b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f13422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f13423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f13424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap f13425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map f13426g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f13427a;

    /* JADX INFO: renamed from: kotlin.jvm.internal.h$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final String a(Class jClass) {
            String str;
            r.f(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String str3 = (String) C1583h.f13425f.get(jClass.getName());
                return str3 == null ? jClass.getCanonicalName() : str3;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) C1583h.f13425f.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        public final String b(Class jClass) {
            String str;
            r.f(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass()) {
                return null;
            }
            if (!jClass.isLocalClass()) {
                if (!jClass.isArray()) {
                    String str3 = (String) C1583h.f13426g.get(jClass.getName());
                    return str3 == null ? jClass.getSimpleName() : str3;
                }
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (str = (String) C1583h.f13426g.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                return str2 == null ? "Array" : str2;
            }
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                r.c(simpleName);
                String strA0 = AbstractC1753A.A0(simpleName, enclosingMethod.getName() + '$', null, 2, null);
                if (strA0 != null) {
                    return strA0;
                }
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                r.c(simpleName);
                return AbstractC1753A.z0(simpleName, '$', null, 2, null);
            }
            r.c(simpleName);
            return AbstractC1753A.A0(simpleName, enclosingConstructor.getName() + '$', null, 2, null);
        }

        public final boolean c(Object obj, Class jClass) {
            r.f(jClass, "jClass");
            Map map = C1583h.f13422c;
            r.d(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return K.e(obj, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = AbstractC1282a.b(AbstractC1282a.c(jClass));
            }
            return jClass.isInstance(obj);
        }

        public a() {
        }
    }

    static {
        List listJ = AbstractC0769p.j(Function0.class, i3.k.class, i3.o.class, i3.p.class, i3.q.class, i3.r.class, i3.s.class, i3.t.class, i3.u.class, i3.v.class, InterfaceC1318a.class, InterfaceC1319b.class, InterfaceC1320c.class, InterfaceC1321d.class, InterfaceC1322e.class, InterfaceC1323f.class, i3.g.class, i3.h.class, i3.i.class, i3.j.class, i3.l.class, i3.m.class, i3.n.class);
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(listJ, 10));
        int i4 = 0;
        for (Object obj : listJ) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                AbstractC0769p.p();
            }
            arrayList.add(W2.t.a((Class) obj, Integer.valueOf(i4)));
            i4 = i5;
        }
        f13422c = L.o(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f13423d = map;
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f13424e = map2;
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
        r.e(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            r.c(str);
            sb.append(AbstractC1753A.C0(str, com.amazon.a.a.o.c.a.b.f8816a, null, 2, null));
            sb.append("CompanionObject");
            W2.o oVarA = W2.t.a(sb.toString(), str + ".Companion");
            map3.put(oVarA.c(), oVarA.d());
        }
        for (Map.Entry entry : f13422c.entrySet()) {
            map3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f13425f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(X2.K.b(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            r.c(str2);
            linkedHashMap.put(key, AbstractC1753A.C0(str2, com.amazon.a.a.o.c.a.b.f8816a, null, 2, null));
        }
        f13426g = linkedHashMap;
    }

    public C1583h(Class jClass) {
        r.f(jClass, "jClass");
        this.f13427a = jClass;
    }

    @Override // p3.InterfaceC1716c
    public String a() {
        return f13421b.a(d());
    }

    @Override // p3.InterfaceC1716c
    public String b() {
        return f13421b.b(d());
    }

    @Override // p3.InterfaceC1716c
    public boolean c(Object obj) {
        return f13421b.c(obj, d());
    }

    @Override // kotlin.jvm.internal.InterfaceC1582g
    public Class d() {
        return this.f13427a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1583h) && r.b(AbstractC1282a.b(this), AbstractC1282a.b((InterfaceC1716c) obj));
    }

    public int hashCode() {
        return AbstractC1282a.b(this).hashCode();
    }

    public String toString() {
        return d() + " (Kotlin reflection is not available)";
    }
}
