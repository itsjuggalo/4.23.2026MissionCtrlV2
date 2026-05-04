package vd;

import dd.p;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23383d;

    public b(char c10, char c11, int i10) {
        this.f23380a = i10;
        this.f23381b = c11;
        boolean z10 = false;
        if (i10 <= 0 ? t.g(c10, c11) >= 0 : t.g(c10, c11) <= 0) {
            z10 = true;
        }
        this.f23382c = z10;
        this.f23383d = z10 ? c10 : c11;
    }

    @Override // dd.p
    public char c() {
        int i10 = this.f23383d;
        if (i10 != this.f23381b) {
            this.f23383d = this.f23380a + i10;
        } else {
            if (!this.f23382c) {
                throw new NoSuchElementException();
            }
            this.f23382c = false;
        }
        return (char) i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f23382c;
    }
}
