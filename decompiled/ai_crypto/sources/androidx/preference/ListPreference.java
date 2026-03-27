package androidx.preference;

import H.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import x0.c;
import x0.f;
import x0.g;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public CharSequence[] f7861O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence[] f7862P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public String f7863Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public String f7864R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public boolean f7865S;

    public static final class a implements Preference.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f7866a;

        public static a b() {
            if (f7866a == null) {
                f7866a = new a();
            }
            return f7866a;
        }

        @Override // androidx.preference.Preference.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.L()) ? listPreference.c().getString(f.f25160a) : listPreference.L();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f25264x, i7, i8);
        this.f7861O = i.h(typedArrayObtainStyledAttributes, g.f25161A, g.f25266y);
        this.f7862P = i.h(typedArrayObtainStyledAttributes, g.f25163B, g.f25268z);
        int i9 = g.f25165C;
        if (i.b(typedArrayObtainStyledAttributes, i9, i9, false)) {
            G(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.f25177I, i7, i8);
        this.f7864R = i.f(typedArrayObtainStyledAttributes2, g.f25251q0, g.f25193Q);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public int J(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f7862P) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.f7862P[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] K() {
        return this.f7861O;
    }

    public CharSequence L() {
        CharSequence[] charSequenceArr;
        int iO = O();
        if (iO < 0 || (charSequenceArr = this.f7861O) == null) {
            return null;
        }
        return charSequenceArr[iO];
    }

    public CharSequence[] M() {
        return this.f7862P;
    }

    public String N() {
        return this.f7863Q;
    }

    public final int O() {
        return J(this.f7863Q);
    }

    public void P(String str) {
        boolean zEquals = TextUtils.equals(this.f7863Q, str);
        if (zEquals && this.f7865S) {
            return;
        }
        this.f7863Q = str;
        this.f7865S = true;
        F(str);
        if (zEquals) {
            return;
        }
        v();
    }

    @Override // androidx.preference.Preference
    public CharSequence p() {
        if (q() != null) {
            return q().a(this);
        }
        CharSequence charSequenceL = L();
        CharSequence charSequenceP = super.p();
        String str = this.f7864R;
        if (str == null) {
            return charSequenceP;
        }
        if (charSequenceL == null) {
            charSequenceL = "";
        }
        String str2 = String.format(str, charSequenceL);
        if (TextUtils.equals(str2, charSequenceP)) {
            return charSequenceP;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return str2;
    }

    @Override // androidx.preference.Preference
    public Object z(TypedArray typedArray, int i7) {
        return typedArray.getString(i7);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f25149b, R.attr.dialogPreferenceStyle));
    }
}
