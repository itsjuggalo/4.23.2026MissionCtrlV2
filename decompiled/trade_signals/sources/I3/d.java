package I3;

import H3.k;
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

/* JADX INFO: loaded from: classes.dex */
public class d extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FiamCardView f4078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public L3.a f4079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScrollView f4080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f4081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f4082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f4083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f4084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f4085k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public R3.f f4086l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View.OnClickListener f4087m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f4088n;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.this.f4083i.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public d(k kVar, LayoutInflater layoutInflater, R3.i iVar) {
        super(kVar, layoutInflater, iVar);
        this.f4088n = new a();
    }

    private void p(k kVar) {
        this.f4083i.setMaxHeight(kVar.r());
        this.f4083i.setMaxWidth(kVar.s());
    }

    @Override // I3.c
    public k b() {
        return this.f4076b;
    }

    @Override // I3.c
    public View c() {
        return this.f4079e;
    }

    @Override // I3.c
    public View.OnClickListener d() {
        return this.f4087m;
    }

    @Override // I3.c
    public ImageView e() {
        return this.f4083i;
    }

    @Override // I3.c
    public ViewGroup f() {
        return this.f4078d;
    }

    @Override // I3.c
    public ViewTreeObserver.OnGlobalLayoutListener g(Map map, View.OnClickListener onClickListener) {
        View viewInflate = this.f4077c.inflate(F3.g.f1588b, (ViewGroup) null);
        this.f4080f = (ScrollView) viewInflate.findViewById(F3.f.f1573g);
        this.f4081g = (Button) viewInflate.findViewById(F3.f.f1585s);
        this.f4082h = (Button) viewInflate.findViewById(F3.f.f1586t);
        this.f4083i = (ImageView) viewInflate.findViewById(F3.f.f1580n);
        this.f4084j = (TextView) viewInflate.findViewById(F3.f.f1581o);
        this.f4085k = (TextView) viewInflate.findViewById(F3.f.f1582p);
        this.f4078d = (FiamCardView) viewInflate.findViewById(F3.f.f1576j);
        this.f4079e = (L3.a) viewInflate.findViewById(F3.f.f1575i);
        if (this.f4075a.c().equals(MessageType.CARD)) {
            R3.f fVar = (R3.f) this.f4075a;
            this.f4086l = fVar;
            q(fVar);
            o(this.f4086l);
            m(map);
            p(this.f4076b);
            n(onClickListener);
            j(this.f4079e, this.f4086l.e());
        }
        return this.f4088n;
    }

    public final void m(Map map) {
        R3.a aVarI = this.f4086l.i();
        R3.a aVarJ = this.f4086l.j();
        c.k(this.f4081g, aVarI.c());
        h(this.f4081g, (View.OnClickListener) map.get(aVarI));
        this.f4081g.setVisibility(0);
        if (aVarJ == null || aVarJ.c() == null) {
            this.f4082h.setVisibility(8);
            return;
        }
        c.k(this.f4082h, aVarJ.c());
        h(this.f4082h, (View.OnClickListener) map.get(aVarJ));
        this.f4082h.setVisibility(0);
    }

    public final void n(View.OnClickListener onClickListener) {
        this.f4087m = onClickListener;
        this.f4078d.setDismissListener(onClickListener);
    }

    public final void o(R3.f fVar) {
        ImageView imageView;
        int i8;
        if (fVar.h() == null && fVar.g() == null) {
            imageView = this.f4083i;
            i8 = 8;
        } else {
            imageView = this.f4083i;
            i8 = 0;
        }
        imageView.setVisibility(i8);
    }

    public final void q(R3.f fVar) {
        this.f4085k.setText(fVar.k().c());
        this.f4085k.setTextColor(Color.parseColor(fVar.k().b()));
        if (fVar.f() == null || fVar.f().c() == null) {
            this.f4080f.setVisibility(8);
            this.f4084j.setVisibility(8);
        } else {
            this.f4080f.setVisibility(0);
            this.f4084j.setVisibility(0);
            this.f4084j.setText(fVar.f().c());
            this.f4084j.setTextColor(Color.parseColor(fVar.f().b()));
        }
    }
}
