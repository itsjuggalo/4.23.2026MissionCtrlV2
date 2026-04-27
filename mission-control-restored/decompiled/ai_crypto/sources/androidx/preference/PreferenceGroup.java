package androidx.preference;

import H.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.List;
import u.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final g f7900D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final Handler f7901E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final List f7902F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f7903G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public int f7904H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f7905I;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public int f7906O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public final Runnable f7907P;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.f7900D.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f7900D = new g();
        this.f7901E = new Handler(Looper.getMainLooper());
        this.f7903G = true;
        this.f7904H = 0;
        this.f7905I = false;
        this.f7906O = a.e.API_PRIORITY_OTHER;
        this.f7907P = new a();
        this.f7902F = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.g.f25261v0, i7, i8);
        int i9 = x0.g.f25265x0;
        this.f7903G = i.b(typedArrayObtainStyledAttributes, i9, i9, true);
        if (typedArrayObtainStyledAttributes.hasValue(x0.g.f25263w0)) {
            int i10 = x0.g.f25263w0;
            L(i.d(typedArrayObtainStyledAttributes, i10, i10, a.e.API_PRIORITY_OTHER));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public Preference J(int i7) {
        return (Preference) this.f7902F.get(i7);
    }

    public int K() {
        return this.f7902F.size();
    }

    public void L(int i7) {
        if (i7 != Integer.MAX_VALUE && !s()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.f7906O = i7;
    }

    @Override // androidx.preference.Preference
    public void w(boolean z7) {
        super.w(z7);
        int iK = K();
        for (int i7 = 0; i7 < iK; i7++) {
            J(i7).A(this, z7);
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
