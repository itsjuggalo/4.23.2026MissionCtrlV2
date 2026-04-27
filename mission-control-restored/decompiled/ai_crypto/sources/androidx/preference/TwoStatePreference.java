package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f7932D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public CharSequence f7933E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public CharSequence f7934F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f7935G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f7936H;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
    }

    @Override // androidx.preference.Preference
    public boolean H() {
        return (this.f7936H ? this.f7932D : !this.f7932D) || super.H();
    }

    public boolean J() {
        return this.f7932D;
    }

    public void K(boolean z7) {
        boolean z8 = this.f7932D != z7;
        if (z8 || !this.f7935G) {
            this.f7932D = z7;
            this.f7935G = true;
            D(z7);
            if (z8) {
                w(H());
                v();
            }
        }
    }

    public void L(boolean z7) {
        this.f7936H = z7;
    }

    public void M(CharSequence charSequence) {
        this.f7934F = charSequence;
        if (J()) {
            return;
        }
        v();
    }

    public void N(CharSequence charSequence) {
        this.f7933E = charSequence;
        if (J()) {
            v();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void O(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.f7932D
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r4.f7933E
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r4.f7933E
            r5.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r4.f7932D
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r4.f7934F
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r4.f7934F
            r5.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r2 = r4.p()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L3e
            r5.setText(r2)
            r0 = r1
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L4c
            r5.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.O(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    public void x() {
        super.x();
        boolean z7 = !J();
        if (a(Boolean.valueOf(z7))) {
            K(z7);
        }
    }

    @Override // androidx.preference.Preference
    public Object z(TypedArray typedArray, int i7) {
        return Boolean.valueOf(typedArray.getBoolean(i7, false));
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
