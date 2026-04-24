package d7;

import Y6.O0;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f17030a = new D("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final B5.o f17031b = new B5.o() { // from class: d7.H
        @Override // B5.o
        public final Object invoke(Object obj, Object obj2) {
            return K.d(obj, (InterfaceC2711i.b) obj2);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final B5.o f17032c = new B5.o() { // from class: d7.I
        @Override // B5.o
        public final Object invoke(Object obj, Object obj2) {
            return K.e((O0) obj, (InterfaceC2711i.b) obj2);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final B5.o f17033d = new B5.o() { // from class: d7.J
        @Override // B5.o
        public final Object invoke(Object obj, Object obj2) {
            return K.h((O) obj, (InterfaceC2711i.b) obj2);
        }
    };

    public static final Object d(Object obj, InterfaceC2711i.b bVar) {
        if (!(bVar instanceof O0)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
    }

    public static final O0 e(O0 o02, InterfaceC2711i.b bVar) {
        if (o02 != null) {
            return o02;
        }
        if (bVar instanceof O0) {
            return (O0) bVar;
        }
        return null;
    }

    public static final void f(InterfaceC2711i interfaceC2711i, Object obj) {
        if (obj == f17030a) {
            return;
        }
        if (obj instanceof O) {
            ((O) obj).b(interfaceC2711i);
            return;
        }
        Object objK = interfaceC2711i.K(null, f17032c);
        AbstractC2304t.d(objK, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((O0) objK).s0(interfaceC2711i, obj);
    }

    public static final Object g(InterfaceC2711i interfaceC2711i) {
        Object objK = interfaceC2711i.K(0, f17031b);
        AbstractC2304t.c(objK);
        return objK;
    }

    public static final O h(O o8, InterfaceC2711i.b bVar) {
        if (bVar instanceof O0) {
            O0 o02 = (O0) bVar;
            o8.a(o02, o02.W(o8.f17036a));
        }
        return o8;
    }

    public static final Object i(InterfaceC2711i interfaceC2711i, Object obj) {
        if (obj == null) {
            obj = g(interfaceC2711i);
        }
        if (obj == 0) {
            return f17030a;
        }
        if (obj instanceof Integer) {
            return interfaceC2711i.K(new O(interfaceC2711i, ((Number) obj).intValue()), f17033d);
        }
        AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((O0) obj).W(interfaceC2711i);
    }
}
