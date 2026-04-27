package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.j4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0603j4 extends A {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4696e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0603j4(C0540b5 c0540b5, V3 v32) {
        super(v32);
        Objects.requireNonNull(c0540b5);
        this.f4696e = c0540b5;
    }

    @Override // S1.A
    public final void a() {
        final C0540b5 c0540b5B = this.f4696e.f4245a.B();
        Objects.requireNonNull(c0540b5B);
        new Thread(new Runnable() { // from class: S1.i4
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                c0540b5B.t0();
            }
        }).start();
    }
}
