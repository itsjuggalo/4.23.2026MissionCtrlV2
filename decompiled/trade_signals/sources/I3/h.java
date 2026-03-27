package I3;

import H3.k;
import R3.j;
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
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FiamRelativeLayout f4100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f4101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScrollView f4102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f4103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f4104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f4105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f4106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f4107k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public j f4108l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f4109m;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            h.this.f4105i.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public h(k kVar, LayoutInflater layoutInflater, R3.i iVar) {
        super(kVar, layoutInflater, iVar);
        this.f4109m = new a();
    }

    private void n(View.OnClickListener onClickListener) {
        this.f4104h.setOnClickListener(onClickListener);
        this.f4100d.setDismissListener(onClickListener);
    }

    private void o(k kVar) {
        this.f4105i.setMaxHeight(kVar.r());
        this.f4105i.setMaxWidth(kVar.s());
    }

    @Override // I3.c
    public k b() {
        return this.f4076b;
    }

    @Override // I3.c
    public View c() {
        return this.f4101e;
    }

    @Override // I3.c
    public ImageView e() {
        return this.f4105i;
    }

    @Override // I3.c
    public ViewGroup f() {
        return this.f4100d;
    }

    @Override // I3.c
    public ViewTreeObserver.OnGlobalLayoutListener g(Map map, View.OnClickListener onClickListener) {
        View viewInflate = this.f4077c.inflate(F3.g.f1590d, (ViewGroup) null);
        this.f4102f = (ScrollView) viewInflate.findViewById(F3.f.f1573g);
        this.f4103g = (Button) viewInflate.findViewById(F3.f.f1574h);
        this.f4104h = viewInflate.findViewById(F3.f.f1577k);
        this.f4105i = (ImageView) viewInflate.findViewById(F3.f.f1580n);
        this.f4106j = (TextView) viewInflate.findViewById(F3.f.f1581o);
        this.f4107k = (TextView) viewInflate.findViewById(F3.f.f1582p);
        this.f4100d = (FiamRelativeLayout) viewInflate.findViewById(F3.f.f1584r);
        this.f4101e = (ViewGroup) viewInflate.findViewById(F3.f.f1583q);
        if (this.f4075a.c().equals(MessageType.MODAL)) {
            j jVar = (j) this.f4075a;
            this.f4108l = jVar;
            p(jVar);
            m(map);
            o(this.f4076b);
            n(onClickListener);
            j(this.f4101e, this.f4108l.f());
        }
        return this.f4109m;
    }

    public final void m(Map map) {
        Button button;
        int i8;
        R3.a aVarE = this.f4108l.e();
        if (aVarE == null || aVarE.c() == null || TextUtils.isEmpty(aVarE.c().c().c())) {
            button = this.f4103g;
            i8 = 8;
        } else {
            c.k(this.f4103g, aVarE.c());
            h(this.f4103g, (View.OnClickListener) map.get(this.f4108l.e()));
            button = this.f4103g;
            i8 = 0;
        }
        button.setVisibility(i8);
    }

    public final void p(j jVar) {
        if (jVar.b() == null || TextUtils.isEmpty(jVar.b().b())) {
            this.f4105i.setVisibility(8);
        } else {
            this.f4105i.setVisibility(0);
        }
        if (jVar.h() != null) {
            if (TextUtils.isEmpty(jVar.h().c())) {
                this.f4107k.setVisibility(8);
            } else {
                this.f4107k.setVisibility(0);
                this.f4107k.setText(jVar.h().c());
            }
            if (!TextUtils.isEmpty(jVar.h().b())) {
                this.f4107k.setTextColor(Color.parseColor(jVar.h().b()));
            }
        }
        if (jVar.g() == null || TextUtils.isEmpty(jVar.g().c())) {
            this.f4102f.setVisibility(8);
            this.f4106j.setVisibility(8);
        } else {
            this.f4102f.setVisibility(0);
            this.f4106j.setVisibility(0);
            this.f4106j.setTextColor(Color.parseColor(jVar.g().b()));
            this.f4106j.setText(jVar.g().c());
        }
    }
}
