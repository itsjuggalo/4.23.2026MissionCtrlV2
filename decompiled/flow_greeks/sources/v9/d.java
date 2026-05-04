package v9;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.inappmessaging.display.internal.layout.FiamCardView;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import u9.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FiamCardView f23168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y9.a f23169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScrollView f23170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f23171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f23172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f23173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f23174j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f23175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ea.f f23176l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View.OnClickListener f23177m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f23178n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.this.f23173i.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public d(k kVar, LayoutInflater layoutInflater, ea.i iVar) {
        super(kVar, layoutInflater, iVar);
        this.f23178n = new a();
    }

    private void p(k kVar) {
        this.f23173i.setMaxHeight(kVar.r());
        this.f23173i.setMaxWidth(kVar.s());
    }

    @Override // v9.c
    public k b() {
        return this.f23166b;
    }

    @Override // v9.c
    public View c() {
        return this.f23169e;
    }

    @Override // v9.c
    public View.OnClickListener d() {
        return this.f23177m;
    }

    @Override // v9.c
    public ImageView e() {
        return this.f23173i;
    }

    @Override // v9.c
    public ViewGroup f() {
        return this.f23168d;
    }

    @Override // v9.c
    public ViewTreeObserver.OnGlobalLayoutListener g(Map map, View.OnClickListener onClickListener) {
        View viewInflate = this.f23167c.inflate(s9.g.f20175b, (ViewGroup) null);
        this.f23170f = (ScrollView) viewInflate.findViewById(s9.f.f20160g);
        this.f23171g = (Button) viewInflate.findViewById(s9.f.f20172s);
        this.f23172h = (Button) viewInflate.findViewById(s9.f.f20173t);
        this.f23173i = (ImageView) viewInflate.findViewById(s9.f.f20167n);
        this.f23174j = (TextView) viewInflate.findViewById(s9.f.f20168o);
        this.f23175k = (TextView) viewInflate.findViewById(s9.f.f20169p);
        this.f23168d = (FiamCardView) viewInflate.findViewById(s9.f.f20163j);
        this.f23169e = (y9.a) viewInflate.findViewById(s9.f.f20162i);
        if (this.f23165a.c().equals(MessageType.CARD)) {
            ea.f fVar = (ea.f) this.f23165a;
            this.f23176l = fVar;
            q(fVar);
            o(this.f23176l);
            m(map);
            p(this.f23166b);
            n(onClickListener);
            j(this.f23169e, this.f23176l.e());
        }
        return this.f23178n;
    }

    public final void m(Map map) {
        ea.a aVarI = this.f23176l.i();
        ea.a aVarJ = this.f23176l.j();
        c.k(this.f23171g, aVarI.c());
        h(this.f23171g, (View.OnClickListener) map.get(aVarI));
        this.f23171g.setVisibility(0);
        if (aVarJ == null || aVarJ.c() == null) {
            this.f23172h.setVisibility(8);
            return;
        }
        c.k(this.f23172h, aVarJ.c());
        h(this.f23172h, (View.OnClickListener) map.get(aVarJ));
        this.f23172h.setVisibility(0);
    }

    public final void n(View.OnClickListener onClickListener) {
        this.f23177m = onClickListener;
        this.f23168d.setDismissListener(onClickListener);
    }

    public final void o(ea.f fVar) {
        if (fVar.h() == null && fVar.g() == null) {
            this.f23173i.setVisibility(8);
        } else {
            this.f23173i.setVisibility(0);
        }
    }

    public final void q(ea.f fVar) {
        this.f23175k.setText(fVar.k().c());
        this.f23175k.setTextColor(Color.parseColor(fVar.k().b()));
        if (fVar.f() == null || fVar.f().c() == null) {
            this.f23170f.setVisibility(8);
            this.f23174j.setVisibility(8);
        } else {
            this.f23170f.setVisibility(0);
            this.f23174j.setVisibility(0);
            this.f23174j.setText(fVar.f().c());
            this.f23174j.setTextColor(Color.parseColor(fVar.f().b()));
        }
    }
}
