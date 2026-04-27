package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import z0.d;

/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f11912f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Class[] f11913g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f11915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f11916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f11917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d.c f11918e;

    public static final class a {
        public a() {
        }

        public final A a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new A();
                }
                HashMap map = new HashMap();
                for (String key : bundle2.keySet()) {
                    AbstractC2304t.e(key, "key");
                    map.put(key, bundle2.get(key));
                }
                return new A(map);
            }
            ClassLoader classLoader = A.class.getClassLoader();
            AbstractC2304t.c(classLoader);
            bundle.setClassLoader(classLoader);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                Object obj = parcelableArrayList.get(i8);
                AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i8));
            }
            return new A(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : A.f11913g) {
                AbstractC2304t.c(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public A() {
        this.f11914a = new LinkedHashMap();
        this.f11915b = new LinkedHashMap();
        this.f11916c = new LinkedHashMap();
        this.f11917d = new LinkedHashMap();
        this.f11918e = new d.c() { // from class: androidx.lifecycle.z
            @Override // z0.d.c
            public final Bundle a() {
                return A.d(this.f12023a);
            }
        };
    }

    public static final Bundle d(A this$0) {
        AbstractC2304t.f(this$0, "this$0");
        for (Map.Entry entry : p5.M.w(this$0.f11915b).entrySet()) {
            this$0.e((String) entry.getKey(), ((d.c) entry.getValue()).a());
        }
        Set<String> setKeySet = this$0.f11914a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f11914a.get(str));
        }
        return P.b.a(o5.w.a("keys", arrayList), o5.w.a("values", arrayList2));
    }

    public final d.c c() {
        return this.f11918e;
    }

    public final void e(String key, Object obj) {
        AbstractC2304t.f(key, "key");
        if (!f11912f.b(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            AbstractC2304t.c(obj);
            sb.append(obj.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj2 = this.f11916c.get(key);
        r rVar = obj2 instanceof r ? (r) obj2 : null;
        if (rVar != null) {
            rVar.setValue(obj);
        } else {
            this.f11914a.put(key, obj);
        }
        b7.o oVar = (b7.o) this.f11917d.get(key);
        if (oVar == null) {
            return;
        }
        oVar.setValue(obj);
    }

    public A(Map initialState) {
        AbstractC2304t.f(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f11914a = linkedHashMap;
        this.f11915b = new LinkedHashMap();
        this.f11916c = new LinkedHashMap();
        this.f11917d = new LinkedHashMap();
        this.f11918e = new d.c() { // from class: androidx.lifecycle.z
            @Override // z0.d.c
            public final Bundle a() {
                return A.d(this.f12023a);
            }
        };
        linkedHashMap.putAll(initialState);
    }
}
