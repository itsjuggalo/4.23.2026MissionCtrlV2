package com.google.protobuf;

import com.google.protobuf.AbstractC1480t;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1474m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f16491b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile C1474m f16492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1474m f16493d = new C1474m(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f16494a = Collections.emptyMap();

    /* JADX INFO: renamed from: com.google.protobuf.m$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f16495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f16496b;

        public a(Object obj, int i8) {
            this.f16495a = obj;
            this.f16496b = i8;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f16495a == aVar.f16495a && this.f16496b == aVar.f16496b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f16495a) * 65535) + this.f16496b;
        }
    }

    public C1474m(boolean z7) {
    }

    public static C1474m b() {
        if (!f16491b) {
            return f16493d;
        }
        C1474m c1474mA = f16492c;
        if (c1474mA == null) {
            synchronized (C1474m.class) {
                try {
                    c1474mA = f16492c;
                    if (c1474mA == null) {
                        c1474mA = AbstractC1473l.a();
                        f16492c = c1474mA;
                    }
                } finally {
                }
            }
        }
        return c1474mA;
    }

    public AbstractC1480t.c a(J j8, int i8) {
        android.support.v4.media.session.b.a(this.f16494a.get(new a(j8, i8)));
        return null;
    }
}
