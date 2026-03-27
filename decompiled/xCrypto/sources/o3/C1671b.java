package o3;

import X2.AbstractC0767n;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: o3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1671b extends AbstractC0767n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13931d;

    public C1671b(char c4, char c5, int i4) {
        this.f13928a = i4;
        this.f13929b = c5;
        boolean z4 = false;
        if (i4 <= 0 ? r.g(c4, c5) >= 0 : r.g(c4, c5) <= 0) {
            z4 = true;
        }
        this.f13930c = z4;
        this.f13931d = z4 ? c4 : c5;
    }

    @Override // X2.AbstractC0767n
    public char b() {
        int i4 = this.f13931d;
        if (i4 != this.f13929b) {
            this.f13931d = this.f13928a + i4;
        } else {
            if (!this.f13930c) {
                throw new NoSuchElementException();
            }
            this.f13930c = false;
        }
        return (char) i4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13930c;
    }
}
