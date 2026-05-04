package hd;

import cd.s;
import gd.e;
import gd.i;
import id.h;
import id.j;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import pd.o;
import pd.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f11295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f11296c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, o oVar, Object obj) {
            super(eVar);
            this.f11295b = oVar;
            this.f11296c = obj;
            t.d(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // id.a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i10 = this.f11294a;
            if (i10 == 0) {
                this.f11294a = 1;
                s.b(obj);
                t.d(this.f11295b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((o) t0.c(this.f11295b, 2)).invoke(this.f11296c, this);
            }
            if (i10 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f11294a = 2;
            s.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: hd.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0207b extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f11298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f11299c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0207b(e eVar, i iVar, o oVar, Object obj) {
            super(eVar, iVar);
            this.f11298b = oVar;
            this.f11299c = obj;
            t.d(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // id.a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i10 = this.f11297a;
            if (i10 == 0) {
                this.f11297a = 1;
                s.b(obj);
                t.d(this.f11298b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((o) t0.c(this.f11298b, 2)).invoke(this.f11299c, this);
            }
            if (i10 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f11297a = 2;
            s.b(obj);
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar) {
            super(eVar);
            t.d(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // id.a
        public Object invokeSuspend(Object obj) throws Throwable {
            s.b(obj);
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends id.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, i iVar) {
            super(eVar, iVar);
            t.d(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // id.a
        public Object invokeSuspend(Object obj) throws Throwable {
            s.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e a(o oVar, Object obj, e completion) {
        t.f(oVar, "<this>");
        t.f(completion, "completion");
        e eVarA = h.a(completion);
        if (oVar instanceof id.a) {
            return ((id.a) oVar).create(obj, eVarA);
        }
        i context = eVarA.getContext();
        return context == gd.j.f10531a ? new a(eVarA, oVar, obj) : new C0207b(eVarA, context, oVar, obj);
    }

    public static final e b(e eVar) {
        i context = eVar.getContext();
        return context == gd.j.f10531a ? new c(eVar) : new d(eVar, context);
    }

    public static e c(e eVar) {
        e eVarIntercepted;
        t.f(eVar, "<this>");
        id.d dVar = eVar instanceof id.d ? (id.d) eVar : null;
        return (dVar == null || (eVarIntercepted = dVar.intercepted()) == null) ? eVar : eVarIntercepted;
    }

    public static Object d(o oVar, Object obj, e completion) {
        t.f(oVar, "<this>");
        t.f(completion, "completion");
        return ((o) t0.c(oVar, 2)).invoke(obj, b(h.a(completion)));
    }

    public static Object e(p pVar, Object obj, Object obj2, e completion) {
        t.f(pVar, "<this>");
        t.f(completion, "completion");
        return ((p) t0.c(pVar, 3)).invoke(obj, obj2, b(h.a(completion)));
    }
}
