package androidx.preference;

import K.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import s0.AbstractC2683c;
import s0.f;
import s0.g;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public String f12046P;

    public static final class a implements Preference.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f12047a;

        public static a b() {
            if (f12047a == null) {
                f12047a = new a();
            }
            return f12047a;
        }

        @Override // androidx.preference.Preference.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.Z()) ? editTextPreference.g().getString(f.f22955a) : editTextPreference.Z();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, AbstractC2683c.f22946d, R.attr.editTextPreferenceStyle));
    }

    @Override // androidx.preference.Preference
    public Object P(TypedArray typedArray, int i8) {
        return typedArray.getString(i8);
    }

    @Override // androidx.preference.Preference
    public boolean X() {
        return TextUtils.isEmpty(this.f12046P) || super.X();
    }

    public String Z() {
        return this.f12046P;
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f23055v, i8, i9);
        int i10 = g.f23057w;
        if (i.b(typedArrayObtainStyledAttributes, i10, i10, false)) {
            W(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
