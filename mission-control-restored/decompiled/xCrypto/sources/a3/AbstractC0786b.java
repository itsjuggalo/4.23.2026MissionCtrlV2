package a3;

import W2.q;
import Z2.e;
import Z2.i;
import b3.AbstractC0863a;
import b3.AbstractC0866d;
import b3.h;
import b3.j;
import i3.o;
import i3.p;
import kotlin.jvm.internal.K;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: a3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0786b {

    /* JADX INFO: renamed from: a3.b$a */
    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f6192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f6193c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, o oVar, Object obj) {
            super(eVar);
            this.f6192b = oVar;
            this.f6193c = obj;
            r.d(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // b3.AbstractC0863a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i4 = this.f6191a;
            if (i4 == 0) {
                this.f6191a = 1;
                q.b(obj);
                r.d(this.f6192b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((o) K.b(this.f6192b, 2)).invoke(this.f6193c, this);
            }
            if (i4 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f6191a = 2;
            q.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: a3.b$b, reason: collision with other inner class name */
    public static final class C0091b extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f6195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f6196c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0091b(e eVar, i iVar, o oVar, Object obj) {
            super(eVar, iVar);
            this.f6195b = oVar;
            this.f6196c = obj;
            r.d(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // b3.AbstractC0863a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i4 = this.f6194a;
            if (i4 == 0) {
                this.f6194a = 1;
                q.b(obj);
                r.d(this.f6195b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((o) K.b(this.f6195b, 2)).invoke(this.f6196c, this);
            }
            if (i4 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f6194a = 2;
            q.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: a3.b$c */
    public static final class c extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar) {
            super(eVar);
            r.d(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // b3.AbstractC0863a
        public Object invokeSuspend(Object obj) throws Throwable {
            q.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: a3.b$d */
    public static final class d extends AbstractC0866d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, i iVar) {
            super(eVar, iVar);
            r.d(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // b3.AbstractC0863a
        public Object invokeSuspend(Object obj) throws Throwable {
            q.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e a(o oVar, Object obj, e completion) {
        r.f(oVar, "<this>");
        r.f(completion, "completion");
        e eVarA = h.a(completion);
        if (oVar instanceof AbstractC0863a) {
            return ((AbstractC0863a) oVar).create(obj, eVarA);
        }
        i context = eVarA.getContext();
        return context == Z2.j.f6012a ? new a(eVarA, oVar, obj) : new C0091b(eVarA, context, oVar, obj);
    }

    public static final e b(e eVar) {
        i context = eVar.getContext();
        return context == Z2.j.f6012a ? new c(eVar) : new d(eVar, context);
    }

    public static e c(e eVar) {
        e eVarIntercepted;
        r.f(eVar, "<this>");
        AbstractC0866d abstractC0866d = eVar instanceof AbstractC0866d ? (AbstractC0866d) eVar : null;
        return (abstractC0866d == null || (eVarIntercepted = abstractC0866d.intercepted()) == null) ? eVar : eVarIntercepted;
    }

    public static Object d(p pVar, Object obj, Object obj2, e completion) {
        r.f(pVar, "<this>");
        r.f(completion, "completion");
        return ((p) K.b(pVar, 3)).invoke(obj, obj2, b(h.a(completion)));
    }
}
