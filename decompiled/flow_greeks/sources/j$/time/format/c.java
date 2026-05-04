package j$.time.format;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f13636a;

    public c(char c10) {
        this.f13636a = c10;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb2) {
        sb2.append(this.f13636a);
        return true;
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i10) {
        if (i10 == charSequence.length()) {
            return ~i10;
        }
        char cCharAt = charSequence.charAt(i10);
        char c10 = this.f13636a;
        return (cCharAt == c10 || (!pVar.f13673b && (Character.toUpperCase(cCharAt) == Character.toUpperCase(c10) || Character.toLowerCase(cCharAt) == Character.toLowerCase(c10)))) ? i10 + 1 : ~i10;
    }

    public final String toString() {
        char c10 = this.f13636a;
        if (c10 == '\'') {
            return "''";
        }
        return "'" + c10 + "'";
    }
}
