package F3;

import Z3.p;
import com.dexterous.flutterlocalnotifications.i;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b implements d, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f515b;

    public /* synthetic */ b(p pVar, int i) {
        this.f514a = i;
        this.f515b = pVar;
    }

    @Override // F3.d
    public void a(Serializable serializable) {
        this.f515b.c(serializable);
    }

    @Override // com.dexterous.flutterlocalnotifications.i
    public void b(boolean z6) {
        switch (this.f514a) {
            case 1:
                this.f515b.c(Boolean.valueOf(z6));
                break;
            default:
                this.f515b.c(Boolean.valueOf(z6));
                break;
        }
    }

    @Override // F3.d
    public void c(String str, HashMap map) {
        this.f515b.a(map, "sqlite_error", str);
    }

    @Override // com.dexterous.flutterlocalnotifications.i
    public void d() {
        switch (this.f514a) {
            case 1:
                this.f515b.a(null, "permissionRequestInProgress", "Another permission request is already in progress");
                break;
            default:
                this.f515b.a(null, "permissionRequestInProgress", "Another permission request is already in progress");
                break;
        }
    }
}
