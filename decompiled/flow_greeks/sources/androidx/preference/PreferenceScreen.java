package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import d2.c;
import k0.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public boolean S;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, i.a(context, c.f7511f, R.attr.preferenceScreenStyle));
        this.S = true;
    }

    @Override // androidx.preference.Preference
    public void H() {
        if (k() == null && i() == null && a0() != 0) {
            s();
            throw null;
        }
    }
}
