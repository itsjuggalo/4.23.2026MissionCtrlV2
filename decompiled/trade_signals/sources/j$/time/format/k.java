package j$.time.format;

/* JADX INFO: loaded from: classes3.dex */
final class k extends l {
    @Override // j$.time.format.l
    protected final boolean b(char c8, char c9) {
        return q.b(c8, c9);
    }

    @Override // j$.time.format.l
    protected final l d(String str, String str2, l lVar) {
        return new k(str, str2, lVar, 0);
    }

    @Override // j$.time.format.l
    protected final boolean f(CharSequence charSequence, int i8, int i9) {
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
            if (!q.b(this.f19759a.charAt(i10), charSequence.charAt(i8))) {
                return false;
            }
            i8 = i13;
            length = i11;
            i10 = i12;
        }
    }
}
