package O1;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class z extends A {
    public z(int i7, int i8, Bundle bundle) {
        super(i7, i8, bundle);
    }

    @Override // O1.A
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            d(null);
        } else {
            c(new B(4, "Invalid response to one way request", null));
        }
    }

    @Override // O1.A
    public final boolean b() {
        return true;
    }
}
