package j5;

import P4.q;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public enum i {
    COMPLETE;

    public static final class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f20114a;

        public a(Throwable th) {
            this.f20114a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return X4.b.c(this.f20114a, ((a) obj).f20114a);
            }
            return false;
        }

        public int hashCode() {
            return this.f20114a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f20114a + "]";
        }
    }

    public static boolean a(Object obj, q qVar) {
        if (obj == COMPLETE) {
            qVar.a();
            return true;
        }
        if (obj instanceof a) {
            qVar.onError(((a) obj).f20114a);
            return true;
        }
        qVar.c(obj);
        return false;
    }

    public static Object b() {
        return COMPLETE;
    }

    public static Object g(Throwable th) {
        return new a(th);
    }

    public static Throwable i(Object obj) {
        return ((a) obj).f20114a;
    }

    public static boolean l(Object obj) {
        return obj == COMPLETE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object k(Object obj) {
        return obj;
    }

    public static Object m(Object obj) {
        return obj;
    }
}
