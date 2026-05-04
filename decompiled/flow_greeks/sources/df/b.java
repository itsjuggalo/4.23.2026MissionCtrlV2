package df;

import dd.a0;
import dd.r;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kg.z;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8086a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8087b = a0.i0(r.n('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f8088c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listN = r.n("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int iC = kd.c.c(0, listN.size() - 1, 2);
        if (iC >= 0) {
            int i10 = 0;
            while (true) {
                StringBuilder sb2 = new StringBuilder();
                String str = f8087b;
                sb2.append(str);
                sb2.append('/');
                sb2.append((String) listN.get(i10));
                int i11 = i10 + 1;
                linkedHashMap.put(sb2.toString(), listN.get(i11));
                linkedHashMap.put(str + '/' + ((String) listN.get(i10)) + "Array", '[' + ((String) listN.get(i11)));
                if (i10 == iC) {
                    break;
                } else {
                    i10 += 2;
                }
            }
        }
        linkedHashMap.put(f8087b + "/Unit", "V");
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : r.n("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : r.n("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            a(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i12 = 0; i12 < 23; i12++) {
            StringBuilder sb3 = new StringBuilder();
            String str4 = f8087b;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i12);
            a(linkedHashMap, "Function" + i12, sb3.toString());
            a(linkedHashMap, "reflect/KFunction" + i12, str4 + "/reflect/KFunction");
        }
        for (String str5 : r.n("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, str5 + ".Companion", f8087b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f8088c = linkedHashMap;
    }

    public static final void a(Map map, String str, String str2) {
        map.put(f8087b + '/' + str, 'L' + str2 + ';');
    }

    public static final String b(String classId) {
        t.f(classId, "classId");
        String str = (String) f8088c.get(classId);
        if (str != null) {
            return str;
        }
        return 'L' + z.E(classId, com.amazon.a.a.o.c.a.b.f4610a, '$', false, 4, null) + ';';
    }
}
