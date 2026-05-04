package v9;

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
import u9.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FiamFrameLayout f23156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f23157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f23158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ResizableImageView f23159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f23160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View.OnClickListener f23161i;

    public a(k kVar, LayoutInflater layoutInflater, ea.i iVar) {
        super(kVar, layoutInflater, iVar);
    }

    @Override // v9.c
    public boolean a() {
        return true;
    }

    @Override // v9.c
    public k b() {
        return this.f23166b;
    }

    @Override // v9.c
    public View c() {
        return this.f23157e;
    }

    @Override // v9.c
    public View.OnClickListener d() {
        return this.f23161i;
    }

    @Override // v9.c
    public ImageView e() {
        return this.f23159g;
    }

    @Override // v9.c
    public ViewGroup f() {
        return this.f23156d;
    }

    @Override // v9.c
    public ViewTreeObserver.OnGlobalLayoutListener g(Map map, View.OnClickListener onClickListener) {
        View viewInflate = this.f23167c.inflate(s9.g.f20174a, (ViewGroup) null);
        this.f23156d = (FiamFrameLayout) viewInflate.findViewById(s9.f.f20158e);
        this.f23157e = (ViewGroup) viewInflate.findViewById(s9.f.f20156c);
        this.f23158f = (TextView) viewInflate.findViewById(s9.f.f20155b);
        this.f23159g = (ResizableImageView) viewInflate.findViewById(s9.f.f20157d);
        this.f23160h = (TextView) viewInflate.findViewById(s9.f.f20159f);
        if (this.f23165a.c().equals(MessageType.BANNER)) {
            ea.c cVar = (ea.c) this.f23165a;
            n(cVar);
            m(this.f23166b);
            o(onClickListener);
            l((View.OnClickListener) map.get(cVar.e()));
        }
        return null;
    }

    public final void l(View.OnClickListener onClickListener) {
        this.f23157e.setOnClickListener(onClickListener);
    }

    public final void m(k kVar) {
        int iMin = Math.min(kVar.u().intValue(), kVar.t().intValue());
        ViewGroup.LayoutParams layoutParams = this.f23156d.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams.width = iMin;
        this.f23156d.setLayoutParams(layoutParams);
        this.f23159g.setMaxHeight(kVar.r());
        this.f23159g.setMaxWidth(kVar.s());
    }

    public final void n(ea.c cVar) {
        if (!TextUtils.isEmpty(cVar.f())) {
            j(this.f23157e, cVar.f());
        }
        this.f23159g.setVisibility((cVar.b() == null || TextUtils.isEmpty(cVar.b().b())) ? 8 : 0);
        if (cVar.h() != null) {
            if (!TextUtils.isEmpty(cVar.h().c())) {
                this.f23160h.setText(cVar.h().c());
            }
            if (!TextUtils.isEmpty(cVar.h().b())) {
                this.f23160h.setTextColor(Color.parseColor(cVar.h().b()));
            }
        }
        if (cVar.g() != null) {
            if (!TextUtils.isEmpty(cVar.g().c())) {
                this.f23158f.setText(cVar.g().c());
            }
            if (TextUtils.isEmpty(cVar.g().b())) {
                return;
            }
            this.f23158f.setTextColor(Color.parseColor(cVar.g().b()));
        }
    }

    public final void o(View.OnClickListener onClickListener) {
        this.f23161i = onClickListener;
        this.f23156d.setDismissListener(onClickListener);
    }
}
