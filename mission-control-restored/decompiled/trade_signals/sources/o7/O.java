package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class O extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f22131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22132b;

    public O(long[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22131a = bufferWithData;
        this.f22132b = bufferWithData.length;
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        long[] jArr = this.f22131a;
        if (jArr.length < i8) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, H5.i.b(i8, jArr.length * 2));
            AbstractC2304t.e(jArrCopyOf, "copyOf(...)");
            this.f22131a = jArrCopyOf;
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22132b;
    }

    public final void e(long j8) {
        AbstractC2520n0.c(this, 0, 1, null);
        long[] jArr = this.f22131a;
        int iD = d();
        this.f22132b = iD + 1;
        jArr[iD] = j8;
    }

    @Override // o7.AbstractC2520n0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public long[] a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f22131a, d());
        AbstractC2304t.e(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }
}
