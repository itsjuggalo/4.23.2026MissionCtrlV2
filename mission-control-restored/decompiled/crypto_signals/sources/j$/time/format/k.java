package j$.time.format;

/* JADX INFO: loaded from: classes2.dex */
final class k extends l {
    @Override // j$.time.format.l
    protected final l d(String str, String str2, l lVar) {
        return new k(str, str2, lVar, 0);
    }

    @Override // j$.time.format.l
    protected final boolean b(char c6, char c7) {
        return q.b(c6, c7);
    }

    @Override // j$.time.format.l
    protected final boolean f(CharSequence charSequence, int i, int i6) {
        int length = this.f7464a.length();
        if (length > i6 - i) {
            return false;
        }
        int i7 = 0;
        while (true) {
            int i8 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i9 = i7 + 1;
            int i10 = i + 1;
            if (!q.b(this.f7464a.charAt(i7), charSequence.charAt(i))) {
                return false;
            }
            i = i10;
            length = i8;
            i7 = i9;
        }
    }
}
