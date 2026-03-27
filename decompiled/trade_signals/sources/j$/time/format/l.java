package j$.time.format;

import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f19759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f19760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected char f19761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected l f19762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected l f19763e;

    private l(String str, String str2, l lVar) {
        this.f19759a = str;
        this.f19760b = str2;
        this.f19762d = lVar;
        this.f19761c = str.isEmpty() ? (char) 65535 : this.f19759a.charAt(0);
    }

    /* synthetic */ l(String str, String str2, l lVar, int i8) {
        this(str, str2, lVar);
    }

    private boolean a(String str, String str2) {
        int i8 = 0;
        while (i8 < str.length() && i8 < this.f19759a.length() && b(str.charAt(i8), this.f19759a.charAt(i8))) {
            i8++;
        }
        if (i8 != this.f19759a.length()) {
            l lVarD = d(this.f19759a.substring(i8), this.f19760b, this.f19762d);
            this.f19759a = str.substring(0, i8);
            this.f19762d = lVarD;
            if (i8 < str.length()) {
                this.f19762d.f19763e = d(str.substring(i8), str2, null);
                this.f19760b = null;
            } else {
                this.f19760b = str2;
            }
            return true;
        }
        if (i8 >= str.length()) {
            this.f19760b = str2;
            return true;
        }
        String strSubstring = str.substring(i8);
        for (l lVar = this.f19762d; lVar != null; lVar = lVar.f19763e) {
            if (b(lVar.f19761c, strSubstring.charAt(0))) {
                return lVar.a(strSubstring, str2);
            }
        }
        l lVarD2 = d(strSubstring, str2, null);
        lVarD2.f19763e = this.f19762d;
        this.f19762d = lVarD2;
        return true;
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

    protected boolean b(char c8, char c9) {
        return c8 == c9;
    }

    public final String c(CharSequence charSequence, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int length = charSequence.length();
        if (!f(charSequence, index, length)) {
            return null;
        }
        int length2 = this.f19759a.length() + index;
        l lVar = this.f19762d;
        if (lVar != null && length2 != length) {
            while (true) {
                if (b(lVar.f19761c, charSequence.charAt(length2))) {
                    parsePosition.setIndex(length2);
                    String strC = lVar.c(charSequence, parsePosition);
                    if (strC != null) {
                        return strC;
                    }
                } else {
                    lVar = lVar.f19763e;
                    if (lVar == null) {
                        break;
                    }
                }
            }
        }
        parsePosition.setIndex(length2);
        return this.f19760b;
    }

    protected l d(String str, String str2, l lVar) {
        return new l(str, str2, lVar);
    }

    protected boolean f(CharSequence charSequence, int i8, int i9) {
        if (charSequence instanceof String) {
            return ((String) charSequence).startsWith(this.f19759a, i8);
        }
        int length = this.f19759a.length();
        if (length > i9 - i8) {
            return false;
        }
        int i10 = 0;
        while (true) {
            int i11 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i12 = i10 + 1;
            int i13 = i8 + 1;
            if (!b(this.f19759a.charAt(i10), charSequence.charAt(i8))) {
                return false;
            }
            i8 = i13;
            length = i11;
            i10 = i12;
        }
    }
}
