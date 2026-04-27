package M5;

import M5.h;
import M5.i;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;
import p5.AbstractC2594p;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f5412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f5414c;

    public static final class a extends k implements g {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f5415d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Method unboxMethod, Object obj) {
            super(unboxMethod, AbstractC2595q.i(), null);
            AbstractC2304t.f(unboxMethod, "unboxMethod");
            this.f5415d = obj;
        }

        @Override // M5.h
        public Object call(Object[] args) {
            AbstractC2304t.f(args, "args");
            e(args);
            return d(this.f5415d, args);
        }
    }

    public static final class b extends k {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method unboxMethod) {
            super(unboxMethod, AbstractC2594p.e(unboxMethod.getDeclaringClass()), null);
            AbstractC2304t.f(unboxMethod, "unboxMethod");
        }

        @Override // M5.h
        public Object call(Object[] args) {
            AbstractC2304t.f(args, "args");
            e(args);
            Object obj = args[0];
            i.d dVar = i.f5397e;
            return d(obj, args.length <= 1 ? new Object[0] : AbstractC2590l.m(args, 1, args.length));
        }
    }

    public k(Method method, List list) {
        this.f5412a = method;
        this.f5413b = list;
        Class<?> returnType = method.getReturnType();
        AbstractC2304t.e(returnType, "getReturnType(...)");
        this.f5414c = returnType;
    }

    @Override // M5.h
    public final List a() {
        return this.f5413b;
    }

    @Override // M5.h
    public boolean c() {
        return h.a.b(this);
    }

    public final Object d(Object obj, Object[] args) {
        AbstractC2304t.f(args, "args");
        return this.f5412a.invoke(obj, Arrays.copyOf(args, args.length));
    }

    public void e(Object[] objArr) {
        h.a.a(this, objArr);
    }

    @Override // M5.h
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Method b() {
        return null;
    }

    @Override // M5.h
    public final Type getReturnType() {
        return this.f5414c;
    }

    public /* synthetic */ k(Method method, List list, AbstractC2296k abstractC2296k) {
        this(method, list);
    }
}
