package P1;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class C extends A {
    public C(int i8, int i9, Bundle bundle) {
        super(i8, i9, bundle);
    }

    @Override // P1.A
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        d(bundle2);
    }

    @Override // P1.A
    public final boolean b() {
        return false;
    }
}
