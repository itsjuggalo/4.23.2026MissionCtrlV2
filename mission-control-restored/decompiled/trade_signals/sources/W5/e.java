package W5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static final Class a(ClassLoader classLoader, String fqName) {
        AbstractC2304t.f(classLoader, "<this>");
        AbstractC2304t.f(fqName, "fqName");
        try {
            return Class.forName(fqName, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
