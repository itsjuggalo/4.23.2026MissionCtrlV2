package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import s0.g;
import w.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final i f12087D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final Handler f12088E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final List f12089F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f12090G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public int f12091H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f12092I;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public int f12093P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final Runnable f12094Q;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.f12087D.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.preference.Preference
    public void M(boolean z7) {
        super.M(z7);
        int iA0 = a0();
        for (int i8 = 0; i8 < iA0; i8++) {
            Z(i8).Q(this, z7);
        }
    }

    public Preference Z(int i8) {
        return (Preference) this.f12089F.get(i8);
    }

    public int a0() {
        return this.f12089F.size();
    }

    public void b0(int i8) {
        if (i8 != Integer.MAX_VALUE && !I()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.f12093P = i8;
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.f12087D = new i();
        this.f12088E = new Handler(Looper.getMainLooper());
        this.f12090G = true;
        this.f12091H = 0;
        this.f12092I = false;
        this.f12093P = Integer.MAX_VALUE;
        this.f12094Q = new a();
        this.f12089F = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f23056v0, i8, i9);
        int i10 = g.f23060x0;
        this.f12090G = K.i.b(typedArrayObtainStyledAttributes, i10, i10, true);
        if (typedArrayObtainStyledAttributes.hasValue(g.f23058w0)) {
            int i11 = g.f23058w0;
            b0(K.i.d(typedArrayObtainStyledAttributes, i11, i11, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
