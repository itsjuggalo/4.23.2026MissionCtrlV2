package E2;

import com.google.firebase.messaging.Constants;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class c extends E2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f409b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f410c;

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f414d;

        public a() {
        }

        @Override // E2.f
        public void error(String str, String str2, Object obj) {
            this.f412b = str;
            this.f413c = str2;
            this.f414d = obj;
        }

        @Override // E2.f
        public void success(Object obj) {
            this.f411a = obj;
        }
    }

    public c(Map map, boolean z4) {
        this.f408a = map;
        this.f410c = z4;
    }

    @Override // E2.e
    public Object a(String str) {
        return this.f408a.get(str);
    }

    @Override // E2.b, E2.e
    public boolean c() {
        return this.f410c;
    }

    @Override // E2.e
    public String f() {
        return (String) this.f408a.get("method");
    }

    @Override // E2.e
    public boolean g(String str) {
        return this.f408a.containsKey(str);
    }

    @Override // E2.a
    public f m() {
        return this.f409b;
    }

    public Map n() {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("code", this.f409b.f412b);
        map2.put(Constants.MESSAGE, this.f409b.f413c);
        map2.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, this.f409b.f414d);
        map.put(com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR, map2);
        return map;
    }

    public Map o() {
        HashMap map = new HashMap();
        map.put("result", this.f409b.f411a);
        return map;
    }

    public void p(MethodChannel.Result result) {
        a aVar = this.f409b;
        result.error(aVar.f412b, aVar.f413c, aVar.f414d);
    }

    public void q(List list) {
        if (c()) {
            return;
        }
        list.add(n());
    }

    public void r(List list) {
        if (c()) {
            return;
        }
        list.add(o());
    }
}
