package I0;

import I0.a;
import I0.q;
import I0.y;
import android.content.Context;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class l implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f839d;

    public l(Context context, a aVar, q qVar, y yVar) {
        this.f836a = context;
        this.f837b = aVar;
        this.f838c = qVar;
        this.f839d = yVar;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        String str = methodCall.method;
        str.getClass();
        switch (str) {
            case "checkServiceStatus":
                int i4 = Integer.parseInt(methodCall.arguments.toString());
                y yVar = this.f839d;
                Context context = this.f836a;
                Objects.requireNonNull(result);
                yVar.a(i4, context, new y.a() { // from class: I0.c
                    @Override // I0.y.a
                    public final void onSuccess(int i5) {
                        result.success(Integer.valueOf(i5));
                    }
                }, new b() { // from class: I0.d
                    @Override // I0.b
                    public final void a(String str2, String str3) {
                        result.error(str2, str3, null);
                    }
                });
                break;
            case "shouldShowRequestPermissionRationale":
                int i5 = Integer.parseInt(methodCall.arguments.toString());
                q qVar = this.f838c;
                Objects.requireNonNull(result);
                qVar.i(i5, new q.c() { // from class: I0.h
                    @Override // I0.q.c
                    public final void a(boolean z4) {
                        result.success(Boolean.valueOf(z4));
                    }
                }, new b() { // from class: I0.i
                    @Override // I0.b
                    public final void a(String str2, String str3) {
                        result.error(str2, str3, null);
                    }
                });
                break;
            case "checkPermissionStatus":
                int i6 = Integer.parseInt(methodCall.arguments.toString());
                q qVar2 = this.f838c;
                Objects.requireNonNull(result);
                qVar2.c(i6, new q.a() { // from class: I0.e
                    @Override // I0.q.a
                    public final void onSuccess(int i7) {
                        result.success(Integer.valueOf(i7));
                    }
                });
                break;
            case "openAppSettings":
                a aVar = this.f837b;
                Context context2 = this.f836a;
                Objects.requireNonNull(result);
                aVar.a(context2, new a.InterfaceC0025a() { // from class: I0.j
                    @Override // I0.a.InterfaceC0025a
                    public final void a(boolean z4) {
                        result.success(Boolean.valueOf(z4));
                    }
                }, new b() { // from class: I0.k
                    @Override // I0.b
                    public final void a(String str2, String str3) {
                        result.error(str2, str3, null);
                    }
                });
                break;
            case "requestPermissions":
                List list = (List) methodCall.arguments();
                q qVar3 = this.f838c;
                Objects.requireNonNull(result);
                qVar3.g(list, new q.b() { // from class: I0.f
                    @Override // I0.q.b
                    public final void a(Map map) {
                        result.success(map);
                    }
                }, new b() { // from class: I0.g
                    @Override // I0.b
                    public final void a(String str2, String str3) {
                        result.error(str2, str3, null);
                    }
                });
                break;
            default:
                result.notImplemented();
                break;
        }
    }
}
