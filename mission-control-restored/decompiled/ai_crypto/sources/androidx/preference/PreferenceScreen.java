package androidx.preference;

import H.i;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import x0.c;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f7909Q;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, i.a(context, c.f25153f, R.attr.preferenceScreenStyle));
        this.f7909Q = true;
    }

    @Override // androidx.preference.Preference
    public void x() {
        if (j() == null && i() == null && K() != 0) {
            o();
            throw null;
        }
    }
}
