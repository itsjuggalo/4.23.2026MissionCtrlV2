package j$.time.format;

/* JADX INFO: loaded from: classes2.dex */
final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f7450a;

    d(char c6) {
        this.f7450a = c6;
    }

    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        sb.append(this.f7450a);
        return true;
    }

    @Override // j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i) {
        if (i == charSequence.length()) {
            return ~i;
        }
        char cCharAt = charSequence.charAt(i);
        char c6 = this.f7450a;
        return (cCharAt == c6 || (!qVar.j() && (Character.toUpperCase(cCharAt) == Character.toUpperCase(c6) || Character.toLowerCase(cCharAt) == Character.toLowerCase(c6)))) ? i + 1 : ~i;
    }

    public final String toString() {
        char c6 = this.f7450a;
        if (c6 == '\'') {
            return "''";
        }
        return "'" + c6 + "'";
    }
}
