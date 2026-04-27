package q7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class N implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f22804a = C2653k.f22892c.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22805b;

    @Override // q7.A
    public void a(char c8) {
        f(1);
        char[] cArr = this.f22804a;
        int i8 = this.f22805b;
        this.f22805b = i8 + 1;
        cArr[i8] = c8;
    }

    @Override // q7.A
    public void b(String text) {
        AbstractC2304t.f(text, "text");
        f(text.length() + 2);
        char[] cArr = this.f22804a;
        int i8 = this.f22805b;
        int i9 = i8 + 1;
        cArr[i8] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i9);
        int i10 = length + i9;
        for (int i11 = i9; i11 < i10; i11++) {
            char c8 = cArr[i11];
            if (c8 < e0.a().length && e0.a()[c8] != 0) {
                e(i11 - i9, i11, text);
                return;
            }
        }
        cArr[i10] = '\"';
        this.f22805b = i10 + 1;
    }

    @Override // q7.A
    public void c(long j8) {
        d(String.valueOf(j8));
    }

    @Override // q7.A
    public void d(String text) {
        AbstractC2304t.f(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        f(length);
        text.getChars(0, text.length(), this.f22804a, this.f22805b);
        this.f22805b += length;
    }

    public final void e(int i8, int i9, String str) {
        byte b8;
        int length = str.length();
        while (i8 < length) {
            int iG = g(i9, 2);
            char cCharAt = str.charAt(i8);
            if (cCharAt >= e0.a().length || (b8 = e0.a()[cCharAt]) == 0) {
                int i10 = iG + 1;
                this.f22804a[iG] = cCharAt;
                i9 = i10;
                i8++;
            } else {
                if (b8 == 1) {
                    String str2 = e0.b()[cCharAt];
                    AbstractC2304t.c(str2);
                    int iG2 = g(iG, str2.length());
                    str2.getChars(0, str2.length(), this.f22804a, iG2);
                    i9 = iG2 + str2.length();
                } else {
                    char[] cArr = this.f22804a;
                    cArr[iG] = '\\';
                    cArr[iG + 1] = (char) b8;
                    i9 = iG + 2;
                }
                this.f22805b = i9;
                i8++;
            }
        }
        int iG3 = g(i9, 1);
        this.f22804a[iG3] = '\"';
        this.f22805b = iG3 + 1;
    }

    public final void f(int i8) {
        g(this.f22805b, i8);
    }

    public final int g(int i8, int i9) {
        int i10 = i9 + i8;
        char[] cArr = this.f22804a;
        if (cArr.length <= i10) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, H5.i.b(i10, i8 * 2));
            AbstractC2304t.e(cArrCopyOf, "copyOf(...)");
            this.f22804a = cArrCopyOf;
        }
        return i8;
    }

    public void h() {
        C2653k.f22892c.c(this.f22804a);
    }

    public String toString() {
        return new String(this.f22804a, 0, this.f22805b);
    }
}
