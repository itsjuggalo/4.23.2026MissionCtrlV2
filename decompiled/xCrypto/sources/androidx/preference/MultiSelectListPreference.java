package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import h0.AbstractC1273c;
import h0.AbstractC1277g;
import java.util.HashSet;
import java.util.Set;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public CharSequence[] f7758O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence[] f7759P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public Set f7760Q;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f7760Q = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f11990D, i4, i5);
        this.f7758O = AbstractC1934i.h(typedArrayObtainStyledAttributes, AbstractC1277g.f11996G, AbstractC1277g.f11992E);
        this.f7759P = AbstractC1934i.h(typedArrayObtainStyledAttributes, AbstractC1277g.f11998H, AbstractC1277g.f11994F);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public Object A(TypedArray typedArray, int i4) {
        CharSequence[] textArray = typedArray.getTextArray(i4);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1934i.a(context, AbstractC1273c.f11972b, R.attr.dialogPreferenceStyle));
    }
}
