package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import h0.AbstractC1273c;
import h0.AbstractC1276f;
import h0.AbstractC1277g;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public CharSequence[] f7752O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence[] f7753P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public String f7754Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public String f7755R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public boolean f7756S;

    public static final class a implements Preference.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f7757a;

        public static a b() {
            if (f7757a == null) {
                f7757a = new a();
            }
            return f7757a;
        }

        @Override // androidx.preference.Preference.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.M()) ? listPreference.g().getString(AbstractC1276f.f11983a) : listPreference.M();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f12087x, i4, i5);
        this.f7752O = AbstractC1934i.h(typedArrayObtainStyledAttributes, AbstractC1277g.f11984A, AbstractC1277g.f12089y);
        this.f7753P = AbstractC1934i.h(typedArrayObtainStyledAttributes, AbstractC1277g.f11986B, AbstractC1277g.f12091z);
        int i6 = AbstractC1277g.f11988C;
        if (AbstractC1934i.b(typedArrayObtainStyledAttributes, i6, i6, false)) {
            H(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f12000I, i4, i5);
        this.f7755R = AbstractC1934i.f(typedArrayObtainStyledAttributes2, AbstractC1277g.f12074q0, AbstractC1277g.f12016Q);
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public Object A(TypedArray typedArray, int i4) {
        return typedArray.getString(i4);
    }

    public int K(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f7753P) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.f7753P[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] L() {
        return this.f7752O;
    }

    public CharSequence M() {
        CharSequence[] charSequenceArr;
        int iP = P();
        if (iP < 0 || (charSequenceArr = this.f7752O) == null) {
            return null;
        }
        return charSequenceArr[iP];
    }

    public CharSequence[] N() {
        return this.f7753P;
    }

    public String O() {
        return this.f7754Q;
    }

    public final int P() {
        return K(this.f7754Q);
    }

    public void Q(String str) {
        boolean zEquals = TextUtils.equals(this.f7754Q, str);
        if (zEquals && this.f7756S) {
            return;
        }
        this.f7754Q = str;
        this.f7756S = true;
        G(str);
        if (zEquals) {
            return;
        }
        w();
    }

    @Override // androidx.preference.Preference
    public CharSequence q() {
        if (r() != null) {
            return r().a(this);
        }
        CharSequence charSequenceM = M();
        CharSequence charSequenceQ = super.q();
        String str = this.f7755R;
        if (str != null) {
            if (charSequenceM == null) {
                charSequenceM = "";
            }
            String str2 = String.format(str, charSequenceM);
            if (!TextUtils.equals(str2, charSequenceQ)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceQ;
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1934i.a(context, AbstractC1273c.f11972b, R.attr.dialogPreferenceStyle));
    }
}
