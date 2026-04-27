package E2;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* JADX INFO: loaded from: classes3.dex */
public class d extends E2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MethodCall f417b;

    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MethodChannel.Result f418a;

        public a(MethodChannel.Result result) {
            this.f418a = result;
        }

        @Override // E2.f
        public void error(String str, String str2, Object obj) {
            this.f418a.error(str, str2, obj);
        }

        @Override // E2.f
        public void success(Object obj) {
            this.f418a.success(obj);
        }
    }

    public d(MethodCall methodCall, MethodChannel.Result result) {
        this.f417b = methodCall;
        this.f416a = new a(result);
    }

    @Override // E2.e
    public Object a(String str) {
        return this.f417b.argument(str);
    }

    @Override // E2.e
    public String f() {
        return this.f417b.method;
    }

    @Override // E2.e
    public boolean g(String str) {
        return this.f417b.hasArgument(str);
    }

    @Override // E2.a
    public f m() {
        return this.f416a;
    }
}
