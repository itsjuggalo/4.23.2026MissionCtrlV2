package m;

import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class J0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f8249b;

    public /* synthetic */ J0(Toolbar toolbar, int i) {
        this.f8248a = i;
        this.f8249b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8248a) {
            case 0:
                M0 m02 = this.f8249b.f4387O;
                l.j jVar = m02 == null ? null : m02.f8258b;
                if (jVar != null) {
                    jVar.collapseActionView();
                }
                break;
            default:
                this.f8249b.l();
                break;
        }
    }
}
