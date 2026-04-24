package com.google.protobuf;

import com.google.protobuf.AbstractC1255y;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1248q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f12754b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile C1248q f12755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1248q f12756d = new C1248q(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f12757a = Collections.emptyMap();

    /* JADX INFO: renamed from: com.google.protobuf.q$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f12758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12759b;

        public a(Object obj, int i7) {
            this.f12758a = obj;
            this.f12759b = i7;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f12758a == aVar.f12758a && this.f12759b == aVar.f12759b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f12758a) * 65535) + this.f12759b;
        }
    }

    public C1248q(boolean z7) {
    }

    public static C1248q b() {
        if (!f12754b) {
            return f12756d;
        }
        C1248q c1248qA = f12755c;
        if (c1248qA == null) {
            synchronized (C1248q.class) {
                try {
                    c1248qA = f12755c;
                    if (c1248qA == null) {
                        c1248qA = AbstractC1247p.a();
                        f12755c = c1248qA;
                    }
                } finally {
                }
            }
        }
        return c1248qA;
    }

    public AbstractC1255y.c a(V v7, int i7) {
        android.support.v4.media.session.b.a(this.f12757a.get(new a(v7, i7)));
        return null;
    }
}
