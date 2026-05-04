package fh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f9584a = k.f9586c.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9585b;

    @Override // fh.w
    public void a(char c10) {
        e(1);
        char[] cArr = this.f9584a;
        int i10 = this.f9585b;
        this.f9585b = i10 + 1;
        cArr[i10] = c10;
    }

    @Override // fh.w
    public void b(String text) {
        kotlin.jvm.internal.t.f(text, "text");
        e(text.length() + 2);
        char[] cArr = this.f9584a;
        int i10 = this.f9585b;
        int i11 = i10 + 1;
        cArr[i10] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i11);
        int i12 = length + i11;
        for (int i13 = i11; i13 < i12; i13++) {
            char c10 = cArr[i13];
            if (c10 < z0.a().length && z0.a()[c10] != 0) {
                d(i13 - i11, i13, text);
                return;
            }
        }
        cArr[i12] = '\"';
        this.f9585b = i12 + 1;
    }

    @Override // fh.w
    public void c(String text) {
        kotlin.jvm.internal.t.f(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        e(length);
        text.getChars(0, text.length(), this.f9584a, this.f9585b);
        this.f9585b += length;
    }

    public final void d(int i10, int i11, String str) {
        byte b10;
        int length = str.length();
        while (i10 < length) {
            int iF = f(i11, 2);
            char cCharAt = str.charAt(i10);
            if (cCharAt >= z0.a().length || (b10 = z0.a()[cCharAt]) == 0) {
                int i12 = iF + 1;
                this.f9584a[iF] = cCharAt;
                i11 = i12;
                i10++;
            } else {
                if (b10 == 1) {
                    String str2 = z0.b()[cCharAt];
                    kotlin.jvm.internal.t.c(str2);
                    int iF2 = f(iF, str2.length());
                    str2.getChars(0, str2.length(), this.f9584a, iF2);
                    i11 = iF2 + str2.length();
                    this.f9585b = i11;
                } else {
                    char[] cArr = this.f9584a;
                    cArr[iF] = '\\';
                    cArr[iF + 1] = (char) b10;
                    i11 = iF + 2;
                    this.f9585b = i11;
                }
                i10++;
            }
        }
        int iF3 = f(i11, 1);
        this.f9584a[iF3] = '\"';
        this.f9585b = iF3 + 1;
    }

    public final void e(int i10) {
        f(this.f9585b, i10);
    }

    public final int f(int i10, int i11) {
        int i12 = i11 + i10;
        char[] cArr = this.f9584a;
        if (cArr.length <= i12) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, vd.l.b(i12, i10 * 2));
            kotlin.jvm.internal.t.e(cArrCopyOf, "copyOf(...)");
            this.f9584a = cArrCopyOf;
        }
        return i10;
    }

    public void g() {
        k.f9586c.c(this.f9584a);
    }

    public String toString() {
        return new String(this.f9584a, 0, this.f9585b);
    }

    @Override // fh.w
    public void writeLong(long j10) {
        c(String.valueOf(j10));
    }
}
