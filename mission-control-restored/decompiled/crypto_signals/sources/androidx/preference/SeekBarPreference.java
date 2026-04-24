package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.cryptosignals.ap.android.R;
import i0.b;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f4720l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4721m;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.i, R.attr.seekBarPreferenceStyle, 0);
        int i = typedArrayObtainStyledAttributes.getInt(3, 0);
        int i6 = typedArrayObtainStyledAttributes.getInt(1, 100);
        i6 = i6 < i ? i : i6;
        if (i6 != this.f4720l) {
            this.f4720l = i6;
        }
        int i7 = typedArrayObtainStyledAttributes.getInt(4, 0);
        if (i7 != this.f4721m) {
            this.f4721m = Math.min(this.f4720l - i, Math.abs(i7));
        }
        typedArrayObtainStyledAttributes.getBoolean(2, true);
        typedArrayObtainStyledAttributes.getBoolean(5, false);
        typedArrayObtainStyledAttributes.getBoolean(6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }
}
