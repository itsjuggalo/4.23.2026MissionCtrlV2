package S1;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class I4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f4001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4002b;

    public I4(C0540b5 c0540b5, B b4) {
        this.f4001a = b4;
        Objects.requireNonNull(c0540b5);
        this.f4002b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0540b5 c0540b5 = this.f4002b;
        C0658q3 c0658q3 = c0540b5.f4245a;
        Q2 q2X = c0658q3.x();
        C0658q3 c0658q32 = q2X.f4245a;
        q2X.h();
        B bU = q2X.u();
        B b4 = this.f4001a;
        if (!C0531a4.u(b4.b(), bU.b())) {
            c0658q3.a().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(b4.b()));
            return;
        }
        SharedPreferences.Editor editorEdit = q2X.p().edit();
        editorEdit.putString("dma_consent_settings", b4.e());
        editorEdit.apply();
        c0658q3.a().w().b("Setting DMA consent(FE)", b4);
        C0658q3 c0658q33 = c0540b5.f4245a;
        if (c0658q33.J().D()) {
            c0658q33.J().a0();
        } else {
            c0658q33.J().Y(false);
        }
    }
}
