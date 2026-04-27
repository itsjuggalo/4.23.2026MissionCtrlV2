package g6;

import H5.g;
import b6.T0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f14275a = new F("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Q5.o f14276b = a.f14279a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Q5.o f14277c = b.f14280a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Q5.o f14278d = c.f14281a;

    public static final class a extends kotlin.jvm.internal.s implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14279a = new a();

        public a() {
            super(2);
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, g.b bVar) {
            if (!(bVar instanceof T0)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14280a = new b();

        public b() {
            super(2);
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final T0 invoke(T0 t02, g.b bVar) {
            if (t02 != null) {
                return t02;
            }
            if (bVar instanceof T0) {
                return (T0) bVar;
            }
            return null;
        }
    }

    public static final class c extends kotlin.jvm.internal.s implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14281a = new c();

        public c() {
            super(2);
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final N invoke(N n7, g.b bVar) {
            if (bVar instanceof T0) {
                T0 t02 = (T0) bVar;
                n7.a(t02, t02.H(n7.f14284a));
            }
            return n7;
        }
    }

    public static final void a(H5.g gVar, Object obj) {
        if (obj == f14275a) {
            return;
        }
        if (obj instanceof N) {
            ((N) obj).b(gVar);
            return;
        }
        Object objFold = gVar.fold(null, f14277c);
        kotlin.jvm.internal.r.d(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((T0) objFold).O(gVar, obj);
    }

    public static final Object b(H5.g gVar) {
        Object objFold = gVar.fold(0, f14276b);
        kotlin.jvm.internal.r.c(objFold);
        return objFold;
    }

    public static final Object c(H5.g gVar, Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        if (obj == 0) {
            return f14275a;
        }
        if (obj instanceof Integer) {
            return gVar.fold(new N(gVar, ((Number) obj).intValue()), f14278d);
        }
        kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((T0) obj).H(gVar);
    }
}
