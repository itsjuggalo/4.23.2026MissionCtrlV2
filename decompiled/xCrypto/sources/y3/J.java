package y3;

import Z2.i;
import t3.T0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f15961a = new F("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i3.o f15962b = a.f15965a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i3.o f15963c = b.f15966a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i3.o f15964d = c.f15967a;

    public static final class a extends kotlin.jvm.internal.s implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15965a = new a();

        public a() {
            super(2);
        }

        @Override // i3.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, i.b bVar) {
            if (!(bVar instanceof T0)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f15966a = new b();

        public b() {
            super(2);
        }

        @Override // i3.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final T0 invoke(T0 t02, i.b bVar) {
            if (t02 != null) {
                return t02;
            }
            if (bVar instanceof T0) {
                return (T0) bVar;
            }
            return null;
        }
    }

    public static final class c extends kotlin.jvm.internal.s implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f15967a = new c();

        public c() {
            super(2);
        }

        @Override // i3.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final N invoke(N n4, i.b bVar) {
            if (bVar instanceof T0) {
                T0 t02 = (T0) bVar;
                n4.a(t02, t02.f(n4.f15970a));
            }
            return n4;
        }
    }

    public static final void a(Z2.i iVar, Object obj) {
        if (obj == f15961a) {
            return;
        }
        if (obj instanceof N) {
            ((N) obj).b(iVar);
            return;
        }
        Object objFold = iVar.fold(null, f15963c);
        kotlin.jvm.internal.r.d(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((T0) objFold).e(iVar, obj);
    }

    public static final Object b(Z2.i iVar) {
        Object objFold = iVar.fold(0, f15962b);
        kotlin.jvm.internal.r.c(objFold);
        return objFold;
    }

    public static final Object c(Z2.i iVar, Object obj) {
        if (obj == null) {
            obj = b(iVar);
        }
        if (obj == 0) {
            return f15961a;
        }
        if (obj instanceof Integer) {
            return iVar.fold(new N(iVar, ((Number) obj).intValue()), f15964d);
        }
        kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((T0) obj).f(iVar);
    }
}
