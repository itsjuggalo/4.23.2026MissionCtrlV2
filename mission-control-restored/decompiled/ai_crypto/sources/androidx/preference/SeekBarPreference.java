package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import x0.c;
import x0.g;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f7910D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f7911E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f7912F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f7913G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f7914H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public SeekBar f7915I;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public TextView f7916O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f7917P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f7918Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f7919R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final SeekBar.OnSeekBarChangeListener f7920S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final View.OnKeyListener f7921T;

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i7, boolean z7) {
            if (z7) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.f7919R || !seekBarPreference.f7914H) {
                    seekBarPreference.M(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.N(i7 + seekBarPreference2.f7911E);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f7914H = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f7914H = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f7911E != seekBarPreference.f7910D) {
                seekBarPreference.M(seekBar);
            }
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i7, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.f7917P && (i7 == 21 || i7 == 22)) || i7 == 23 || i7 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.f7915I;
            if (seekBar != null) {
                return seekBar.onKeyDown(i7, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f7920S = new a();
        this.f7921T = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f25166C0, i7, i8);
        this.f7911E = typedArrayObtainStyledAttributes.getInt(g.f25172F0, 0);
        J(typedArrayObtainStyledAttributes.getInt(g.f25168D0, 100));
        K(typedArrayObtainStyledAttributes.getInt(g.f25174G0, 0));
        this.f7917P = typedArrayObtainStyledAttributes.getBoolean(g.f25170E0, true);
        this.f7918Q = typedArrayObtainStyledAttributes.getBoolean(g.f25176H0, false);
        this.f7919R = typedArrayObtainStyledAttributes.getBoolean(g.f25178I0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void J(int i7) {
        int i8 = this.f7911E;
        if (i7 < i8) {
            i7 = i8;
        }
        if (i7 != this.f7912F) {
            this.f7912F = i7;
            v();
        }
    }

    public final void K(int i7) {
        if (i7 != this.f7913G) {
            this.f7913G = Math.min(this.f7912F - this.f7911E, Math.abs(i7));
            v();
        }
    }

    public final void L(int i7, boolean z7) {
        int i8 = this.f7911E;
        if (i7 < i8) {
            i7 = i8;
        }
        int i9 = this.f7912F;
        if (i7 > i9) {
            i7 = i9;
        }
        if (i7 != this.f7910D) {
            this.f7910D = i7;
            N(i7);
            E(i7);
            if (z7) {
                v();
            }
        }
    }

    public void M(SeekBar seekBar) {
        int progress = this.f7911E + seekBar.getProgress();
        if (progress != this.f7910D) {
            if (a(Integer.valueOf(progress))) {
                L(progress, false);
            } else {
                seekBar.setProgress(this.f7910D - this.f7911E);
                N(this.f7910D);
            }
        }
    }

    public void N(int i7) {
        TextView textView = this.f7916O;
        if (textView != null) {
            textView.setText(String.valueOf(i7));
        }
    }

    @Override // androidx.preference.Preference
    public Object z(TypedArray typedArray, int i7) {
        return Integer.valueOf(typedArray.getInt(i7, 0));
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f25155h);
    }
}
