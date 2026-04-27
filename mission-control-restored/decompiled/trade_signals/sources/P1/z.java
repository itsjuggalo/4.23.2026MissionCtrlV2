package P1;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class z extends A {
    public z(int i8, int i9, Bundle bundle) {
        super(i8, i9, bundle);
    }

    @Override // P1.A
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            d(null);
        } else {
            c(new B(4, "Invalid response to one way request", null));
        }
    }

    @Override // P1.A
    public final boolean b() {
        return true;
    }
}
