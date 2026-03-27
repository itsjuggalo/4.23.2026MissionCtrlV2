package x4;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* JADX INFO: loaded from: classes.dex */
public class d extends AbstractC2957a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f24195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MethodCall f24196b;

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MethodChannel.Result f24197a;

        public a(MethodChannel.Result result) {
            this.f24197a = result;
        }

        @Override // x4.f
        public void error(String str, String str2, Object obj) {
            this.f24197a.error(str, str2, obj);
        }

        @Override // x4.f
        public void success(Object obj) {
            this.f24197a.success(obj);
        }
    }

    public d(MethodCall methodCall, MethodChannel.Result result) {
        this.f24196b = methodCall;
        this.f24195a = new a(result);
    }

    @Override // x4.e
    public Object a(String str) {
        return this.f24196b.argument(str);
    }

    @Override // x4.e
    public String f() {
        return this.f24196b.method;
    }

    @Override // x4.e
    public boolean g(String str) {
        return this.f24196b.hasArgument(str);
    }

    @Override // x4.AbstractC2957a
    public f m() {
        return this.f24195a;
    }
}
