package androidx.preference;

import H.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import x0.c;
import x0.d;
import x0.g;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final a f7928I;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public CharSequence f7929O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence f7930P;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (SwitchPreferenceCompat.this.a(Boolean.valueOf(z7))) {
                SwitchPreferenceCompat.this.K(z7);
            } else {
                compoundButton.setChecked(!z7);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f7928I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f25202U0, i7, i8);
        N(i.f(typedArrayObtainStyledAttributes, g.f25221c1, g.f25204V0));
        M(i.f(typedArrayObtainStyledAttributes, g.f25218b1, g.f25206W0));
        Q(i.f(typedArrayObtainStyledAttributes, g.f25227e1, g.f25210Y0));
        P(i.f(typedArrayObtainStyledAttributes, g.f25224d1, g.f25212Z0));
        L(i.b(typedArrayObtainStyledAttributes, g.f25215a1, g.f25208X0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void R(View view) {
        boolean z7 = view instanceof SwitchCompat;
        if (z7) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f7932D);
        }
        if (z7) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f7929O);
            switchCompat.setTextOff(this.f7930P);
            switchCompat.setOnCheckedChangeListener(this.f7928I);
        }
    }

    private void S(View view) {
        if (((AccessibilityManager) c().getSystemService("accessibility")).isEnabled()) {
            R(view.findViewById(d.f25158a));
            O(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void C(View view) {
        super.C(view);
        S(view);
    }

    public void P(CharSequence charSequence) {
        this.f7930P = charSequence;
        v();
    }

    public void Q(CharSequence charSequence) {
        this.f7929O = charSequence;
        v();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f25156i);
    }
}
