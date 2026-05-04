package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import d2.c;
import d2.f;
import d2.g;
import k0.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public CharSequence[] Q;
    public CharSequence[] R;
    public String S;
    public String T;
    public boolean U;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Preference.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f2508a;

        public static a b() {
            if (f2508a == null) {
                f2508a = new a();
            }
            return f2508a;
        }

        @Override // androidx.preference.Preference.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.b0()) ? listPreference.c().getString(f.f7518a) : listPreference.b0();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7570x, i10, i11);
        this.Q = i.h(typedArrayObtainStyledAttributes, g.A, g.f7572y);
        this.R = i.h(typedArrayObtainStyledAttributes, g.B, g.f7574z);
        int i12 = g.C;
        if (i.b(typedArrayObtainStyledAttributes, i12, i12, false)) {
            W(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.I, i10, i11);
        this.T = i.f(typedArrayObtainStyledAttributes2, g.f7557q0, g.Q);
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public Object L(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    public int Z(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.R) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.R[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] a0() {
        return this.Q;
    }

    public CharSequence b0() {
        CharSequence[] charSequenceArr;
        int iE0 = e0();
        if (iE0 < 0 || (charSequenceArr = this.Q) == null) {
            return null;
        }
        return charSequenceArr[iE0];
    }

    public CharSequence[] c0() {
        return this.R;
    }

    public String d0() {
        return this.S;
    }

    public final int e0() {
        return Z(this.S);
    }

    public void f0(String str) {
        boolean zEquals = TextUtils.equals(this.S, str);
        if (zEquals && this.U) {
            return;
        }
        this.S = str;
        this.U = true;
        V(str);
        if (zEquals) {
            return;
        }
        E();
    }

    @Override // androidx.preference.Preference
    public CharSequence u() {
        if (v() != null) {
            return v().a(this);
        }
        CharSequence charSequenceB0 = b0();
        CharSequence charSequenceU = super.u();
        String str = this.T;
        if (str != null) {
            if (charSequenceB0 == null) {
                charSequenceB0 = "";
            }
            String str2 = String.format(str, charSequenceB0);
            if (!TextUtils.equals(str2, charSequenceU)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceU;
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f7507b, R.attr.dialogPreferenceStyle));
    }
}
