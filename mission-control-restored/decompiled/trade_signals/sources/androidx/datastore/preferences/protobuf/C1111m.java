package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC1117t;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1111m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile C1111m f11335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1111m f11336c = new C1111m(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11337a = Collections.emptyMap();

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.m$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f11338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11339b;

        public a(Object obj, int i8) {
            this.f11338a = obj;
            this.f11339b = i8;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f11338a == aVar.f11338a && this.f11339b == aVar.f11339b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f11338a) * 65535) + this.f11339b;
        }
    }

    public C1111m(boolean z7) {
    }

    public static C1111m b() {
        if (U.f11176d) {
            return f11336c;
        }
        C1111m c1111mA = f11335b;
        if (c1111mA == null) {
            synchronized (C1111m.class) {
                try {
                    c1111mA = f11335b;
                    if (c1111mA == null) {
                        c1111mA = AbstractC1110l.a();
                        f11335b = c1111mA;
                    }
                } finally {
                }
            }
        }
        return c1111mA;
    }

    public AbstractC1117t.c a(J j8, int i8) {
        android.support.v4.media.session.b.a(this.f11337a.get(new a(j8, i8)));
        return null;
    }
}
