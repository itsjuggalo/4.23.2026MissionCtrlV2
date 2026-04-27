package androidx.preference;

import K.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import s0.AbstractC2683c;
import s0.g;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final a f12111I;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence f12112P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public CharSequence f12113Q;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (SwitchPreference.this.a(Boolean.valueOf(z7))) {
                SwitchPreference.this.a0(z7);
            } else {
                compoundButton.setChecked(!z7);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, AbstractC2683c.f22952j, R.attr.switchPreferenceStyle));
    }

    private void i0(View view) {
        if (((AccessibilityManager) g().getSystemService("accessibility")).isEnabled()) {
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
        this.f12113Q = charSequence;
        L();
    }

    public void g0(CharSequence charSequence) {
        this.f12112P = charSequence;
        L();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h0(View view) {
        boolean z7 = view instanceof Switch;
        if (z7) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f12119D);
        }
        if (z7) {
            Switch r42 = (Switch) view;
            r42.setTextOn(this.f12112P);
            r42.setTextOff(this.f12113Q);
            r42.setOnCheckedChangeListener(this.f12111I);
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.f12111I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f22975J0, i8, i9);
        d0(i.f(typedArrayObtainStyledAttributes, g.f22991R0, g.f22977K0));
        c0(i.f(typedArrayObtainStyledAttributes, g.f22989Q0, g.f22979L0));
        g0(i.f(typedArrayObtainStyledAttributes, g.f22995T0, g.f22983N0));
        f0(i.f(typedArrayObtainStyledAttributes, g.f22993S0, g.f22985O0));
        b0(i.b(typedArrayObtainStyledAttributes, g.f22987P0, g.f22981M0, false));
        typedArrayObtainStyledAttributes.recycle();
    }
}
