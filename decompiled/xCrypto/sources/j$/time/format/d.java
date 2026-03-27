package j$.time.format;

/* JADX INFO: loaded from: classes2.dex */
final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f13207a;

    d(char c4) {
        this.f13207a = c4;
    }

    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        sb.append(this.f13207a);
        return true;
    }

    @Override // j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i4) {
        if (i4 == charSequence.length()) {
            return ~i4;
        }
        char cCharAt = charSequence.charAt(i4);
        char c4 = this.f13207a;
        return (cCharAt == c4 || (!qVar.j() && (Character.toUpperCase(cCharAt) == Character.toUpperCase(c4) || Character.toLowerCase(cCharAt) == Character.toLowerCase(c4)))) ? i4 + 1 : ~i4;
    }

    public final String toString() {
        char c4 = this.f13207a;
        if (c4 == '\'') {
            return "''";
        }
        return "'" + c4 + "'";
    }
}
