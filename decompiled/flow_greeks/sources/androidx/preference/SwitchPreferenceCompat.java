package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import d2.c;
import d2.d;
import d2.g;
import k0.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    public final a I;
    public CharSequence Q;
    public CharSequence R;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (SwitchPreferenceCompat.this.a(Boolean.valueOf(z10))) {
                SwitchPreferenceCompat.this.a0(z10);
            } else {
                compoundButton.setChecked(!z10);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.U0, i10, i11);
        d0(i.f(typedArrayObtainStyledAttributes, g.f7527c1, g.V0));
        c0(i.f(typedArrayObtainStyledAttributes, g.f7524b1, g.W0));
        g0(i.f(typedArrayObtainStyledAttributes, g.f7533e1, g.Y0));
        f0(i.f(typedArrayObtainStyledAttributes, g.f7530d1, g.Z0));
        b0(i.b(typedArrayObtainStyledAttributes, g.f7521a1, g.X0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h0(View view) {
        boolean z10 = view instanceof SwitchCompat;
        if (z10) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.D);
        }
        if (z10) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.Q);
            switchCompat.setTextOff(this.R);
            switchCompat.setOnCheckedChangeListener(this.I);
        }
    }

    private void i0(View view) {
        if (((AccessibilityManager) c().getSystemService("accessibility")).isEnabled()) {
            h0(view.findViewById(d.f7516a));
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

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f7514i);
    }
}
