package I3;

import H3.k;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FiamFrameLayout f4093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f4094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f4095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f4096g;

    public f(k kVar, LayoutInflater layoutInflater, R3.i iVar) {
        super(kVar, layoutInflater, iVar);
    }

    @Override // I3.c
    public View c() {
        return this.f4094e;
    }

    @Override // I3.c
    public ImageView e() {
        return this.f4095f;
    }

    @Override // I3.c
    public ViewGroup f() {
        return this.f4093d;
    }

    @Override // I3.c
    public ViewTreeObserver.OnGlobalLayoutListener g(Map map, View.OnClickListener onClickListener) {
        View viewInflate = this.f4077c.inflate(F3.g.f1589c, (ViewGroup) null);
        this.f4093d = (FiamFrameLayout) viewInflate.findViewById(F3.f.f1579m);
        this.f4094e = (ViewGroup) viewInflate.findViewById(F3.f.f1578l);
        this.f4095f = (ImageView) viewInflate.findViewById(F3.f.f1580n);
        this.f4096g = (Button) viewInflate.findViewById(F3.f.f1577k);
        this.f4095f.setMaxHeight(this.f4076b.r());
        this.f4095f.setMaxWidth(this.f4076b.s());
        if (this.f4075a.c().equals(MessageType.IMAGE_ONLY)) {
            R3.h hVar = (R3.h) this.f4075a;
            this.f4095f.setVisibility((hVar.b() == null || TextUtils.isEmpty(hVar.b().b())) ? 8 : 0);
            this.f4095f.setOnClickListener((View.OnClickListener) map.get(hVar.e()));
        }
        this.f4093d.setDismissListener(onClickListener);
        this.f4096g.setOnClickListener(onClickListener);
        return null;
    }
}
