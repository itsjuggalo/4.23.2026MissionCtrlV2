package j$.time.format;

import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f13223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f13224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected char f13225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected l f13226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected l f13227e;

    /* synthetic */ l(String str, String str2, l lVar, int i4) {
        this(str, str2, lVar);
    }

    protected boolean b(char c4, char c5) {
        return c4 == c5;
    }

    private l(String str, String str2, l lVar) {
        this.f13223a = str;
        this.f13224b = str2;
        this.f13226d = lVar;
        if (str.isEmpty()) {
            this.f13225c = (char) 65535;
        } else {
            this.f13225c = this.f13223a.charAt(0);
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
        int length2 = this.f13223a.length() + index;
        l lVar = this.f13226d;
        if (lVar != null && length2 != length) {
            while (true) {
                if (b(lVar.f13225c, charSequence.charAt(length2))) {
                    parsePosition.setIndex(length2);
                    String strC = lVar.c(charSequence, parsePosition);
                    if (strC != null) {
                        return strC;
                    }
                } else {
                    lVar = lVar.f13227e;
                    if (lVar == null) {
                        break;
                    }
                }
            }
        }
        parsePosition.setIndex(length2);
        return this.f13224b;
    }

    protected l d(String str, String str2, l lVar) {
        return new l(str, str2, lVar);
    }

    protected boolean f(CharSequence charSequence, int i4, int i5) {
        if (charSequence instanceof String) {
            return ((String) charSequence).startsWith(this.f13223a, i4);
        }
        int length = this.f13223a.length();
        if (length > i5 - i4) {
            return false;
        }
        int i6 = 0;
        while (true) {
            int i7 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i8 = i6 + 1;
            int i9 = i4 + 1;
            if (!b(this.f13223a.charAt(i6), charSequence.charAt(i4))) {
                return false;
            }
            i4 = i9;
            length = i7;
            i6 = i8;
        }
    }

    private boolean a(String str, String str2) {
        int i4 = 0;
        while (i4 < str.length() && i4 < this.f13223a.length() && b(str.charAt(i4), this.f13223a.charAt(i4))) {
            i4++;
        }
        if (i4 == this.f13223a.length()) {
            if (i4 < str.length()) {
                String strSubstring = str.substring(i4);
                for (l lVar = this.f13226d; lVar != null; lVar = lVar.f13227e) {
                    if (b(lVar.f13225c, strSubstring.charAt(0))) {
                        return lVar.a(strSubstring, str2);
                    }
                }
                l lVarD = d(strSubstring, str2, null);
                lVarD.f13227e = this.f13226d;
                this.f13226d = lVarD;
                return true;
            }
            this.f13224b = str2;
            return true;
        }
        l lVarD2 = d(this.f13223a.substring(i4), this.f13224b, this.f13226d);
        this.f13223a = str.substring(0, i4);
        this.f13226d = lVarD2;
        if (i4 < str.length()) {
            this.f13226d.f13227e = d(str.substring(i4), str2, null);
            this.f13224b = null;
            return true;
        }
        this.f13224b = str2;
        return true;
    }
}
