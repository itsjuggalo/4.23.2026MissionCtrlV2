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
import k2.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f2489f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Class[] f2490g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f2493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f2494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d.c f2495e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final z a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new z();
                }
                HashMap map = new HashMap();
                for (String key : bundle2.keySet()) {
                    kotlin.jvm.internal.t.e(key, "key");
                    map.put(key, bundle2.get(key));
                }
                return new z(map);
            }
            ClassLoader classLoader = z.class.getClassLoader();
            kotlin.jvm.internal.t.c(classLoader);
            bundle.setClassLoader(classLoader);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = parcelableArrayList.get(i10);
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i10));
            }
            return new z(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : z.f2490g) {
                kotlin.jvm.internal.t.c(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        public a() {
        }
    }

    public z(Map initialState) {
        kotlin.jvm.internal.t.f(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f2491a = linkedHashMap;
        this.f2492b = new LinkedHashMap();
        this.f2493c = new LinkedHashMap();
        this.f2494d = new LinkedHashMap();
        this.f2495e = new d.c() { // from class: androidx.lifecycle.y
            @Override // k2.d.c
            public final Bundle a() {
                return z.d(this.f2488a);
            }
        };
        linkedHashMap.putAll(initialState);
    }

    public static final Bundle d(z this$0) {
        kotlin.jvm.internal.t.f(this$0, "this$0");
        for (Map.Entry entry : dd.o0.v(this$0.f2492b).entrySet()) {
            this$0.e((String) entry.getKey(), ((d.c) entry.getValue()).a());
        }
        Set<String> setKeySet = this$0.f2491a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f2491a.get(str));
        }
        return p0.b.a(cd.w.a("keys", arrayList), cd.w.a("values", arrayList2));
    }

    public final d.c c() {
        return this.f2495e;
    }

    public final void e(String key, Object obj) {
        kotlin.jvm.internal.t.f(key, "key");
        if (!f2489f.b(obj)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't put value with type ");
            kotlin.jvm.internal.t.c(obj);
            sb2.append(obj.getClass());
            sb2.append(" into saved state");
            throw new IllegalArgumentException(sb2.toString());
        }
        Object obj2 = this.f2493c.get(key);
        r rVar = obj2 instanceof r ? (r) obj2 : null;
        if (rVar != null) {
            rVar.setValue(obj);
        } else {
            this.f2491a.put(key, obj);
        }
        qg.o oVar = (qg.o) this.f2494d.get(key);
        if (oVar == null) {
            return;
        }
        oVar.setValue(obj);
    }

    public z() {
        this.f2491a = new LinkedHashMap();
        this.f2492b = new LinkedHashMap();
        this.f2493c = new LinkedHashMap();
        this.f2494d = new LinkedHashMap();
        this.f2495e = new d.c() { // from class: androidx.lifecycle.y
            @Override // k2.d.c
            public final Bundle a() {
                return z.d(this.f2488a);
            }
        };
    }
}
