package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0948t;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0942m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile C0942m f7523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0942m f7524c = new C0942m(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7525a = Collections.emptyMap();

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.m$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f7526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7527b;

        public a(Object obj, int i7) {
            this.f7526a = obj;
            this.f7527b = i7;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7526a == aVar.f7526a && this.f7527b == aVar.f7527b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f7526a) * 65535) + this.f7527b;
        }
    }

    public C0942m(boolean z7) {
    }

    public static C0942m b() {
        if (U.f7364d) {
            return f7524c;
        }
        C0942m c0942mA = f7523b;
        if (c0942mA == null) {
            synchronized (C0942m.class) {
                try {
                    c0942mA = f7523b;
                    if (c0942mA == null) {
                        c0942mA = AbstractC0941l.a();
                        f7523b = c0942mA;
                    }
                } finally {
                }
            }
        }
        return c0942mA;
    }

    public AbstractC0948t.c a(J j7, int i7) {
        android.support.v4.media.session.b.a(this.f7525a.get(new a(j7, i7)));
        return null;
    }
}
