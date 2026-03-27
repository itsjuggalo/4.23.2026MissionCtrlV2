package androidx.preference;

import K.i;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import s0.AbstractC2683c;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, AbstractC2683c.f22947e, R.attr.preferenceCategoryStyle));
    }

    @Override // androidx.preference.Preference
    public boolean J() {
        return false;
    }

    @Override // androidx.preference.Preference
    public boolean X() {
        return !super.J();
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
    }
}
