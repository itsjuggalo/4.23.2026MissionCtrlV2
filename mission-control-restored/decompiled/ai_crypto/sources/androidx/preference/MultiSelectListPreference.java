package androidx.preference;

import H.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.HashSet;
import java.util.Set;
import x0.c;
import x0.g;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public CharSequence[] f7867O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence[] f7868P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public Set f7869Q;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f7869Q = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f25167D, i7, i8);
        this.f7867O = i.h(typedArrayObtainStyledAttributes, g.f25173G, g.f25169E);
        this.f7868P = i.h(typedArrayObtainStyledAttributes, g.f25175H, g.f25171F);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public Object z(TypedArray typedArray, int i7) {
        CharSequence[] textArray = typedArray.getTextArray(i7);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f25149b, R.attr.dialogPreferenceStyle));
    }
}
