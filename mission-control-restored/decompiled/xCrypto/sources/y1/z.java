package y1;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class z extends AbstractC1937A {
    public z(int i4, int i5, Bundle bundle) {
        super(i4, i5, bundle);
    }

    @Override // y1.AbstractC1937A
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            d(null);
        } else {
            c(new B(4, "Invalid response to one way request", null));
        }
    }

    @Override // y1.AbstractC1937A
    public final boolean b() {
        return true;
    }
}
