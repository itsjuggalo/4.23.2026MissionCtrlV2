package ee;

import ce.o;
import dd.v0;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import xe.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f8763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f8764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f8765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f8766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f8767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f8768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set f8769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set f8770h;

    static {
        x xVar = new x();
        f8763a = xVar;
        f0 f0Var = f0.f24840a;
        f8764b = v0.m(f0Var.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f8765c = v0.l(v0.l(v0.l(v0.l(v0.l(v0.l(xVar.b(), f0Var.f("List", "sort(Ljava/util/Comparator;)V", "reversed()Ljava/util/List;")), f0Var.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), f0Var.e("Double", "isInfinite()Z", "isNaN()Z")), f0Var.e("Float", "isInfinite()Z", "isNaN()Z")), f0Var.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), f0Var.e("CharSequence", "isEmpty()Z"));
        f8766d = f0Var.f("List", "getFirst()Ljava/lang/Object;", "getLast()Ljava/lang/Object;");
        f8767e = v0.l(v0.l(v0.l(v0.l(v0.l(v0.l(f0Var.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), f0Var.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), f0Var.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), f0Var.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), f0Var.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), f0Var.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;")), f0Var.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f8768f = v0.l(v0.l(f0Var.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), f0Var.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;")), f0Var.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Set setA = xVar.a();
        String[] strArrB = f0Var.b("D");
        Set setL = v0.l(setA, f0Var.e("Float", (String[]) Arrays.copyOf(strArrB, strArrB.length)));
        String[] strArrB2 = f0Var.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        f8769g = v0.l(setL, f0Var.e("String", (String[]) Arrays.copyOf(strArrB2, strArrB2.length)));
        String[] strArrB3 = f0Var.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f8770h = f0Var.e("Throwable", (String[]) Arrays.copyOf(strArrB3, strArrB3.length));
    }

    public final Set a() {
        f0 f0Var = f0.f24840a;
        of.e eVar = of.e.BOOLEAN;
        of.e eVar2 = of.e.BYTE;
        List listN = dd.r.n(eVar, eVar2, of.e.DOUBLE, of.e.FLOAT, eVar2, of.e.INT, of.e.LONG, of.e.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listN.iterator();
        while (it.hasNext()) {
            String strB = ((of.e) it.next()).l().f().b();
            kotlin.jvm.internal.t.e(strB, "asString(...)");
            String[] strArrB = f0Var.b("Ljava/lang/String;");
            dd.w.z(linkedHashSet, f0Var.e(strB, (String[]) Arrays.copyOf(strArrB, strArrB.length)));
        }
        return linkedHashSet;
    }

    public final Set b() {
        f0 f0Var = f0.f24840a;
        List<of.e> listN = dd.r.n(of.e.BOOLEAN, of.e.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (of.e eVar : listN) {
            String strB = eVar.l().f().b();
            kotlin.jvm.internal.t.e(strB, "asString(...)");
            dd.w.z(linkedHashSet, f0Var.e(strB, eVar.i() + "Value()" + eVar.h()));
        }
        return linkedHashSet;
    }

    public final Set c() {
        return f8766d;
    }

    public final Set d() {
        return f8764b;
    }

    public final Set e() {
        return f8769g;
    }

    public final Set f() {
        return f8765c;
    }

    public final Set g() {
        return f8768f;
    }

    public final Set h() {
        return f8770h;
    }

    public final Set i() {
        return f8767e;
    }

    public final boolean j(ef.d fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return kotlin.jvm.internal.t.b(fqName, o.a.f3989i) || ce.o.e(fqName);
    }

    public final boolean k(ef.d fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        if (j(fqName)) {
            return true;
        }
        ef.b bVarN = c.f8681a.n(fqName);
        if (bVarN == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(bVarN.a().a()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
