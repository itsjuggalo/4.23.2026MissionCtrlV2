package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1293m {

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.m$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f15036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f15037b;

        public /* synthetic */ a(Object obj, T t8) {
            AbstractC1294n.j(obj);
            this.f15037b = obj;
            this.f15036a = new ArrayList();
        }

        public a a(String str, Object obj) {
            AbstractC1294n.j(str);
            this.f15036a.add(str + com.amazon.a.a.o.b.f.f14101b + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f15037b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f15036a.size();
            for (int i8 = 0; i8 < size; i8++) {
                sb.append((String) this.f15036a.get(i8));
                if (i8 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, null);
    }
}
