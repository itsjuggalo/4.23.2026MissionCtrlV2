package x4;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.database.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends AbstractC2957a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f24187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f24188b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f24189c;

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f24190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f24193d;

        public a() {
        }

        @Override // x4.f
        public void error(String str, String str2, Object obj) {
            this.f24191b = str;
            this.f24192c = str2;
            this.f24193d = obj;
        }

        @Override // x4.f
        public void success(Object obj) {
            this.f24190a = obj;
        }
    }

    public c(Map map, boolean z7) {
        this.f24187a = map;
        this.f24189c = z7;
    }

    @Override // x4.e
    public Object a(String str) {
        return this.f24187a.get(str);
    }

    @Override // x4.AbstractC2958b, x4.e
    public boolean c() {
        return this.f24189c;
    }

    @Override // x4.e
    public String f() {
        return (String) this.f24187a.get(FirebaseAnalytics.Param.METHOD);
    }

    @Override // x4.e
    public boolean g(String str) {
        return this.f24187a.containsKey(str);
    }

    @Override // x4.AbstractC2957a
    public f m() {
        return this.f24188b;
    }

    public Map n() {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put(Constants.ERROR_CODE, this.f24188b.f24191b);
        map2.put(Constants.ERROR_MESSAGE, this.f24188b.f24192c);
        map2.put("data", this.f24188b.f24193d);
        map.put("error", map2);
        return map;
    }

    public Map o() {
        HashMap map = new HashMap();
        map.put("result", this.f24188b.f24190a);
        return map;
    }

    public void p(MethodChannel.Result result) {
        a aVar = this.f24188b;
        result.error(aVar.f24191b, aVar.f24192c, aVar.f24193d);
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
