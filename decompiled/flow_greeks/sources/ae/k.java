package ae;

import ae.h;
import ae.i;
import dd.q;
import dd.r;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f791c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends k implements g {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f792d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Method unboxMethod, Object obj) {
            super(unboxMethod, r.k(), null);
            t.f(unboxMethod, "unboxMethod");
            this.f792d = obj;
        }

        @Override // ae.h
        public Object call(Object[] args) {
            t.f(args, "args");
            e(args);
            return d(this.f792d, args);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends k {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method unboxMethod) {
            super(unboxMethod, q.e(unboxMethod.getDeclaringClass()), null);
            t.f(unboxMethod, "unboxMethod");
        }

        @Override // ae.h
        public Object call(Object[] args) {
            t.f(args, "args");
            e(args);
            Object obj = args[0];
            i.d dVar = i.f774e;
            return d(obj, args.length <= 1 ? new Object[0] : dd.l.m(args, 1, args.length));
        }
    }

    public /* synthetic */ k(Method method, List list, kotlin.jvm.internal.k kVar) {
        this(method, list);
    }

    @Override // ae.h
    public final List a() {
        return this.f790b;
    }

    @Override // ae.h
    public boolean c() {
        return h.a.b(this);
    }

    public final Object d(Object obj, Object[] args) {
        t.f(args, "args");
        return this.f789a.invoke(obj, Arrays.copyOf(args, args.length));
    }

    public void e(Object[] objArr) {
        h.a.a(this, objArr);
    }

    @Override // ae.h
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Method b() {
        return null;
    }

    @Override // ae.h
    public final Type getReturnType() {
        return this.f791c;
    }

    public k(Method method, List list) {
        this.f789a = method;
        this.f790b = list;
        Class<?> returnType = method.getReturnType();
        t.e(returnType, "getReturnType(...)");
        this.f791c = returnType;
    }
}
