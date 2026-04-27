package t6;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class G {
    public static final String a(q6.d dVar) {
        AbstractC2304t.f(dVar, "<this>");
        return c(dVar.h());
    }

    public static final String b(q6.f fVar) {
        AbstractC2304t.f(fVar, "<this>");
        if (!e(fVar)) {
            String strB = fVar.b();
            AbstractC2304t.e(strB, "asString(...)");
            return strB;
        }
        StringBuilder sb = new StringBuilder();
        String strB2 = fVar.b();
        AbstractC2304t.e(strB2, "asString(...)");
        sb.append('`' + strB2);
        sb.append('`');
        return sb.toString();
    }

    public static final String c(List pathSegments) {
        AbstractC2304t.f(pathSegments, "pathSegments");
        StringBuilder sb = new StringBuilder();
        Iterator it = pathSegments.iterator();
        while (it.hasNext()) {
            q6.f fVar = (q6.f) it.next();
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(b(fVar));
        }
        return sb.toString();
    }

    public static final String d(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        AbstractC2304t.f(lowerRendered, "lowerRendered");
        AbstractC2304t.f(lowerPrefix, "lowerPrefix");
        AbstractC2304t.f(upperRendered, "upperRendered");
        AbstractC2304t.f(upperPrefix, "upperPrefix");
        AbstractC2304t.f(foldedPrefix, "foldedPrefix");
        if (V6.A.G(lowerRendered, lowerPrefix, false, 2, null) && V6.A.G(upperRendered, upperPrefix, false, 2, null)) {
            String strSubstring = lowerRendered.substring(lowerPrefix.length());
            AbstractC2304t.e(strSubstring, "substring(...)");
            String strSubstring2 = upperRendered.substring(upperPrefix.length());
            AbstractC2304t.e(strSubstring2, "substring(...)");
            String str = foldedPrefix + strSubstring;
            if (AbstractC2304t.b(strSubstring, strSubstring2)) {
                return str;
            }
            if (f(strSubstring, strSubstring2)) {
                return str + '!';
            }
        }
        return null;
    }

    public static final boolean e(q6.f fVar) {
        String strB = fVar.b();
        AbstractC2304t.e(strB, "asString(...)");
        if (!B.f23338a.contains(strB)) {
            int i8 = 0;
            while (true) {
                if (i8 < strB.length()) {
                    char cCharAt = strB.charAt(i8);
                    if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                        break;
                    }
                    i8++;
                } else if (strB.length() != 0 && Character.isJavaIdentifierStart(strB.codePointAt(0))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean f(java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "lower"
            kotlin.jvm.internal.AbstractC2304t.f(r7, r0)
            java.lang.String r0 = "upper"
            kotlin.jvm.internal.AbstractC2304t.f(r8, r0)
            r5 = 4
            r6 = 0
            java.lang.String r2 = "?"
            java.lang.String r3 = ""
            r4 = 0
            r1 = r8
            java.lang.String r0 = V6.A.E(r1, r2, r3, r4, r5, r6)
            boolean r0 = kotlin.jvm.internal.AbstractC2304t.b(r7, r0)
            if (r0 != 0) goto L5a
            r0 = 2
            r1 = 0
            java.lang.String r2 = "?"
            r3 = 0
            boolean r0 = V6.A.w(r8, r2, r3, r0, r1)
            if (r0 == 0) goto L3e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r1 = 63
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r0 = kotlin.jvm.internal.AbstractC2304t.b(r0, r8)
            if (r0 != 0) goto L5a
        L3e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 40
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = ")?"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            boolean r7 = kotlin.jvm.internal.AbstractC2304t.b(r7, r8)
            if (r7 == 0) goto L5b
        L5a:
            r3 = 1
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.G.f(java.lang.String, java.lang.String):boolean");
    }
}
