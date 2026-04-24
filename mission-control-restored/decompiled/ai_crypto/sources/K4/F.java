package K4;

import K4.L;
import U4.i;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes2.dex */
public class F implements L.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U4.i f3508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final L.b f3509b = new L.b();

    public F(U4.i iVar) {
        this.f3508a = iVar;
    }

    @Override // K4.L.d
    public void a(KeyEvent keyEvent, final L.d.a aVar) {
        int action = keyEvent.getAction();
        if (action == 0 || action == 1) {
            this.f3508a.e(new i.b(keyEvent, this.f3509b.a(keyEvent.getUnicodeChar())), action != 0, new i.a() { // from class: K4.E
                @Override // U4.i.a
                public final void a(boolean z7) {
                    aVar.a(z7);
                }
            });
        } else {
            aVar.a(false);
        }
    }
}
