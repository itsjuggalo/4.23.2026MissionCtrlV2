package H5;

import java.util.NoSuchElementException;
import p5.I;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3961d;

    public c(int i8, int i9, int i10) {
        this.f3958a = i10;
        this.f3959b = i9;
        boolean z7 = false;
        if (i10 <= 0 ? i8 >= i9 : i8 <= i9) {
            z7 = true;
        }
        this.f3960c = z7;
        this.f3961d = z7 ? i8 : i9;
    }

    @Override // p5.I
    public int c() {
        int i8 = this.f3961d;
        if (i8 != this.f3959b) {
            this.f3961d = this.f3958a + i8;
        } else {
            if (!this.f3960c) {
                throw new NoSuchElementException();
            }
            this.f3960c = false;
        }
        return i8;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3960c;
    }
}
