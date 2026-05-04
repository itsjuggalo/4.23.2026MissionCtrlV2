package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import g.g;
import g.i;
import o.j0;
import o.q;
import t0.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toolbar f1318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f1320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f1321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f1322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f1325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f1326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f1327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Window.Callback f1328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f1332o;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n.a f1333a;

        public a() {
            this.f1333a = new n.a(d.this.f1318a.getContext(), 0, R.id.home, 0, 0, d.this.f1325h);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = d.this;
            Window.Callback callback = dVar.f1328k;
            if (callback == null || !dVar.f1329l) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1333a);
        }
    }

    public d(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, g.f9747a, g.d.f9705n);
    }

    @Override // o.q
    public void a(CharSequence charSequence) {
        if (this.f1324g) {
            return;
        }
        o(charSequence);
    }

    @Override // o.q
    public void b(int i10) {
        i(i10 != 0 ? i.a.b(e(), i10) : null);
    }

    @Override // o.q
    public void c(Window.Callback callback) {
        this.f1328k = callback;
    }

    public final int d() {
        if (this.f1318a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1332o = this.f1318a.getNavigationIcon();
        return 15;
    }

    public Context e() {
        return this.f1318a.getContext();
    }

    public void f(View view) {
        View view2 = this.f1320c;
        if (view2 != null && (this.f1319b & 16) != 0) {
            this.f1318a.removeView(view2);
        }
        this.f1320c = view;
        if (view == null || (this.f1319b & 16) == 0) {
            return;
        }
        this.f1318a.addView(view);
    }

    public void g(int i10) {
        if (i10 == this.f1331n) {
            return;
        }
        this.f1331n = i10;
        if (TextUtils.isEmpty(this.f1318a.getNavigationContentDescription())) {
            j(this.f1331n);
        }
    }

    @Override // o.q
    public CharSequence getTitle() {
        return this.f1318a.getTitle();
    }

    public void h(int i10) {
        View view;
        int i11 = this.f1319b ^ i10;
        this.f1319b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    p();
                }
                q();
            }
            if ((i11 & 3) != 0) {
                r();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f1318a.setTitle(this.f1325h);
                    this.f1318a.setSubtitle(this.f1326i);
                } else {
                    this.f1318a.setTitle((CharSequence) null);
                    this.f1318a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) == 0 || (view = this.f1320c) == null) {
                return;
            }
            if ((i10 & 16) != 0) {
                this.f1318a.addView(view);
            } else {
                this.f1318a.removeView(view);
            }
        }
    }

    public void i(Drawable drawable) {
        this.f1322e = drawable;
        r();
    }

    public void j(int i10) {
        k(i10 == 0 ? null : e().getString(i10));
    }

    public void k(CharSequence charSequence) {
        this.f1327j = charSequence;
        p();
    }

    public void l(Drawable drawable) {
        this.f1323f = drawable;
        q();
    }

    public void m(CharSequence charSequence) {
        this.f1326i = charSequence;
        if ((this.f1319b & 8) != 0) {
            this.f1318a.setSubtitle(charSequence);
        }
    }

    public void n(CharSequence charSequence) {
        this.f1324g = true;
        o(charSequence);
    }

    public final void o(CharSequence charSequence) {
        this.f1325h = charSequence;
        if ((this.f1319b & 8) != 0) {
            this.f1318a.setTitle(charSequence);
            if (this.f1324g) {
                c0.L(this.f1318a.getRootView(), charSequence);
            }
        }
    }

    public final void p() {
        if ((this.f1319b & 4) != 0) {
            if (TextUtils.isEmpty(this.f1327j)) {
                this.f1318a.setNavigationContentDescription(this.f1331n);
            } else {
                this.f1318a.setNavigationContentDescription(this.f1327j);
            }
        }
    }

    public final void q() {
        if ((this.f1319b & 4) == 0) {
            this.f1318a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f1318a;
        Drawable drawable = this.f1323f;
        if (drawable == null) {
            drawable = this.f1332o;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void r() {
        Drawable drawable;
        int i10 = this.f1319b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f1322e) == null) {
            drawable = this.f1321d;
        }
        this.f1318a.setLogo(drawable);
    }

    @Override // o.q
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? i.a.b(e(), i10) : null);
    }

    public d(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f1330m = 0;
        this.f1331n = 0;
        this.f1318a = toolbar;
        this.f1325h = toolbar.getTitle();
        this.f1326i = toolbar.getSubtitle();
        this.f1324g = this.f1325h != null;
        this.f1323f = toolbar.getNavigationIcon();
        j0 j0VarS = j0.s(toolbar.getContext(), null, i.f9762a, g.a.f9661c, 0);
        this.f1332o = j0VarS.f(i.f9798j);
        if (z10) {
            CharSequence charSequenceN = j0VarS.n(i.f9822p);
            if (!TextUtils.isEmpty(charSequenceN)) {
                n(charSequenceN);
            }
            CharSequence charSequenceN2 = j0VarS.n(i.f9814n);
            if (!TextUtils.isEmpty(charSequenceN2)) {
                m(charSequenceN2);
            }
            Drawable drawableF = j0VarS.f(i.f9806l);
            if (drawableF != null) {
                i(drawableF);
            }
            Drawable drawableF2 = j0VarS.f(i.f9802k);
            if (drawableF2 != null) {
                setIcon(drawableF2);
            }
            if (this.f1323f == null && (drawable = this.f1332o) != null) {
                l(drawable);
            }
            h(j0VarS.i(i.f9790h, 0));
            int iL = j0VarS.l(i.f9786g, 0);
            if (iL != 0) {
                f(LayoutInflater.from(this.f1318a.getContext()).inflate(iL, (ViewGroup) this.f1318a, false));
                h(this.f1319b | 16);
            }
            int iK = j0VarS.k(i.f9794i, 0);
            if (iK > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1318a.getLayoutParams();
                layoutParams.height = iK;
                this.f1318a.setLayoutParams(layoutParams);
            }
            int iD = j0VarS.d(i.f9782f, -1);
            int iD2 = j0VarS.d(i.f9778e, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.f1318a.F(Math.max(iD, 0), Math.max(iD2, 0));
            }
            int iL2 = j0VarS.l(i.f9826q, 0);
            if (iL2 != 0) {
                Toolbar toolbar2 = this.f1318a;
                toolbar2.H(toolbar2.getContext(), iL2);
            }
            int iL3 = j0VarS.l(i.f9818o, 0);
            if (iL3 != 0) {
                Toolbar toolbar3 = this.f1318a;
                toolbar3.G(toolbar3.getContext(), iL3);
            }
            int iL4 = j0VarS.l(i.f9810m, 0);
            if (iL4 != 0) {
                this.f1318a.setPopupTheme(iL4);
            }
        } else {
            this.f1319b = d();
        }
        j0VarS.u();
        g(i10);
        this.f1327j = this.f1318a.getNavigationContentDescription();
        this.f1318a.setNavigationOnClickListener(new a());
    }

    @Override // o.q
    public void setIcon(Drawable drawable) {
        this.f1321d = drawable;
        r();
    }
}
