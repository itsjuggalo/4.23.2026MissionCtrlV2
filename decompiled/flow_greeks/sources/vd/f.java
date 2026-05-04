package vd;

import dd.j0;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23393d;

    public f(int i10, int i11, int i12) {
        this.f23390a = i12;
        this.f23391b = i11;
        boolean z10 = false;
        if (i12 <= 0 ? i10 >= i11 : i10 <= i11) {
            z10 = true;
        }
        this.f23392c = z10;
        this.f23393d = z10 ? i10 : i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f23392c;
    }

    @Override // dd.j0
    public int nextInt() {
        int i10 = this.f23393d;
        if (i10 != this.f23391b) {
            this.f23393d = this.f23390a + i10;
            return i10;
        }
        if (!this.f23392c) {
            throw new NoSuchElementException();
        }
        this.f23392c = false;
        return i10;
    }
}
