package o3;

import X2.G;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: o3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1675f extends G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13941d;

    public C1675f(int i4, int i5, int i6) {
        this.f13938a = i6;
        this.f13939b = i5;
        boolean z4 = false;
        if (i6 <= 0 ? i4 >= i5 : i4 <= i5) {
            z4 = true;
        }
        this.f13940c = z4;
        this.f13941d = z4 ? i4 : i5;
    }

    @Override // X2.G
    public int b() {
        int i4 = this.f13941d;
        if (i4 != this.f13939b) {
            this.f13941d = this.f13938a + i4;
            return i4;
        }
        if (!this.f13940c) {
            throw new NoSuchElementException();
        }
        this.f13940c = false;
        return i4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13940c;
    }
}
