package v9;

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
import u9.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FiamFrameLayout f23183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f23184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f23185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f23186g;

    public f(k kVar, LayoutInflater layoutInflater, ea.i iVar) {
        super(kVar, layoutInflater, iVar);
    }

    @Override // v9.c
    public View c() {
        return this.f23184e;
    }

    @Override // v9.c
    public ImageView e() {
        return this.f23185f;
    }

    @Override // v9.c
    public ViewGroup f() {
        return this.f23183d;
    }

    @Override // v9.c
    public ViewTreeObserver.OnGlobalLayoutListener g(Map map, View.OnClickListener onClickListener) {
        View viewInflate = this.f23167c.inflate(s9.g.f20176c, (ViewGroup) null);
        this.f23183d = (FiamFrameLayout) viewInflate.findViewById(s9.f.f20166m);
        this.f23184e = (ViewGroup) viewInflate.findViewById(s9.f.f20165l);
        this.f23185f = (ImageView) viewInflate.findViewById(s9.f.f20167n);
        this.f23186g = (Button) viewInflate.findViewById(s9.f.f20164k);
        this.f23185f.setMaxHeight(this.f23166b.r());
        this.f23185f.setMaxWidth(this.f23166b.s());
        if (this.f23165a.c().equals(MessageType.IMAGE_ONLY)) {
            ea.h hVar = (ea.h) this.f23165a;
            this.f23185f.setVisibility((hVar.b() == null || TextUtils.isEmpty(hVar.b().b())) ? 8 : 0);
            this.f23185f.setOnClickListener((View.OnClickListener) map.get(hVar.e()));
        }
        this.f23183d.setDismissListener(onClickListener);
        this.f23186g.setOnClickListener(onClickListener);
        return null;
    }
}
