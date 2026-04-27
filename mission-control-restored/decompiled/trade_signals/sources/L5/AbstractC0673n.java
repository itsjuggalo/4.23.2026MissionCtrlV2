package L5;

import X5.AbstractC0990f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;
import p6.AbstractC2601d;
import r5.AbstractC2678a;

/* JADX INFO: renamed from: L5.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0673n {

    /* JADX INFO: renamed from: L5.n$a */
    public static final class a extends AbstractC0673n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f5204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f5205b;

        /* JADX INFO: renamed from: L5.n$a$a, reason: collision with other inner class name */
        public static final class C0074a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC2678a.a(((Method) obj).getName(), ((Method) obj2).getName());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class jClass) {
            super(null);
            AbstractC2304t.f(jClass, "jClass");
            this.f5204a = jClass;
            Method[] declaredMethods = jClass.getDeclaredMethods();
            AbstractC2304t.e(declaredMethods, "getDeclaredMethods(...)");
            this.f5205b = AbstractC2592n.b0(declaredMethods, new C0074a());
        }

        public static final CharSequence c(Method method) {
            Class<?> returnType = method.getReturnType();
            AbstractC2304t.e(returnType, "getReturnType(...)");
            return AbstractC0990f.f(returnType);
        }

        @Override // L5.AbstractC0673n
        public String a() {
            return p5.z.h0(this.f5205b, "", "<init>(", ")V", 0, null, C0671m.f5201a, 24, null);
        }

        public final List d() {
            return this.f5205b;
        }
    }

    /* JADX INFO: renamed from: L5.n$b */
    public static final class b extends AbstractC0673n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Constructor f5206a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor constructor) {
            super(null);
            AbstractC2304t.f(constructor, "constructor");
            this.f5206a = constructor;
        }

        public static final CharSequence c(Class cls) {
            AbstractC2304t.c(cls);
            return AbstractC0990f.f(cls);
        }

        @Override // L5.AbstractC0673n
        public String a() {
            Class<?>[] parameterTypes = this.f5206a.getParameterTypes();
            AbstractC2304t.e(parameterTypes, "getParameterTypes(...)");
            return AbstractC2592n.U(parameterTypes, "", "<init>(", ")V", 0, null, C0675o.f5213a, 24, null);
        }

        public final Constructor d() {
            return this.f5206a;
        }
    }

    /* JADX INFO: renamed from: L5.n$c */
    public static final class c extends AbstractC0673n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f5207a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            AbstractC2304t.f(method, "method");
            this.f5207a = method;
        }

        @Override // L5.AbstractC0673n
        public String a() {
            return h1.d(this.f5207a);
        }

        public final Method b() {
            return this.f5207a;
        }
    }

    /* JADX INFO: renamed from: L5.n$d */
    public static final class d extends AbstractC0673n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2601d.b f5208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5209b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbstractC2601d.b signature) {
            super(null);
            AbstractC2304t.f(signature, "signature");
            this.f5208a = signature;
            this.f5209b = signature.a();
        }

        @Override // L5.AbstractC0673n
        public String a() {
            return this.f5209b;
        }

        public final String b() {
            return this.f5208a.d();
        }
    }

    /* JADX INFO: renamed from: L5.n$e */
    public static final class e extends AbstractC0673n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2601d.b f5210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5211b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbstractC2601d.b signature) {
            super(null);
            AbstractC2304t.f(signature, "signature");
            this.f5210a = signature;
            this.f5211b = signature.a();
        }

        @Override // L5.AbstractC0673n
        public String a() {
            return this.f5211b;
        }

        public final String b() {
            return this.f5210a.d();
        }

        public final String c() {
            return this.f5210a.e();
        }
    }

    public AbstractC0673n() {
    }

    public abstract String a();

    public /* synthetic */ AbstractC0673n(AbstractC2296k abstractC2296k) {
        this();
    }
}
