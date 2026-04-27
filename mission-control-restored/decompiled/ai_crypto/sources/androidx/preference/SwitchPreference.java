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
import android.widget.Switch;
import x0.c;
import x0.g;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final a f7924I;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public CharSequence f7925O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence f7926P;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (SwitchPreference.this.a(Boolean.valueOf(z7))) {
                SwitchPreference.this.K(z7);
            } else {
                compoundButton.setChecked(!z7);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f7924I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f25180J0, i7, i8);
        N(i.f(typedArrayObtainStyledAttributes, g.f25196R0, g.f25182K0));
        M(i.f(typedArrayObtainStyledAttributes, g.f25194Q0, g.f25184L0));
        Q(i.f(typedArrayObtainStyledAttributes, g.f25200T0, g.f25188N0));
        P(i.f(typedArrayObtainStyledAttributes, g.f25198S0, g.f25190O0));
        L(i.b(typedArrayObtainStyledAttributes, g.f25192P0, g.f25186M0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void S(View view) {
        if (((AccessibilityManager) c().getSystemService("accessibility")).isEnabled()) {
            R(view.findViewById(R.id.switch_widget));
            O(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void C(View view) {
        super.C(view);
        S(view);
    }

    public void P(CharSequence charSequence) {
        this.f7926P = charSequence;
        v();
    }

    public void Q(CharSequence charSequence) {
        this.f7925O = charSequence;
        v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R(View view) {
        boolean z7 = view instanceof Switch;
        if (z7) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f7932D);
        }
        if (z7) {
            Switch r42 = (Switch) view;
            r42.setTextOn(this.f7925O);
            r42.setTextOff(this.f7926P);
            r42.setOnCheckedChangeListener(this.f7924I);
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f25157j, R.attr.switchPreferenceStyle));
    }
}
