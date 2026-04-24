package L5;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a1 {

    public static class a extends b implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0 f5141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile SoftReference f5142c;

        public a(Object obj, Function0 function0) {
            if (function0 == null) {
                g(0);
            }
            this.f5142c = null;
            this.f5141b = function0;
            if (obj != null) {
                this.f5142c = new SoftReference(a(obj));
            }
        }

        public static /* synthetic */ void g(int i8) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        @Override // L5.a1.b, kotlin.jvm.functions.Function0
        public Object invoke() {
            Object obj;
            SoftReference softReference = this.f5142c;
            if (softReference != null && (obj = softReference.get()) != null) {
                return c(obj);
            }
            Object objInvoke = this.f5141b.invoke();
            this.f5142c = new SoftReference(a(objInvoke));
            return objInvoke;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Object f5143a = new a();

        public static class a {
        }

        public Object a(Object obj) {
            return obj == null ? f5143a : obj;
        }

        public final Object b(Object obj, Object obj2) {
            return invoke();
        }

        public Object c(Object obj) {
            if (obj == f5143a) {
                return null;
            }
            return obj;
        }

        public abstract Object invoke();
    }

    public static /* synthetic */ void a(int i8) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
    }

    public static a b(Object obj, Function0 function0) {
        if (function0 == null) {
            a(0);
        }
        return new a(obj, function0);
    }

    public static a c(Function0 function0) {
        if (function0 == null) {
            a(1);
        }
        return b(null, function0);
    }
}
