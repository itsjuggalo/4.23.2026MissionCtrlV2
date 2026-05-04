package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import d2.c;
import d2.g;
import k0.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    public final a I;
    public CharSequence Q;
    public CharSequence R;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (SwitchPreference.this.a(Boolean.valueOf(z10))) {
                SwitchPreference.this.a0(z10);
            } else {
                compoundButton.setChecked(!z10);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.J0, i10, i11);
        d0(i.f(typedArrayObtainStyledAttributes, g.R0, g.K0));
        c0(i.f(typedArrayObtainStyledAttributes, g.Q0, g.L0));
        g0(i.f(typedArrayObtainStyledAttributes, g.T0, g.N0));
        f0(i.f(typedArrayObtainStyledAttributes, g.S0, g.O0));
        b0(i.b(typedArrayObtainStyledAttributes, g.P0, g.M0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void i0(View view) {
        if (((AccessibilityManager) c().getSystemService("accessibility")).isEnabled()) {
            h0(view.findViewById(R.id.switch_widget));
            e0(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void S(View view) {
        super.S(view);
        i0(view);
    }

    public void f0(CharSequence charSequence) {
        this.R = charSequence;
        E();
    }

    public void g0(CharSequence charSequence) {
        this.Q = charSequence;
        E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h0(View view) {
        boolean z10 = view instanceof Switch;
        if (z10) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.D);
        }
        if (z10) {
            Switch r42 = (Switch) view;
            r42.setTextOn(this.Q);
            r42.setTextOff(this.R);
            r42.setOnCheckedChangeListener(this.I);
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f7515j, R.attr.switchPreferenceStyle));
    }
}
