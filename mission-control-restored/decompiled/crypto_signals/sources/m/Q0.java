package m;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes.dex */
public final class Q0 implements K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toolbar f8271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f8274d;
    public Drawable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f8275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8276g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f8277h;
    public CharSequence i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f8278j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Window.Callback f8279k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8280l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f8281m;

    public final void a(int i) {
        View view;
        int i6 = this.f8272b ^ i;
        this.f8272b = i;
        if (i6 != 0) {
            if ((i6 & 4) != 0) {
                if ((i & 4) != 0) {
                    b();
                }
                int i7 = this.f8272b & 4;
                Toolbar toolbar = this.f8271a;
                if (i7 != 0) {
                    Drawable drawable = this.f8275f;
                    if (drawable == null) {
                        drawable = this.f8281m;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i6 & 3) != 0) {
                c();
            }
            int i8 = i6 & 8;
            Toolbar toolbar2 = this.f8271a;
            if (i8 != 0) {
                if ((i & 8) != 0) {
                    toolbar2.setTitle(this.f8277h);
                    toolbar2.setSubtitle(this.i);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i6 & 16) == 0 || (view = this.f8273c) == null) {
                return;
            }
            if ((i & 16) != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    public final void b() {
        if ((this.f8272b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f8278j);
            Toolbar toolbar = this.f8271a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f8280l);
            } else {
                toolbar.setNavigationContentDescription(this.f8278j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i = this.f8272b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.e) == null) {
            drawable = this.f8274d;
        }
        this.f8271a.setLogo(drawable);
    }
}
