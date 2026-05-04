package l5;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends a0 {
    public c0(int i10, int i11, Bundle bundle) {
        super(i10, i11, bundle);
    }

    @Override // l5.a0
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        d(bundle2);
    }

    @Override // l5.a0
    public final boolean b() {
        return false;
    }
}
