package I3;

import H3.k;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.inappmessaging.display.internal.ResizableImageView;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FiamFrameLayout f4066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f4067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f4068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ResizableImageView f4069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f4070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View.OnClickListener f4071i;

    public a(k kVar, LayoutInflater layoutInflater, R3.i iVar) {
        super(kVar, layoutInflater, iVar);
    }

    @Override // I3.c
    public boolean a() {
        return true;
    }

    @Override // I3.c
    public k b() {
        return this.f4076b;
    }

    @Override // I3.c
    public View c() {
        return this.f4067e;
    }

    @Override // I3.c
    public View.OnClickListener d() {
        return this.f4071i;
    }

    @Override // I3.c
    public ImageView e() {
        return this.f4069g;
    }

    @Override // I3.c
    public ViewGroup f() {
        return this.f4066d;
    }

    @Override // I3.c
    public ViewTreeObserver.OnGlobalLayoutListener g(Map map, View.OnClickListener onClickListener) {
        View viewInflate = this.f4077c.inflate(F3.g.f1587a, (ViewGroup) null);
        this.f4066d = (FiamFrameLayout) viewInflate.findViewById(F3.f.f1571e);
        this.f4067e = (ViewGroup) viewInflate.findViewById(F3.f.f1569c);
        this.f4068f = (TextView) viewInflate.findViewById(F3.f.f1568b);
        this.f4069g = (ResizableImageView) viewInflate.findViewById(F3.f.f1570d);
        this.f4070h = (TextView) viewInflate.findViewById(F3.f.f1572f);
        if (this.f4075a.c().equals(MessageType.BANNER)) {
            R3.c cVar = (R3.c) this.f4075a;
            n(cVar);
            m(this.f4076b);
            o(onClickListener);
            l((View.OnClickListener) map.get(cVar.e()));
        }
        return null;
    }

    public final void l(View.OnClickListener onClickListener) {
        this.f4067e.setOnClickListener(onClickListener);
    }

    public final void m(k kVar) {
        int iMin = Math.min(kVar.u().intValue(), kVar.t().intValue());
        ViewGroup.LayoutParams layoutParams = this.f4066d.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams.width = iMin;
        this.f4066d.setLayoutParams(layoutParams);
        this.f4069g.setMaxHeight(kVar.r());
        this.f4069g.setMaxWidth(kVar.s());
    }

    public final void n(R3.c cVar) {
        if (!TextUtils.isEmpty(cVar.f())) {
            j(this.f4067e, cVar.f());
        }
        this.f4069g.setVisibility((cVar.b() == null || TextUtils.isEmpty(cVar.b().b())) ? 8 : 0);
        if (cVar.h() != null) {
            if (!TextUtils.isEmpty(cVar.h().c())) {
                this.f4070h.setText(cVar.h().c());
            }
            if (!TextUtils.isEmpty(cVar.h().b())) {
                this.f4070h.setTextColor(Color.parseColor(cVar.h().b()));
            }
        }
        if (cVar.g() != null) {
            if (!TextUtils.isEmpty(cVar.g().c())) {
                this.f4068f.setText(cVar.g().c());
            }
            if (TextUtils.isEmpty(cVar.g().b())) {
                return;
            }
            this.f4068f.setTextColor(Color.parseColor(cVar.g().b()));
        }
    }

    public final void o(View.OnClickListener onClickListener) {
        this.f4071i = onClickListener;
        this.f4066d.setDismissListener(onClickListener);
    }
}
