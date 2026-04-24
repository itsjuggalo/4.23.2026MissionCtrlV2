package com.google.android.gms.common.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1206q {

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.q$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f11134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f11135b;

        public /* synthetic */ a(Object obj, d0 d0Var) {
            AbstractC1207s.k(obj);
            this.f11135b = obj;
            this.f11134a = new ArrayList();
        }

        public a a(String str, Object obj) {
            AbstractC1207s.k(str);
            this.f11134a.add(str + com.amazon.a.a.o.b.f.f9990b + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f11135b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f11134a.size();
            for (int i7 = 0; i7 < size; i7++) {
                sb.append((String) this.f11134a.get(i7));
                if (i7 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> setKeySet = bundle.keySet();
        if (!setKeySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!b(bundle.get(str), bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int c(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a d(Object obj) {
        return new a(obj, null);
    }
}
