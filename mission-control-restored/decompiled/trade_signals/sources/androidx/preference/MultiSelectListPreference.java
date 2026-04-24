package androidx.preference;

import K.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.HashSet;
import java.util.Set;
import s0.AbstractC2683c;
import s0.g;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence[] f12054P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public CharSequence[] f12055Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public Set f12056R;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, AbstractC2683c.f22944b, R.attr.dialogPreferenceStyle));
    }

    @Override // androidx.preference.Preference
    public Object P(TypedArray typedArray, int i8) {
        CharSequence[] textArray = typedArray.getTextArray(i8);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.f12056R = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f22962D, i8, i9);
        this.f12054P = i.h(typedArrayObtainStyledAttributes, g.f22968G, g.f22964E);
        this.f12055Q = i.h(typedArrayObtainStyledAttributes, g.f22970H, g.f22966F);
        typedArrayObtainStyledAttributes.recycle();
    }
}
