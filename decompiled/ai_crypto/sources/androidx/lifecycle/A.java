package androidx.lifecycle;

import F0.d;
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
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f7714f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Class[] f7715g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f7718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f7719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d.c f7720e;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final A a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new A();
                }
                HashMap map = new HashMap();
                for (String key : bundle2.keySet()) {
                    kotlin.jvm.internal.r.e(key, "key");
                    map.put(key, bundle2.get(key));
                }
                return new A(map);
            }
            ClassLoader classLoader = A.class.getClassLoader();
            kotlin.jvm.internal.r.c(classLoader);
            bundle.setClassLoader(classLoader);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                Object obj = parcelableArrayList.get(i7);
                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i7));
            }
            return new A(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : A.f7715g) {
                kotlin.jvm.internal.r.c(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        public a() {
        }
    }

    public A(Map initialState) {
        kotlin.jvm.internal.r.f(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f7716a = linkedHashMap;
        this.f7717b = new LinkedHashMap();
        this.f7718c = new LinkedHashMap();
        this.f7719d = new LinkedHashMap();
        this.f7720e = new d.c() { // from class: androidx.lifecycle.z
            @Override // F0.d.c
            public final Bundle a() {
                return A.d(this.f7836a);
            }
        };
        linkedHashMap.putAll(initialState);
    }

    public static final Bundle d(A this$0) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        for (Map.Entry entry : F5.J.s(this$0.f7717b).entrySet()) {
            this$0.e((String) entry.getKey(), ((d.c) entry.getValue()).a());
        }
        Set<String> setKeySet = this$0.f7716a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f7716a.get(str));
        }
        return M.d.a(E5.t.a("keys", arrayList), E5.t.a("values", arrayList2));
    }

    public final d.c c() {
        return this.f7720e;
    }

    public final void e(String key, Object obj) {
        kotlin.jvm.internal.r.f(key, "key");
        if (!f7714f.b(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            kotlin.jvm.internal.r.c(obj);
            sb.append(obj.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj2 = this.f7718c.get(key);
        r rVar = obj2 instanceof r ? (r) obj2 : null;
        if (rVar != null) {
            rVar.n(obj);
        } else {
            this.f7716a.put(key, obj);
        }
        e6.o oVar = (e6.o) this.f7719d.get(key);
        if (oVar == null) {
            return;
        }
        oVar.setValue(obj);
    }

    public A() {
        this.f7716a = new LinkedHashMap();
        this.f7717b = new LinkedHashMap();
        this.f7718c = new LinkedHashMap();
        this.f7719d = new LinkedHashMap();
        this.f7720e = new d.c() { // from class: androidx.lifecycle.z
            @Override // F0.d.c
            public final Bundle a() {
                return A.d(this.f7836a);
            }
        };
    }
}
