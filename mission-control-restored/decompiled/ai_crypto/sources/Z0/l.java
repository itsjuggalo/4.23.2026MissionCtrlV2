package Z0;

import V4.j;
import Z0.a;
import Z0.q;
import Z0.y;
import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class l implements j.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f5691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f5692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f5693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y f5694f;

    public l(Context context, a aVar, q qVar, y yVar) {
        this.f5691c = context;
        this.f5692d = aVar;
        this.f5693e = qVar;
        this.f5694f = yVar;
    }

    @Override // V4.j.c
    public void onMethodCall(V4.i iVar, final j.d dVar) {
        String str = iVar.f5332a;
        str.hashCode();
        switch (str) {
            case "checkServiceStatus":
                int i7 = Integer.parseInt(iVar.f5333b.toString());
                y yVar = this.f5694f;
                Context context = this.f5691c;
                Objects.requireNonNull(dVar);
                yVar.a(i7, context, new y.a() { // from class: Z0.c
                    @Override // Z0.y.a
                    public final void a(int i8) {
                        dVar.a(Integer.valueOf(i8));
                    }
                }, new b() { // from class: Z0.d
                    @Override // Z0.b
                    public final void a(String str2, String str3) {
                        dVar.b(str2, str3, null);
                    }
                });
                break;
            case "shouldShowRequestPermissionRationale":
                int i8 = Integer.parseInt(iVar.f5333b.toString());
                q qVar = this.f5693e;
                Objects.requireNonNull(dVar);
                qVar.i(i8, new q.c() { // from class: Z0.h
                    @Override // Z0.q.c
                    public final void a(boolean z7) {
                        dVar.a(Boolean.valueOf(z7));
                    }
                }, new b() { // from class: Z0.i
                    @Override // Z0.b
                    public final void a(String str2, String str3) {
                        dVar.b(str2, str3, null);
                    }
                });
                break;
            case "checkPermissionStatus":
                int i9 = Integer.parseInt(iVar.f5333b.toString());
                q qVar2 = this.f5693e;
                Objects.requireNonNull(dVar);
                qVar2.c(i9, new q.a() { // from class: Z0.e
                    @Override // Z0.q.a
                    public final void a(int i10) {
                        dVar.a(Integer.valueOf(i10));
                    }
                });
                break;
            case "openAppSettings":
                a aVar = this.f5692d;
                Context context2 = this.f5691c;
                Objects.requireNonNull(dVar);
                aVar.a(context2, new a.InterfaceC0103a() { // from class: Z0.j
                    @Override // Z0.a.InterfaceC0103a
                    public final void a(boolean z7) {
                        dVar.a(Boolean.valueOf(z7));
                    }
                }, new b() { // from class: Z0.k
                    @Override // Z0.b
                    public final void a(String str2, String str3) {
                        dVar.b(str2, str3, null);
                    }
                });
                break;
            case "requestPermissions":
                List list = (List) iVar.b();
                q qVar3 = this.f5693e;
                Objects.requireNonNull(dVar);
                qVar3.g(list, new q.b() { // from class: Z0.f
                    @Override // Z0.q.b
                    public final void a(Map map) {
                        dVar.a(map);
                    }
                }, new b() { // from class: Z0.g
                    @Override // Z0.b
                    public final void a(String str2, String str3) {
                        dVar.b(str2, str3, null);
                    }
                });
                break;
            default:
                dVar.c();
                break;
        }
    }
}
