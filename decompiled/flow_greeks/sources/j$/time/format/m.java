package j$.time.format;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13661a;

    public m(String str) {
        this.f13661a = str;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb2) {
        sb2.append(this.f13661a);
        return true;
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i10) {
        if (i10 > charSequence.length() || i10 < 0) {
            throw new IndexOutOfBoundsException();
        }
        String str = this.f13661a;
        return !pVar.g(charSequence, i10, str, 0, str.length()) ? ~i10 : str.length() + i10;
    }

    public final String toString() {
        return "'" + this.f13661a.replace("'", "''") + "'";
    }
}
