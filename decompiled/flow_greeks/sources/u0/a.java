package u0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f22102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22103c;

    public a(int i10, p pVar, int i11) {
        this.f22101a = i10;
        this.f22102b = pVar;
        this.f22103c = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f22101a);
        this.f22102b.U(this.f22103c, bundle);
    }
}
