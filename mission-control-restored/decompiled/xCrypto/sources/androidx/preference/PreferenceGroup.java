package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import h0.AbstractC1277g;
import java.util.ArrayList;
import java.util.List;
import u.C1859g;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final C1859g f7791D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final Handler f7792E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final List f7793F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f7794G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public int f7795H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f7796I;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public int f7797O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public final Runnable f7798P;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.f7791D.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f7791D = new C1859g();
        this.f7792E = new Handler(Looper.getMainLooper());
        this.f7794G = true;
        this.f7795H = 0;
        this.f7796I = false;
        this.f7797O = Integer.MAX_VALUE;
        this.f7798P = new a();
        this.f7793F = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f12084v0, i4, i5);
        int i6 = AbstractC1277g.f12088x0;
        this.f7794G = AbstractC1934i.b(typedArrayObtainStyledAttributes, i6, i6, true);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC1277g.f12086w0)) {
            int i7 = AbstractC1277g.f12086w0;
            M(AbstractC1934i.d(typedArrayObtainStyledAttributes, i7, i7, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public Preference K(int i4) {
        return (Preference) this.f7793F.get(i4);
    }

    public int L() {
        return this.f7793F.size();
    }

    public void M(int i4) {
        if (i4 != Integer.MAX_VALUE && !t()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.f7797O = i4;
    }

    @Override // androidx.preference.Preference
    public void x(boolean z4) {
        super.x(z4);
        int iL = L();
        for (int i4 = 0; i4 < iL; i4++) {
            K(i4).B(this, z4);
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
