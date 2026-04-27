package p6;

import V6.A;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import p5.z;
import w5.AbstractC2927c;

/* JADX INFO: renamed from: p6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2599b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2599b f22397a = new C2599b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f22398b = z.h0(AbstractC2595q.l('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f22399c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listL = AbstractC2595q.l("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int iC = AbstractC2927c.c(0, listL.size() - 1, 2);
        if (iC >= 0) {
            int i8 = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f22398b;
                sb.append(str);
                sb.append('/');
                sb.append((String) listL.get(i8));
                int i9 = i8 + 1;
                linkedHashMap.put(sb.toString(), listL.get(i9));
                linkedHashMap.put(str + '/' + ((String) listL.get(i8)) + "Array", '[' + ((String) listL.get(i9)));
                if (i8 == iC) {
                    break;
                } else {
                    i8 += 2;
                }
            }
        }
        linkedHashMap.put(f22398b + "/Unit", "V");
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : AbstractC2595q.l("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : AbstractC2595q.l("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            a(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i10 = 0; i10 < 23; i10++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f22398b;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i10);
            a(linkedHashMap, "Function" + i10, sb2.toString());
            a(linkedHashMap, "reflect/KFunction" + i10, str4 + "/reflect/KFunction");
        }
        for (String str5 : AbstractC2595q.l("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, str5 + ".Companion", f22398b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f22399c = linkedHashMap;
    }

    public static final void a(Map map, String str, String str2) {
        map.put(f22398b + '/' + str, 'L' + str2 + ';');
    }

    public static final String b(String classId) {
        AbstractC2304t.f(classId, "classId");
        String str = (String) f22399c.get(classId);
        if (str != null) {
            return str;
        }
        return 'L' + A.D(classId, com.amazon.a.a.o.c.a.b.f14112a, '$', false, 4, null) + ';';
    }
}
