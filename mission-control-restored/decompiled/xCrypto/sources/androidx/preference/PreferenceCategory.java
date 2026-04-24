package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import h0.AbstractC1273c;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }

    @Override // androidx.preference.Preference
    public boolean I() {
        return !super.u();
    }

    @Override // androidx.preference.Preference
    public boolean u() {
        return false;
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1934i.a(context, AbstractC1273c.f11975e, R.attr.preferenceCategoryStyle));
    }
}
