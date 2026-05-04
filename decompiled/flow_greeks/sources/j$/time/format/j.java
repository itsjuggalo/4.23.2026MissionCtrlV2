package j$.time.format;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends k {
    @Override // j$.time.format.k
    public final k d(String str, String str2, k kVar) {
        return new j(str, str2, kVar);
    }

    @Override // j$.time.format.k
    public final boolean b(char c10, char c11) {
        return p.b(c10, c11);
    }

    @Override // j$.time.format.k
    public final boolean e(CharSequence charSequence, int i10, int i11) {
        int length = this.f13655a.length();
        if (length > i11 - i10) {
            return false;
        }
        int i12 = 0;
        while (true) {
            int i13 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i14 = i12 + 1;
            int i15 = i10 + 1;
            if (!p.b(this.f13655a.charAt(i12), charSequence.charAt(i10))) {
                return false;
            }
            i10 = i15;
            length = i13;
            i12 = i14;
        }
    }
}
