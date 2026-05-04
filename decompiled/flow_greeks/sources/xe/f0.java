package xe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f24840a = new f0();

    public static final CharSequence k(String it) {
        kotlin.jvm.internal.t.f(it, "it");
        return f24840a.c(it);
    }

    public final String[] b(String... signatures) {
        kotlin.jvm.internal.t.f(signatures, "signatures");
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
        kotlin.jvm.internal.t.f(internalName, "internalName");
        kotlin.jvm.internal.t.f(signatures, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : signatures) {
            linkedHashSet.add(internalName + com.amazon.a.a.o.c.a.b.f4610a + str);
        }
        return linkedHashSet;
    }

    public final Set e(String name, String... signatures) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(signatures, "signatures");
        return d(h(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final Set f(String name, String... signatures) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(signatures, "signatures");
        return d(i(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final String g(String name) {
        kotlin.jvm.internal.t.f(name, "name");
        return "java/util/function/" + name;
    }

    public final String h(String name) {
        kotlin.jvm.internal.t.f(name, "name");
        return "java/lang/" + name;
    }

    public final String i(String name) {
        kotlin.jvm.internal.t.f(name, "name");
        return "java/util/" + name;
    }

    public final String j(String name, List parameters, String ret) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(parameters, "parameters");
        kotlin.jvm.internal.t.f(ret, "ret");
        return name + '(' + dd.a0.i0(parameters, "", null, null, 0, null, e0.f24839a, 30, null) + ')' + c(ret);
    }

    public final String l(String internalName, String jvmDescriptor) {
        kotlin.jvm.internal.t.f(internalName, "internalName");
        kotlin.jvm.internal.t.f(jvmDescriptor, "jvmDescriptor");
        return internalName + com.amazon.a.a.o.c.a.b.f4610a + jvmDescriptor;
    }
}
