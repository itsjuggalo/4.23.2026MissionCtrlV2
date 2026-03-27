package a3;

import com.google.android.gms.common.api.internal.ComponentCallbacks2C1166c;

/* JADX INFO: renamed from: a3.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0858j0 implements ComponentCallbacks2C1166c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0852g0 f6244a;

    public C0858j0(C0852g0 c0852g0) {
        this.f6244a = c0852g0;
    }

    @Override // com.google.android.gms.common.api.internal.ComponentCallbacks2C1166c.a
    public final void a(boolean z7) {
        if (z7) {
            this.f6244a.f6219c = true;
            this.f6244a.b();
        } else {
            this.f6244a.f6219c = false;
            if (this.f6244a.f()) {
                this.f6244a.f6218b.c();
            }
        }
    }
}
