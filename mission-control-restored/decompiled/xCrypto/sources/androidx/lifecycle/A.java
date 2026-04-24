package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1585j;
import o0.d;

/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f7616f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Class[] f7617g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f7620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f7621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d.c f7622e;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
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
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(UserMetadata.KEYDATA_FILENAME);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                Object obj = parcelableArrayList.get(i4);
                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i4));
            }
            return new A(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : A.f7617g) {
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
        this.f7618a = linkedHashMap;
        this.f7619b = new LinkedHashMap();
        this.f7620c = new LinkedHashMap();
        this.f7621d = new LinkedHashMap();
        this.f7622e = new d.c() { // from class: androidx.lifecycle.z
            @Override // o0.d.c
            public final Bundle a() {
                return A.d(this.f7727a);
            }
        };
        linkedHashMap.putAll(initialState);
    }

    public static final Bundle d(A this$0) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        for (Map.Entry entry : X2.L.q(this$0.f7619b).entrySet()) {
            this$0.e((String) entry.getKey(), ((d.c) entry.getValue()).a());
        }
        Set<String> setKeySet = this$0.f7618a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f7618a.get(str));
        }
        return D.b.a(W2.t.a(UserMetadata.KEYDATA_FILENAME, arrayList), W2.t.a("values", arrayList2));
    }

    public final d.c c() {
        return this.f7622e;
    }

    public final void e(String key, Object obj) {
        kotlin.jvm.internal.r.f(key, "key");
        if (!f7616f.b(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            kotlin.jvm.internal.r.c(obj);
            sb.append(obj.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj2 = this.f7620c.get(key);
        r rVar = obj2 instanceof r ? (r) obj2 : null;
        if (rVar != null) {
            rVar.setValue(obj);
        } else {
            this.f7618a.put(key, obj);
        }
        w3.o oVar = (w3.o) this.f7621d.get(key);
        if (oVar == null) {
            return;
        }
        oVar.setValue(obj);
    }

    public A() {
        this.f7618a = new LinkedHashMap();
        this.f7619b = new LinkedHashMap();
        this.f7620c = new LinkedHashMap();
        this.f7621d = new LinkedHashMap();
        this.f7622e = new d.c() { // from class: androidx.lifecycle.z
            @Override // o0.d.c
            public final Bundle a() {
                return A.d(this.f7727a);
            }
        };
    }
}
