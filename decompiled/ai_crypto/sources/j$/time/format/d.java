package j$.time.format;

/* JADX INFO: loaded from: classes3.dex */
final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f17166a;

    d(char c7) {
        this.f17166a = c7;
    }

    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        sb.append(this.f17166a);
        return true;
    }

    @Override // j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i7) {
        if (i7 == charSequence.length()) {
            return ~i7;
        }
        char cCharAt = charSequence.charAt(i7);
        char c7 = this.f17166a;
        return (cCharAt == c7 || (!qVar.j() && (Character.toUpperCase(cCharAt) == Character.toUpperCase(c7) || Character.toLowerCase(cCharAt) == Character.toLowerCase(c7)))) ? i7 + 1 : ~i7;
    }

    public final String toString() {
        char c7 = this.f17166a;
        if (c7 == '\'') {
            return "''";
        }
        return "'" + c7 + "'";
    }
}
