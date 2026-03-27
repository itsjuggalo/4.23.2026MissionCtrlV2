package W5;

import F5.E;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5456d;

    public f(int i7, int i8, int i9) {
        this.f5453a = i9;
        this.f5454b = i8;
        boolean z7 = false;
        if (i9 <= 0 ? i7 >= i8 : i7 <= i8) {
            z7 = true;
        }
        this.f5455c = z7;
        this.f5456d = z7 ? i7 : i8;
    }

    @Override // F5.E
    public int c() {
        int i7 = this.f5456d;
        if (i7 != this.f5454b) {
            this.f5456d = this.f5453a + i7;
        } else {
            if (!this.f5455c) {
                throw new NoSuchElementException();
            }
            this.f5455c = false;
        }
        return i7;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f5455c;
    }
}
