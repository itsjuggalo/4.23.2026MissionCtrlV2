package androidx.preference;

import K.i;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import s0.AbstractC2683c;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f12096R;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, i.a(context, AbstractC2683c.f22948f, R.attr.preferenceScreenStyle));
        this.f12096R = true;
    }

    @Override // androidx.preference.Preference
    public void N() {
        if (l() == null && k() == null && a0() != 0) {
            t();
            throw null;
        }
    }
}
