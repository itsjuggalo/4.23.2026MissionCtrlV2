package S6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7775a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f7776b = false;

    public static class a {
        public String toString() {
            return "NULL_VALUE";
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f7777a;

        public b(Throwable th) {
            if (th == null) {
                a(0);
            }
            this.f7777a = th;
        }

        public static /* synthetic */ void a(int i8) {
            String str = i8 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i8 != 1 ? 3 : 2];
            if (i8 != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i8 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i8 != 1) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i8 == 1) {
                throw new IllegalStateException(str2);
            }
        }

        public Throwable b() {
            Throwable th = this.f7777a;
            if (th == null) {
                a(1);
            }
            return th;
        }

        public String toString() {
            return this.f7777a.toString();
        }

        public /* synthetic */ b(Throwable th, a aVar) {
            this(th);
        }
    }

    public static class c extends RuntimeException {
        public c(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    public static /* synthetic */ void a(int i8) {
        String str = (i8 == 1 || i8 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 1 || i8 == 2) ? 2 : 3];
        if (i8 == 1 || i8 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i8 != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i8 == 1 || i8 == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (i8 != 1 && i8 != 2) {
            if (i8 == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i8 != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String str2 = String.format(str, objArr);
        if (i8 != 1 && i8 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static Object b(Object obj) {
        if (obj == null && (obj = f7775a) == null) {
            a(1);
        }
        return obj;
    }

    public static Object c(Throwable th) {
        if (th == null) {
            a(3);
        }
        return new b(th, null);
    }

    public static Object d(Object obj) {
        if (obj == null) {
            a(4);
        }
        return e(f(obj));
    }

    public static Object e(Object obj) {
        if (obj == null) {
            a(0);
        }
        if (obj == f7775a) {
            return null;
        }
        return obj;
    }

    public static Object f(Object obj) {
        if (!(obj instanceof b)) {
            return obj;
        }
        Throwable thB = ((b) obj).b();
        if (f7776b && d.a(thB)) {
            throw new c(thB);
        }
        throw d.b(thB);
    }
}
