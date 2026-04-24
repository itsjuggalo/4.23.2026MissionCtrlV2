package q6;

import V6.A;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22670a;

        static {
            int[] iArr = new int[k.values().length];
            try {
                iArr[k.f22785a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[k.f22787c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[k.f22786b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f22670a = iArr;
        }
    }

    public static final Object a(c cVar, Map values) {
        Object next;
        AbstractC2304t.f(cVar, "<this>");
        AbstractC2304t.f(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : values.entrySet()) {
            c cVar2 = (c) entry.getKey();
            if (AbstractC2304t.b(cVar, cVar2) || b(cVar, cVar2)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (!(!linkedHashMap.isEmpty())) {
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
        AbstractC2304t.f(cVar, "<this>");
        AbstractC2304t.f(packageName, "packageName");
        return AbstractC2304t.b(f(cVar), packageName);
    }

    public static final boolean c(String str, String str2) {
        return A.G(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final boolean d(c cVar, c packageName) {
        AbstractC2304t.f(cVar, "<this>");
        AbstractC2304t.f(packageName, "packageName");
        if (AbstractC2304t.b(cVar, packageName) || packageName.c()) {
            return true;
        }
        return c(cVar.a(), packageName.a());
    }

    public static final boolean e(String str) {
        if (str == null) {
            return false;
        }
        k kVar = k.f22785a;
        for (int i8 = 0; i8 < str.length(); i8++) {
            char cCharAt = str.charAt(i8);
            int i9 = a.f22670a[kVar.ordinal()];
            if (i9 == 1 || i9 == 2) {
                if (!Character.isJavaIdentifierStart(cCharAt)) {
                    return false;
                }
                kVar = k.f22786b;
            } else {
                if (i9 != 3) {
                    throw new C2487o();
                }
                if (cCharAt == '.') {
                    kVar = k.f22787c;
                } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                    return false;
                }
            }
        }
        return kVar != k.f22787c;
    }

    public static final c f(c cVar) {
        AbstractC2304t.f(cVar, "<this>");
        if (cVar.c()) {
            return null;
        }
        return cVar.d();
    }

    public static final c g(c cVar, c prefix) {
        AbstractC2304t.f(cVar, "<this>");
        AbstractC2304t.f(prefix, "prefix");
        if (!d(cVar, prefix) || prefix.c()) {
            return cVar;
        }
        if (AbstractC2304t.b(cVar, prefix)) {
            return c.f22660d;
        }
        String strSubstring = cVar.a().substring(prefix.a().length() + 1);
        AbstractC2304t.e(strSubstring, "substring(...)");
        return new c(strSubstring);
    }
}
