package t5;

import B5.o;
import B5.p;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.V;
import o5.AbstractC2491s;
import s5.C2712j;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import u5.AbstractC2774a;
import u5.AbstractC2777d;
import u5.AbstractC2781h;
import u5.AbstractC2783j;

/* JADX INFO: renamed from: t5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2750b {

    /* JADX INFO: renamed from: t5.b$a */
    public static final class a extends AbstractC2783j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f23331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f23332c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC2707e interfaceC2707e, o oVar, Object obj) {
            super(interfaceC2707e);
            this.f23331b = oVar;
            this.f23332c = obj;
            AbstractC2304t.d(interfaceC2707e, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // u5.AbstractC2774a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i8 = this.f23330a;
            if (i8 == 0) {
                this.f23330a = 1;
                AbstractC2491s.b(obj);
                AbstractC2304t.d(this.f23331b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((o) V.c(this.f23331b, 2)).invoke(this.f23332c, this);
            }
            if (i8 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f23330a = 2;
            AbstractC2491s.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: t5.b$b, reason: collision with other inner class name */
    public static final class C0404b extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f23334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f23335c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0404b(InterfaceC2707e interfaceC2707e, InterfaceC2711i interfaceC2711i, o oVar, Object obj) {
            super(interfaceC2707e, interfaceC2711i);
            this.f23334b = oVar;
            this.f23335c = obj;
            AbstractC2304t.d(interfaceC2707e, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // u5.AbstractC2774a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i8 = this.f23333a;
            if (i8 == 0) {
                this.f23333a = 1;
                AbstractC2491s.b(obj);
                AbstractC2304t.d(this.f23334b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((o) V.c(this.f23334b, 2)).invoke(this.f23335c, this);
            }
            if (i8 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f23333a = 2;
            AbstractC2491s.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: t5.b$c */
    public static final class c extends AbstractC2783j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
            AbstractC2304t.d(interfaceC2707e, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // u5.AbstractC2774a
        public Object invokeSuspend(Object obj) throws Throwable {
            AbstractC2491s.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: t5.b$d */
    public static final class d extends AbstractC2777d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC2707e interfaceC2707e, InterfaceC2711i interfaceC2711i) {
            super(interfaceC2707e, interfaceC2711i);
            AbstractC2304t.d(interfaceC2707e, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // u5.AbstractC2774a
        public Object invokeSuspend(Object obj) throws Throwable {
            AbstractC2491s.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static InterfaceC2707e a(o oVar, Object obj, InterfaceC2707e completion) {
        AbstractC2304t.f(oVar, "<this>");
        AbstractC2304t.f(completion, "completion");
        InterfaceC2707e interfaceC2707eA = AbstractC2781h.a(completion);
        if (oVar instanceof AbstractC2774a) {
            return ((AbstractC2774a) oVar).create(obj, interfaceC2707eA);
        }
        InterfaceC2711i context = interfaceC2707eA.getContext();
        return context == C2712j.f23116a ? new a(interfaceC2707eA, oVar, obj) : new C0404b(interfaceC2707eA, context, oVar, obj);
    }

    public static final InterfaceC2707e b(InterfaceC2707e interfaceC2707e) {
        InterfaceC2711i context = interfaceC2707e.getContext();
        return context == C2712j.f23116a ? new c(interfaceC2707e) : new d(interfaceC2707e, context);
    }

    public static InterfaceC2707e c(InterfaceC2707e interfaceC2707e) {
        InterfaceC2707e interfaceC2707eIntercepted;
        AbstractC2304t.f(interfaceC2707e, "<this>");
        AbstractC2777d abstractC2777d = interfaceC2707e instanceof AbstractC2777d ? (AbstractC2777d) interfaceC2707e : null;
        return (abstractC2777d == null || (interfaceC2707eIntercepted = abstractC2777d.intercepted()) == null) ? interfaceC2707e : interfaceC2707eIntercepted;
    }

    public static Object d(o oVar, Object obj, InterfaceC2707e completion) {
        AbstractC2304t.f(oVar, "<this>");
        AbstractC2304t.f(completion, "completion");
        return ((o) V.c(oVar, 2)).invoke(obj, b(AbstractC2781h.a(completion)));
    }

    public static Object e(p pVar, Object obj, Object obj2, InterfaceC2707e completion) {
        AbstractC2304t.f(pVar, "<this>");
        AbstractC2304t.f(completion, "completion");
        return ((p) V.c(pVar, 3)).invoke(obj, obj2, b(AbstractC2781h.a(completion)));
    }
}
