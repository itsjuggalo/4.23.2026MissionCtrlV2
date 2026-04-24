package L3;

import java.util.Arrays;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class K implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f1451a = C0387j.f1534c.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1452b;

    @Override // L3.T
    public void a(char c4) {
        f(1);
        char[] cArr = this.f1451a;
        int i4 = this.f1452b;
        this.f1452b = i4 + 1;
        cArr[i4] = c4;
    }

    @Override // L3.T
    public void b(String text) {
        kotlin.jvm.internal.r.f(text, "text");
        f(text.length() + 2);
        char[] cArr = this.f1451a;
        int i4 = this.f1452b;
        int i5 = i4 + 1;
        cArr[i4] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i5);
        int i6 = length + i5;
        for (int i7 = i5; i7 < i6; i7++) {
            char c4 = cArr[i7];
            if (c4 < a0.a().length && a0.a()[c4] != 0) {
                e(i7 - i5, i7, text);
                return;
            }
        }
        cArr[i6] = '\"';
        this.f1452b = i6 + 1;
    }

    @Override // L3.T
    public void c(long j4) {
        d(String.valueOf(j4));
    }

    @Override // L3.T
    public void d(String text) {
        kotlin.jvm.internal.r.f(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        f(length);
        text.getChars(0, text.length(), this.f1451a, this.f1452b);
        this.f1452b += length;
    }

    public final void e(int i4, int i5, String str) {
        byte b4;
        int length = str.length();
        while (i4 < length) {
            int iG = g(i5, 2);
            char cCharAt = str.charAt(i4);
            if (cCharAt >= a0.a().length || (b4 = a0.a()[cCharAt]) == 0) {
                int i6 = iG + 1;
                this.f1451a[iG] = cCharAt;
                i5 = i6;
                i4++;
            } else {
                if (b4 == 1) {
                    String str2 = a0.b()[cCharAt];
                    kotlin.jvm.internal.r.c(str2);
                    int iG2 = g(iG, str2.length());
                    str2.getChars(0, str2.length(), this.f1451a, iG2);
                    i5 = iG2 + str2.length();
                    this.f1452b = i5;
                } else {
                    char[] cArr = this.f1451a;
                    cArr[iG] = '\\';
                    cArr[iG + 1] = (char) b4;
                    i5 = iG + 2;
                    this.f1452b = i5;
                }
                i4++;
            }
        }
        int iG3 = g(i5, 1);
        this.f1451a[iG3] = '\"';
        this.f1452b = iG3 + 1;
    }

    public final void f(int i4) {
        g(this.f1452b, i4);
    }

    public final int g(int i4, int i5) {
        int i6 = i5 + i4;
        char[] cArr = this.f1451a;
        if (cArr.length <= i6) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, AbstractC1681l.b(i6, i4 * 2));
            kotlin.jvm.internal.r.e(cArrCopyOf, "copyOf(this, newSize)");
            this.f1451a = cArrCopyOf;
        }
        return i4;
    }

    public void h() {
        C0387j.f1534c.c(this.f1451a);
    }

    public String toString() {
        return new String(this.f1451a, 0, this.f1452b);
    }
}
