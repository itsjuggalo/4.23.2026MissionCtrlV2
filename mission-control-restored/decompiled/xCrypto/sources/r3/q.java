package r3;

import X2.AbstractC0769p;
import X2.AbstractC0770q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q extends n {
    public static final i3.k d(final String str) {
        return str.length() == 0 ? new i3.k() { // from class: r3.o
            @Override // i3.k
            public final Object invoke(Object obj) {
                return q.e((String) obj);
            }
        } : new i3.k() { // from class: r3.p
            @Override // i3.k
            public final Object invoke(Object obj) {
                return q.f(str, (String) obj);
            }
        };
    }

    public static final String e(String line) {
        kotlin.jvm.internal.r.f(line, "line");
        return line;
    }

    public static final String f(String str, String line) {
        kotlin.jvm.internal.r.f(line, "line");
        return str + line;
    }

    public static final int g(String str) {
        int length = str.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                i4 = -1;
                break;
            }
            if (!AbstractC1754a.c(str.charAt(i4))) {
                break;
            }
            i4++;
        }
        return i4 == -1 ? str.length() : i4;
    }

    public static final String h(String str, String newIndent) {
        String str2;
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(newIndent, "newIndent");
        List listB0 = AbstractC1753A.b0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listB0) {
            if (!AbstractC1753A.U((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC0770q.q(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(g((String) it.next())));
        }
        Integer num = (Integer) X2.x.T(arrayList2);
        int i4 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listB0.size());
        i3.k kVarD = d(newIndent);
        int i5 = AbstractC0769p.i(listB0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listB0) {
            int i6 = i4 + 1;
            if (i4 < 0) {
                AbstractC0769p.p();
            }
            String str3 = (String) obj2;
            if ((i4 == 0 || i4 == i5) && AbstractC1753A.U(str3)) {
                str3 = null;
            } else {
                String strG0 = C.G0(str3, iIntValue);
                if (strG0 != null && (str2 = (String) kVarD.invoke(strG0)) != null) {
                    str3 = str2;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i4 = i6;
        }
        return ((StringBuilder) X2.x.N(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
    }

    public static String i(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return h(str, "");
    }
}
