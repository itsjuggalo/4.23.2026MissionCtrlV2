package U4;

import V4.j;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f4983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f4984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f4985c;

    public class a implements j.c {
        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            if (l.this.f4984b == null) {
                return;
            }
            String str = iVar.f5332a;
            str.hashCode();
            if (!str.equals("Localization.getStringResource")) {
                dVar.c();
                return;
            }
            JSONObject jSONObject = (JSONObject) iVar.b();
            try {
                dVar.a(l.this.f4984b.a(jSONObject.getString(SubscriberAttributeKt.JSON_NAME_KEY), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e7) {
                dVar.b("error", e7.getMessage(), null);
            }
        }
    }

    public interface b {
        String a(String str, String str2);
    }

    public l(M4.a aVar) {
        a aVar2 = new a();
        this.f4985c = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/localization", V4.f.f5331a);
        this.f4983a = jVar;
        jVar.e(aVar2);
    }

    public void b(List list) {
        J4.b.f("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Locale locale = (Locale) it.next();
            J4.b.f("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(locale.getScript());
            arrayList.add(locale.getVariant());
        }
        this.f4983a.c("setLocale", arrayList);
    }

    public void c(b bVar) {
        this.f4984b = bVar;
    }
}
