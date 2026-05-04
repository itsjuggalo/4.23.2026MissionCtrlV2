package kg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends p {
    public static final pd.k d(final String str) {
        return str.length() == 0 ? new pd.k() { // from class: kg.q
            @Override // pd.k
            public final Object invoke(Object obj) {
                return s.e((String) obj);
            }
        } : new pd.k() { // from class: kg.r
            @Override // pd.k
            public final Object invoke(Object obj) {
                return s.f(str, (String) obj);
            }
        };
    }

    public static final String e(String line) {
        kotlin.jvm.internal.t.f(line, "line");
        return line;
    }

    public static final String f(String str, String line) {
        kotlin.jvm.internal.t.f(line, "line");
        return str + line;
    }

    public static final int g(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (!a.c(str.charAt(i10))) {
                break;
            }
            i10++;
        }
        return i10 == -1 ? str.length() : i10;
    }

    public static final String h(String str, String newIndent) {
        String str2;
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(newIndent, "newIndent");
        List listL0 = c0.l0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listL0) {
            if (!c0.e0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(dd.s.u(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(g((String) it.next())));
        }
        Integer num = (Integer) dd.a0.o0(arrayList2);
        int i10 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listL0.size());
        pd.k kVarD = d(newIndent);
        int iM = dd.r.m(listL0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listL0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                dd.r.t();
            }
            String str3 = (String) obj2;
            if ((i10 == 0 || i10 == iM) && c0.e0(str3)) {
                str3 = null;
            } else {
                String strB1 = e0.b1(str3, iIntValue);
                if (strB1 != null && (str2 = (String) kVarD.invoke(strB1)) != null) {
                    str3 = str2;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i10 = i11;
        }
        return ((StringBuilder) dd.a0.f0(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
    }

    public static String i(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        return h(str, "");
    }
}
