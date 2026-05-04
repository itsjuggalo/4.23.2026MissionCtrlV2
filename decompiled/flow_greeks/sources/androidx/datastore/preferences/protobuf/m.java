package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.t;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile m f1805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f1806c = new m(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f1807a = Collections.EMPTY_MAP;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f1808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1809b;

        public a(Object obj, int i10) {
            this.f1808a = obj;
            this.f1809b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1808a == aVar.f1808a && this.f1809b == aVar.f1809b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f1808a) * 65535) + this.f1809b;
        }
    }

    public m(boolean z10) {
    }

    public static m b() {
        m mVarA;
        if (t0.f1908d) {
            return f1806c;
        }
        m mVar = f1805b;
        if (mVar != null) {
            return mVar;
        }
        synchronized (m.class) {
            try {
                mVarA = f1805b;
                if (mVarA == null) {
                    mVarA = l.a();
                    f1805b = mVarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVarA;
    }

    public t.c a(j0 j0Var, int i10) {
        android.support.v4.media.session.b.a(this.f1807a.get(new a(j0Var, i10)));
        return null;
    }
}
