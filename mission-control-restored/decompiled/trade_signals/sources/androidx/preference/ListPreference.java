package androidx.preference;

import K.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import s0.AbstractC2683c;
import s0.f;
import s0.g;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence[] f12048P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public CharSequence[] f12049Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public String f12050R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public String f12051S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public boolean f12052T;

    public static final class a implements Preference.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f12053a;

        public static a b() {
            if (f12053a == null) {
                f12053a = new a();
            }
            return f12053a;
        }

        @Override // androidx.preference.Preference.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.b0()) ? listPreference.g().getString(f.f22955a) : listPreference.b0();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, AbstractC2683c.f22944b, R.attr.dialogPreferenceStyle));
    }

    @Override // androidx.preference.Preference
    public Object P(TypedArray typedArray, int i8) {
        return typedArray.getString(i8);
    }

    public int Z(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f12049Q) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.f12049Q[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] a0() {
        return this.f12048P;
    }

    public CharSequence b0() {
        CharSequence[] charSequenceArr;
        int iE0 = e0();
        if (iE0 < 0 || (charSequenceArr = this.f12048P) == null) {
            return null;
        }
        return charSequenceArr[iE0];
    }

    public CharSequence[] c0() {
        return this.f12049Q;
    }

    public String d0() {
        return this.f12050R;
    }

    public final int e0() {
        return Z(this.f12050R);
    }

    public void f0(String str) {
        boolean z7 = !TextUtils.equals(this.f12050R, str);
        if (z7 || !this.f12052T) {
            this.f12050R = str;
            this.f12052T = true;
            V(str);
            if (z7) {
                L();
            }
        }
    }

    @Override // androidx.preference.Preference
    public CharSequence w() {
        if (B() != null) {
            return B().a(this);
        }
        CharSequence charSequenceB0 = b0();
        CharSequence charSequenceW = super.w();
        String str = this.f12051S;
        if (str == null) {
            return charSequenceW;
        }
        if (charSequenceB0 == null) {
            charSequenceB0 = "";
        }
        String str2 = String.format(str, charSequenceB0);
        if (TextUtils.equals(str2, charSequenceW)) {
            return charSequenceW;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return str2;
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f23059x, i8, i9);
        this.f12048P = i.h(typedArrayObtainStyledAttributes, g.f22956A, g.f23061y);
        this.f12049Q = i.h(typedArrayObtainStyledAttributes, g.f22958B, g.f23063z);
        int i10 = g.f22960C;
        if (i.b(typedArrayObtainStyledAttributes, i10, i10, false)) {
            W(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.f22972I, i8, i9);
        this.f12051S = i.f(typedArrayObtainStyledAttributes2, g.f23046q0, g.f22988Q);
        typedArrayObtainStyledAttributes2.recycle();
    }
}
