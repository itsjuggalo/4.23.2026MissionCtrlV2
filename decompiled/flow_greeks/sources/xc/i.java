package xc;

import cc.q;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public enum i {
    COMPLETE;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f24806a;

        public a(Throwable th) {
            this.f24806a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return kc.b.c(this.f24806a, ((a) obj).f24806a);
            }
            return false;
        }

        public int hashCode() {
            return this.f24806a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f24806a + "]";
        }
    }

    public static boolean a(Object obj, q qVar) {
        if (obj == COMPLETE) {
            qVar.onComplete();
            return true;
        }
        if (obj instanceof a) {
            qVar.onError(((a) obj).f24806a);
            return true;
        }
        qVar.onNext(obj);
        return false;
    }

    public static Object b() {
        return COMPLETE;
    }

    public static Object c(Throwable th) {
        return new a(th);
    }

    public static Throwable h(Object obj) {
        return ((a) obj).f24806a;
    }

    public static boolean k(Object obj) {
        return obj == COMPLETE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object i(Object obj) {
        return obj;
    }

    public static Object l(Object obj) {
        return obj;
    }
}
