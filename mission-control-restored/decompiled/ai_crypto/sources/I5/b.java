package I5;

import E5.q;
import H5.g;
import J5.h;
import J5.j;
import Q5.o;
import Q5.p;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f3049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f3050c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(H5.d dVar, o oVar, Object obj) {
            super(dVar);
            this.f3049b = oVar;
            this.f3050c = obj;
            r.d(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // J5.a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i7 = this.f3048a;
            if (i7 == 0) {
                this.f3048a = 1;
                q.b(obj);
                r.d(this.f3049b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((o) L.b(this.f3049b, 2)).invoke(this.f3050c, this);
            }
            if (i7 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f3048a = 2;
            q.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: I5.b$b, reason: collision with other inner class name */
    public static final class C0038b extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f3052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f3053c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0038b(H5.d dVar, g gVar, o oVar, Object obj) {
            super(dVar, gVar);
            this.f3052b = oVar;
            this.f3053c = obj;
            r.d(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // J5.a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i7 = this.f3051a;
            if (i7 == 0) {
                this.f3051a = 1;
                q.b(obj);
                r.d(this.f3052b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((o) L.b(this.f3052b, 2)).invoke(this.f3053c, this);
            }
            if (i7 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f3051a = 2;
            q.b(obj);
            return obj;
        }
    }

    public static final class c extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(H5.d dVar) {
            super(dVar);
            r.d(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // J5.a
        public Object invokeSuspend(Object obj) throws Throwable {
            q.b(obj);
            return obj;
        }
    }

    public static final class d extends J5.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(H5.d dVar, g gVar) {
            super(dVar, gVar);
            r.d(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // J5.a
        public Object invokeSuspend(Object obj) throws Throwable {
            q.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static H5.d a(o oVar, Object obj, H5.d completion) {
        r.f(oVar, "<this>");
        r.f(completion, "completion");
        H5.d dVarA = h.a(completion);
        if (oVar instanceof J5.a) {
            return ((J5.a) oVar).create(obj, dVarA);
        }
        g context = dVarA.getContext();
        return context == H5.h.f2671a ? new a(dVarA, oVar, obj) : new C0038b(dVarA, context, oVar, obj);
    }

    public static final H5.d b(H5.d dVar) {
        g context = dVar.getContext();
        return context == H5.h.f2671a ? new c(dVar) : new d(dVar, context);
    }

    public static H5.d c(H5.d dVar) {
        H5.d dVarIntercepted;
        r.f(dVar, "<this>");
        J5.d dVar2 = dVar instanceof J5.d ? (J5.d) dVar : null;
        return (dVar2 == null || (dVarIntercepted = dVar2.intercepted()) == null) ? dVar : dVarIntercepted;
    }

    public static Object d(p pVar, Object obj, Object obj2, H5.d completion) {
        r.f(pVar, "<this>");
        r.f(completion, "completion");
        return ((p) L.b(pVar, 3)).invoke(obj, obj2, b(h.a(completion)));
    }
}
