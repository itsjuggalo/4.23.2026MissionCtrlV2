package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2517m extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f22189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22190b;

    public C2517m(char[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22189a = bufferWithData;
        this.f22190b = bufferWithData.length;
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        char[] cArr = this.f22189a;
        if (cArr.length < i8) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, H5.i.b(i8, cArr.length * 2));
            AbstractC2304t.e(cArrCopyOf, "copyOf(...)");
            this.f22189a = cArrCopyOf;
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22190b;
    }

    public final void e(char c8) {
        AbstractC2520n0.c(this, 0, 1, null);
        char[] cArr = this.f22189a;
        int iD = d();
        this.f22190b = iD + 1;
        cArr[iD] = c8;
    }

    @Override // o7.AbstractC2520n0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public char[] a() {
        char[] cArrCopyOf = Arrays.copyOf(this.f22189a, d());
        AbstractC2304t.e(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }
}
