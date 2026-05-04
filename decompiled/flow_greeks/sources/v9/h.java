package v9;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.inappmessaging.display.internal.layout.FiamRelativeLayout;
import com.google.firebase.inappmessaging.model.MessageType;
import ea.j;
import java.util.Map;
import u9.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FiamRelativeLayout f23190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f23191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScrollView f23192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f23193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f23194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f23195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f23196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f23197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public j f23198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f23199m;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            h.this.f23195i.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public h(k kVar, LayoutInflater layoutInflater, ea.i iVar) {
        super(kVar, layoutInflater, iVar);
        this.f23199m = new a();
    }

    private void n(View.OnClickListener onClickListener) {
        this.f23194h.setOnClickListener(onClickListener);
        this.f23190d.setDismissListener(onClickListener);
    }

    private void o(k kVar) {
        this.f23195i.setMaxHeight(kVar.r());
        this.f23195i.setMaxWidth(kVar.s());
    }

    @Override // v9.c
    public k b() {
        return this.f23166b;
    }

    @Override // v9.c
    public View c() {
        return this.f23191e;
    }

    @Override // v9.c
    public ImageView e() {
        return this.f23195i;
    }

    @Override // v9.c
    public ViewGroup f() {
        return this.f23190d;
    }

    @Override // v9.c
    public ViewTreeObserver.OnGlobalLayoutListener g(Map map, View.OnClickListener onClickListener) {
        View viewInflate = this.f23167c.inflate(s9.g.f20177d, (ViewGroup) null);
        this.f23192f = (ScrollView) viewInflate.findViewById(s9.f.f20160g);
        this.f23193g = (Button) viewInflate.findViewById(s9.f.f20161h);
        this.f23194h = viewInflate.findViewById(s9.f.f20164k);
        this.f23195i = (ImageView) viewInflate.findViewById(s9.f.f20167n);
        this.f23196j = (TextView) viewInflate.findViewById(s9.f.f20168o);
        this.f23197k = (TextView) viewInflate.findViewById(s9.f.f20169p);
        this.f23190d = (FiamRelativeLayout) viewInflate.findViewById(s9.f.f20171r);
        this.f23191e = (ViewGroup) viewInflate.findViewById(s9.f.f20170q);
        if (this.f23165a.c().equals(MessageType.MODAL)) {
            j jVar = (j) this.f23165a;
            this.f23198l = jVar;
            p(jVar);
            m(map);
            o(this.f23166b);
            n(onClickListener);
            j(this.f23191e, this.f23198l.f());
        }
        return this.f23199m;
    }

    public final void m(Map map) {
        ea.a aVarE = this.f23198l.e();
        if (aVarE == null || aVarE.c() == null || TextUtils.isEmpty(aVarE.c().c().c())) {
            this.f23193g.setVisibility(8);
            return;
        }
        c.k(this.f23193g, aVarE.c());
        h(this.f23193g, (View.OnClickListener) map.get(this.f23198l.e()));
        this.f23193g.setVisibility(0);
    }

    public final void p(j jVar) {
        if (jVar.b() == null || TextUtils.isEmpty(jVar.b().b())) {
            this.f23195i.setVisibility(8);
        } else {
            this.f23195i.setVisibility(0);
        }
        if (jVar.h() != null) {
            if (TextUtils.isEmpty(jVar.h().c())) {
                this.f23197k.setVisibility(8);
            } else {
                this.f23197k.setVisibility(0);
                this.f23197k.setText(jVar.h().c());
            }
            if (!TextUtils.isEmpty(jVar.h().b())) {
                this.f23197k.setTextColor(Color.parseColor(jVar.h().b()));
            }
        }
        if (jVar.g() == null || TextUtils.isEmpty(jVar.g().c())) {
            this.f23192f.setVisibility(8);
            this.f23196j.setVisibility(8);
        } else {
            this.f23192f.setVisibility(0);
            this.f23196j.setVisibility(0);
            this.f23196j.setTextColor(Color.parseColor(jVar.g().b()));
            this.f23196j.setText(jVar.g().c());
        }
    }
}
