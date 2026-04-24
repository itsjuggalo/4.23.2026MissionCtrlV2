package y1;

import android.os.Bundle;
import com.google.firebase.messaging.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class C extends AbstractC1937A {
    public C(int i4, int i5, Bundle bundle) {
        super(i4, i5, bundle);
    }

    @Override // y1.AbstractC1937A
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        d(bundle2);
    }

    @Override // y1.AbstractC1937A
    public final boolean b() {
        return false;
    }
}
