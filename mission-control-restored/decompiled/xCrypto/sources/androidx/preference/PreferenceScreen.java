package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import h0.AbstractC1273c;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f7800Q;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, AbstractC1934i.a(context, AbstractC1273c.f11976f, R.attr.preferenceScreenStyle));
        this.f7800Q = true;
    }

    @Override // androidx.preference.Preference
    public void y() {
        if (k() == null && i() == null && L() != 0) {
            p();
            throw null;
        }
    }
}
