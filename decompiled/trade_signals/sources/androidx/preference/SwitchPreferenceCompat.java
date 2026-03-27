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
import androidx.appcompat.widget.SwitchCompat;
import s0.AbstractC2683c;
import s0.AbstractC2684d;
import s0.g;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final a f12115I;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence f12116P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public CharSequence f12117Q;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (SwitchPreferenceCompat.this.a(Boolean.valueOf(z7))) {
                SwitchPreferenceCompat.this.a0(z7);
            } else {
                compoundButton.setChecked(!z7);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC2683c.f22951i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h0(View view) {
        boolean z7 = view instanceof SwitchCompat;
        if (z7) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f12119D);
        }
        if (z7) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f12116P);
            switchCompat.setTextOff(this.f12117Q);
            switchCompat.setOnCheckedChangeListener(this.f12115I);
        }
    }

    private void i0(View view) {
        if (((AccessibilityManager) g().getSystemService("accessibility")).isEnabled()) {
            h0(view.findViewById(AbstractC2684d.f22953a));
            e0(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void S(View view) {
        super.S(view);
        i0(view);
    }

    public void f0(CharSequence charSequence) {
        this.f12117Q = charSequence;
        L();
    }

    public void g0(CharSequence charSequence) {
        this.f12116P = charSequence;
        L();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.f12115I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f22997U0, i8, i9);
        d0(i.f(typedArrayObtainStyledAttributes, g.f23016c1, g.f22999V0));
        c0(i.f(typedArrayObtainStyledAttributes, g.f23013b1, g.f23001W0));
        g0(i.f(typedArrayObtainStyledAttributes, g.f23022e1, g.f23005Y0));
        f0(i.f(typedArrayObtainStyledAttributes, g.f23019d1, g.f23007Z0));
        b0(i.b(typedArrayObtainStyledAttributes, g.f23010a1, g.f23003X0, false));
        typedArrayObtainStyledAttributes.recycle();
    }
}
