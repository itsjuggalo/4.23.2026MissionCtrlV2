package j6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: j6.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2232F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2232F f20124a = new C2232F();

    public static final CharSequence k(String it) {
        AbstractC2304t.f(it, "it");
        return f20124a.c(it);
    }

    public final String[] b(String... signatures) {
        AbstractC2304t.f(signatures, "signatures");
        ArrayList arrayList = new ArrayList(signatures.length);
        for (String str : signatures) {
            arrayList.add("<init>(" + str + ")V");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String c(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    public final Set d(String internalName, String... signatures) {
        AbstractC2304t.f(internalName, "internalName");
        AbstractC2304t.f(signatures, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : signatures) {
            linkedHashSet.add(internalName + com.amazon.a.a.o.c.a.b.f14112a + str);
        }
        return linkedHashSet;
    }

    public final Set e(String name, String... signatures) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(signatures, "signatures");
        return d(h(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final Set f(String name, String... signatures) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(signatures, "signatures");
        return d(i(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final String g(String name) {
        AbstractC2304t.f(name, "name");
        return "java/util/function/" + name;
    }

    public final String h(String name) {
        AbstractC2304t.f(name, "name");
        return "java/lang/" + name;
    }

    public final String i(String name) {
        AbstractC2304t.f(name, "name");
        return "java/util/" + name;
    }

    public final String j(String name, List parameters, String ret) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(parameters, "parameters");
        AbstractC2304t.f(ret, "ret");
        return name + '(' + p5.z.h0(parameters, "", null, null, 0, null, C2231E.f20123a, 30, null) + ')' + c(ret);
    }

    public final String l(String internalName, String jvmDescriptor) {
        AbstractC2304t.f(internalName, "internalName");
        AbstractC2304t.f(jvmDescriptor, "jvmDescriptor");
        return internalName + com.amazon.a.a.o.c.a.b.f14112a + jvmDescriptor;
    }
}
