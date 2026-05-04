package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.gms.common.api.a;
import d2.g;
import java.util.ArrayList;
import java.util.List;
import w.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public final i D;
    public final Handler E;
    public final List F;
    public boolean G;
    public int H;
    public boolean I;
    public int Q;
    public final Runnable R;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.D.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.D = new i();
        this.E = new Handler(Looper.getMainLooper());
        this.G = true;
        this.H = 0;
        this.I = false;
        this.Q = a.e.API_PRIORITY_OTHER;
        this.R = new a();
        this.F = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7567v0, i10, i11);
        int i12 = g.f7571x0;
        this.G = k0.i.b(typedArrayObtainStyledAttributes, i12, i12, true);
        if (typedArrayObtainStyledAttributes.hasValue(g.f7569w0)) {
            int i13 = g.f7569w0;
            b0(k0.i.d(typedArrayObtainStyledAttributes, i13, i13, a.e.API_PRIORITY_OTHER));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void G(boolean z10) {
        super.G(z10);
        int iA0 = a0();
        for (int i10 = 0; i10 < iA0; i10++) {
            Z(i10).M(this, z10);
        }
    }

    public Preference Z(int i10) {
        return (Preference) this.F.get(i10);
    }

    public int a0() {
        return this.F.size();
    }

    public void b0(int i10) {
        if (i10 != Integer.MAX_VALUE && !y()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.Q = i10;
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
