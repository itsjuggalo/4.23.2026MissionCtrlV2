package hf;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g0 {
    public static final String a(ef.d dVar) {
        kotlin.jvm.internal.t.f(dVar, "<this>");
        return c(dVar.h());
    }

    public static final String b(ef.f fVar) {
        kotlin.jvm.internal.t.f(fVar, "<this>");
        if (!e(fVar)) {
            String strB = fVar.b();
            kotlin.jvm.internal.t.e(strB, "asString(...)");
            return strB;
        }
        StringBuilder sb2 = new StringBuilder();
        String strB2 = fVar.b();
        kotlin.jvm.internal.t.e(strB2, "asString(...)");
        sb2.append('`' + strB2);
        sb2.append('`');
        return sb2.toString();
    }

    public static final String c(List pathSegments) {
        kotlin.jvm.internal.t.f(pathSegments, "pathSegments");
        StringBuilder sb2 = new StringBuilder();
        Iterator it = pathSegments.iterator();
        while (it.hasNext()) {
            ef.f fVar = (ef.f) it.next();
            if (sb2.length() > 0) {
                sb2.append(".");
            }
            sb2.append(b(fVar));
        }
        return sb2.toString();
    }

    public static final String d(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        kotlin.jvm.internal.t.f(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.t.f(lowerPrefix, "lowerPrefix");
        kotlin.jvm.internal.t.f(upperRendered, "upperRendered");
        kotlin.jvm.internal.t.f(upperPrefix, "upperPrefix");
        kotlin.jvm.internal.t.f(foldedPrefix, "foldedPrefix");
        if (kg.z.J(lowerRendered, lowerPrefix, false, 2, null) && kg.z.J(upperRendered, upperPrefix, false, 2, null)) {
            String strSubstring = lowerRendered.substring(lowerPrefix.length());
            kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
            String strSubstring2 = upperRendered.substring(upperPrefix.length());
            kotlin.jvm.internal.t.e(strSubstring2, "substring(...)");
            String str = foldedPrefix + strSubstring;
            if (kotlin.jvm.internal.t.b(strSubstring, strSubstring2)) {
                return str;
            }
            if (f(strSubstring, strSubstring2)) {
                return str + '!';
            }
        }
        return null;
    }

    public static final boolean e(ef.f fVar) {
        String strB = fVar.b();
        kotlin.jvm.internal.t.e(strB, "asString(...)");
        if (b0.f11316a.contains(strB)) {
            return true;
        }
        for (int i10 = 0; i10 < strB.length(); i10++) {
            char cCharAt = strB.charAt(i10);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                return true;
            }
        }
        return strB.length() == 0 || !Character.isJavaIdentifierStart(strB.codePointAt(0));
    }

    public static final boolean f(String lower, String upper) {
        kotlin.jvm.internal.t.f(lower, "lower");
        kotlin.jvm.internal.t.f(upper, "upper");
        if (kotlin.jvm.internal.t.b(lower, kg.z.F(upper, "?", "", false, 4, null))) {
            return true;
        }
        if (kg.z.x(upper, "?", false, 2, null)) {
            if (kotlin.jvm.internal.t.b(lower + '?', upper)) {
                return true;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        sb2.append(lower);
        sb2.append(")?");
        return kotlin.jvm.internal.t.b(sb2.toString(), upper);
    }
}
