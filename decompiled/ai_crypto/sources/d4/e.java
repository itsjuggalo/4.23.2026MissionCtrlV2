package d4;

import E5.E;
import E5.q;
import Q5.o;
import Z3.C0782b;
import android.net.Uri;
import b6.AbstractC1073i;
import b6.L;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements InterfaceC1463a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13365c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0782b f13366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H5.g f13367b;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends J5.l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13368a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f13370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o f13371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ o f13372e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Map map, o oVar, o oVar2, H5.d dVar) {
            super(2, dVar);
            this.f13370c = map;
            this.f13371d = oVar;
            this.f13372e = oVar2;
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            return e.this.new b(this.f13370c, this.f13371d, this.f13372e, dVar);
        }

        @Override // Q5.o
        public final Object invoke(L l7, H5.d dVar) {
            return ((b) create(l7, dVar)).invokeSuspend(E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = I5.c.e();
            int i7 = this.f13368a;
            try {
                if (i7 == 0) {
                    q.b(obj);
                    URLConnection uRLConnectionOpenConnection = e.this.c().openConnection();
                    r.d(uRLConnectionOpenConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setRequestProperty("Accept", "application/json");
                    for (Map.Entry entry : this.f13370c.entrySet()) {
                        httpsURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = httpsURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder sb = new StringBuilder();
                        G g7 = new G();
                        while (true) {
                            String line = bufferedReader.readLine();
                            g7.f18249a = line;
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        }
                        bufferedReader.close();
                        inputStream.close();
                        JSONObject jSONObject = new JSONObject(sb.toString());
                        o oVar = this.f13371d;
                        this.f13368a = 1;
                        if (oVar.invoke(jSONObject, this) == objE) {
                            return objE;
                        }
                    } else {
                        o oVar2 = this.f13372e;
                        String str = "Bad response code: " + responseCode;
                        this.f13368a = 2;
                        if (oVar2.invoke(str, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i7 != 1 && i7 != 2 && i7 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                }
            } catch (Exception e7) {
                o oVar3 = this.f13372e;
                String message = e7.getMessage();
                if (message == null) {
                    message = e7.toString();
                }
                this.f13368a = 3;
                if (oVar3.invoke(message, this) == objE) {
                    return objE;
                }
            }
            return E.f1657a;
        }
    }

    public e(C0782b appInfo, H5.g blockingDispatcher) {
        r.f(appInfo, "appInfo");
        r.f(blockingDispatcher, "blockingDispatcher");
        this.f13366a = appInfo;
        this.f13367b = blockingDispatcher;
    }

    @Override // d4.InterfaceC1463a
    public Object a(Map map, o oVar, o oVar2, H5.d dVar) {
        Object objG = AbstractC1073i.g(this.f13367b, new b(map, oVar, oVar2, null), dVar);
        return objG == I5.c.e() ? objG : E.f1657a;
    }

    public final URL c() {
        return new URL(new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.f13366a.b()).appendPath("settings").appendQueryParameter("build_version", this.f13366a.a().a()).appendQueryParameter("display_version", this.f13366a.a().f()).build().toString());
    }
}
