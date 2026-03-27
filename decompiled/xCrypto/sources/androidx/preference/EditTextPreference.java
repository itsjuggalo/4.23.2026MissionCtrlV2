package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import h0.AbstractC1273c;
import h0.AbstractC1276f;
import h0.AbstractC1277g;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public String f7750O;

    public static final class a implements Preference.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f7751a;

        public static a b() {
            if (f7751a == null) {
                f7751a = new a();
            }
            return f7751a;
        }

        @Override // androidx.preference.Preference.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.K()) ? editTextPreference.g().getString(AbstractC1276f.f11983a) : editTextPreference.K();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f12083v, i4, i5);
        int i6 = AbstractC1277g.f12085w;
        if (AbstractC1934i.b(typedArrayObtainStyledAttributes, i6, i6, false)) {
            H(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public Object A(TypedArray typedArray, int i4) {
        return typedArray.getString(i4);
    }

    @Override // androidx.preference.Preference
    public boolean I() {
        return TextUtils.isEmpty(this.f7750O) || super.I();
    }

    public String K() {
        return this.f7750O;
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1934i.a(context, AbstractC1273c.f11974d, R.attr.editTextPreferenceStyle));
    }
}
