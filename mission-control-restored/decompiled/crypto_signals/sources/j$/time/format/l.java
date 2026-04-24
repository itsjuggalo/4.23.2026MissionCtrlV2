package j$.time.format;

import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f7464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f7465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected char f7466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected l f7467d;
    protected l e;

    /* synthetic */ l(String str, String str2, l lVar, int i) {
        this(str, str2, lVar);
    }

    protected boolean b(char c6, char c7) {
        return c6 == c7;
    }

    private l(String str, String str2, l lVar) {
        this.f7464a = str;
        this.f7465b = str2;
        this.f7467d = lVar;
        if (str.isEmpty()) {
            this.f7466c = (char) 65535;
        } else {
            this.f7466c = this.f7464a.charAt(0);
        }
    }

    public static l e(Set set, q qVar) {
        l lVar = qVar.j() ? new l("", null, null) : new k("", null, null);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            lVar.a(str, str);
        }
        return lVar;
    }

    public final String c(CharSequence charSequence, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int length = charSequence.length();
        if (!f(charSequence, index, length)) {
            return null;
        }
        int length2 = this.f7464a.length() + index;
        l lVar = this.f7467d;
        if (lVar != null && length2 != length) {
            while (true) {
                if (b(lVar.f7466c, charSequence.charAt(length2))) {
                    parsePosition.setIndex(length2);
                    String strC = lVar.c(charSequence, parsePosition);
                    if (strC != null) {
                        return strC;
                    }
                } else {
                    lVar = lVar.e;
                    if (lVar == null) {
                        break;
                    }
                }
            }
        }
        parsePosition.setIndex(length2);
        return this.f7465b;
    }

    protected l d(String str, String str2, l lVar) {
        return new l(str, str2, lVar);
    }

    protected boolean f(CharSequence charSequence, int i, int i6) {
        if (charSequence instanceof String) {
            return ((String) charSequence).startsWith(this.f7464a, i);
        }
        int length = this.f7464a.length();
        if (length > i6 - i) {
            return false;
        }
        int i7 = 0;
        while (true) {
            int i8 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i9 = i7 + 1;
            int i10 = i + 1;
            if (!b(this.f7464a.charAt(i7), charSequence.charAt(i))) {
                return false;
            }
            i = i10;
            length = i8;
            i7 = i9;
        }
    }

    private boolean a(String str, String str2) {
        int i = 0;
        while (i < str.length() && i < this.f7464a.length() && b(str.charAt(i), this.f7464a.charAt(i))) {
            i++;
        }
        if (i == this.f7464a.length()) {
            if (i < str.length()) {
                String strSubstring = str.substring(i);
                for (l lVar = this.f7467d; lVar != null; lVar = lVar.e) {
                    if (b(lVar.f7466c, strSubstring.charAt(0))) {
                        return lVar.a(strSubstring, str2);
                    }
                }
                l lVarD = d(strSubstring, str2, null);
                lVarD.e = this.f7467d;
                this.f7467d = lVarD;
                return true;
            }
            this.f7465b = str2;
            return true;
        }
        l lVarD2 = d(this.f7464a.substring(i), this.f7465b, this.f7467d);
        this.f7464a = str.substring(0, i);
        this.f7467d = lVarD2;
        if (i < str.length()) {
            this.f7467d.e = d(str.substring(i), str2, null);
            this.f7465b = null;
            return true;
        }
        this.f7465b = str2;
        return true;
    }
}
