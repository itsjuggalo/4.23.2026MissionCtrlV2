package j$.time.format;

import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f17182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f17183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected char f17184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected l f17185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected l f17186e;

    /* synthetic */ l(String str, String str2, l lVar, int i7) {
        this(str, str2, lVar);
    }

    protected boolean b(char c7, char c8) {
        return c7 == c8;
    }

    private l(String str, String str2, l lVar) {
        this.f17182a = str;
        this.f17183b = str2;
        this.f17185d = lVar;
        if (str.isEmpty()) {
            this.f17184c = (char) 65535;
        } else {
            this.f17184c = this.f17182a.charAt(0);
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
        int length2 = this.f17182a.length() + index;
        l lVar = this.f17185d;
        if (lVar != null && length2 != length) {
            while (true) {
                if (b(lVar.f17184c, charSequence.charAt(length2))) {
                    parsePosition.setIndex(length2);
                    String strC = lVar.c(charSequence, parsePosition);
                    if (strC != null) {
                        return strC;
                    }
                } else {
                    lVar = lVar.f17186e;
                    if (lVar == null) {
                        break;
                    }
                }
            }
        }
        parsePosition.setIndex(length2);
        return this.f17183b;
    }

    protected l d(String str, String str2, l lVar) {
        return new l(str, str2, lVar);
    }

    protected boolean f(CharSequence charSequence, int i7, int i8) {
        if (charSequence instanceof String) {
            return ((String) charSequence).startsWith(this.f17182a, i7);
        }
        int length = this.f17182a.length();
        if (length > i8 - i7) {
            return false;
        }
        int i9 = 0;
        while (true) {
            int i10 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i11 = i9 + 1;
            int i12 = i7 + 1;
            if (!b(this.f17182a.charAt(i9), charSequence.charAt(i7))) {
                return false;
            }
            i7 = i12;
            length = i10;
            i9 = i11;
        }
    }

    private boolean a(String str, String str2) {
        int i7 = 0;
        while (i7 < str.length() && i7 < this.f17182a.length() && b(str.charAt(i7), this.f17182a.charAt(i7))) {
            i7++;
        }
        if (i7 == this.f17182a.length()) {
            if (i7 < str.length()) {
                String strSubstring = str.substring(i7);
                for (l lVar = this.f17185d; lVar != null; lVar = lVar.f17186e) {
                    if (b(lVar.f17184c, strSubstring.charAt(0))) {
                        return lVar.a(strSubstring, str2);
                    }
                }
                l lVarD = d(strSubstring, str2, null);
                lVarD.f17186e = this.f17185d;
                this.f17185d = lVarD;
                return true;
            }
            this.f17183b = str2;
            return true;
        }
        l lVarD2 = d(this.f17182a.substring(i7), this.f17183b, this.f17185d);
        this.f17182a = str.substring(0, i7);
        this.f17185d = lVarD2;
        if (i7 < str.length()) {
            this.f17185d.f17186e = d(str.substring(i7), str2, null);
            this.f17183b = null;
        } else {
            this.f17183b = str2;
        }
        return true;
    }
}
