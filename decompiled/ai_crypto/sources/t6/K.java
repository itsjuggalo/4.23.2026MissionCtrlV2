package t6;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class K implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f24244a = C2720j.f24327c.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24245b;

    @Override // t6.T
    public void a(char c7) {
        f(1);
        char[] cArr = this.f24244a;
        int i7 = this.f24245b;
        this.f24245b = i7 + 1;
        cArr[i7] = c7;
    }

    @Override // t6.T
    public void b(String text) {
        kotlin.jvm.internal.r.f(text, "text");
        f(text.length() + 2);
        char[] cArr = this.f24244a;
        int i7 = this.f24245b;
        int i8 = i7 + 1;
        cArr[i7] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i8);
        int i9 = length + i8;
        for (int i10 = i8; i10 < i9; i10++) {
            char c7 = cArr[i10];
            if (c7 < a0.a().length && a0.a()[c7] != 0) {
                e(i10 - i8, i10, text);
                return;
            }
        }
        cArr[i9] = '\"';
        this.f24245b = i9 + 1;
    }

    @Override // t6.T
    public void c(long j7) {
        d(String.valueOf(j7));
    }

    @Override // t6.T
    public void d(String text) {
        kotlin.jvm.internal.r.f(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        f(length);
        text.getChars(0, text.length(), this.f24244a, this.f24245b);
        this.f24245b += length;
    }

    public final void e(int i7, int i8, String str) {
        byte b7;
        int length = str.length();
        while (i7 < length) {
            int iG = g(i8, 2);
            char cCharAt = str.charAt(i7);
            if (cCharAt >= a0.a().length || (b7 = a0.a()[cCharAt]) == 0) {
                int i9 = iG + 1;
                this.f24244a[iG] = cCharAt;
                i8 = i9;
                i7++;
            } else {
                if (b7 == 1) {
                    String str2 = a0.b()[cCharAt];
                    kotlin.jvm.internal.r.c(str2);
                    int iG2 = g(iG, str2.length());
                    str2.getChars(0, str2.length(), this.f24244a, iG2);
                    i8 = iG2 + str2.length();
                    this.f24245b = i8;
                } else {
                    char[] cArr = this.f24244a;
                    cArr[iG] = '\\';
                    cArr[iG + 1] = (char) b7;
                    i8 = iG + 2;
                    this.f24245b = i8;
                }
                i7++;
            }
        }
        int iG3 = g(i8, 1);
        this.f24244a[iG3] = '\"';
        this.f24245b = iG3 + 1;
    }

    public final void f(int i7) {
        g(this.f24245b, i7);
    }

    public final int g(int i7, int i8) {
        int i9 = i8 + i7;
        char[] cArr = this.f24244a;
        if (cArr.length <= i9) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, W5.l.b(i9, i7 * 2));
            kotlin.jvm.internal.r.e(cArrCopyOf, "copyOf(this, newSize)");
            this.f24244a = cArrCopyOf;
        }
        return i7;
    }

    public void h() {
        C2720j.f24327c.c(this.f24244a);
    }

    public String toString() {
        return new String(this.f24244a, 0, this.f24245b);
    }
}
