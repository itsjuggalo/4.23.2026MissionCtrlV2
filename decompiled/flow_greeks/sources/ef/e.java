package ef;

import cd.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kg.z;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8794a;

        static {
            int[] iArr = new int[k.values().length];
            try {
                iArr[k.f8870a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[k.f8872c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[k.f8871b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f8794a = iArr;
        }
    }

    public static final Object a(c cVar, Map values) {
        Object next;
        t.f(cVar, "<this>");
        t.f(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : values.entrySet()) {
            c cVar2 = (c) entry.getKey();
            if (t.b(cVar, cVar2) || b(cVar, cVar2)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int length = g((c) ((Map.Entry) next).getKey(), cVar).a().length();
                do {
                    Object next2 = it.next();
                    int length2 = g((c) ((Map.Entry) next2).getKey(), cVar).a().length();
                    if (length > length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry2 = (Map.Entry) next;
        if (entry2 != null) {
            return entry2.getValue();
        }
        return null;
    }

    public static final boolean b(c cVar, c packageName) {
        t.f(cVar, "<this>");
        t.f(packageName, "packageName");
        return t.b(f(cVar), packageName);
    }

    public static final boolean c(c cVar, c packageName) {
        t.f(cVar, "<this>");
        t.f(packageName, "packageName");
        if (t.b(cVar, packageName) || packageName.c()) {
            return true;
        }
        return d(cVar.a(), packageName.a());
    }

    public static final boolean d(String str, String str2) {
        return z.J(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final boolean e(String str) {
        if (str == null) {
            return false;
        }
        k kVar = k.f8870a;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            int i11 = a.f8794a[kVar.ordinal()];
            if (i11 == 1 || i11 == 2) {
                if (!Character.isJavaIdentifierStart(cCharAt)) {
                    return false;
                }
                kVar = k.f8871b;
            } else {
                if (i11 != 3) {
                    throw new o();
                }
                if (cCharAt == '.') {
                    kVar = k.f8872c;
                } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                    return false;
                }
            }
        }
        return kVar != k.f8872c;
    }

    public static final c f(c cVar) {
        t.f(cVar, "<this>");
        if (cVar.c()) {
            return null;
        }
        return cVar.d();
    }

    public static final c g(c cVar, c prefix) {
        t.f(cVar, "<this>");
        t.f(prefix, "prefix");
        if (!c(cVar, prefix) || prefix.c()) {
            return cVar;
        }
        if (t.b(cVar, prefix)) {
            return c.f8784d;
        }
        String strSubstring = cVar.a().substring(prefix.a().length() + 1);
        t.e(strSubstring, "substring(...)");
        return new c(strSubstring);
    }
}
