package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import s0.AbstractC2683c;
import s0.g;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f12097D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f12098E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f12099F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f12100G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f12101H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public SeekBar f12102I;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public TextView f12103P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f12104Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f12105R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public boolean f12106S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final SeekBar.OnSeekBarChangeListener f12107T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final View.OnKeyListener f12108U;

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i8, boolean z7) {
            if (z7) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.f12106S || !seekBarPreference.f12101H) {
                    seekBarPreference.c0(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.d0(i8 + seekBarPreference2.f12098E);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f12101H = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f12101H = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f12098E != seekBarPreference.f12097D) {
                seekBarPreference.c0(seekBar);
            }
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i8, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.f12104Q && (i8 == 21 || i8 == 22)) || i8 == 23 || i8 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.f12102I;
            if (seekBar != null) {
                return seekBar.onKeyDown(i8, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC2683c.f22950h);
    }

    @Override // androidx.preference.Preference
    public Object P(TypedArray typedArray, int i8) {
        return Integer.valueOf(typedArray.getInt(i8, 0));
    }

    public final void Z(int i8) {
        int i9 = this.f12098E;
        if (i8 < i9) {
            i8 = i9;
        }
        if (i8 != this.f12099F) {
            this.f12099F = i8;
            L();
        }
    }

    public final void a0(int i8) {
        if (i8 != this.f12100G) {
            this.f12100G = Math.min(this.f12099F - this.f12098E, Math.abs(i8));
            L();
        }
    }

    public final void b0(int i8, boolean z7) {
        int i9 = this.f12098E;
        if (i8 < i9) {
            i8 = i9;
        }
        int i10 = this.f12099F;
        if (i8 > i10) {
            i8 = i10;
        }
        if (i8 != this.f12097D) {
            this.f12097D = i8;
            d0(i8);
            U(i8);
            if (z7) {
                L();
            }
        }
    }

    public void c0(SeekBar seekBar) {
        int progress = this.f12098E + seekBar.getProgress();
        if (progress != this.f12097D) {
            if (a(Integer.valueOf(progress))) {
                b0(progress, false);
            } else {
                seekBar.setProgress(this.f12097D - this.f12098E);
                d0(this.f12097D);
            }
        }
    }

    public void d0(int i8) {
        TextView textView = this.f12103P;
        if (textView != null) {
            textView.setText(String.valueOf(i8));
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.f12107T = new a();
        this.f12108U = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f22961C0, i8, i9);
        this.f12098E = typedArrayObtainStyledAttributes.getInt(g.f22967F0, 0);
        Z(typedArrayObtainStyledAttributes.getInt(g.f22963D0, 100));
        a0(typedArrayObtainStyledAttributes.getInt(g.f22969G0, 0));
        this.f12104Q = typedArrayObtainStyledAttributes.getBoolean(g.f22965E0, true);
        this.f12105R = typedArrayObtainStyledAttributes.getBoolean(g.f22971H0, false);
        this.f12106S = typedArrayObtainStyledAttributes.getBoolean(g.f22973I0, false);
        typedArrayObtainStyledAttributes.recycle();
    }
}
