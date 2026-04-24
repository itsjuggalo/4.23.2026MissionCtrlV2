package androidx.preference;

import H.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import x0.c;
import x0.f;
import x0.g;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public String f7859O;

    public static final class a implements Preference.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f7860a;

        public static a b() {
            if (f7860a == null) {
                f7860a = new a();
            }
            return f7860a;
        }

        @Override // androidx.preference.Preference.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.J()) ? editTextPreference.c().getString(f.f25160a) : editTextPreference.J();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f25260v, i7, i8);
        int i9 = g.f25262w;
        if (i.b(typedArrayObtainStyledAttributes, i9, i9, false)) {
            G(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public boolean H() {
        return TextUtils.isEmpty(this.f7859O) || super.H();
    }

    public String J() {
        return this.f7859O;
    }

    @Override // androidx.preference.Preference
    public Object z(TypedArray typedArray, int i7) {
        return typedArray.getString(i7);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f25151d, R.attr.editTextPreferenceStyle));
    }
}
