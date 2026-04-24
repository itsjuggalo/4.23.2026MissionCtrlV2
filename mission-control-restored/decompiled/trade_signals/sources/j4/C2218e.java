package j4;

import Y6.AbstractC1005g;
import Y6.L;
import android.net.Uri;
import g4.C1813b;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.N;
import o5.AbstractC2491s;
import o5.C2470H;
import org.json.JSONObject;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import t5.AbstractC2751c;
import u5.AbstractC2785l;

/* JADX INFO: renamed from: j4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2218e implements InterfaceC2214a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f20051c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1813b f20052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2711i f20053b;

    /* JADX INFO: renamed from: j4.e$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: j4.e$b */
    public static final class b extends AbstractC2785l implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20054a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f20056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ B5.o f20057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ B5.o f20058e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Map map, B5.o oVar, B5.o oVar2, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.f20056c = map;
            this.f20057d = oVar;
            this.f20058e = oVar2;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return C2218e.this.new b(this.f20056c, this.f20057d, this.f20058e, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((b) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.f20054a;
            try {
                if (i8 == 0) {
                    AbstractC2491s.b(obj);
                    URLConnection uRLConnectionOpenConnection = C2218e.this.c().openConnection();
                    AbstractC2304t.d(uRLConnectionOpenConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setRequestProperty("Accept", "application/json");
                    for (Map.Entry entry : this.f20056c.entrySet()) {
                        httpsURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = httpsURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder sb = new StringBuilder();
                        N n8 = new N();
                        while (true) {
                            String line = bufferedReader.readLine();
                            n8.f20469a = line;
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        }
                        bufferedReader.close();
                        inputStream.close();
                        JSONObject jSONObject = new JSONObject(sb.toString());
                        B5.o oVar = this.f20057d;
                        this.f20054a = 1;
                        if (oVar.invoke(jSONObject, this) == objF) {
                            return objF;
                        }
                    } else {
                        B5.o oVar2 = this.f20058e;
                        String str = "Bad response code: " + responseCode;
                        this.f20054a = 2;
                        if (oVar2.invoke(str, this) == objF) {
                            return objF;
                        }
                    }
                } else {
                    if (i8 != 1 && i8 != 2 && i8 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC2491s.b(obj);
                }
            } catch (Exception e8) {
                B5.o oVar3 = this.f20058e;
                String message = e8.getMessage();
                if (message == null) {
                    message = e8.toString();
                }
                this.f20054a = 3;
                if (oVar3.invoke(message, this) == objF) {
                    return objF;
                }
            }
            return C2470H.f21956a;
        }
    }

    public C2218e(C1813b appInfo, InterfaceC2711i blockingDispatcher) {
        AbstractC2304t.f(appInfo, "appInfo");
        AbstractC2304t.f(blockingDispatcher, "blockingDispatcher");
        this.f20052a = appInfo;
        this.f20053b = blockingDispatcher;
    }

    @Override // j4.InterfaceC2214a
    public Object a(Map map, B5.o oVar, B5.o oVar2, InterfaceC2707e interfaceC2707e) {
        Object objG = AbstractC1005g.g(this.f20053b, new b(map, oVar, oVar2, null), interfaceC2707e);
        return objG == AbstractC2751c.f() ? objG : C2470H.f21956a;
    }

    public final URL c() {
        return new URL(new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.f20052a.b()).appendPath("settings").appendQueryParameter("build_version", this.f20052a.a().a()).appendQueryParameter("display_version", this.f20052a.a().f()).build().toString());
    }
}
