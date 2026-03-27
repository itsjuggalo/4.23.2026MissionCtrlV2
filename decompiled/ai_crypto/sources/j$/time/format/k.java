package j$.time.format;

/* JADX INFO: loaded from: classes3.dex */
final class k extends l {
    @Override // j$.time.format.l
    protected final l d(String str, String str2, l lVar) {
        return new k(str, str2, lVar, 0);
    }

    @Override // j$.time.format.l
    protected final boolean b(char c7, char c8) {
        return q.b(c7, c8);
    }

    @Override // j$.time.format.l
    protected final boolean f(CharSequence charSequence, int i7, int i8) {
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
            if (!q.b(this.f17182a.charAt(i9), charSequence.charAt(i7))) {
                return false;
            }
            i7 = i12;
            length = i10;
            i9 = i11;
        }
    }
}
