package j$.time.format;

/* JADX INFO: loaded from: classes3.dex */
final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f19743a;

    d(char c8) {
        this.f19743a = c8;
    }

    @Override // j$.time.format.f
    public final boolean o(t tVar, StringBuilder sb) {
        sb.append(this.f19743a);
        return true;
    }

    @Override // j$.time.format.f
    public final int q(q qVar, CharSequence charSequence, int i8) {
        if (i8 == charSequence.length()) {
            return ~i8;
        }
        char cCharAt = charSequence.charAt(i8);
        char c8 = this.f19743a;
        return (cCharAt == c8 || (!qVar.j() && (Character.toUpperCase(cCharAt) == Character.toUpperCase(c8) || Character.toLowerCase(cCharAt) == Character.toLowerCase(c8)))) ? i8 + 1 : ~i8;
    }

    public final String toString() {
        char c8 = this.f19743a;
        if (c8 == '\'') {
            return "''";
        }
        return "'" + c8 + "'";
    }
}
