package j6;

import R5.h0;
import R5.i0;
import e6.C1677D;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: j6.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2261y implements h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1677D f20235b;

    public C2261y(C1677D packageFragment) {
        AbstractC2304t.f(packageFragment, "packageFragment");
        this.f20235b = packageFragment;
    }

    @Override // R5.h0
    public i0 a() {
        i0 NO_SOURCE_FILE = i0.f7250a;
        AbstractC2304t.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    public String toString() {
        return this.f20235b + ": " + this.f20235b.P0().keySet();
    }
}
