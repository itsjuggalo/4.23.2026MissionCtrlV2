package i6;

import i6.C1986n0;
import j6.C2232F;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import z6.EnumC3021e;

/* JADX INFO: renamed from: i6.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1970f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1973h f18867a = new C1973h(EnumC1979k.f18896b, null, false, false, 8, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1973h f18868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1973h f18869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f18870d;

    static {
        EnumC1979k enumC1979k = EnumC1979k.f18897c;
        f18868b = new C1973h(enumC1979k, null, false, false, 8, null);
        f18869c = new C1973h(enumC1979k, null, true, false, 8, null);
        C2232F c2232f = C2232F.f20124a;
        String strH = c2232f.h("Object");
        String strG = c2232f.g("Predicate");
        String strG2 = c2232f.g("Function");
        String strG3 = c2232f.g("Consumer");
        String strG4 = c2232f.g("BiFunction");
        String strG5 = c2232f.g("BiConsumer");
        String strG6 = c2232f.g("UnaryOperator");
        String strI = c2232f.i("stream/Stream");
        String strI2 = c2232f.i("Optional");
        C1986n0 c1986n0 = new C1986n0();
        C1986n0.a.b(new C1986n0.a(c1986n0, c2232f.i("Iterator")), "forEachRemaining", null, new C1983m(strG3), 2, null);
        C1986n0.a.b(new C1986n0.a(c1986n0, c2232f.h("Iterable")), "spliterator", null, new C2002x(c2232f), 2, null);
        C1986n0.a aVar = new C1986n0.a(c1986n0, c2232f.i("Collection"));
        C1986n0.a.b(aVar, "removeIf", null, new C1942I(strG), 2, null);
        C1986n0.a.b(aVar, "stream", null, new C1953U(strI), 2, null);
        C1986n0.a.b(aVar, "parallelStream", null, new C1958Z(strI), 2, null);
        C1986n0.a aVar2 = new C1986n0.a(c1986n0, c2232f.i("List"));
        C1986n0.a.b(aVar2, "replaceAll", null, new C1960a0(strG6), 2, null);
        aVar2.a("addFirst", "2.1", new C1962b0(strH));
        aVar2.a("addLast", "2.1", new C1964c0(strH));
        aVar2.a("removeFirst", "2.1", new C1966d0(strH));
        aVar2.a("removeLast", "2.1", new C1968e0(strH));
        C1986n0.a aVar3 = new C1986n0.a(c1986n0, c2232f.i("LinkedList"));
        aVar3.a("addFirst", "2.1", new C1985n(strH));
        aVar3.a("addLast", "2.1", new C1987o(strH));
        aVar3.a("removeFirst", "2.1", new C1989p(strH));
        aVar3.a("removeLast", "2.1", new C1991q(strH));
        C1986n0.a aVar4 = new C1986n0.a(c1986n0, c2232f.i("LinkedHashSet"));
        aVar4.a("addFirst", "2.2", new C1993r(strH));
        aVar4.a("addLast", "2.2", new C1995s(strH));
        aVar4.a("removeFirst", "2.2", new C1997t(strH));
        aVar4.a("removeLast", "2.2", new C1999u(strH));
        aVar4.a("getFirst", "2.2", new C2000v(strH));
        aVar4.a("getLast", "2.2", new C2001w(strH));
        C1986n0.a aVar5 = new C1986n0.a(c1986n0, c2232f.i("Map"));
        C1986n0.a.b(aVar5, "forEach", null, new C2003y(strG5), 2, null);
        C1986n0.a.b(aVar5, "putIfAbsent", null, new C2004z(strH), 2, null);
        C1986n0.a.b(aVar5, "replace", null, new C1934A(strH), 2, null);
        C1986n0.a.b(aVar5, "replace", null, new C1935B(strH), 2, null);
        C1986n0.a.b(aVar5, "replaceAll", null, new C1936C(strG4), 2, null);
        C1986n0.a.b(aVar5, "compute", null, new C1937D(strH, strG4), 2, null);
        C1986n0.a.b(aVar5, "computeIfAbsent", null, new C1938E(strH, strG2), 2, null);
        C1986n0.a.b(aVar5, "computeIfPresent", null, new C1939F(strH, strG4), 2, null);
        C1986n0.a.b(aVar5, "merge", null, new C1940G(strH, strG4), 2, null);
        C1986n0.a aVar6 = new C1986n0.a(c1986n0, c2232f.i("LinkedHashMap"));
        aVar6.a("putFirst", "2.2", new C1941H(strH));
        aVar6.a("putLast", "2.2", new C1943J(strH));
        C1986n0.a aVar7 = new C1986n0.a(c1986n0, strI2);
        C1986n0.a.b(aVar7, "empty", null, new C1944K(strI2), 2, null);
        C1986n0.a.b(aVar7, "of", null, new C1945L(strH, strI2), 2, null);
        C1986n0.a.b(aVar7, "ofNullable", null, new C1946M(strH, strI2), 2, null);
        C1986n0.a.b(aVar7, com.amazon.a.a.o.b.au, null, new C1947N(strH), 2, null);
        C1986n0.a.b(aVar7, "ifPresent", null, new C1948O(strG3), 2, null);
        C1986n0.a.b(new C1986n0.a(c1986n0, c2232f.h("ref/Reference")), com.amazon.a.a.o.b.au, null, new C1949P(strH), 2, null);
        C1986n0.a.b(new C1986n0.a(c1986n0, strG), "test", null, new C1950Q(strH), 2, null);
        C1986n0.a.b(new C1986n0.a(c1986n0, c2232f.g("BiPredicate")), "test", null, new C1951S(strH), 2, null);
        C1986n0.a.b(new C1986n0.a(c1986n0, strG3), "accept", null, new C1952T(strH), 2, null);
        C1986n0.a.b(new C1986n0.a(c1986n0, strG5), "accept", null, new C1954V(strH), 2, null);
        C1986n0.a.b(new C1986n0.a(c1986n0, strG2), "apply", null, new C1955W(strH), 2, null);
        C1986n0.a.b(new C1986n0.a(c1986n0, strG4), "apply", null, new C1956X(strH), 2, null);
        C1986n0.a.b(new C1986n0.a(c1986n0, c2232f.g("Supplier")), com.amazon.a.a.o.b.au, null, new C1957Y(strH), 2, null);
        f18870d = c1986n0.b();
    }

    public static final C2470H A(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        function.b(str, c1973h);
        function.c(str, f18867a);
        return C2470H.f21956a;
    }

    public static final C2470H B(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        function.b(str, c1973h);
        function.c(str, f18867a);
        return C2470H.f21956a;
    }

    public static final C2470H C(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18868b, f18869c);
        return C2470H.f21956a;
    }

    public static final C2470H D(String str, String str2, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18869c;
        function.b(str, c1973h);
        function.c(str2, f18868b, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H E(String str, String str2, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.b(str, f18867a);
        function.c(str2, f18868b, f18869c);
        return C2470H.f21956a;
    }

    public static final C2470H F(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18869c);
        return C2470H.f21956a;
    }

    public static final C2470H G(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.b(str, f18868b, f18869c);
        return C2470H.f21956a;
    }

    public static final C2470H H(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18867a);
        return C2470H.f21956a;
    }

    public static final C2470H I(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.b(str, f18868b);
        function.d(EnumC3021e.BOOLEAN);
        return C2470H.f21956a;
    }

    public static final C2470H J(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        function.b(str, c1973h);
        function.d(EnumC3021e.BOOLEAN);
        return C2470H.f21956a;
    }

    public static final C2470H K(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.b(str, f18868b);
        return C2470H.f21956a;
    }

    public static final Map K0() {
        return f18870d;
    }

    public static final C2470H L(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        function.b(str, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H M(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        function.c(str, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H N(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        function.b(str, c1973h);
        function.c(str, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H O(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H P(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h, c1973h);
        function.d(EnumC3021e.BOOLEAN);
        return C2470H.f21956a;
    }

    public static final C2470H Q(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.c(str, c1973h, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H R(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.c(str, c1973h, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H a(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H b(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.b(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H c(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H d(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H e(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H f(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.b(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H g(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.b(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H h(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.b(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H i(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H j(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H k(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.b(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H l(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.b(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H m(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H n(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H o(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H p(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        function.c(str, f18868b);
        return C2470H.f21956a;
    }

    public static final C2470H q(C2232F c2232f, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        String strI = c2232f.i("Spliterator");
        C1973h c1973h = f18868b;
        function.c(strI, c1973h, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H r(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h, c1973h, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H s(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        function.b(str, c1973h);
        function.c(str, f18867a);
        return C2470H.f21956a;
    }

    public static final C2470H t(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        function.b(str, c1973h);
        function.c(str, f18867a);
        return C2470H.f21956a;
    }

    public static final C2470H u(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        function.b(str, c1973h);
        function.b(str, c1973h);
        function.d(EnumC3021e.BOOLEAN);
        return C2470H.f21956a;
    }

    public static final C2470H v(String str, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h, c1973h, c1973h, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H w(String str, String str2, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        C1973h c1973h2 = f18867a;
        function.b(str2, c1973h, c1973h, c1973h2, c1973h2);
        function.c(str, c1973h2);
        return C2470H.f21956a;
    }

    public static final C2470H x(String str, String str2, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        function.b(str2, c1973h, c1973h, c1973h);
        function.c(str, c1973h);
        return C2470H.f21956a;
    }

    public static final C2470H y(String str, String str2, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        C1973h c1973h2 = f18869c;
        C1973h c1973h3 = f18867a;
        function.b(str2, c1973h, c1973h, c1973h2, c1973h3);
        function.c(str, c1973h3);
        return C2470H.f21956a;
    }

    public static final C2470H z(String str, String str2, C1986n0.a.C0317a function) {
        AbstractC2304t.f(function, "$this$function");
        C1973h c1973h = f18868b;
        function.b(str, c1973h);
        C1973h c1973h2 = f18869c;
        function.b(str, c1973h2);
        C1973h c1973h3 = f18867a;
        function.b(str2, c1973h, c1973h2, c1973h2, c1973h3);
        function.c(str, c1973h3);
        return C2470H.f21956a;
    }
}
