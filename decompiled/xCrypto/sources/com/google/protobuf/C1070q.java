package com.google.protobuf;

import com.google.protobuf.AbstractC1077y;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1070q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f11135b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile C1070q f11136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1070q f11137d = new C1070q(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11138a = Collections.EMPTY_MAP;

    /* JADX INFO: renamed from: com.google.protobuf.q$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f11139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11140b;

        public a(Object obj, int i4) {
            this.f11139a = obj;
            this.f11140b = i4;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f11139a == aVar.f11139a && this.f11140b == aVar.f11140b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f11139a) * 65535) + this.f11140b;
        }
    }

    public C1070q(boolean z4) {
    }

    public static C1070q b() {
        C1070q c1070qA;
        if (!f11135b) {
            return f11137d;
        }
        C1070q c1070q = f11136c;
        if (c1070q != null) {
            return c1070q;
        }
        synchronized (C1070q.class) {
            try {
                c1070qA = f11136c;
                if (c1070qA == null) {
                    c1070qA = AbstractC1069p.a();
                    f11136c = c1070qA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1070qA;
    }

    public AbstractC1077y.d a(W w4, int i4) {
        return (AbstractC1077y.d) this.f11138a.get(new a(w4, i4));
    }
}
