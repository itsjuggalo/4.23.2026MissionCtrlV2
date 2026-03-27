package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.cryptosignals.ap.android.R;
import v.AbstractC1253b;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, AbstractC1253b.a(context, R.attr.preferenceCategoryStyle, android.R.attr.preferenceCategoryStyle));
    }
}
