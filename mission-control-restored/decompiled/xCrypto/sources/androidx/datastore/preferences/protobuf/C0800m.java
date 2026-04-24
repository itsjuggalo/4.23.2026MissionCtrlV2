package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0806t;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0800m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile C0800m f7115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0800m f7116c = new C0800m(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7117a = Collections.EMPTY_MAP;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.m$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f7118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7119b;

        public a(Object obj, int i4) {
            this.f7118a = obj;
            this.f7119b = i4;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7118a == aVar.f7118a && this.f7119b == aVar.f7119b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f7118a) * 65535) + this.f7119b;
        }
    }

    public C0800m(boolean z4) {
    }

    public static C0800m b() {
        C0800m c0800mA;
        if (U.f6956d) {
            return f7116c;
        }
        C0800m c0800m = f7115b;
        if (c0800m != null) {
            return c0800m;
        }
        synchronized (C0800m.class) {
            try {
                c0800mA = f7115b;
                if (c0800mA == null) {
                    c0800mA = AbstractC0799l.a();
                    f7115b = c0800mA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0800mA;
    }

    public AbstractC0806t.c a(J j4, int i4) {
        android.support.v4.media.session.b.a(this.f7117a.get(new a(j4, i4)));
        return null;
    }
}
